package geometria;

public class Circulo {
private Punto origen;
private double radio;


	public Circulo(Punto origen, double radio) {
	this.origen = origen;
	this.radio = radio;
	}

	public Punto getOrigen() {
	return origen;
	}
	public void setOrigen(Punto origen) {
	this.origen = origen;
	}
	public double getRadio() {
	return radio;
	}
	public void setRadio(double radio) {
	this.radio = radio;
	}

	

	//public void mover(double desplazamientoX,double desplazamientoY){//mueve el circulo que tiene el objeto CIrculo
	//origen.mover(desplazamientoX,desplazamientoY); //Puedo reutilizar este metodo porque la clase tiene un objeto Punto
	//esto cambia el punto pero cambia el objeto punto tambien, esto puede cambiar a todos los circulos si no hacemos un new
	//}//cambia la "x" y "y" del punto que tiene la clase Circulo 
	
	//para que no cambie todos los circulos y se vean afectados podemos hacer esto
	 public void mover(double desplazamientoX,double desplazamientoY){
	 Punto puntoNuevo=new Punto(origen.getX()+desplazamientoX,origen.getY()+desplazamientoY);
	this.setOrigen(puntoNuevo); //Puedo reutilizar este metodo porque la clase tiene un objeto Punto
	
	}
	 
}