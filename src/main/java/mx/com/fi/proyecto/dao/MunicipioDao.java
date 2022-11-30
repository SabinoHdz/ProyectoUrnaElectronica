package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Municipio;
import mx.com.fi.proyecto.interfaz.MunicipioInterfaz;

public class MunicipioDao implements MunicipioInterfaz {
	private static final String SQL_SELECT_GENERAL = "SELECT IdMunicipio,IdEstado,clave,nombre FROM municipio";
	private static final String SQL_SELECT_BY_ID = "SELECT IdMunicipio,IdEstado,clave,nombre  FROM municipio WHERE IdMunicipio= ? limit 1";
	private static final String SQL_SELECT_BY_Estado = "SELECT IdMunicipio,IdEstado,nombre FROM municipio WHERE IdEstado= ?";
	private Connection conexion;

	public MunicipioDao() {
		super();
		try {
			this.conexion = Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MunicipioDao(Connection conexion) {
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
	public ArrayList<Municipio> mostrarMunicipios() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Municipio municipio = null;

		ArrayList<Municipio> municipiosAll = new ArrayList<>();
		try {
			conn = this.getConexion();
			psmt = conn.prepareStatement(SQL_SELECT_GENERAL);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int idMunicipio = rs.getInt("IdMunicipio");
				int idEstatdo = rs.getInt("IdEstado");
				String clave = rs.getString("clave");
				String nombre = rs.getString("nombre");
				
				municipio =new Municipio(idMunicipio, idEstatdo, clave, nombre);
						municipiosAll.add(municipio);
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

		return municipiosAll;
	}

	@Override
	public ArrayList<Municipio> mostrarMunicipiosByEstado(int idEstado) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Municipio municipio = null;
		ArrayList<Municipio> municipios = new ArrayList<>();
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_Estado);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1, idEstado);
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				
				int idMunicipio = rs.getInt("IdMunicipio");
				int idEstadoSelect = rs.getInt("IdEstado");
		
				String nombre = rs.getString("nombre");
				Municipio mcp=new Municipio(idMunicipio, idEstadoSelect, nombre);
				municipios.add(mcp);
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
		return municipios;
	
	}

	@Override
	public Municipio buscarMunicipio(Municipio municipio) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1, municipio.getIdMunicipio());
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				municipio.setIdMunicipio(rs.getInt("IdMunicipio"));
				municipio.setIdEstado(rs.getInt("IdEstado"));
				municipio.setClave(rs.getString("clave"));
				municipio.setNombre(rs.getString("nombre"));
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
		return municipio;
	}
	public static void main(String[] args) {
		//MunicipioDao mcpDao= new MunicipioDao();
		//ArrayList<Municipio> municipios=mcpDao.mostrarMunicipiosByEstado(15);
		//for (Municipio municipio : municipios) {
			//System.out.println(municipio);
		//}
	
		//Municipio m = new Municipio(770);
		//Municipio search=new MunicipioDao().buscarMunicipio(m);
		//System.out.println(search);
	}
}
