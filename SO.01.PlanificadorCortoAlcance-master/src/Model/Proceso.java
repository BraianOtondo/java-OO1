package Model;

public class Proceso implements Cloneable, Comparable<Proceso>{

	private int idProceso;
	private String proceso;
	private int comienzaTiempo;
	private Prioridad prioridad;
	private Duracion duracion;

	public Proceso() {
		this.idProceso = 0;
		this.proceso = " ";
		this.comienzaTiempo = 0;
		this.prioridad = Prioridad.Baja;
		this.duracion = new Duracion();
	}

	public Proceso(int idProceso, String proceso, int comienzaTiempo, Prioridad prioridad, Duracion duracion) {
		this.idProceso = idProceso;
		this.proceso = proceso;
		this.comienzaTiempo = comienzaTiempo;
		this.prioridad = prioridad;
		this.duracion = duracion;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public int getComienzaTiempo() {
		return comienzaTiempo;
	}

	public void setComienzaTiempo(int comienzaTiempo) {
		this.comienzaTiempo = comienzaTiempo;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Duracion getDuracion() {
		return duracion;
	}

	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}
	
	public void tiempoEspera() {
		getDuracion().setTiempoEspera();
	}
	
	public int tasaRespuesta(){
		int prioridad=0;
		prioridad=(	getDuracion().getTiempoEspera()+getDuracion().getTiempoTotal() )
					/getDuracion().getTiempoTotal();
		return prioridad;
	}
	public int tiempoTotal() {
		return getDuracion().getiCPU()+getDuracion().getfCPU()+getDuracion().getEyS();
	}
	
	@Override
	public String toString() {
		return "Proceso=" + getProceso() + ", Tiempo Comienza=" + getComienzaTiempo() + ", Duraci�n=" + getDuracion()
				+ ", Prioridad=" + getPrioridad();
	}

	public boolean equal(int idProceso) {
		boolean validate = false;
		if (getIdProceso() == idProceso) {
			validate = true;
		}
		return validate;
	}

	public boolean equal(Proceso proceso) { // NOV-2017���
		boolean validate = false;
		if (this.hashCode() == proceso.hashCode()) {
			validate = true;
		}
		return validate;
	}

	public int hashCode() { // NOV-2017���
		final int prime = 31;
		int result = 1;
		result = prime * result + comienzaTiempo;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + idProceso;
		result = prime * result + ((prioridad == null) ? 0 : prioridad.hashCode());
		result = prime * result + ((proceso == null) ? 0 : proceso.hashCode());
		return result;
	}

	public Proceso clone() { // ENE-2019���
		Proceso obj = null;
		try {
			obj = (Proceso)super.clone();
		} catch (Exception e) {
			System.out.println(" no se puede duplicar objeto");
		}
		obj.duracion = (Duracion)obj.duracion.clone();
		return obj;
	}
	
	public int compareTo(Proceso producto) { // ENE-2019���
		int resultado = 0;
		if (this.getDuracion().getTiempoTotal()  < producto.getDuracion().getTiempoTotal()) {
			resultado = -1;
		} else if (this.getDuracion().getTiempoTotal() > producto.getDuracion().getTiempoTotal()) {
			resultado = 1;
		} else {
			resultado = 0;
		}
		return resultado;
	}

}
