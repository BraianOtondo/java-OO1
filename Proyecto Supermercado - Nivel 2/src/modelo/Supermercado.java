package modelo;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> lstProducto=new ArrayList<Producto>();
	private List<Cliente> lstCliente=new ArrayList<Cliente>();
	private List<Carrito> lstCarrito=new ArrayList<Carrito>();
	public Supermercado() {
	}
	public List<Producto> getLstProducto() {
		return lstProducto;
	}
	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}
	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}
	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	//PRODUCTOS
	public Producto traerProducto(int idProducto){
		int i=0;
		boolean encontrado=false;
		Producto p=null;
		while(i<this.lstProducto.size() && encontrado==false){
			if(this.lstProducto.get(i).getIdProducto()==idProducto){
				p=this.lstProducto.get(i);
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
		
		while(i<this.lstProducto.size() && encontrado==false){
			if(this.lstProducto.get(i).getProducto().equalsIgnoreCase(producto)){
				p=this.lstProducto.get(i);
				encontrado=true;
			}
			i++;
		}
		return p;
	}
	public int traerIdMayorListaProducto(){
		int mayor=0;
		if(this.lstProducto.size()!=0){
			mayor=this.lstProducto.get(this.lstProducto.size()-1).getIdProducto();
		}
		return mayor;
	}
	
	
	public boolean agregarProducto(String producto, float precio)throws Exception{
		if(this.traerProducto(producto)!=null){
			throw new Exception("El producto : "+producto+" ya existe");		
		}else{
			System.out.println("Producto: "+producto+" agregado correctamente");
			lstProducto.add(new Producto(this.traerIdMayorListaProducto()+ 1,producto,precio));	
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
		if(productoEliminar==null){
			throw new Exception("El producto con id: "+idProducto+" no existe");
		}
		this.lstProducto.remove(productoEliminar);
		return true;
	}
	
	

}
