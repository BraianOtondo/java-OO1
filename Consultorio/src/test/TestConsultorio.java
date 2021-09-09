package test;
import consultorio.Medico;
import consultorio.Paciente;
public class TestConsultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Paciente paciente1=new Paciente("Jorge","Perez",1.80f,85);
		Medico medico=new Medico("Roberto","Gomez","Quiropractico");
		System.out.println("PACIENTES");

		System.out.println("MEDICOS");
		System.out.println("Nombre:"+ medico.getNombre());
		System.out.println(medico.getApellido());
		System.out.println(medico.getEspecialidad());
		System.out.println(medico.calcularIMC(paciente1));
		
		
		if(paciente1.getPeso()==85){
			System.out.println(paciente1.traerNombreCompleto());
		}else{
			System.out.println("SU PESO NO ES 85");
		}
		*/
		Paciente[] pacientes={new Paciente("Braian","Otondo",1.78f,50),new Paciente("Pepe","Chirulo",1.82f,92),
		new Paciente("Alejandro","Suarez",1.48f,50),new Paciente("Fernando","Cazales",1.78f,50)};
		Medico medico=new Medico("Roberto","Gomez","Quiropractico",pacientes);
		System.out.println(medico);
		System.out.println("El peso promedio de los pacientes es: "+medico.traerPromedioPeso());
		System.out.println("El paciente con la estatura mas alta es: "+medico.traerPacienteMayorEstatura());
		for(int i=0;i<medico.getPacientesFrecuentes().length;i++){
			System.out.println("Paciente: "+medico.getPacientesFrecuentes()[i].getNombre()+" IMC:"+medico.calcularIMC(pacientes[i]));
			
		}
		System.out.println("El paciente con menor IMC es: "+medico.traerMenorIMC());
	}

}
