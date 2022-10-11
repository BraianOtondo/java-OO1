package test;

import modelo.Empresa;
import modelo.SistemaSaludDispositivos;

public class TestFunciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaSaludDispositivos sistema1=new SistemaSaludDispositivos();
		sistema1.agregarEmpresa("Empresa 1");
		sistema1.agregarEmpresa("Empresa 2");
		System.out.println(sistema1.traerEmpresa("Empresa 1"));
		Empresa empresa1=sistema1.traerEmpresa("Empresa 1");
		Empresa empresa2=sistema1.traerEmpresa("Empresa 2");

		try {
		System.out.println(sistema1.agregarDispositivo("Sensor Calor", "A2020", empresa1));
		System.out.println(sistema1.agregarDispositivo("Sensor Presion","A2325", empresa1));	
		System.out.println(sistema1.agregarDispositivo("Sensor Temperatura","B2021", empresa2));
		System.out.println(sistema1.agregarDispositivo("Sensor Humedad","B2326", empresa2));
		//sistema1.agregarDispositivo("Sensor","A2020",this.)	
		} catch (Exception e) {
			// TODO: handle exception
		
			System.out.println(e.getMessage());
		}
		try {
			sistema1.agregarDispositivo("Sensor Movimiento","B2022", empresa1);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(sistema1.toString());
		
	}

}

