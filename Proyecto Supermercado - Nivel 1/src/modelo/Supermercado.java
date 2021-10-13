package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> gondola = new ArrayList<Producto>();
	private List<Carrito> lstCarrito=new ArrayList<Carrito>();
	
	
	public Supermercado(){
	}
	
	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	
	@Override
	public String toString() {
		return "Supermercado [gondola=" + gondola + ", lstCarrito=" + lstCarrito + "]";
	}

	//SOBRECARCA
	public Producto traerProducto(String producto){
		int i=0;
		boolean encontrado=false;
		Producto p=null;
		
		while(i<this.gondola.size() && encontrado==false){
			if(gondola.get(i).getProducto().equalsIgnoreCase(producto)){
				p=this.gondola.get(i);
				encontrado=true;
			}
			i++;
		}
		return p;
	}
	public int traerId(){
		int mayor=0;
		if(this.gondola.size()!=0){
			mayor=this.gondola.get(this.gondola.size()-1).getIdProducto();
		}
		return mayor;
	}
	public int traerIdCarrito(){
		int mayor=0;
		if(this.lstCarrito.size()!=0){
			mayor=this.lstCarrito.get(this.lstCarrito.size()-1).getIdCarrito();
		}
		return mayor;
	}
	public Producto traerProducto(int idProducto){
		int i=0;
		boolean encontrado=false;
		Producto p=null;
		while(i<this.gondola.size() && encontrado==false){
			if(this.gondola.get(i).getIdProducto()==idProducto){
				p=this.gondola.get(i);
				encontrado=true;
			}
			i++;
		}
		return p;
	}
	
	public boolean agregarProducto(String producto, float precio)throws Exception{
		if(this.traerProducto(producto)!=null){
			throw new Exception("El producto : "+producto+" ya existe");		
		}else{
			System.out.println("Producto: "+producto+" agregado correctamente");
			gondola.add(new Producto(this.traerId()+ 1,producto,precio));	
		}
		
		return true;
	}
	
	public boolean modificarProducto(int idProducto,String producto,double precio)throws Exception{
		Producto productoModificado=this.traerProducto(idProducto);
		if(productoModificado==null){
			throw new Exception("El producto : "+producto+" no existe");
		}
		productoModificado.setProducto(producto);
		productoModificado.setPrecio((float)precio);
		return true;
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto productoExiste = traerProducto(idProducto);// POR ID
		//Carrito productoOcupado = traerCarrito(productoEncontrado);// POR PRODUCTO
		
		if (productoExiste == null ||  this.buscarProducto(idProducto)== false) {
			throw new Exception("El producto no existe o existe en otro carrito");
		}else{
			gondola.remove(productoExiste);
			System.out.println("El producto se eliminó correctamente");	
		}
		return true;
	}
	public Carrito traerCarrito(int idCarrito){
		Carrito c=null;
		int i=0;
		int n=this.tamanioListaCarrito();
		boolean encontrado=false;
		while((i<n)&&(encontrado==false)){
			if(this.lstCarrito.get(i).equals(idCarrito)){
				c=this.lstCarrito.get(i);
				encontrado=true;
			}
		i++;
		}
		return c;
	}
	public Carrito traerCarrito(LocalDate fecha, LocalTime hora){
		Carrito c=null;
		int i=0;
		int n=this.tamanioListaCarrito();
		boolean encontrado=false;
		while((i<n)&&(encontrado==false)){
			if(this.lstCarrito.get(i).getFecha().equals(fecha) && this.lstCarrito.get(i).getHora().equals(hora)){
				c=this.lstCarrito.get(i);
				encontrado=true;
			}
		i++;
		}
		return c;
	}
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora)throws Exception{
	if(this.traerCarrito(fecha, hora)!=null){
		throw new Exception("El carrito ya existe ");
	}else{
		this.lstCarrito.add(new Carrito(this.traerIdCarrito()+1,fecha,hora));
		System.out.println("Carrito agregado correctamente");
	}
		return true;
	}
	
	public int tamanioListaCarrito(){
		return this.lstCarrito.size();
	}
	public boolean buscarProducto(int idProducto){
		boolean existe=false;
		int i=0;
		int n=this.tamanioListaCarrito();
		while((i<n)&&(existe==false)){
			if(this.lstCarrito.get(i).buscarProducto(idProducto)==true){
				existe=true;
			}
			i++;
		}
		return existe;
	}
	
}