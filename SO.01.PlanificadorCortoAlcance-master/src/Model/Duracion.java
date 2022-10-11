package Model;

public class Duracion implements Cloneable {

	private int iCPU;
	private int EyS;
	private int fCPU;
	private int tiempoTotal;
	private int tiempoEspera;

	public Duracion(int iCPU, int eyS, int fCPU) {
		this.iCPU = iCPU;
		this.EyS = eyS;
		this.fCPU = fCPU;
		this.tiempoTotal = iCPU + fCPU;
		this.tiempoEspera = 0;
	}

	public Duracion() {
		this.iCPU = 0;
		this.EyS = 0;
		this.fCPU = 0;
		this.tiempoTotal = 0;
		this.tiempoEspera = 0;
	}

	public int getiCPU() {
		return iCPU;
	}

	public void setiCPU(int iCPU) {
		this.iCPU = iCPU;
	}

	public int getEyS() {
		return EyS;
	}

	public void setEyS(int eyS) {
		EyS = eyS;
	}

	public int getfCPU() {
		return fCPU;
	}

	public void setfCPU(int fCPU) {
		this.fCPU = fCPU;
	}

	public int getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(int tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public int getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	public void setTiempoEspera() {
		this.tiempoEspera = tiempoEspera + 1;
	}

	@Override
	public String toString() {
		return "[CPU=" + getiCPU() + ", E/S=" + getEyS() + ", CPU=" + getfCPU() + "]";
	}

	public Object clone() { // ENE-2019¡¡¡
		Duracion obj = null;
		try {
			obj = (Duracion)super.clone();
		} catch (Exception e) {
			System.out.println(" no se puede duplicar objeto");
		}
		return obj;
	}
	
	
}
