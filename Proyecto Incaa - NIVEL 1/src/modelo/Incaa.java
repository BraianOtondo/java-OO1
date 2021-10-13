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
	
	@Override
	public String toString() {
		return "Incaa [catalogo=" + catalogo + "]";
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
			
		catalogo.add(new Pelicula(traerId()+1, pelicula));
		System.out.println("La pelicula : "+pelicula+" se agrego correctamente");
	return true;
	}
	
	public int traerId() { // ESTE METODO TRAE EL ID MAYOR DE TODOS 
		int mayor=0;
		if (this.catalogo.size() != 0) {
			mayor =catalogo.get(catalogo.size()-1).getIdPelicula();
		}
		return mayor;
	}
	
	public boolean modificarPelicula(int idPelicula,String pelicula)throws Exception{//cambia el nombre de la pelicula
		if (traerPelicula(idPelicula) == null) {
			throw new Exception("La pelicula no existe");
		}
		else{
			traerPelicula(idPelicula).setPelicula(pelicula); 
			System.out.println("La pelicula : "+pelicula+" se modificó correctamente");
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
}
