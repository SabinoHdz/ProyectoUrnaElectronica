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
	private static final String SQL_SELECT_GENERAL = "SELECT IdBoleta,codigoBoleta,procesoElectoral,tipoEleccion,entidadFederativa,municipio,distritoElectoral,periodo FROM boleta";

	private static final String SQL_SELECT_BY_ID = "SELECT IdBoleta,codigoBoleta,procesoElectoral,tipoEleccion,entidadFederativa,municipio,distritoElectoral,periodo FROM boleta WHERE IdBoleta= ? limit 1";
	private static final String SQL_INSERT = "INSERT INTO boleta(codigoBoleta,procesoElectoral,tipoEleccion,entidadFederativa,municipio,distritoElectoral,periodo) VALUES (?,?,?,?,?,?,?)";
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
				String codigoBoleta=rs.getString("codigoBoleta");
				String procesoElectoral=rs.getString("procesoElectoral");
				String tipoEleccion=rs.getString("tipoEleccion");
				int entidadFederativa=rs.getInt("entidadFederativa");
				int municipio=rs.getInt("municipio");
				String distritoElectoral=rs.getString("distritoElectoral");
				String periodo=rs.getString("periodo");

				boleta=new Boleta(idCandidato,codigoBoleta, procesoElectoral, tipoEleccion, entidadFederativa, municipio, distritoElectoral, periodo);
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
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1,  boleta.getIdBoleta());
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				boleta.setIdBoleta(rs.getInt("IdBoleta"));
				boleta.setCodigoBoleta(rs.getString("codigoBoleta"));
				boleta.setProcesoElectoral(rs.getString("procesoElectoral"));
				boleta.setTipoEleccion(rs.getString("tipoEleccion"));
				boleta.setEntidadFederativa(rs.getInt("entidadFederativa"));
				boleta.setMunicipio(rs.getInt("municipio"));
				boleta.setDistritoElectoral(rs.getString("distritoElectoral"));
				boleta.setPeriodo(rs.getString("periodo"));
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
		return boleta;
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
			psmt.setString(1, boleta.getCodigoBoleta());
			psmt.setString(2, boleta.getProcesoElectoral());
			psmt.setString(3, boleta.getTipoEleccion());
			psmt.setInt(4,boleta.getEntidadFederativa());
			psmt.setInt(5,boleta.getMunicipio());
			psmt.setString(6,boleta.getDistritoElectoral());
			psmt.setString(7,boleta.getPeriodo());
			
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
	public static void main(String[] args) {
		//BoletaDao btDao= new BoletaDao();
		//Boleta boleta=new Boleta("Estatal", "Senador", 15, 770, 1, "015", "2021-2022");
		//btDao.insertarBoleta(boleta);
		
	//ArrayList<Boleta> boletas=new BoletaDao().mostrarBoletas();
		//for (Boleta boleta : boletas) {
	//		System.out.println(boleta);
		//}
	//Boleta blt=new Boleta(1);
	//Boleta bltSearch=new BoletaDao().buscarBoleta(blt);
	//System.out.println(bltSearch);
	}

}
