package practica;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayInt = new int[3];//indefinido
		int[] arrayDef={10,20,30};
		arrayInt[0] = 1;
		arrayInt[2] = 3;
		int i;
		System.out.println("INDEFINIDO");
		for(i=0; i<arrayInt.length; i++){ //lenght indica el tamaño del array
			System.out.println(arrayInt[i]);
			}
		System.out.println("i= "+i); // SE VE AFECTADO POR EL FOR; SI SE PUEDE USAR FUERA
		System.out.println("DEFINIDO");
		for(int j=0;j<arrayDef.length;j++){// ese int i, no se puede usar fuera del for
			System.out.println(arrayDef[j]);

		}

	}
}
