package test;
import modelo.Punto;
public class TestPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto punto1=new Punto(7,4); 
		Punto punto2=new Punto(1,2);
		System.out.println(punto1.equals(punto2));// false porque los puntos del equals no coinciden
		Punto punto3=new Punto(3,5);
		System.out.println(punto1.equals(punto3)); // true porque los puntos son iguales
		System.out.println("Distancia: "+punto1.calcularDistancia(punto2));
	}

}
/*
A la implementación vista, agregar lo siguiente:
1) Crear un TestPunto
Escenario 1: crear dos instancias (objetos) de Punto distintas. Imprimir ambas. Imprimir el resultado de
equals entre los puntos.
Escenario 2: crear dos objetos de Punto iguales, imprimir ambos. Imprimir el resultado de equals entre los
puntos.
2) Implementar el método para calcular la distancia entre dos puntos como lo muestra el diagrama
de clases.
*/