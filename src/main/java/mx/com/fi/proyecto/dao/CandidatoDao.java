package mx.com.fi.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.fi.proyecto.conexion.Conexion;
import mx.com.fi.proyecto.dominio.Candidato;
import mx.com.fi.proyecto.dominio.Partido;
import mx.com.fi.proyecto.interfaz.CandidatoInterfaz;

public class CandidatoDao implements CandidatoInterfaz{
	private static final String SQL_SELECT_GENERAL = "SELECT IdCandidato,nombre,cargo,edad,sexo FROM candidato";
	private static final String SQL_SELECT_OWNER = "SELECT IdCandidato,nombre,cargo FROM candidato WHERE cargo='Propietario' AND bHabilitado=1";
	private static final String SQL_SELECT_ALTERNATE = "SELECT IdCandidato,nombre,cargo FROM candidato WHERE cargo='Suplente' AND bHabilitado=1";

	private static final String SQL_SELECT_BY_ID = "SELECT IdCandidato,nombre,cargo,edad,sexo FROM candidato WHERE IdCandidato= ? limit 1";
	private static final String SQL_INSERT = "INSERT INTO candidato(nombre,cargo,edad,sexo) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE candidato SET nombre=?,cargo=?,edad=?,sexo=? WHERE IdCandidato=?";
	private static final String SQL_DELETE = "DELETE FROM candidato WHERE IdCandidato=?";
	private  Connection conexion;
	
	
	public CandidatoDao() {
		super();
		try {
			this.conexion=Conexion.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public CandidatoDao(Connection conexion) {
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
	public ArrayList<Candidato> mostrarCandidatos() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Candidato candidato = null;

		ArrayList<Candidato> candidatos = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT_GENERAL);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idCandidato=rs.getInt("IdCandidato");
				String nombre=rs.getString("nombre");
				String cargo=rs.getString("cargo");
				int edad=rs.getInt("edad");
				String sexo=rs.getString("sexo");

				candidato= new Candidato(idCandidato,nombre, cargo, sexo, edad);
				candidatos.add(candidato);
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

		return candidatos;
	}

	@Override
	public ArrayList<Candidato> mostrarPropietarios() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Candidato propietatorio = null;

		ArrayList<Candidato> candidatos = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT_OWNER);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idCandidato=rs.getInt("IdCandidato");
				String nombre=rs.getString("nombre");
				String cargo=rs.getString("cargo");

				propietatorio= new Candidato(idCandidato,nombre,cargo);
				candidatos.add(propietatorio);
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

		return candidatos;
	}

	@Override
	public ArrayList<Candidato> mostrarSuplentes() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Candidato suplente = null;

		ArrayList<Candidato> candidatos = new ArrayList<>();
		try {
			conn =this.getConexion();
			psmt=conn.prepareStatement(SQL_SELECT_ALTERNATE);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int idCandidato=rs.getInt("IdCandidato");
				String nombre=rs.getString("nombre");
				String cargo=rs.getString("cargo");

				suplente= new Candidato(idCandidato,nombre,cargo);
				candidatos.add(suplente);
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

		return candidatos;
	}


	@Override
	public Candidato buscarCandidato(Candidato candidato) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn =Conexion.getConexion();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			System.out.println("prepare: "+stmt);
			stmt.setInt(1,  candidato.getIdCandidato());
			//System.out.println(stmt);
			//System.out.println("prepare2: "+stmt);
			rs = stmt.executeQuery();
			//System.out.println("rs: "+rs);
			while (rs.next()) {
				candidato.setIdCandidato(rs.getInt("IdCandidato"));
				candidato.setNombre(rs.getString("nombre"));
				candidato.setCargo(rs.getString("cargo"));
				candidato.setEdad(rs.getInt("edad"));
				candidato.setSexo(rs.getString("sexo"));
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
		return candidato;
	}


	@Override
	public int insertarCandidato(Candidato candidato) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn =this.getConexion();
			//System.out.println("conexion asignada: "+conn);
			psmt = conn.prepareStatement(SQL_INSERT);
			psmt.setString(1, candidato.getNombre());
			psmt.setString(2, candidato.getCargo());
			psmt.setInt(3,candidato.getEdad());
			psmt.setString(4,candidato.getSexo());
			

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
	public int actualizarCandidato(Candidato candidato) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn = this.getConexion();
			psmt = conn.prepareStatement(SQL_UPDATE);
			psmt.setString(1, candidato.getNombre());
			psmt.setString(2,candidato.getCargo());
			psmt.setInt(3, candidato.getEdad());
			psmt.setString(4, candidato.getSexo());
			psmt.setInt(5, candidato.getIdCandidato());
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
	public int eliminarCandidato(Candidato candidato) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int rows = 0;
		try {
			conn=this.getConexion();
			psmt = conn.prepareStatement(SQL_DELETE);

			psmt.setInt(1,candidato.getIdCandidato());
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

	/*public static void main(String[] args) {
		//Candidato cdo=new Candidato(3, "Juan Perez Moraless", "Propietario", "Masculino", 50);
		//CandidatoDao dao=new CandidatoDao();
		//System.out.println(dao.getConexion());
		//int reg=dao.actualizarCandidato(cdo);
		//System.out.println("Reg: "+reg);
		
	}*/
	

}
