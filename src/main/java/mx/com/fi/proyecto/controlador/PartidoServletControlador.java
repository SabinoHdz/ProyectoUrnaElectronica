package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mx.com.fi.proyecto.dao.PartidoDao;
import mx.com.fi.proyecto.dao.UrnaDao;
import mx.com.fi.proyecto.dominio.Partido;
import mx.com.fi.proyecto.dominio.Urna;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

/**
 * Servlet implementation class PartidoServletControlador
 */
@MultipartConfig
public class PartidoServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartidoServletControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("partido.jsp").forward(request, response);
		response.sendRedirect("partido.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String accion=request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "insertar": 
				insertarPartido(request, response);
				doGet(request, response);
				break;
			default:
				doGet(request, response);
				break;
				
			}
			
		}else {
			doGet(request, response);
		}
	}
	
	private void insertarPartido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nombrePartido=request.getParameter("partidoPolitico");
		String abreviacion=request.getParameter("abreviacion");
		String nombreImagen=request.getParameter("nombreImagen");
		//Part part=request.getPart("emblema");
		//InputStream emblema=part.getInputStream();
		//String estado=request.getParameter("estado");
		//int iEstado=Integer.parseInt(estado);
		Part archivo = request.getPart("emblema");
	    String fileName = Paths.get(archivo.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    
	    String pathOrigin = request.getServletContext().getRealPath("/imagenes/");
	  	
	  	//out.print("<p>Path origin: "+pathOrigin+"</p>");
	  	File file = new File(pathOrigin , fileName);
	  	
	  	try(InputStream input=archivo.getInputStream()){
            Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
        }
	    
		//System.out.println(fileName);
		Partido partidoPolitico=new Partido(nombrePartido, nombreImagen, abreviacion, fileName);
		PartidoDao insertPartidoDao=new PartidoDao();
		insertPartidoDao.insertarPartido(partidoPolitico);
	}

}

