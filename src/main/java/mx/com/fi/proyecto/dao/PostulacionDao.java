package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Candidato;
import mx.com.fi.proyecto.dominio.Postulacion;
import mx.com.fi.proyecto.interfaz.PostulacionInterfaz;

public class PostulacionDao implements PostulacionInterfaz{
	private static final String SQL_SELECT_GENERAL = "SELECT IdPostulacion,IdCandidato,IdSuplente,IdPartido,TipoPostulacion FROM postulacion";

	private static final String SQL_SELECT_BY_ID = "SELECT IdCandidato,nombre,cargo,edad,sexo FROM candidato WHERE IdCandidato= ? limit 1";
	private static final String SQL_INSERT = "INSERT INTO postulacion(IdCandidato,IdSuplente,IdPartido,TipoPostulacion) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE candidato SET nombre=?,cargo=?,edad=?,sexo=? WHERE IdCandidato=?";
	private static final String SQL_DELETE = "DELETE FROM postulacion WHERE IdPostulacion=?";
	private  Connection conexion;
	public PostulacionDao() {
		super();
		try {
			this.conexion=Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public PostulacionDao(Connection conexion) {
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
	public ArrayList<Postulacion> mostrarPostulacion() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Postulacion postulacion = null;

		ArrayList<Postulacion> postulaciones = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT_GENERAL);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idPostulacion=rs.getInt("IdPostulacion");
				int idCandidato=rs.getInt("IdCandidato");
				int idSuplente=rs.getInt("IdSuplente");
				int idPartido=rs.getInt("IdPartido");
				String tipoPostulacion=rs.getString("TipoPostulacion");

				postulacion= new Postulacion(idPostulacion, idCandidato, idSuplente, idPartido, tipoPostulacion);
				postulaciones.add(postulacion);
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

		return postulaciones;
	}

	@Override
	public Postulacion buscarPostulacion(Postulacion postulacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarPostulacion(Postulacion postulacion) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn =this.getConexion();
			//System.out.println("conexion asignada: "+conn);
			psmt = conn.prepareStatement(SQL_INSERT);
			psmt.setInt(1, postulacion.getIdCandidato());
			psmt.setInt(2, postulacion.getIdSuplente());
			psmt.setInt(3,postulacion.getIdPartido());
			psmt.setString(4,postulacion.getTipoPostulacion());
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
	public int actualizarPostulacion(Postulacion postulacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarPostulacion(Postulacion postulacion) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn=this.getConexion();
			psmt = conn.prepareStatement(SQL_DELETE);

			psmt.setInt(1,postulacion.getIdCandidato());
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

}
