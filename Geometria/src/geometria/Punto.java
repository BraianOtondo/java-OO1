package geometria;

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
	
	

}
