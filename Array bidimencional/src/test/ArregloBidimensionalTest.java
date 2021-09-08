package test;

import modelo.ArregloBidimensional;

public class ArregloBidimensionalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] m1={{2,1,0,7},{3,4,2,-1},{1,0,5,8}};
		
		ArregloBidimensional matriz1=new ArregloBidimensional(m1);
		double[][]m2=matriz1.transpuesta();
		ArregloBidimensional matriz2=new ArregloBidimensional(m2);
		System.out.println("MATRIZ1: ");
		matriz1.mostrarMatrizA();
		System.out.println("MATRIZ 2");
		matriz2.mostrarMatrizA();
		double[][] m3={{10,10,10,10},{20,20,20,30}};
		ArregloBidimensional matriz3=new ArregloBidimensional(m3);
		double[][] m4=matriz3.multiplicar(2);
		ArregloBidimensional matriz4=new ArregloBidimensional(m4);
		matriz4.mostrarMatrizA();
		
		double[][] m5={{2,3,5,1},{7,2,4,3},{-1,5,0,8}};
		double[][]m6={{1,1},{7,2},{0,-5},{4,0}};
		ArregloBidimensional matriz5= new ArregloBidimensional(m5);
		double [][] m7=matriz5.multiplicar(m6);
		ArregloBidimensional matriz7= new ArregloBidimensional(m7);
		matriz7.mostrarMatrizA();
		
		
		
	}

}
