package modelo;

public class ArregloBidimensional {
	private double[][] matrizA;

	public ArregloBidimensional(double[][] matrizA) {
		this.matrizA = matrizA;
	}

	public double[][] getMatrizA() {
		return matrizA;
	}

	public void setMatrizA(double[][] matrizA) {
		this.matrizA = matrizA;
	}
	public void mostrarMatrizA(){
		for(int i=0;i<matrizA.length;i++){
			for(int j=0;j<matrizA[0].length;j++){
			System.out.println("matriz ["+i+"]["+j+"] = "+matrizA[i][j]);
			}
		}
	}
	public double[][] sumar(double[][] matrizB){
		if ((matrizA.length == matrizB.length) && (matrizA[0].length==matrizB[0].length)){
			//int n=matrizA.length;
			//int m=matrizB[0].length;
			for(int i=0;i<matrizA.length;i++){
				for(int j=0;j<matrizA[0].length;j++){
					matrizA[i][j]=matrizB[i][j]+matrizA[i][j];
				}
			}
		}
		
		return matrizA;
	}
	public double[][] restar(double[][] matrizB){
		if ((matrizA.length == matrizB.length) && (matrizA[0].length==matrizB[0].length)){
			//int n=matrizA.length;
			//int m=matrizB[0].length;
			for(int i=0;i<matrizA.length;i++){
				for(int j=0;j<matrizA[0].length;j++){
					matrizA[i][j]=matrizA[i][j]-matrizB[i][j];
				}
			}
			return matrizA;
		}
		return null;
		
	}
	
	public double[][] transpuesta(){
		int n=matrizA.length;
		int m=matrizA[0].length;
		double[][] matrizB= new double [m] [n];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				matrizB[j][i]=matrizA[i][j];
			}
		}
		//this.setMatrizA(matrizB);
		return matrizB;
	}
	
	public double[][] multiplicar(double numero){
		for(int i=0;i<matrizA.length;i++){
			for(int j=0;j<matrizA[0].length;j++){
				matrizA[i][j]=matrizA[i][j]*numero;
			}
		}
		return matrizA;
	}
	
	public double[][] multiplicar(double[][] matrizB){
		int af=matrizA.length;
		int ac=matrizA[0].length;
		int bf=matrizB.length;
		int bc=matrizB[0].length;
		if(ac==bf){
			double[][] matrizC= new double [af] [bc];
			double acum;
			for(int i=0;i<af;i++){
				for(int j=0;j<bc;j++){
					acum=0;
					for(int k=0;k<ac;k++){
						acum=acum+matrizA[i][k]*matrizB[k][j];
					}
					matrizC[i][j]=acum;
				}
			}
			return matrizC;
		}
		return null;
	}
}
