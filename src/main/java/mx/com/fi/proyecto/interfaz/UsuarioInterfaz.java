package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;

import mx.com.fi.proyecto.dominio.Usuario;

public interface UsuarioInterfaz {
	public ArrayList<Usuario> mostrarUsuarios();
	public Usuario buscarUsuario(Usuario usuario);
	public int insertarUsuario(Usuario usuario);
	public int actualizarUsuario(Usuario usuario);
	public int eliminarUsuario(Usuario usuario);

}
