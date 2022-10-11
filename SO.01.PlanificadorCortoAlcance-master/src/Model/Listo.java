package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Listo {

	private int idListo;
	private List<Proceso> lstProcesos;

	public Listo(int idListo) {
		this.idListo = idListo;
		this.lstProcesos = new ArrayList<Proceso>();
	}

	public int getIdListo() {
		return idListo;
	}

	public void setIdListo(int idListo) {
		this.idListo = idListo;
	}

	public List<Proceso> getLstProcesos() {
		return lstProcesos;
	}

	public void setLstProcesos(List<Proceso> lstProcesos) {
		this.lstProcesos = lstProcesos;
	}

	public Proceso traerProceso(int idProceso) {
		Proceso procesoAux = null;
		int i = 0;
		int lenD = 0;
		if (!getLstProcesos().isEmpty()) {
			lenD = getLstProcesos().size();
			while (i < lenD) {
				if (getLstProcesos().get(i).equal(idProceso)) {
					procesoAux = getLstProcesos().get(i);
					i = lenD;
				}
				i++;
			}
		}
		return procesoAux;
	}

	public boolean listarProceso(Proceso proceso) {
		boolean agregar = false;
		agregar = getLstProcesos().add(proceso);
		return agregar;
	}

	public Proceso deslistarProceso(int idProceso) {
		Proceso procesoAux = null;
		if (!traerProceso(idProceso).equals(null)) {
			procesoAux = traerProceso(idProceso);
			int i = 0;
			int lenD = getLstProcesos().size();
			while (i < lenD) {
				if (traerProceso(i + 1).equal(idProceso)) {
					getLstProcesos().remove(i);
					i = lenD;
				}
				i++;
			}
		}
		return procesoAux;
	}

	public boolean ordenarPrioridad() {
		boolean orden = false;
		List<Proceso> lstProcesosAux = new ArrayList<Proceso>();
		int i = 0;
		int contAlta = 0;
		int contMedia = 0;
		int lenD = getLstProcesos().size();
		// Ordeno lista
		while (i < lenD) {
			if (getLstProcesos().get(i).getPrioridad().equals(Prioridad.Alta)) {
				if (lstProcesosAux.isEmpty()) {
					lstProcesosAux.add(getLstProcesos().get(i));
				} else {
					lstProcesosAux.add(contAlta, getLstProcesos().get(i));
				}
				contAlta++;
			}
			if (getLstProcesos().get(i).getPrioridad().equals(Prioridad.Media)) {
				if (lstProcesosAux.isEmpty()) {
					lstProcesosAux.add(getLstProcesos().get(i));
				} else {
					lstProcesosAux.add(contAlta + contMedia, getLstProcesos().get(i));
				}
				contMedia++;
			}
			if (getLstProcesos().get(i).getPrioridad().equals(Prioridad.Baja)) {
				lstProcesosAux.add(getLstProcesos().get(i));
			}
			// Siguiente
			i++;
		} // Termino y guardo lista ordenada por prioridad
		getLstProcesos().removeAll(lstProcesos);
		setLstProcesos(lstProcesosAux);
		return orden;
	}

	public boolean ordenarTiempoTotal() {
		// ENE-2019¡¡¡
		Collections.sort(getLstProcesos());
		return true;
	}

	public boolean ordenarTiempoRestante() {
		// Se calcula tiempo restante
		int lenD = getLstProcesos().size();
		Proceso procesoAux = new Proceso();
		int j = 0;
		int iCPU = 0;
		int fCPU = 0;
		while (j < lenD) {
			iCPU = 0;
			fCPU = 0;
			procesoAux = getLstProcesos().get(j);
			if (procesoAux.getDuracion().getiCPU() > 0) {
				iCPU = procesoAux.getDuracion().getiCPU();
			}
			if (procesoAux.getDuracion().getfCPU() > 0) {
				fCPU = procesoAux.getDuracion().getfCPU();
			}
			procesoAux.getDuracion().setTiempoTotal(iCPU + fCPU);
			j++;
		}
		// ENE-2019¡¡¡
		Collections.sort(getLstProcesos());
		return true;
	}

	public boolean tasaRespuesta() {
		int prioridad = 0;
		if (!getLstProcesos().isEmpty()) {
			for (Proceso proceso : getLstProcesos()) {
				proceso.tiempoEspera();
				// se suma +1 a tiempo de espera
				prioridad = proceso.tasaRespuesta();
				// se cambia prioridad segun:
				if (prioridad >= 0 && prioridad <= 3) {
					proceso.setPrioridad(Prioridad.Baja);
				}
				if (prioridad >= 4 && prioridad <= 6) {
					proceso.setPrioridad(Prioridad.Media);
				}
				if (prioridad >= 7) {
					proceso.setPrioridad(Prioridad.Alta);
				}
			}
			return true;
		}
		return false;
	}

	public boolean expulsionFIFO() {
		boolean desender = false;
		Proceso p = getLstProcesos().get(getLstProcesos().size() - 1);
		if (!desender && p.getPrioridad().equals(Prioridad.Alta)) {
			p.setPrioridad(Prioridad.Media);
			desender = true;
		}
		if (!desender && p.getPrioridad().equals(Prioridad.Media)) {
			p.setPrioridad(Prioridad.Baja);
			desender = true;
		}
		// si es false es que un proceso no puede desender más
		return desender;
	}

	public boolean promoverProcesoFIFO() {
		boolean promoted = false;
		if (!getLstProcesos().isEmpty()) {
			Proceso p = getLstProcesos().get(getLstProcesos().size() - 1);
			p.setPrioridad(Prioridad.Alta);
			promoted = true;
		}
		return promoted;
	}

	@Override
	public String toString() {
		String string = "IdListo=" + getIdListo();
		if (!getLstProcesos().isEmpty()) {
			string += ", LstProcesos=[";
			for (Proceso proceso : getLstProcesos()) {
				string += "\n\t" + proceso;
			}
			string += "]";
		} else {
			string += ", LstProcesos=[" + null + "]";
		}
		return string;
	}

}
