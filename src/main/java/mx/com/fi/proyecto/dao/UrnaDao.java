package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Urna;
import mx.com.fi.proyecto.interfaz.UrnaInterfaz;

public class UrnaDao implements UrnaInterfaz {
	private static final String SQL_SELECT = "SELECT idUrna,codigoPostal,codigoActivacion,estadoActual FROM urna";
	private static final String SQL_SELECT_BY_ID = "SELECT idUrna,codigoPostal,codigoActivacion,estadoActual FROM urna WHERE idUrna= ? limit 1";
	private static final String SQL_INSERT = "INSERT INTO urna(codigoPostal,codigoActivacion,estadoActual) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE urna SET codigoPostal=?,codigoActivacion=?,estadoActual=? WHERE idUrna=?";
	private static final String SQL_DELETE = "DELETE FROM urna WHERE idUrna=?";
	private  Connection conexion;
	
	public Connection getConexion() {
		return this.conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public UrnaDao() {
		super();
		try {
			this.conexion=Conexion.getConexion();
			System.out.println("Conexion creado: ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Urna> mostrarUrnas() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Urna urna = null;

		ArrayList<Urna> urnas = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idUrna=rs.getInt("idUrna");
				String codigoPostal=rs.getString("codigoPostal");
				String codigoActivacion=rs.getString("codigoActivacion");
				int estadoActual=rs.getInt("estadoActual");
				urna=new  Urna(idUrna, codigoPostal, codigoActivacion, estadoActual);
				urnas.add(urna);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(rs);
			Conexion.close(conn);
		}

		return urnas;

	}

	@Override
	public Urna buscarUrna(Urna urna) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1,  urna.getIdUrna());
			//System.out.println(stmt);
			System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			System.out.println("rs: "+rs);
			while (rs.next()) {
				System.out.println(rs.getInt("idUrna"));
				System.out.println(rs.getString("codigoPostal"));
				System.out.println(rs.getString("codigoActivacion"));
				System.out.println(rs.getInt("estadoActual"));
				urna.setIdUrna(rs.getInt("idUrna"));
				urna.setCodigoPostal(rs.getString("codigoPostal"));
				urna.setCodigoActivacion(rs.getString("codigoActivacion"));
				urna.setEstadoActual(rs.getInt("estadoActual"));
				

			}

			/*rs.absolute(1);
			
			int idUrna = rs.getInt("idUrna");
			String codigoPostal = rs.getString("codigoPostal");
			String codigoActivacion = rs.getString("codigoActivacion");
			int estadoActual = rs.getInt("estadoActual");

			urna.setCodigoPostal(codigoPostal);
			urna.setCodigoActivacion(codigoActivacion);
			urna.setEstadoActual(estadoActual);*/
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(stmt);
			Conexion.close(rs);
			//Conexion.close(conn);
		}
		return urna;
	}

	@Override
	public int insetarUrna(Urna urna) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn =this.getConexion();
			System.out.println("conexion asignada: "+conn);
			psmt = conn.prepareStatement(SQL_INSERT);
			psmt.setString(1, urna.getCodigoPostal());
			psmt.setString(2, urna.getCodigoActivacion());
			psmt.setInt(3, urna.getEstadoActual());

			rows = psmt.executeUpdate();

			//psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(conn);
		}
		return rows;
	}

	@Override
	public int actualizarUrna(Urna urna) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn = this.getConexion();
			psmt = conn.prepareStatement(SQL_UPDATE);
			psmt.setString(1, urna.getCodigoPostal());
			psmt.setString(2, urna.getCodigoActivacion());
			psmt.setInt(3, urna.getEstadoActual());
			psmt.setInt(4, urna.getIdUrna());

			rows = psmt.executeUpdate();

			psmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);
			Conexion.close(conn);
		}
		return rows;
	}

	@Override
	public int eliminarUrna(Urna urna) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn=this.getConexion();
			psmt = conn.prepareStatement(SQL_DELETE);

			psmt.setInt(1, urna.getIdUrna());
			rows = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			Conexion.close(psmt);

			Conexion.close(conn);
		}
		return rows;
	}
	/*public static void main(String[] args) {
		Urna urna=new Urna(1);
		UrnaDao urnaDao=new UrnaDao();
		Urna urnaFind=urnaDao.buscarUrna(urna);
		
		//System.out.println(urnaFind.toString());
	}*/

	
}
