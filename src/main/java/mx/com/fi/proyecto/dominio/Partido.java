package mx.com.fi.proyecto.dominio;

import java.io.InputStream;

public class Partido {
	private int idPartido;
	private String nombrePartido;
	private String nombreImagen;
	private String abrev;
	private String emblema;
	public Partido() {
		super();
	}
	public Partido(int idPartido) {
		super();
		this.idPartido = idPartido;
	}
	public Partido(String nombrePartido, String nombreImagen,String abrev, String emblema) {
		super();
		this.nombrePartido = nombrePartido;
		this.nombreImagen = nombreImagen;
		this.abrev=abrev;
		this.emblema = emblema;
	}
	public Partido(int idPartido, String nombrePartido, String nombreImagen,String abrev, String emblema) {
		super();
		this.idPartido = idPartido;
		this.nombrePartido = nombrePartido;
		this.nombreImagen = nombreImagen;
		this.abrev=abrev;
		this.emblema = emblema;
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public String getNombrePartido() {
		return nombrePartido;
	}
	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}
	public String getNombreImagen() {
		return nombreImagen;
	}
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	public String getEmblema() {
		return emblema;
	}
	public void setEmblema(String emblema) {
		this.emblema = emblema;
	}
	public String getAbrev() {
		return abrev;
	}
	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}
	@Override
	public String toString() {
		return "Partido [idPartido=" + idPartido + ", nombrePartido=" + nombrePartido + ", nombreImagen=" + nombreImagen
				+ ", abrev=" + abrev + ", emblema=" + emblema + "]";
	}
	
	
}
