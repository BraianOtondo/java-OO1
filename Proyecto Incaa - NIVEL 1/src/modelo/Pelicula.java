package modelo;

public class Pelicula {
	private int idPelicula;
	private String pelicula;
	
	public Pelicula(int idPelicula, String pelicula) {
		super();
		this.idPelicula = idPelicula;
		this.pelicula = pelicula;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	

	//@Override
	public boolean equals(Pelicula pelicula) {
		//Pelicula pelicula = (Pelicula) obj;// esto es para respetar los parametros del override
		return this.pelicula.equalsIgnoreCase(pelicula.getPelicula()); // POR NOMBRE PORQUE AGREGAMOS DEPENDIENDO EL NOMBRE Y HACEMOS LA COMPARACION
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", pelicula=" + pelicula + "]";
	}
	
	
	
}
