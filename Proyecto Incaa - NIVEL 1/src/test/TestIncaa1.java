package test;
import modelo.Incaa;
import modelo.Pelicula;
public class TestIncaa1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pelicula peli1=new Pelicula(1,"Spiderman 1");
		//Pelicula peli2=new Pelicula(2,"Spiderman 2");
		//Pelicula peli3=new Pelicula(3,"Spiderman 3");
		Incaa incaa=new Incaa();
		//System.out.println(incaa.estaVacia());
		try {
			System.out.println("Peliculas agregadas");
			System.out.println("**************1*****************");
			System.out.println(incaa.agregarPelicula("Spiderman 1"));
			System.out.println("**************2*****************");
			System.out.println(incaa.agregarPelicula("Spiderman 1"));
		} catch (Exception e) {
			System.out.println(e.getMessage()+" ENTENDISTE???");
		}
		
		
		
	}

}
