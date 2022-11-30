package mx.com.fi.proyecto.dominio;

public class Candidato {
	private int idCandidato;
	private String nombre;
	private String cargo;
	private String sexo;
	private int edad;
	public Candidato() {
		super();
	}
	public Candidato(int idCandidato) {
		super();
		this.idCandidato = idCandidato;
	}
	
	public Candidato(int idCandidato, String nombre,String cargo) {
		super();
		this.idCandidato = idCandidato;
		this.nombre = nombre;
		this.cargo=cargo;
	}
	public Candidato(String nombre,String cargo, String sexo,int edad) {
		super();
		this.nombre = nombre;
		this.cargo = cargo;
		this.sexo = sexo;
		this.edad = edad;
	}
	public Candidato(int idCandidato, String nombre, String cargo,String sexo, int edad) {
		super();
		this.idCandidato = idCandidato;
		this.nombre = nombre;
		this.cargo = cargo;
		this.sexo = sexo;
		this.edad = edad;
	}
	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Candidato [idCandidato=" + idCandidato + ", nombre=" + nombre + ", cargo=" + cargo + ", sexo=" + sexo
				+ ", edad=" + edad + "]";
	}
	

}
