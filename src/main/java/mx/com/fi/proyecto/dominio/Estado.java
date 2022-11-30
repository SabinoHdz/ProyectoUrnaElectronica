package mx.com.fi.proyecto.dominio;

public class Estado {
	private int idEstado;
	private String clave;
	private String nombre;
	private String abrev;
	public Estado() {
		super();
	}
	public Estado(int idEstado) {
		super();
		this.idEstado = idEstado;
	}
	public Estado(int idEstado, String nombre) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
	}
	
	
	public Estado(int idEstado, String nombre, String abrev) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.abrev = abrev;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbrev() {
		return abrev;
	}
	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}
	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", clave=" + clave + ", nombre=" + nombre + ", abrev=" + abrev + "]";
	}
	
}
