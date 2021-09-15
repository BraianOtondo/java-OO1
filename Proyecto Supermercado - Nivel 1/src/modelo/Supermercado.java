package modelo;

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
	
	public boolean eliminarProducto(int idProducto)throws Exception{
		Producto productoEliminar=this.traerProducto(idProducto);
		ItemCarrito itemEncontrado = traerCarrito(productoEliminar);
		if(productoEliminar==null || itemEncontrado!=null){
			throw new Exception("El producto con id: "+idProducto+" no existe o esta en un carrito");
		}else {
			gondola.remove(productoEliminar);
			return true;
		}
	}
	public ItemCarrito traerCarrito(Producto producto) {
		ItemCarrito ic = null;
		int i = 0;
		boolean encontrado = false;
		while (i < lstCarrito.size() && encontrado == false) {
			if(this.lstCarrito.get(i).traerItemCarrito(producto)!=null){
			ic=this.lstCarrito.get(i).traerItemCarrito(producto);	
			encontrado=true;
			}
			i++;
		}
		return ic;
	}
}	