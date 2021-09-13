package modelo;
import java.util.ArrayList;
import java.util.List;
public class Incaa {

	private List<Pelicula> catalogo = new ArrayList<Pelicula>();// lista vacia para poder usarse

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
	
	public boolean agregarPelicula(String pelicula)throws Exception{
			if(traerPelicula(pelicula)!= null){
				throw new Exception("La pelicula"+pelicula +" ya existe");
			}
			catalogo.add(new Pelicula(traerId() + 1, pelicula));
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
	
	public void modificarPelicula(int idPelicula,String pelicula)throws Exception{//cambia el nombre de la pelicula
		if (traerPelicula(idPelicula) == null) {
			throw new Exception("La pelicula no existe");
		}
		else{
			//Pelicula peliculaEncontrada=traerPelicula(idPelicula);
			//peliculaEncontrada.setIdPelicula(idPelicula);
			//peliculaEncontrada.setPelicula(pelicula);
			traerPelicula(idPelicula).setPelicula(pelicula); 
		}
	
	}
}
