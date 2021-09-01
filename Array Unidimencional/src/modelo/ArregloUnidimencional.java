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
public int[] ordenar() {
    int aux;
    for(int i=0;i<vector.length-1;i++){
        for(int j=0;j<vector.length-i-1;j++){
            if(vector[j+1]<vector[j]) {
                aux=vector[j+1];
                vector[j+1]=vector[j];
                vector[j]=aux;
            }
        }
    }
    return vector;
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
	//double max=this.traerFrecuencia(vector[0]);
	//boolean band;
	int pos=0;
	int i;
	for(i=0;i<(vector.length)-1;i++){
		if(this.traerFrecuencia(vector[i])>this.traerFrecuencia(vector[i+1])){
			pos=i;
		}
		//if(repetido!=vector[i]){
		//}
		
	}
	return vector[pos];
}
}
