package modelo;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
	private List<Pelicula> catalogo = new ArrayList<Pelicula>();

	public Incaa() {
	} 

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}

	public boolean estaVacia(){
		return(catalogo.size()==0);
	}
	public Pelicula traerPelicula(int idPelicula) {
		Pelicula p = null;
		int i = 0;
		boolean encontrado = false;
		while (i < catalogo.size() && encontrado == false) {
			if (catalogo.get(i).getIdPelicula() == idPelicula) {
				p = catalogo.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}
	public Pelicula traerPelicula(String pelicula) {
		Pelicula p = null;
		int i = 0;
		boolean encontrado = false;
		while (i < catalogo.size() && encontrado == false) {
			if (catalogo.get(i).getPelicula() == pelicula) {
				p = catalogo.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}
	
	public boolean agregarPelicula(String pelicula,Genero genero)throws Exception{
			if(traerPelicula(pelicula)!= null){
				throw new Exception("La pelicula "+pelicula +" ya existe");
			}
			catalogo.add(new Pelicula(traerId() + 1, pelicula,genero));
	return true;
	}
	
	public int traerId() { // ESTE METODO TRAE EL ID MAYOR DE TODOS 
		int mayor = 0;
		if (catalogo.size() != 0) {
			mayor = catalogo.get(0).getIdPelicula();
		}
		int actual;
		for (int i = 0; i < catalogo.size(); i++) {
			actual = catalogo.get(i).getIdPelicula();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}
	
	public boolean modificarPelicula(int idPelicula,String pelicula)throws Exception{
		if (traerPelicula(idPelicula) == null) {
			throw new Exception("La pelicula con Id="+idPelicula+"no existe");
		}
		else{
			traerPelicula(idPelicula).setPelicula(pelicula); 
		return true;
		}
	
	}
	
	public boolean eliminarPelicula(int idPelicula)throws Exception{
		if (traerPelicula(idPelicula) == null) {
			throw new Exception("La pelicula no existe");
		}else{
			catalogo.remove(traerPelicula(idPelicula));
		}
		return true;
	}
	
	public List<Pelicula> traerPelicula(Genero genero){
		List<Pelicula> p= new ArrayList<Pelicula>();
		for (int i=0;i<catalogo.size(); i++) {
			if(catalogo.get(i).getGenero().equals(genero)){
				p.add(new Pelicula(this.catalogo.get(i).getIdPelicula(),this.catalogo.get(i).getPelicula(),this.catalogo.get(i).getGenero()));
			}
		}
	
		return p;
	}
	
	
}
