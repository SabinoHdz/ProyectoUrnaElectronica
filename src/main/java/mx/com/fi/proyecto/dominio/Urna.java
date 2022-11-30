package mx.com.fi.proyecto.dominio;

public class Urna {
	private int idUrna;
	private String codigoPostal;
	private String codigoActivacion;
	private int estadoActual;
	public Urna() {
		super();
	}
	public Urna(int idUrna) {
		super();
		this.idUrna = idUrna;
	}
	public Urna(String codigoPostal, String codigoActivacion, int estadoActual) {
		super();
		this.codigoPostal = codigoPostal;
		this.codigoActivacion = codigoActivacion;
		this.estadoActual = estadoActual;
	}
	public Urna(int idUrna, String codigoPostal, String codigoActivacion, int estadoActual) {
		super();
		this.idUrna = idUrna;
		this.codigoPostal = codigoPostal;
		this.codigoActivacion = codigoActivacion;
		this.estadoActual = estadoActual;
	}
	public int getIdUrna() {
		return idUrna;
	}
	public void setIdUrna(int idUrna) {
		this.idUrna = idUrna;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCodigoActivacion() {
		return codigoActivacion;
	}
	public void setCodigoActivacion(String codigoActivacion) {
		this.codigoActivacion = codigoActivacion;
	}
	public int getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(int estadoActual) {
		this.estadoActual = estadoActual;
	}
	@Override
	public String toString() {
		return "Urna [idUrna=" + idUrna + ", codigoPostal=" + codigoPostal + ", codigoActivacion=" + codigoActivacion
				+ ", estadoActual=" + estadoActual + "]";
		
	}
	public void prueba() {
		int edad=Integer.parseInt("1");
	}
	
}
