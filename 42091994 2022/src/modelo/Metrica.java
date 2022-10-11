package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Metrica {
	private int valor;
	private LocalDate fecha;
	private LocalTime hora;
	public Metrica(int valor, LocalDate fecha, LocalTime hora) {
		super();
		this.valor = valor;
		this.fecha = fecha;
		this.hora = hora;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
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
	@Override
	public String toString() {
		return "Metrica [valor=" + valor + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	public boolean equals(Metrica metrica) {
		return this.valor==metrica.getValor();
	}
		
	
}
