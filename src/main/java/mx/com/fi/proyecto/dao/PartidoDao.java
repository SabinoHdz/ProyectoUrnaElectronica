package mx.com.fi.proyecto.dao;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletResponse;
import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Partido;
import mx.com.fi.proyecto.dominio.Urna;
import mx.com.fi.proyecto.interfaz.PartidoInterfaz;

public class PartidoDao implements PartidoInterfaz {
	private static final String SQL_SELECT = "SELECT IdPartido,nombrePartido,nombreImagen,abrev,emblema FROM partido WHERE bHabilitado=1";
	private static final String SQL_SELECT_BY_ID = "SELECT IdPartido,nombrePartido,nombreImagen,abrev,emblema FROM partido WHERE IdPartido=? limit 1";
	private static final String SQL_INSERT = "INSERT INTO partido(nombrePartido,nombreImagen,abrev,emblema) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE partido SET nombrePartido=?,nombreImagen=?,emblema=? WHERE IdPartido=?";
	private static final String SQL_DELETE = "DELETE FROM partido WHERE IdPartido=?";
	private  Connection conexion;
	

	public PartidoDao() {
		super();
		try {
			this.conexion=Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PartidoDao(Connection conexion) {
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
	public ArrayList<Partido> mostrarPartidos() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Partido partido = null;

		ArrayList<Partido> partidos = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idPartido=rs.getInt("IdPartido");
				String nombrePartido=rs.getString("nombrePartido");
				String nombreImagen=rs.getString("nombreImagen");
				String abrev=rs.getString("abrev");
				String emblema=rs.getString("emblema");
				//InputStream emblema=rs.getBinaryStream("emblema");
				//int estadoActual=rs.getInt("estadoActual")
				partido=new Partido(idPartido,nombrePartido, nombreImagen,abrev,emblema);
				partidos.add(partido);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(rs);
			Conexion.close(conn);
		}

		return partidos;

	}

	@Override
	public Partido buscarPartido(Partido partido) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1, partido.getIdPartido());
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				partido.setIdPartido(rs.getInt("IdPartido"));
				partido.setNombrePartido(rs.getString("nombrePartido"));
				partido.setNombreImagen(rs.getString("nombreImagen"));
				partido.setAbrev(rs.getString("abrev"));
				partido.setEmblema(rs.getString("emblema"));
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
		return partido;
	}

	@Override
	public int insertarPartido(Partido partido) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn =this.getConexion();
			//System.out.println("conexion asignada: "+conn);
			psmt = conn.prepareStatement(SQL_INSERT);
			psmt.setString(1, partido.getNombrePartido());
			psmt.setString(2, partido.getNombreImagen());
			psmt.setString(3, partido.getAbrev());
			psmt.setString(4, partido.getEmblema());

			rows = psmt.executeUpdate();

			//psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(conn);
			Conexion.close(psmt);
			Conexion.close(conn);
		}
		return rows;
		
	}

	@Override
	public int actualizarPartido(Partido partido) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarPartido(Partido partido) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String[] args) {
	Partido partido=new Partido(1);
	PartidoDao pdDao=new PartidoDao();
	System.out.println(pdDao.buscarPartido(partido));
	//pdDao.insertarPartido(partido);

}
}
