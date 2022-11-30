package mx.com.fi.proyecto.dominio;

public class Municipio {
	private int idMunicipio;
	private int idEstado;
	private String clave;
	private String nombre;
	public Municipio() {
		super();
	}
	
	public Municipio(int idMunicipio) {
		super();
		this.idMunicipio = idMunicipio;
	}
	
	public Municipio(int idMunicipio, int idEstado) {
		super();
		this.idMunicipio = idMunicipio;
		this.idEstado = idEstado;
	}
	
	public Municipio(int idMunicipio,int idEstado, String nombre) {
		super();
		this.idMunicipio = idMunicipio;
		this.idEstado = idEstado;
		this.nombre = nombre;
	}

	public Municipio(int idMunicipio, int idEstado, String clave, String nombre) {
		super();
		this.idMunicipio = idMunicipio;
		this.idEstado = idEstado;
		this.clave = clave;
		this.nombre = nombre;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
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

	@Override
	public String toString() {
		return "Municipio [idMunicipio=" + idMunicipio + ", idEstado=" + idEstado + ", clave=" + clave + ", nombre="
				+ nombre + "]";
	}
	
	
}
