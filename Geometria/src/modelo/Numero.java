package modelo;
public class Numero {
private int n;

public Numero(int n) {
	this.n = n;
}

public int getN() {
	return n;
}

public void setN(int n) {
	this.n = n;
}

@Override
public String toString() {
	return "Numero [n=" + n + "]";
}

public int sumar(int n1){
	return(n+n1);
}

public int multiplizar(int n1){
	return (n*n1);
}

public boolean esPrimo(){
	//double tope=calcularPotencia(n,0.5);
double tope=Math.sqrt(n);
boolean esPrimo=true;
int i=2;
int resto;
	while((i<=tope)&&(esPrimo)){
	resto=n%i;
		if(resto==0){
		esPrimo=false;
		}
	i++;
	}	
return (esPrimo);
}
public double calcularPotencia(int num,int exp){
	double potencia=Math.pow(num, exp);
	return potencia;
}
public double calcularPotencia(int exp){
	return calcularPotencia(n,exp);

}

public boolean esPar(){
	return(n%2==0);
}

public String convertirAString(){
	return String.valueOf(n);
}

public double convertirADouble(){
	return Double.parseDouble(convertirAString());
}

public String pasarBase2(){
	String bin= Long.toBinaryString(n);
	return  bin;
}
//SOBRECARGA
public int calcularFactorial(int num){
	int factorial=1;
	for(int i=1;i<=num;i++){
		factorial=factorial * i;
	}
	return factorial;
}
public int calcularFactorial(){
	return calcularFactorial(n);
}
public int numeroCombinatorio(int n1){
	return calcularFactorial()/(calcularFactorial(n1)* calcularFactorial(n-n1));
}
}
