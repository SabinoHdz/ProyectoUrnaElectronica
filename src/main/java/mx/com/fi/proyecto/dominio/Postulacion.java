package mx.com.fi.proyecto.dominio;

import mx.com.fi.proyecto.interfaz.PostulacionInterfaz;

public class Postulacion{
	private int idPostulacion;
	private int idCandidato;
	private int idSuplente;
	private int idPartido;
	private String tipoPostulacion;
	public Postulacion() {
		super();
	}
	public Postulacion(int idPostulacion) {
		super();
		this.idPostulacion = idPostulacion;
	}
	public Postulacion(int idCandidato, int idSuplente, int idPartido, String tipoPostulacion) {
		super();
		this.idCandidato = idCandidato;
		this.idSuplente = idSuplente;
		this.idPartido = idPartido;
		this.tipoPostulacion = tipoPostulacion;
	}
	public Postulacion(int idPostulacion, int idCandidato, int idSuplente, int idPartido, String tipoPostulacion) {
		super();
		this.idPostulacion = idPostulacion;
		this.idCandidato = idCandidato;
		this.idSuplente = idSuplente;
		this.idPartido = idPartido;
		this.tipoPostulacion = tipoPostulacion;
	}
	public int getIdPostulacion() {
		return idPostulacion;
	}
	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}
	public int getIdSuplente() {
		return idSuplente;
	}
	public void setIdSuplente(int idSuplente) {
		this.idSuplente = idSuplente;
	}
	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public String getTipoPostulacion() {
		return tipoPostulacion;
	}
	public void setTipoPostulacion(String tipoPostulacion) {
		this.tipoPostulacion = tipoPostulacion;
	}
	@Override
	public String toString() {
		return "Postulacion [idPostulacion=" + idPostulacion + ", idCandidato=" + idCandidato + ", idSuplente="
				+ idSuplente + ", idPartido=" + idPartido + ", tipoPostulacion=" + tipoPostulacion + "]";
	}
	

}
