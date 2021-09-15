package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem=new ArrayList<ItemCarrito>();
	public Carrito(){
	}
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora) {
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
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
	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}
	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem + "]";
	}
	
	public int traerId(){
		int mayor=0;
		if(this.lstItem.size()!=0){
			mayor=this.lstItem.get(this.lstItem.size()-1).getIdItem();
		}
		return mayor;
	}
	
	
	public boolean agregarItem(Producto producto,int cantidad){
		 ItemCarrito item= this.traerItemCarrito(producto);
		if(item!=null){//TIENE
			item.setCantidad(item.getCantidad()+cantidad);
		}else{
			System.out.println("Producto agregado: "+producto.getProducto());
			ItemCarrito nuevoItem=new ItemCarrito(traerId()+1,producto,cantidad);
			this.lstItem.add(nuevoItem);
		}
		
		return (item==null); //SIGNOFICA QUE PUDO AGREGAR NUEVO Y NO MODIFICAR
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
