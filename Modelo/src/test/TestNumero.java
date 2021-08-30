package test;
import modelo.Numero;
public class TestNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Numero numero1=new Numero(2);
		System.out.println(numero1);
		System.out.println(numero1.sumar(8));
		System.out.println(numero1.multiplizar(2));
		numero1.calcularPotencia(2);
		Numero numero2=new Numero(1);
		System.out.println(numero2);
		numero2.setN(5);
		System.out.println(numero1.pasarBase2());
		if((Object)numero1.convertirADouble() instanceof Double){
	        System.out.println("Es de tipo Double");
	    }
		System.out.println("Factorial: "+numero2.calcularFactorial());
		System.out.println("Combinatoria: "+numero2.numeroCombinatorio(3));
		
	}
}