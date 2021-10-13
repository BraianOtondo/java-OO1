package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private Cliente cliente;
	private List<ItemCarrito> lstItem=new ArrayList<ItemCarrito>();
	public Carrito() {
	}
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}
	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}
	
	public int traerIdMayor(){
		int mayor=0;
		if(this.lstItem.size()!=0){
			mayor=this.lstItem.get(this.lstItem.size()-1).getIdItem();
		}
		return mayor;
	}
	
	public ItemCarrito traerItemCarrito(Producto producto){ // DE TODOS LOS ITEMS EN LA LISTA, NOS IMPORTA 1 
		ItemCarrito ic=null;
		int i=0;
		boolean encontrado=false;
		while(i<this.lstItem.size() && encontrado==false){
			if(this.lstItem.get(i).getProducto().equals(producto)){
				ic=this.lstItem.get(i);
				encontrado=true;
			}
		i++;
		}
		return ic;
	}
	
	private boolean agregarItem(Producto producto, int cantidad){
		 ItemCarrito item= this.traerItemCarrito(producto);
			if(item!=null){//TIENE
				item.setCantidad(item.getCantidad()+cantidad);
			}else{
				System.out.println("Producto agregado: "+producto.getProducto());
				ItemCarrito nuevoItem=new ItemCarrito(traerIdMayor()+1,producto,cantidad);
				this.lstItem.add(nuevoItem);
			}
			
			return (item==null);
	}
	public boolean eliminarItem(Producto producto, int cantidad)throws Exception{
		ItemCarrito item=this.traerItemCarrito(producto);
		boolean itemEliminado=false;	
		if(item==null){
			throw new Exception("El producto :"+producto.getProducto()+" no existe");
		}
		if(cantidad==item.getCantidad()){
			itemEliminado=this.lstItem.remove(item);
			itemEliminado=true;
		}
		else if(cantidad<item.getCantidad()){
			item.setCantidad(item.getCantidad()-cantidad);
		}
		return itemEliminado;
	}
	
	public float calcularTotal(){
		float total=0;
		for(int i=0;i<this.lstItem.size();i++){
			total=total+this.lstItem.get(i).calcularSubTotal();
		}
		return total;
	}
	
	
}

