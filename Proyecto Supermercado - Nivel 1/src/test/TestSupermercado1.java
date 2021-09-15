package test;
import modelo.Carrito;
import modelo.Supermercado;
public class TestSupermercado1 {

	public static void main(String[] args) {
		Supermercado super1=new Supermercado();
		Carrito carrito1=new Carrito();
		try {
			super1.agregarProducto("Leche",50);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			super1.eliminarProducto(4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Existe??="+super1.traerProducto(1));
		
		try {
			carrito1.agregarItem(super1.traerProducto(1), 2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			super1.eliminarProducto(1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
