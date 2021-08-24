package test;
import geometria.Punto;
import geometria.Circulo;;
public class TestGeometria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto punto1=new Punto(3.0,5.0); //CREAMOS UN PUNTO
		Punto punto2=new Punto(3.0,5.0);
		System.out.println(punto1.equals(punto2));
		Circulo circulo1=new Circulo(punto1,3.0);
		Circulo circulo2=new Circulo(punto1,10.0);
		punto1.mover(1, 1);// añada 1 Y QUEDA 4 y 6
		System.out.println("C1 (1): "+circulo1.getOrigen()); //4 y 6
		System.out.println("C2 (1): "+circulo2.getOrigen());//4 y 6
		
		circulo2.setOrigen(new Punto(3,5)); //cambio de punto, ose aque circulo cambia su origen new
		System.out.println("C1 (2): "+circulo1.getOrigen());//4 y 6
		System.out.println("C2 (2): "+circulo2.getOrigen());//3 y 5
		circulo1.mover(2,2);  //TIENE OTRO punto
		System.out.println("C1 (3): "+circulo1.getOrigen());//new  6 y 8
		System.out.println("C2 (3): "+circulo2.getOrigen());// 3 y 5

	System.out.println("PUNTOS: ");

System.out.println(punto1);
System.out.println(circulo1.getOrigen());
System.out.println(circulo2.getOrigen());
System.out.println("CIRCULOS: ");
System.out.println(circulo1);
System.out.println(circulo2);
	}

}
