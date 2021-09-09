package consultorio;

public class Paciente {
//atributos
	private String nombre;
	private String apellido;
	private float estatura;
	private float peso;
//constructor
	
	public Paciente(String nombre,String apellido,float estatura,float peso){ //Es el unico con el mismo nombre de packete y Mayuscula primero
	this.nombre=nombre;
	this.apellido=apellido;
	this.estatura=estatura;
	this.peso=peso;
	}
//Getters 
	public String getNombre(){
	return nombre;
	}
	
	public String getApellido(){
	return apellido;
	}
	
	public float getEstatura(){
	return estatura;
	}
	
	public float getPeso(){
	return peso;
	}
	
//Setters
	public void setNombre(String nombre){
	this.nombre=nombre;
	}
	
	public void setApellido(String apellido){
	this.apellido=apellido;	
	}
	
	public void setEstatura(float estatura){
	this.estatura=estatura;
	}
	
	public void setPeso(float peso){
		this.peso=estatura;
	}

	public String traerNombreCompleto(){
		String resultado;
		resultado= nombre+" "+apellido;
		return resultado;
	}
	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellido=" + apellido + ", estatura=" + estatura + ", peso=" + peso
				+ "]";
	}
	
}


