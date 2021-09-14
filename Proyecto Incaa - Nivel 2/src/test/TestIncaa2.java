package test;
import modelo.Incaa;
import modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

import modelo.Genero;
public class TestIncaa2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Genero gen1=new Genero(1,"Terror");
		Genero gen2=new Genero(2,"Ciencia Ficcion");
		Genero gen3=new Genero(3,"Anime");
		Genero gen4=new Genero(4,"Accion");
		Incaa incaa=new Incaa();
		//TRY DE AGREGAR PELICULAS
		try{
			incaa.agregarPelicula("Viernes 13",gen1);
			incaa.agregarPelicula("Rick y Morty", gen2);
			incaa.agregarPelicula("Death Note", gen3);
			incaa.agregarPelicula("It",gen1);
			incaa.agregarPelicula("Daredevil",gen4);
			incaa.agregarPelicula("Iron Man",gen2);
			incaa.agregarPelicula("Iron Fist", gen4);
			incaa.agregarPelicula("Punisher",gen4);
			incaa.agregarPelicula("Defenders",gen4);
			incaa.agregarPelicula("Luke Cage", gen4);
			incaa.agregarPelicula("El conjuro",gen1);
			incaa.agregarPelicula("Punisher",gen4);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//System.out.println(incaa.traerPelicula(gen4));
		//TRY DE MODIFICAR PELICULA
		try {
			incaa.modificarPelicula(incaa.traerPelicula("Rick y Morty").getIdPelicula(),"Rick and Morty");
			incaa.modificarPelicula(incaa.traerPelicula(1).getIdPelicula(),"Friday 13");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//COMPROBACION DEL TRAER LISTA POR GENERO
		List<Pelicula> pelis =incaa.traerPelicula(gen2); // reutilizo el metodo que devuelve la lista
		for(int i=0;i<pelis.size();i++){
			System.out.println("**************"+i+"***************");
			System.out.println(pelis.get(i).toString());
		}

		System.out.println(incaa.traerPelicula(1)); // VIERNES 13
		
	
		
		
		

	}
}