package mx.com.fi.proyecto.dominio;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String  tipoUsuario;
	private String correo;
	private String password;
	public Usuario() {
		super();
	}
	public Usuario(int idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}
	public Usuario(String nombre, String tipoUsuario, String correo, String password) {
		super();
		this.nombre = nombre;
		this.tipoUsuario = tipoUsuario;
		this.correo = correo;
		this.password = password;
	}
	public Usuario(int idUsuario, String nombre, String tipoUsuario, String correo, String password) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.tipoUsuario = tipoUsuario;
		this.correo = correo;
		this.password = password;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", tipoUsuario=" + tipoUsuario + ", correo="
				+ correo + ", password=" + password + "]";
	}
	

}
