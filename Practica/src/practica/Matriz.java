package practica;

public class Matriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrayInd = new int[3][3]; //INDEFINIDO
		int k=1;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			arrayInd[i][j]=k;
			k++;
			}
		}
		System.out.println("INDEFINIDO");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			System.out.println(arrayInd[i][j]);
			}
		}
		int[][] arrayDef = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("DEFINIDO");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			System.out.println(arrayDef[i][j]);
			}
		}
		
	}

}
