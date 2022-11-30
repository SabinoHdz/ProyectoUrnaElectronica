package mx.com.fi.proyecto.dominio;

public class Boleta {
	 private int idBoleta;
	 private String procesoElectoral;
	 private String tipoEleccion;
	 private int entidadFederativa;
	 private int municipio;
	 private String distritoElectoral;
	 private String periodo;
	public Boleta() {
		super();
	}
	public Boleta(int idBoleta) {
		super();
		this.idBoleta = idBoleta;
	}
	public Boleta(String procesoElectoral, String tipoEleccion, int entidadFederativa, int municipio,
			String distritoElectoral, String periodo) {
		super();
		this.procesoElectoral = procesoElectoral;
		this.tipoEleccion = tipoEleccion;
		this.entidadFederativa = entidadFederativa;
		this.municipio = municipio;
		this.distritoElectoral = distritoElectoral;
		this.periodo = periodo;
	}
	public Boleta(int idBoleta, String procesoElectoral, String tipoEleccion, int entidadFederativa, int municipio,
			String distritoElectoral, String periodo) {
		super();
		this.idBoleta = idBoleta;
		this.procesoElectoral = procesoElectoral;
		this.tipoEleccion = tipoEleccion;
		this.entidadFederativa = entidadFederativa;
		this.municipio = municipio;
		this.distritoElectoral = distritoElectoral;
		this.periodo = periodo;
	}
	public int getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getProcesoElectoral() {
		return procesoElectoral;
	}
	public void setProcesoElectoral(String procesoElectoral) {
		this.procesoElectoral = procesoElectoral;
	}
	public String getTipoEleccion() {
		return tipoEleccion;
	}
	public void setTipoEleccion(String tipoEleccion) {
		this.tipoEleccion = tipoEleccion;
	}
	public int getEntidadFederativa() {
		return entidadFederativa;
	}
	public void setEntidadFederativa(int entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}
	public int getMunicipio() {
		return municipio;
	}
	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	public String getDistritoElectoral() {
		return distritoElectoral;
	}
	public void setDistritoElectoral(String distritoElectoral) {
		this.distritoElectoral = distritoElectoral;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	@Override
	public String toString() {
		return "Boleta [idBoleta=" + idBoleta + ", procesoElectoral=" + procesoElectoral + ", tipoEleccion="
				+ tipoEleccion + ", entidadFederativa=" + entidadFederativa + ", municipio=" + municipio
				+ ", distritoElectoral=" + distritoElectoral + ", periodo=" + periodo + "]";
	}
	 
	
	
}
