package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Postulacion;
import mx.com.fi.proyecto.dominio.Usuario;
import mx.com.fi.proyecto.interfaz.UsuarioInterfaz;

public class UsuarioDao implements UsuarioInterfaz {
	
	private static final String SQL_SELECT_GENERAL = "SELECT IdUsuario,nombre,tipoUsuario,correo,password FROM usuario";

	private static final String SQL_SELECT_BY_ID = "SELECT IdUsuario,nombre,tipoUsuario,correo,password FROM usuario WHERE IdUsuario= ? limit 1";
	private static final String SQL_INSERT = "INSERT INTO usuario(nombre,tipoUsuario,correo,password) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre=?,tipoUsuario=?,correo=?,password=? WHERE IdUsuario=?";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE IdUsuario=?";
	private  Connection conexion;

	public UsuarioDao() {
		super();
		try {
			this.conexion=Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UsuarioDao(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public ArrayList<Usuario> mostrarUsuarios() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Usuario usuario = null;

		ArrayList<Usuario> usuarios = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT_GENERAL);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idUsuario=rs.getInt("IdUsuario");
				String nombre=rs.getString("nombre");
				String tipoUsuario=rs.getString("tipoUsuario");
				String correo=rs.getString("correo");
				String password=rs.getString("password");

				usuario= new Usuario(idUsuario, nombre, tipoUsuario, correo, password);
				usuarios.add(usuario);
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(rs);
			Conexion.close(this.getConexion());
		}

		return usuarios;
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1,  usuario.getIdUsuario());
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				usuario.setIdUsuario(rs.getInt("IdUsuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setTipoUsuario(rs.getString("tipoUsuario"));
				usuario.setCorreo(rs.getString("correo"));;
				usuario.setPassword(rs.getString("password"));
			
			}

			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(stmt);
			Conexion.close(rs);
			Conexion.close(this.getConexion());
		}
		return usuario;
	}

	@Override
	public int insertarUsuario(Usuario usuario) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn =this.getConexion();
			//System.out.println("conexion asignada: "+conn);
			psmt = conn.prepareStatement(SQL_INSERT);
			psmt.setString(1, usuario.getNombre());
			psmt.setString(2, usuario.getTipoUsuario());
			psmt.setString(3,usuario.getCorreo());
			psmt.setString(4,usuario.getPassword());
			rows = psmt.executeUpdate();
			conn.close();
			//psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(this.getConexion());
		}
		return rows;
	}

	@Override
	public int actualizarUsuario(Usuario usuario) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn = this.getConexion();
			psmt = conn.prepareStatement(SQL_UPDATE);
			psmt.setString(1, usuario.getNombre());
			psmt.setString(2,usuario.getTipoUsuario());
			psmt.setString(3, usuario.getCorreo());
			psmt.setString(4, usuario.getPassword());
			psmt.setInt(5, usuario.getIdUsuario());
			rows = psmt.executeUpdate();

		//	psmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(this.getConexion());
		}
		return rows;
	}

	@Override
	public int eliminarUsuario(Usuario usuario) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn=this.getConexion();
			psmt = conn.prepareStatement(SQL_DELETE);

			psmt.setInt(1,usuario.getIdUsuario());
			rows = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(this.getConexion());
			Conexion.close(conn);
		}
		return rows;
	}
	 public static void main(String[] args) {
		//ArrayList<Usuario>usuarios=new UsuarioDao().mostrarUsuarios();
		//for (Usuario usuario : usuarios) {
		//	System.out.println(usuario);
		//}
		 
		// Usuario user=new Usuario("Juan perez perez ","Funcionario","peres@gmai.com","juan");
		 //int registros =new UsuarioDao().insertarUsuario(user);
		 //System.out.println(registros);
		 
		 Usuario user=new Usuario(4);
		 int regdel=new UsuarioDao().eliminarUsuario(user);
		 System.out.println(regdel);
		// System.out.println(Search);
		 //Search.setNombre("Juan Jose Martines");
		 
		// int resgistros= new UsuarioDao().actualizarUsuario(Search);
		 //System.out.println(resgistros);
	}
}
