package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Boleta;
import mx.com.fi.proyecto.dominio.BoletaElectronica;
import mx.com.fi.proyecto.dominio.Candidato;
import mx.com.fi.proyecto.dominio.Partido;
import mx.com.fi.proyecto.dominio.Postulacion;
import mx.com.fi.proyecto.interfaz.BoletaElectronicaInterfaz;
public class BoletaElectronicaDao implements BoletaElectronicaInterfaz{
	
	private static final String SQL_SELECT_GENERAL = "SELECT IdBoletaPostulante,boleta,postulacion FROM boletapostulante";

	private static final String SQL_SELECT_BY_ID = "SELECT IdBoletaPostulante,boleta,postulacion  FROM boleta WHERE  IdBoletaPostulante= ? limit 1";
	private static final String SQL_SELECT_BY_ID_BOLETA = "SELECT boleta,postulacion  FROM boletapostulante WHERE  boleta= ?";
	private static final String SQL_INSERT = "INSERT INTO boletapostulante(boleta,postulacion) VALUES (?,?)";
	private  Connection conexion;
	

	public BoletaElectronicaDao() {
		super();
		try {
			this.conexion=Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BoletaElectronicaDao(Connection conexion) {
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
	public ArrayList<BoletaElectronica> mostrarBoletasElectronicas() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BoletaElectronica boletaElect = null;

		ArrayList<BoletaElectronica> boletas = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT_GENERAL);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idBoletaPostulante=rs.getInt("IdBoletaPostulante");
				int boleta=rs.getInt("boleta");
				int postulacion=rs.getInt("postulacion");

				boletaElect=new BoletaElectronica(postulacion, idBoletaPostulante, postulacion);
				boletas.add(boletaElect);
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
	public ArrayList<BoletaElectronica> mostrarBoletasElectronicasById(int idBoleta) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BoletaElectronica be=null;
		ArrayList<BoletaElectronica> boletasElectronicas=new ArrayList<>();
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID_BOLETA);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1,idBoleta);
			
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				
				int idBta=rs.getInt("boleta");
				int postulante=rs.getInt("postulacion");
				be=new BoletaElectronica(idBoleta, postulante);
				boletasElectronicas.add(be);
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
		return boletasElectronicas;
	}
	@Override
	public BoletaElectronica buscarBoletaElectronica(BoletaElectronica boleta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarBoleta(BoletaElectronica boleta) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn =this.getConexion();
			//System.out.println("conexion asignada: "+conn);
			psmt = conn.prepareStatement(SQL_INSERT);
			psmt.setInt(1,boleta.getIdBoleta());
			psmt.setInt(2,boleta.getIdPostulacion());
		
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

		public static void main(String[] args) {
			
			BoletaElectronicaDao bdao=new BoletaElectronicaDao();
			ArrayList<BoletaElectronica> bltElectronica=new ArrayList<>();
			bltElectronica=bdao.mostrarBoletasElectronicasById(1);
			ArrayList<Postulacion> postulaciones=new ArrayList<>();
			
			for (BoletaElectronica boletaElectronica : bltElectronica) {
				Postulacion postulacion= new Postulacion(boletaElectronica.getIdPostulacion());
				Postulacion postulacionSearch=new PostulacionDao().buscarPostulacion(postulacion);
				postulaciones.add(postulacionSearch);
				//System.out.println(postulacionSearch);
				//Candidato
				//Candidato candidatoPropietario= new Candidato(postulacionSearch.getIdCandidato());
				//Candidato propietarioSearch=new CandidatoDao().buscarCandidato(candidatoPropietario);
				
				//Propietario
				//Candidato candidatoSuplente= new Candidato(postulacionSearch.getIdSuplente());
				//Candidato suplenteSearch=new CandidatoDao().buscarCandidato(candidatoSuplente);
				//Partido 
				//Partido partido=new Partido(postulacionSearch.getIdPartido());
				//Partido partidoSearch= new PartidoDao().buscarPartido(partido);
				
				//System.out.println( propietarioSearch.getNombre()+" | "+propietarioSearch.getCargo());
				//System.out.println(suplenteSearch.getNombre()+" | "+suplenteSearch.getCargo());
				//System.out.println(partidoSearch.getNombrePartido()+" | "+ partidoSearch.getEmblema());
				//System.out.println("****************");
			}
			
			for (Postulacion postulacion : postulaciones) {
				System.out.println(postulacion);
			}
			
		}


}
