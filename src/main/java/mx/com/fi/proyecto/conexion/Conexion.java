package mx.com.fi.proyecto.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;



public class Conexion {
	/*
	private static final String BD = "urnaelectronica";
	private static final String URL = "jdbc:mysql://localhost:3306/";*/
	private static final String JDBC_URL ="jdbc:mysql://localhost:3306/urnaelectronicabd?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private  static BasicDataSource dataSource;
	
	public static DataSource getDataSource() {
		if(dataSource==null) {
			dataSource = new BasicDataSource();
			dataSource.setUrl(JDBC_URL);
			dataSource.setDriverClassName(JDBC_DRIVER);
			dataSource.setUsername(JDBC_USER);
			dataSource.setPassword(JDBC_PASSWORD);
			dataSource.setInitialSize(50);
			
		}
		
		return dataSource;
	}
	
	public static Connection getConexion() throws SQLException {
		System.out.println(JDBC_URL);
		Connection conexion;
		conexion=getDataSource().getConnection();
		return  conexion;
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection cn) {
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) {
		
		try {
			Conexion c=new Conexion();
			Connection cn=c.getConexion();
			System.out.println(cn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	
	
}
