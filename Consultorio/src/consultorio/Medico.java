package consultorio;

import java.util.Arrays;

public class Medico {
	private String nombre;
	private String apellido;
	private String especialidad;
	private Paciente[] pacientesFrecuentes;
	
	public Medico(String nombre, String apellido, String especialidad, Paciente[] pacientesFrecuentes) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.pacientesFrecuentes = pacientesFrecuentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Paciente[] getPacientesFrecuentes() {
		return pacientesFrecuentes;
	}

	public void setPacientesFrecuentes(Paciente[] pacientesFrecuentes) {
		this.pacientesFrecuentes = pacientesFrecuentes;
	}

	public float calcularIMC(Paciente paciente){
		float imc=paciente.getPeso() / (float) Math.pow(paciente.getEstatura(), 2);
	return imc;
	}
	
	public double traerPromedioPeso(){
		double total=0;
		for(int i=0;i<pacientesFrecuentes.length;i++){
			total=total+pacientesFrecuentes[i].getPeso();
		}
		return total/pacientesFrecuentes.length;
	}

	@Override
	public String toString() {
		return "Medico [nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad
				+ ", pacientesFrecuentes=" + Arrays.toString(pacientesFrecuentes) + "]";
	}
	public Paciente traerPacienteMayorEstatura(){
		float max=pacientesFrecuentes[0].getEstatura();
		int i;
		int pos=0;
		for(i=0;i<pacientesFrecuentes.length;i++){
			if(max<pacientesFrecuentes[i].getEstatura()){
				max=pacientesFrecuentes[i].getEstatura();
				pos=i;
			}
		}
		return pacientesFrecuentes[pos];
	}
	
	public Paciente traerMenorIMC(){
		float min=this.calcularIMC(pacientesFrecuentes[0]);
		int i;
		int pos=0;
		for(i=0;i<pacientesFrecuentes.length;i++){
			if(min>this.calcularIMC(pacientesFrecuentes[i])){
				min=calcularIMC(pacientesFrecuentes[i]);
				pos=i;
			}
		}
		return pacientesFrecuentes[pos];
	}
}
