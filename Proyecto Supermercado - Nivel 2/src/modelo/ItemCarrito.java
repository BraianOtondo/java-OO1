package modelo;

public class ItemCarrito {
	private int idItem;
	private Producto producto;
	private int cantidad;
	public ItemCarrito(int idItem, Producto producto, int cantidad) {
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ItemCarrito [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	} 
	public boolean equals(ItemCarrito itemcarrito) {
		return this.idItem==itemcarrito.getIdItem();
	}
	public float calcularSubTotal(){
		return this.producto.getPrecio()*this.cantidad;
	}
	
}	
