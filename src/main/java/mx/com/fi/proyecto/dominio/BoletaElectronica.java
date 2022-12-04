package mx.com.fi.proyecto.dominio;

public class BoletaElectronica {
	private int idPostulanteBoleta;
	private int idBoleta;
	private int idPostulacion;
	
	public BoletaElectronica() {
		super();
	}
	

	public BoletaElectronica(int idPostulanteBoleta) {
		super();
		this.idPostulanteBoleta = idPostulanteBoleta;
	}


	public BoletaElectronica(int idBoleta, int idPostulacion) {
		super();
		this.idBoleta = idBoleta;
		this.idPostulacion = idPostulacion;
	}


	public BoletaElectronica(int idPostulanteBoleta, int idBoleta, int idPostulacion) {
		super();
		this.idPostulanteBoleta = idPostulanteBoleta;
		this.idBoleta = idBoleta;
		this.idPostulacion = idPostulacion;
	}


	public int getIdPostulanteBoleta() {
		return idPostulanteBoleta;
	}


	public void setIdPostulanteBoleta(int idPostulanteBoleta) {
		this.idPostulanteBoleta = idPostulanteBoleta;
	}


	public int getIdBoleta() {
		return idBoleta;
	}


	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}


	public int getIdPostulacion() {
		return idPostulacion;
	}


	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}


	@Override
	public String toString() {
		return "PostulanteBoleta [idPostulanteBoleta=" + idPostulanteBoleta + ", idBoleta=" + idBoleta
				+ ", idPostulacion=" + idPostulacion + "]";
	}
	
	

}
