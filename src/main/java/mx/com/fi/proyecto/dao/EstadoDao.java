package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Estado;
import mx.com.fi.proyecto.dominio.Postulacion;
import mx.com.fi.proyecto.interfaz.EstadoInterfaz;

public class EstadoDao implements EstadoInterfaz {
	private static final String SQL_SELECT_GENERAL = "SELECT IdEstado,nombre,abrev FROM estado";
	private static final String SQL_SELECT_BY_ID = "SELECT IdEstado,nombre,abrev FROM estado WHERE IdEstado= ? limit 1";
	private Connection conexion;

	public EstadoDao() {
		super();
		try {
			this.conexion = Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EstadoDao(Connection conexion) {
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
	public ArrayList<Estado> mostrarEstados() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Estado estado = null;

		ArrayList<Estado> estados = new ArrayList<>();
		try {
			conn = this.getConexion();
			psmt = conn.prepareStatement(SQL_SELECT_GENERAL);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int idEstatdo = rs.getInt("IdEstado");
				String nombre = rs.getString("nombre");
				String abrev = rs.getString("abrev");
				estado = new Estado(idEstatdo, nombre, abrev);
				estados.add(estado);
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

		return estados;
	}

	@Override
	public Estado buscarEstado(Estado estado) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1, estado.getIdEstado());
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				estado.setIdEstado(rs.getInt("IdEstado"));
				estado.setNombre(rs.getString("nombre"));
				estado.setAbrev(rs.getString("abrev"));
				
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
		return estado;
	}
	public static void main(String[] args) {
	// ArrayList<Estado> estados= new EstadoDao().mostrarEstados();
	 //for (Estado estado : estados) {
		//System.out.println(estado);
	//}
	 Estado estado=new Estado(15);
	 Estado estadoshwarch=new EstadoDao().buscarEstado(estado);
	 System.out.println(estadoshwarch);
	}

}
