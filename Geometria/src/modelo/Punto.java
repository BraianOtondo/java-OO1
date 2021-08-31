package modelo;
//import modelo.Numero;
public class Punto {
private double x;
private double y;

public Punto(double x,double y){
	this.x=x;
	this.y=y;
}

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public boolean equals(Punto p){
		return ((x==p.getX())&&(y==p.getY()));
		}
	
	public String toString(){ //polimorfismo puro
	return "("+x+","+y+")";
	}
	
	public void mover(double x,double y){
	this.x=this.x + x;
	this.y=this.y + y;
	}
	public double calcularDistancia(Punto punto){
		double calculo1=Math.pow((punto.getX()-x),2);
		double calculo2=Math.pow((punto.getY()-y), 2);
		return (Math.sqrt(calculo1+calculo2));
	}

}
