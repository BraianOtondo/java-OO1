package test;
import consultorio.Medico;
import consultorio.Paciente;
public class TestConsultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Paciente paciente1=new Paciente("Jorge","Perez",1.80f,85);
		Medico medico=new Medico("Roberto","Gomez","Quiropractico");
		System.out.println("PACIENTES");

		/*System.out.println("MEDICOS");
		System.out.println("Nombre:"+ medico.getNombre());
		System.out.println(medico.getApellido());
		System.out.println(medico.getEspecialidad());
		System.out.println(medico.calcularIMC(paciente1));
		*/
		
		if(paciente1.getPeso()==85){
			System.out.println(paciente1.traerNombreCompleto());
		}else{
			System.out.println("SU PESO NO ES 85");
		}
	}

}
