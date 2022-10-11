package modelo;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo {
	private int id;
	private String nombre;
	private String codigo;
	private List<Metrica> lstMetricas=new ArrayList<Metrica>();
	private Empresa empresa;
	public Dispositivo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Metrica> getLstMetricas() {
		return lstMetricas;
	}
	public void setLstMetricas(List<Metrica> lstMetricas) {
		this.lstMetricas = lstMetricas;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", lstMetricas=" + lstMetricas
				+ ", empresa=" + empresa + "]";
	}
	public boolean equals(Dispositivo dispositivo) {
		return this.codigo.equals(dispositivo.getCodigo());
	}
	

		
	
}
