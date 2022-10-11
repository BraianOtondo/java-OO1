package modelo;
import java.util.ArrayList;
import java.util.List;
public class SistemaSaludDispositivos {
	private List<Empresa>lstEmpresas=new ArrayList<Empresa>();
	private List<Dispositivo> lstDispositivos=new ArrayList<Dispositivo>();
	public List<Empresa> getLstEmpresas() {
		return lstEmpresas;
	}
	public void setLstEmpresas(List<Empresa> lstEmpresas) {
		this.lstEmpresas = lstEmpresas;
	}
	public List<Dispositivo> getLstDispositivos() {
		return lstDispositivos;
	}
	public void setLstDispositivos(List<Dispositivo> lstDispositivos) {
		this.lstDispositivos = lstDispositivos;
	}
	@Override
	public String toString() {
		return "SistemaSaludDispositivos [lstEmpresas=" + lstEmpresas + ", lstDispositivos=" + lstDispositivos + "]";
	}
	public Empresa traerEmpresa(String nombre) {
		Empresa objeto=null;
		int i=0;
		while(i<this.lstEmpresas.size() && objeto==null){
			if(this.lstEmpresas.get(i).getNombre().equalsIgnoreCase(nombre)){
				objeto=this.lstEmpresas.get(i);
			}
		i++;
		}
		return objeto;
	}
	public boolean agregarEmpresa(String nombre){
		Empresa objeto=this.traerEmpresa(nombre);
		if(objeto==null) {
			objeto= new Empresa(traerUltimoIdEmpresa()+1, nombre);
		}
		return this.lstEmpresas.add(objeto);
	}
	
	public int traerUltimoIdEmpresa(){
		int ultimo=0;
		if(!this.lstEmpresas.isEmpty()) {
			ultimo=this.lstEmpresas.get(lstEmpresas.size()-1).getId();
		}
		return ultimo;
	}
	public Dispositivo traerDispositivo(String codigo){
		Dispositivo objeto=null;
		int i=0;
		while(i<this.lstDispositivos.size() && objeto==null){
			if(lstDispositivos.get(i).getCodigo().equals(codigo)) {
				objeto=this.lstDispositivos.get(i);
			}
			i++;
		}
		return objeto;
	}
	
	
	public boolean agregarDispositivo(String nombre,String codigo,Empresa empresa)throws Exception {
			Dispositivo objeto=this.traerDispositivo(codigo);
			if(validarCodigo(codigo)==false) {
				throw new Exception("El codigo no es valido");
			}
			if(objeto==null) {
				objeto= new Dispositivo();
				objeto.setId(this.traerUltimoIdDispositivo()+1);
				objeto.setCodigo(codigo);
				objeto.setEmpresa(empresa);
				objeto.setNombre(nombre);

			}
			
		return this.lstDispositivos.add(objeto);
	}
	public int traerUltimoIdDispositivo() {
		int ultimo=0;
		if(!this.lstDispositivos.isEmpty()) {
			ultimo=this.lstDispositivos.get(lstDispositivos.size()-1).getId();
		}
		return ultimo;
	}
	
	public boolean validarCodigo(String codigo) {
		boolean band=false;
		if(codigo.length()==5) {
			if(this.esLetra(codigo, 0)==true && this.esNumero(codigo, 1)&& this.esNumero(codigo, 2) && this.esNumero(codigo,3) && this.esNumero(codigo, 4)) {
				int suma;
				if(codigo.charAt(0)=='A' || codigo.charAt(0)=='B') {
					suma=this.numero(codigo,1)+this.numero(codigo,2)+this.numero(codigo,3)+this.numero(codigo,4);
					if(codigo.charAt(0)=='A') {
						if(this.esPar(suma)==true) {
							band=true;
						}
					}else if(codigo.charAt(0)=='B') {
						if(this.esPar(suma)==false){
							band=false;
						}
					}
					
				}
			}
		}
		return band;
	}
	public int numero(String codigo , int pos) {
		int num=codigo.charAt(pos);
		return num;
	}
	public boolean esPar(int num) {
		return num % 2==0;
	}
	
	public boolean esLetra(String codigo,int pos){
		return Character.isLetter(codigo.charAt(pos)); 
		//return Character.isLetter(c);
	}
	
	public boolean esNumero(String codigo , int pos){
		boolean flag=false;
		switch(codigo.charAt(pos)){
		case '0':flag=true;break;
		case '1':flag=true;break;
		case '2':flag=true;break;
		case '3':flag=true;break;
		case '4':flag=true;break;
		case '5':flag=true;break;
		case '6':flag=true;break;
		case '7':flag=true;break;
		case '8':flag=true;break;
		case '9':flag=true;break;
		
		}
		return flag;
	}
}
