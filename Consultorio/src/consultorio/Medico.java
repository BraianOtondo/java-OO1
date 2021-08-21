package consultorio;

public class Medico {
	private String nombre;
	private String apellido;
	private String especialidad;
	
	public Medico(String nombre, String apellido, String especialidad){
		this.nombre=nombre;
		this.apellido=apellido;
		this.especialidad=especialidad;
		
	}
	//Getters
	public String getNombre(){
		return nombre;	
	}
	
	public String getApellido(){
		return apellido;
	}
	
	public String getEspecialidad(){
		return especialidad;
	}
	//Setters
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	
	public void setEspecialidad(String especialidad){
		this.especialidad=especialidad;
	}
	public float calcularIMC(Paciente paciente){
		float imc=paciente.getPeso() / (float) Math.pow(paciente.getEstatura(), 2);
	return imc;
	}
}
