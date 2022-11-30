package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Boleta;
import mx.com.fi.proyecto.dominio.Candidato;
import mx.com.fi.proyecto.interfaz.BoletaInterfaz;

public class BoletaDao implements BoletaInterfaz {
	private static final String SQL_SELECT_GENERAL = "SELECT IdBoleta,procesoElectoral,tipoEleccion,entidadFederativa,municipio,distritoElectoral,periodo FROM boleta";

	private static final String SQL_SELECT_BY_ID = "SELECT IdCandidato,nombre,cargo,edad,sexo FROM candidato WHERE IdCandidato= ? limit 1";
	private static final String SQL_INSERT = "INSERT INTO boleta(procesoElectoral,tipoEleccion,entidadFederativa,municipio,distritoElectoral,periodo) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE candidato SET nombre=?,cargo=?,edad=?,sexo=? WHERE IdCandidato=?";
	private static final String SQL_DELETE = "DELETE FROM candidato WHERE IdCandidato=?";
	private  Connection conexion;
	public BoletaDao() {
		super();
		try {
			this.conexion=Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public BoletaDao(Connection conexion) {
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
	public ArrayList<Boleta> mostrarBoletas() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Boleta boleta = null;

		ArrayList<Boleta> boletas = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT_GENERAL);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idCandidato=rs.getInt("IdBoleta");
				
				String procesoElectoral=rs.getString("procesoElectoral");
				String tipoEleccion=rs.getString("tipoEleccion");
				int entidadFederativa=rs.getInt("entidadFederativa");
				int municipio=rs.getInt("municipio");
				String distritoElectoral=rs.getString("distritoElectoral");
				String periodo=rs.getString("periodo");

				boleta=new Boleta(idCandidato, procesoElectoral, tipoEleccion, entidadFederativa, municipio, distritoElectoral, periodo);
				boletas.add(boleta);
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

		return boletas;
	}


	@Override
	public Boleta buscarBoleta(Boleta boleta) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int insertarBoleta(Boleta boleta) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn =this.getConexion();
			//System.out.println("conexion asignada: "+conn);
			psmt = conn.prepareStatement(SQL_INSERT);
			psmt.setString(1, boleta.getProcesoElectoral());
			psmt.setString(2, boleta.getTipoEleccion());
			psmt.setInt(3,boleta.getEntidadFederativa());
			psmt.setInt(4,boleta.getMunicipio());
			psmt.setString(5,boleta.getDistritoElectoral());
			psmt.setString(6,boleta.getPeriodo());
			
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
	public int actualizarBoleta(Boleta boleta) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int eliminarBoleta(Boleta boleta) {
		// TODO Auto-generated method stub
		return 0;
	}
	/*public static void main(String[] args) {
		//BoletaDao btDao= new BoletaDao();
		//Boleta boleta=new Boleta("Estatal", "Senador", 15, 770, 1, "015", "2021-2022");
		//btDao.insertarBoleta(boleta);
		
	ArrayList<Boleta> boletas=new BoletaDao().mostrarBoletas();
		for (Boleta boleta : boletas) {
			System.out.println(boleta);
		}
	}*/

}
