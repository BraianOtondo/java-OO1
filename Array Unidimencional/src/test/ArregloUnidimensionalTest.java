package test;
import modelo.ArregloUnidimencional;
public class ArregloUnidimensionalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={10,2,30,6,10,10};
		ArregloUnidimencional vector1=new ArregloUnidimencional(array);
		System.out.println("MUESTRA 1");
		vector1.mostrarArrays();
		vector1.ordenar();
		System.out.println("MUESTRA 2");
		vector1.mostrarArrays();
		System.out.println("El numero 10 se repite con una frecuencia del %"+vector1.traerFrecuencia(10));
		System.out.println("Lo que est� de moda es :"+vector1.traerModa());
	}

}
