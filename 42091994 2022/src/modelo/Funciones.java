package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {
	private LocalDate fecha;
	private LocalTime hora;

	public Funciones(LocalDate fecha, LocalTime hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	// esBisiesto (int anio) : boolean
	// Serán bisiestos los años divisibles por 4, exceptuando los que son
	// divisibles por 100 y no divisibles por
	// 400. Ejemplos: son bisiestos 1996, 2004, 2000, 1600; No son bisiestos
	// 1700, 1800, 1900, 2100
	public boolean esBisiesto(int anio) {
		return (anio % 4 == 0 && !(anio % 100 == 0 && !(anio % 400 == 0)));
	}

	// En el caso de ser bisiesto es válido el día 29/02/xxxx
	public boolean esFechaValida(LocalDate fecha) {
		return esBisiesto(fecha.getYear());
	}

	public String traerFechaCorta(LocalDate fecha) {

		// return fecha.toString(); 2022-08-15
		return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
	}

	public String traerHoraCorta(LocalTime hora) {
		return hora.getHour() + ":" + hora.getMinute();
	}
	// Retorna “hh:mm”

	public LocalDate transformar(String fecha) {
		return LocalDate.parse(fecha);
	}

	public static boolean esDiaHabil(LocalDate fecha) {
		int d = fecha.getDayOfWeek().getValue();
		/*
		 * Help: LocalDate fecha=LocalDate.of (2019,9,30); int
		 * nroDiaSem=fecha.getDayOfWeek().getValue(); //nroDiaSem=1,from 1
		 * (Monday) to 7 (Sunday)
		 */
		return ((d >= 1) && (d <= 5));
	}

	public String traerDiaDeLaSemana(LocalDate fecha) {
		String diaString = "";
		int dia = fecha.getDayOfWeek().getValue();
		switch (dia) {
		case 1:
			diaString = "Lunes";
			break;
		case 2:
			diaString = "Martes";
			break;
		case 3:
			diaString = "Miercoles";
			break;
		case 4:
			diaString = "Jueves";
			break;
		case 5:
			diaString = "Viermes";
			break;
		case 6:
			diaString="Sabado";
			break;
		case 7:
			diaString="Domingo";
			break;
		}
		return diaString;
	}

	public String traerMesEnLetras(LocalDate fecha) {
		int mes = fecha.getMonth().getValue();
		String mesString = "";
		switch (mes) {
		case 1:
			mesString = "Enero";
			break;
		case 2:
			mesString = "Febrero";
			break;
		case 3:
			mesString = "Marzo";
			break;
		case 4:
			mesString = "Abril";
			break;
		case 5:
			mesString = "Mayo";
			break;
		case 6:
			mesString = "Junio";
			break;
		case 7:
			mesString = "Julio";
			break;
		case 8:
			mesString = "Agosto";
			break;
		case 9:
			mesString = "Septiembre";
			break;
		case 10:
			mesString = "Octubre";
			break;
		case 11:
			mesString = "Noviembre";
			break;
		case 12:
			mesString = "Diciembre";
			break;
		}
		return mesString;
	}

	// Consideramos hábil de lunes a viernes.
	public String traerFechaLarga (LocalDate fecha){
		return this.traerDiaDeLaSemana(fecha)+" "+fecha.getDayOfMonth()+" de "+this.traerMesEnLetras(fecha)+" del "+fecha.getYear();
	}
	//Ejemplo: “Sábado 20 de Agosto del 2016”
	//public int traerCantDiasDeUnMes (int anio, int mes){
		
	//}
	//((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0))
	/*Los meses que tienen 30 días son:
		Abril
		Junio
		Septiembre
		Noviembre
		Los meses que tienen 31 días son:
		Enero
		Marzo
		Mayo
		Julio
		Agosto
		Octubre
		Diciembre
		En Febrero si el año es bisiesto, tendrá 29 días, sino tendrá 28 días.*/
	public boolean esNumero(char c){
		boolean flag=false;
		switch(c){
		case '0':flag=true;break;
		case '1':flag=true;break;
		case '2':flag=true;break;
		case '3':flag=true;break;
		case '4':flag=true;break;
		case '5':flag=true;break;
		case '6':flag=true;break;
		case '7':flag=true;break;
		case '8':flag=true;break;
		case '9':flag=true;break;
		
		}
		return flag;
	}
	public boolean esLetra(char c){
		return Character.isLetter(c);
	}
	
}