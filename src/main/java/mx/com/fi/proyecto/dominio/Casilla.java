package mx.com.fi.proyecto.dominio;

import java.util.List;

public class Casilla {
	private int idCasilla;
	private String distritoElectoral;
	private String tipo;
	private List<Urna> urna;
	//Sobrecarga de contructor
	public Casilla() {
		super();
	}
	
	//contructor para eliminar urna
	public Casilla(int idCasilla) {
		super();
		this.idCasilla = idCasilla;
	}

	//constructor para registar urna
	public Casilla(String distritoElectoral, String tipo, List<Urna> urna) {
		super();
		this.distritoElectoral = distritoElectoral;
		this.tipo = tipo;
		this.urna = urna;
	}
	//actualizar
	public Casilla(int idCasilla, String distritoElectoral, String tipo, List<Urna> urna) {
		super();
		this.idCasilla = idCasilla;
		this.distritoElectoral = distritoElectoral;
		this.tipo = tipo;
		this.urna = urna;
	}

	public int getIdCasilla() {
		return idCasilla;
	}

	public void setIdCasilla(int idCasilla) {
		this.idCasilla = idCasilla;
	}

	public String getDistritoElectoral() {
		return distritoElectoral;
	}

	public void setDistritoElectoral(String distritoElectoral) {
		this.distritoElectoral = distritoElectoral;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Urna> getUrna() {
		return urna;
	}

	public void setUrna(List<Urna> urna) {
		this.urna = urna;
	}

	@Override
	public String toString() {
		return "Casilla [idCasilla=" + idCasilla + ", distritoElectoral=" + distritoElectoral + ", tipo=" + tipo
				+ ", urna=" + urna + "]";
	}
}

