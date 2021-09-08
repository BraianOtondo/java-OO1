package modelo;
import java.util.Arrays;

public class ArregloUnidimencional {
private int[] vector;

public ArregloUnidimencional(int[] vector) {
	this.vector = vector;
}

@Override
public String toString() {
	return "ArregloUnidimencional [vector=" + Arrays.toString(vector) + "]";
}

public int[] getVector() {
	return vector;
}

public void setVector(int[] vector) {
	this.vector = vector;
}
public void mostrarArrays(){
    for(int i = 0; i <vector.length; i++){
        System.out.println("vector ["+i+"]=" +vector[i]);
    }
}

public double traerFrecuencia(int numero){
	float contar=0;
	for(int i=0;i<vector.length;i++){
		if(vector[i]==numero){
			contar++;
		}
	}
	return (contar/vector.length)*100;
}
//+ traerModa(): int
public int traerModa(){
	int pos=0;
	int i;
	for(i=0;i<(vector.length)-1;i++){
		if(this.traerFrecuencia(vector[i])>this.traerFrecuencia(vector[i+1])){
			pos=i;
		}
	}
	return vector[pos];
}
public int traerElMenor(){
	int min=vector[0];
	for(int i=0;i<vector.length;i++){
		if(min>vector[i]){
		min=vector[i];
		}
	}
	
	return min;
}

public int traerElMayor(){
	int max=vector[0];
	for(int i=0;i<vector.length;i++){
		if(max<vector[i]){
		max=vector[i];
		}
	}
	
	return max;
}

public double calcularPromedio(){
	double total=0;
	for(int i=0;i<vector.length;i++){
		total=total+vector[i];
	}
	return (total/vector.length);
}

public  int[] ordenarAscendente(){
	int aux;
	for(int i=1;i<vector.length;i++){
		for(int j=0;j<vector.length-i;j++){
			if(vector[j+1]<vector[j]){
				aux=vector[j];
				vector[j]=vector[j+1];
				vector[j+1]=aux;
			}
		}
	}
	return vector;
}

public  int[] ordenarDescendente(){
	int aux;
	for(int i=1;i<vector.length;i++){
		for(int j=0;j<vector.length-i;j++){
			if(vector[j+1]>vector[j]){
				aux=vector[j];
				vector[j]=vector[j+1];
				vector[j+1]=aux;
			}
		}
	}
	return vector;
}

}
