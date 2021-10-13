package test;
import modelo.Supermercado;
import java.time.LocalDate;
import java.time.LocalTime;
public class TestSupermercado1 {

	public static void main(String[] args) {
		Supermercado super1=new Supermercado();
		try {
			super1.agregarProducto("Leche",50);
			super1.agregarProducto("Café",100);
			super1.agregarProducto("Fideos",60);
			super1.agregarProducto("Azucar",70);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("------------------TRAER PRODUCTOS---------------------");
		System.out.println(super1.traerProducto(1).getProducto());
		System.out.println(super1.traerProducto(2).getProducto());
		System.out.println(super1.traerProducto(3).getProducto());
		System.out.println(super1.traerProducto(4).getProducto());
		System.out.println("--------------------------MODIFICAR PRODUCTOS---------------------------");
		try {
			System.out.println(super1.modificarProducto(1,"Leche Sancor", 60));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(super1.traerProducto(1).getProducto());
		
		System.out.println("---------------------------AGREGAR CARRITO-----------------------------");
		try {
			super1.agregarCarrito(LocalDate.of(2021,8,15) ,LocalTime.of(10,30));
			super1.agregarCarrito(LocalDate.of(2021,8,16) ,LocalTime.of(10,30));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(super1.getLstCarrito().get(0).getIdCarrito());
		System.out.println(super1.getLstCarrito().get(1).getIdCarrito());
		
		System.out.println("-------------------------AGREGAR ITEM----------------------------------");
		try {
			super1.getLstCarrito().get(0).agregarItem(super1.traerProducto("Leche Sancor"),2);
			super1.getLstCarrito().get(0).agregarItem(super1.traerProducto("Fideos"), 3);
		//	carrito1.agregarItem(super1.traerProducto("Leche"),2);
			//carrito1.agregarItem(super1.traerProducto("Café"),1);
			//carrito1.agregarItem(super1.traerProducto("Fideos"), 3);
			//carrito1.agregarItem(super1.traerProducto("Azucar"),5);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(super1.traerProducto(1).getProducto());
		System.out.println("SUBTOTAL SANCOR:"+super1.getLstCarrito().get(0).getLstItem().get(0).calcularSubTotal());
		System.out.println("TOTAL: "+super1.getLstCarrito().get(0).calcularTotal());
		System.out.println("--------------------------ELIMINAR PRODUCTO--------------------------------");
		try {
			System.out.println(super1.eliminarProducto(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(super1.traerProducto(2).getProducto());

		// System.out.println(super1.buscarProducto(3));
	//	System.out.println(carrito1.buscarProducto(4));
		
		/*try {
			super1.eliminarProducto(1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("Producto 1="+super1.traerProducto(1));
		System.out.println(carrito1.getLstItem().get(0));*/
		
		
	}

}
