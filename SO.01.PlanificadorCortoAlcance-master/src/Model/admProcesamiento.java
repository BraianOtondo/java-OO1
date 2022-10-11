package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Model.Prioridad;
import Model.Tabla;

public class admProcesamiento {

	private List<Proceso> lstProcesos;
	private int cantidadFilas;
	private int cantidaColumnas;
	private Tabla[][] tabla;
	private Hilo hilo;
	private Buffers buffers;
	private Listo listo;

	public admProcesamiento(int cantidadFilas, int cantidaColumnas) {
		this.lstProcesos = new ArrayList<Proceso>();
		this.cantidadFilas = cantidadFilas;
		this.cantidaColumnas = cantidaColumnas;
		this.tabla = new Tabla[cantidadFilas][cantidaColumnas];
		setTabla();
		this.hilo = new Hilo(1);
		this.buffers = new Buffers(1);
		this.listo = new Listo(1);
	}

	public List<Proceso> getLstProcesos() {
		return lstProcesos;
	}

	public void setLstProcesos(List<Proceso> lstProcesos) {
		this.lstProcesos = lstProcesos;
	}

	public Tabla[][] getTabla() {
		return tabla;
	}

	public void setTabla(Tabla[][] tabla) {
		this.tabla = tabla;
	}

	public void setTabla() {
		this.tabla = newTable();
	}

	public int getCantidadFilas() {
		return cantidadFilas;
	}

	public void setCantidadFilas(int cantidadFilas) {
		this.cantidadFilas = cantidadFilas;
	}

	public int getCantidaColumnas() {
		return cantidaColumnas;
	}

	public void setCantidaColumnas(int cantidaColumnas) {
		this.cantidaColumnas = cantidaColumnas;
	}

	public Hilo getHilo() {
		return hilo;
	}

	public void setHilo(Hilo hilo) {
		this.hilo = hilo;
	}

	public Buffers getBuffers() {
		return buffers;
	}

	public void setBuffers(Buffers buffers) {
		this.buffers = buffers;
	}

	public Listo getListo() {
		return listo;
	}

	public void setListo(Listo listo) {
		this.listo = listo;
	}
	
	/*------------------------------------------------------*/
	// Metodos
	/*------------------------------------------------------*/

	// Crear Proceso
	public boolean agregarProceso(String nombreProceso, int comienzaTiempo, int iCPU, int eyS, int fCPU, Prioridad prioridad) {
		boolean agregar = false;
		int idProceso = 1;
		if (!getLstProcesos().isEmpty()) {
			idProceso = getLstProcesos().get(getLstProcesos().size() - 1).getIdProceso() + 1;
		}
		Duracion duracion = new Duracion(iCPU, eyS, fCPU);
		agregar = getLstProcesos().add(new Proceso(idProceso, nombreProceso, comienzaTiempo, prioridad, duracion));
		return agregar;
	}

	// Traer Proceso
	public Proceso traerProceso(int index) {
		Proceso procesoAux = null;
		if (!getLstProcesos().isEmpty() && getLstProcesos().size() > index) {
			procesoAux = getLstProcesos().get(index);
		}
		return procesoAux;
	}

	// Listar
	public boolean listarProcesoFIFO(Proceso proceso) {
		boolean validate = false;
		// Se Agrega al final
		validate = getListo().getLstProcesos().add(proceso);
		return validate;
	}

	public boolean listarProcesoLIFO(Proceso proceso) {
		int index=0;
		// Se Agrega al principio 
		getListo().getLstProcesos().add(index,proceso);
		return true;
	}
	
	public Proceso deslistarProcesoFIFO() {
		Proceso procesoAux = null;
		// Saco el primero  
		if (!getListo().getLstProcesos().isEmpty()) {
			// procesoAux = getListo().deslistarProceso(1);
			// No porque no saco por id sino por índex
			procesoAux = getListo().getLstProcesos().get(0);
			getListo().getLstProcesos().remove(0);
		}
		return procesoAux;
	}

	// Ejecutar
	public boolean ejecutarProceso(Proceso proceso) {
		boolean validate = false;
		validate = getHilo().ejecutarProceso(proceso);
		return validate;
	}

	public Proceso terminarProceso() {
		Proceso procesoAux = new Proceso();
		if (getHilo().isEjecutando()) {
			procesoAux = getHilo().eliminarProceso();
		}
		return procesoAux;
	}

	// Bloquear
	public boolean bloquearProceso(Proceso proceso) {
		boolean validate = false;
		validate = getBuffers().bloquearProceso(proceso);
		return validate;
	}

	public Proceso desbloquearProceso(int idProceso) {
		Proceso procesoAux = new Proceso();
		if (!getBuffers().getLstProcesos().isEmpty()) {
			procesoAux = getBuffers().eliminarBloqueado(idProceso);
		}
		return procesoAux;
	}

	// Algoritmos de Planificación ->
	/*------------------------------------------------------*/

	public Tabla[][] planificarFIFO( ) {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();

		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: No
				
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: No

				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: No
					
				}
				// Se resta Quantum: No
				
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}

	public Tabla[][] planificarPrioridad() {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();
		
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: No
				
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarPrioridad(); /***Ordeno por Prioridad***/
				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: No
					
				}
				// Se resta Quantum: No
				
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}
	
	public Tabla[][] planificarSPN() {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();

		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: No
				
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarTiempoTotal(); /***Ordeno por Tiempo Total***/
				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: No
					
				}
				// Se resta Quantum: No
				
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}
	
	public Tabla[][] planificarRoundRobin(int quantum) {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();
		int timeOut = quantum;
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: Si
				if(timeOut==0)if(turnarProcesoFIFO())timeOut=quantum;
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: NO

				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: Si
					timeOut=quantum;
				}
				// Se resta Quantum: Si
				timeOut--;
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}
	
	public Tabla[][] planificarPrioridadesApropiativos() {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();
		int timeOut = 1;
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: Si
				if(timeOut==0)if(turnarProcesoLIFO())timeOut=1;
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarPrioridad(); /***Ordeno por Prioridad***/
				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: Si
					timeOut=1;
				}
				// Se resta Quantum: Si
				timeOut--;
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}
	
	public Tabla[][] planificarSRT() {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();
		int timeOut = 1;
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: Si
				if(timeOut==0)if(turnarProcesoLIFO())timeOut=1;
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarTiempoRestante(); /***Ordeno por Tiempo Restante***/
				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: Si
					timeOut=1;
				}
				// Se resta Quantum: Si
				timeOut--;
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}
	
	public Tabla[][] planificarHRRN() {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();
		
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: No
				
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: No
						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarPrioridad();  /***Ordeno por Prioridad***/
				// Se saca un proceso de Listo a: Ejecutando
				prosesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: No
					
				}
				// Se resta Quantum: No
				
				// Se suma Tiempo de Espera: Si
				getListo().tasaRespuesta();
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}
	
	public Tabla[][] planificarFeedback() {
		// Preparo Datos
		List<Proceso> procesos = clone(getLstProcesos());
		Tabla[][] auxTabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int cont = procesos.size();
		int timeOut = 1;
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Se Realiza Turnos Rotativos: Si
				if(timeOut==0)if(turnarProcesoFIFO()){timeOut=1;getListo().expulsionFIFO();}
				// Se pasa proceso a: Listo
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
						// Se promueve Proceso: Si
						getListo().promoverProcesoFIFO();
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarPrioridad(); /***Ordeno por Prioridad***/
				// Se saca un proceso de Listo a: Ejecutando
				if (prosesarProceso())timeOut=tiempoInstancia();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(auxTabla,columna)) {
					if (prosesarProceso())timeOut=tiempoInstancia();// Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(auxTabla,columna);
					// Se reinicia quantum: No
					
				}
				// Se resta Quantum: Si
				timeOut--;
				// Se realiza E/S: Paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}
	
	// Módulos para los planificadores ->
	/*------------------------------------------------------*/
	
	// Módulos para Planificador de Largo Alcanze
	public boolean listarProcesoEntrada(List<Proceso> procesos,int columna){
		boolean add=false;
		for (int fila = 0; fila < procesos.size(); fila++) {
			if (procesos.get(fila).getComienzaTiempo() == (columna + 1)) {
				// Estado de proceso a: Listo
				listarProcesoFIFO(procesos.get(fila));
				add=true;
			}
		}
		return add;
	}

	public int tiempoInstancia(){
		boolean end=false;
		int tiempo=1;
		Proceso p=getHilo().getProceso();
		if (!end && p.getPrioridad().equals(Prioridad.Baja)) {
			end=true;
			tiempo=calcular2Potencia(2);
		}
		if (!end && p.getPrioridad().equals(Prioridad.Media)) {
			end=true;
			tiempo=calcular2Potencia(1);
		}
		if (!end && p.getPrioridad().equals(Prioridad.Alta) ) {
			end=true;
			tiempo=calcular2Potencia(0);
		}
		return tiempo;
	}

	public int calcular2Potencia(int exponente){
		return (int) Math.pow(2, exponente);
	}

	//Módulos para Planificador de Corto Alcanze
	public boolean prosesarProceso(){
		boolean load=false;
		// Se saca procesos de Estado Listo a:
		if (!getHilo().isEjecutando()) {
			if (!getListo().getLstProcesos().isEmpty()) {
				// Estado de proceso a: Ejecutando
				load=ejecutarProceso(deslistarProcesoFIFO());
			}
		}
		return load;
	}

	public boolean activador(Tabla[][] auxTabla,int columna){
		boolean ejecutando=false;
		boolean bloquear=true;
		boolean nuevo=false;
		if (getHilo().isEjecutando()) {
			ejecutando = getHilo().ejecutarInstrucción();
			// Se carga a la tabla estado E caso 1
			if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() >= 0) {
				auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
			}
			// Se carga a la tabla estado E caso 2
			if (ejecutando && getHilo().getProceso().getDuracion().getfCPU() >= 0) {
				auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
			}
			// Módulo Proceso Terminado:
			if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() == -1 && getHilo().getProceso().getDuracion().getfCPU() == -1) {
				// Estado de proceso a: Terminado
				auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("T");
				terminarProceso();
				bloquear = false; // Se interrumpe trabajo del módulo Proceso Bloqueado 
				nuevo=true;
			}
			// Módulo Proceso Bloqueado:
			if (bloquear) {// NOTA: no tira error de hilo vacío cuidado con esta parte que puede ser causa errores por la id que traigo que es distinto que el index :) Revisar a futuro porque me daba error
				if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() == -1 && getHilo().getProceso().getDuracion().getfCPU() == traerProceso(getHilo().getProceso().getIdProceso() - 1).getDuracion().getfCPU()) {
					// Estado de proceso a: Bloqueado
					bloquearProceso(terminarProceso());
					nuevo=true;
				}
			}
		}
		return nuevo;
	}

	public boolean turnarProcesoFIFO() {
		boolean end=false;
		if (getHilo().isEjecutando()) {
			Proceso procesoAux=getHilo().getProceso();
			int cpuInicio=procesoAux.getDuracion().getiCPU();
			int cpuFinal=procesoAux.getDuracion().getfCPU();
			// Se saca proceso de Estado Ejecutando y lo paso según:
			if (cpuInicio>0) {
				end=listarProcesoFIFO(terminarProceso()); //recibe true
			}
			if (!end) {
				if (cpuInicio<0 && cpuFinal==traerProceso(getHilo().getProceso().getIdProceso() - 1).getDuracion().getfCPU()) {
					end=bloquearProceso(terminarProceso()); //recibe true
				}
			}
			if (!end) {
				if (cpuInicio<0 && cpuFinal>=1) {
					end=listarProcesoFIFO(terminarProceso()); //recibe true
				}
			}
		}
		return end;
	}

	public boolean turnarProcesoLIFO() {
		boolean end=false;
		if (getHilo().isEjecutando()) {
			Proceso procesoAux=getHilo().getProceso();
			int cpuInicio=procesoAux.getDuracion().getiCPU();
			int cpuFinal=procesoAux.getDuracion().getfCPU();
			// Se saca proceso de Estado Ejecutando y lo paso según:
			if (cpuInicio>0) {
				end=listarProcesoLIFO(terminarProceso()); //recibe true
			}
			if (!end) {
				if (cpuInicio<0 && cpuFinal==traerProceso(getHilo().getProceso().getIdProceso() - 1).getDuracion().getfCPU()) {
					end=bloquearProceso(terminarProceso()); //recibe true
				}
			}
			if (!end) {
				if (cpuInicio<0 && cpuFinal>=1) {
					end=listarProcesoLIFO(terminarProceso()); //recibe true
				}
			}
		}
		return end;
	}

	// Módulos para Planificador E/S
	public boolean listarProcesoBloqueado(){
		boolean add=false;
		int i = 0;
		int reiniciar = getBuffers().getLstProcesos().size();
		int lenD = getBuffers().getLstProcesos().size();
		// Se Ordena: Si
		getBuffers().ordenarId();
		while (reiniciar > 0) {// Se saca procesos de Estado Bloqueado a:
			i = 0;
			while (i < lenD) {
				if (getBuffers().interrupcionEyS(i)) {
					// Estado de proceso a: Listo
					listarProcesoFIFO(desbloquearProceso(getBuffers().getLstProcesos().get(i).getIdProceso()));
					// Se saco un Proceso, entonces:
					lenD--;
					i = getBuffers().getLstProcesos().size();
					add=true;
				}
				i++;
			}
			reiniciar--;
		}
		return add;
	}

	public boolean ejecutarEyS(Tabla[][] auxTabla,int columna){
		boolean run=false;
		if (!getBuffers().getLstProcesos().isEmpty() ) {
			for (Proceso proceso : getBuffers().getLstProcesos()) {
				if (proceso.getDuracion().getEyS() > 0) {
					// Se carga a la tabla estado B
					getBuffers().ejecutarEyS(proceso.getIdProceso());
					auxTabla[proceso.getIdProceso() - 1][columna].setEstado("B");
					run=true;
				}
			}
		}
		return run;
	}

	// @Override ->
	/*------------------------------------------------------*/
	@Override
	public String toString() {
		String string;
		string = "--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		string += "\n| proceso: |";
		for (int i = 1; i <= getCantidaColumnas(); i++) {
			if (i < 10) {
				string += " "+i+" |";
			}
			if (i >= 10 && i < 100) {
				string += i + " |";
			}else{
				if (i >= 10)string += i + "|";
			}
		}
		for (int i = 0; i < getLstProcesos().size(); i++) {

			string += "\n| " + getLstProcesos().get(i).getProceso() + "\t   |";
			for (int j = 0; j < getCantidaColumnas(); j++) {
				string += " " + getTabla()[i][j] + " |";
			}
		}
		string += "\n--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		return string;
	}

	public String mostrarPlanificador(Tabla[][] auxTabla) {
		String string;
		string = "--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		string += "\n| proceso: |";
		for (int i = 1; i <= getCantidaColumnas(); i++) {
			if (i < 10) {
				string += " "+i+" |";
			}
			if (i >= 10 && i < 100) {
				string += i + " |";
			}else{
				if (i >= 10)string += i + "|";
			}
		}
		for (int i = 0; i < getLstProcesos().size(); i++) {
			string += "\n| " + getLstProcesos().get(i).getProceso() + "\t   |";
			for (int j = 0; j < getCantidaColumnas(); j++) {
				string += " " + auxTabla[i][j] + " |";
			}
		}
		string += "\n--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		return string;
	}

	public List<Proceso> clone(List<Proceso> lstProcesos){
		List<Proceso> lstProcesosAux = new ArrayList<Proceso>();
		/*--------------   Se Respalda Datos    ------------*/
		for (Proceso proceso : lstProcesos) {
			Proceso auxProceso1 = proceso.clone();
			lstProcesosAux.add(auxProceso1);
		}
		return lstProcesosAux;
	}

	public Tabla[][] newTable(){
		Tabla[][] auxTabla = new Tabla[getCantidadFilas()][getCantidaColumnas()];
		/*-------------- Se Prepara nueva Tabla ------------*/
		for (int i = 0; i < getCantidadFilas(); i++) {
			for (int j = 0; j < getCantidaColumnas(); j++) {
				auxTabla[i][j] = new Tabla(i + 1, j + 1);
			}
		}
		return auxTabla;
	}
	
	public String mostrarProcesos() {
		String string = "";
		for (Proceso proceso : getLstProcesos()) {
			string += proceso + "\n";
		}
		return string;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		admProcesamiento other = (admProcesamiento) obj;
		if (cantidaColumnas != other.cantidaColumnas)
			return false;
		if (cantidadFilas != other.cantidadFilas)
			return false;
		if (lstProcesos == null) {
			if (other.lstProcesos != null)
				return false;
		} else if (!lstProcesos.equals(other.lstProcesos))
			return false;
		if (!Arrays.deepEquals(tabla, other.tabla))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidaColumnas;
		result = prime * result + cantidadFilas;
		result = prime * result + ((lstProcesos == null) ? 0 : lstProcesos.hashCode());
		result = prime * result + Arrays.deepHashCode(tabla);
		return result;
	}
	
	public int hashCode(Tabla[][] table) {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(table);
		return result;
	}
	
}
