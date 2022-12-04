package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mx.com.fi.proyecto.dao.PartidoDao;
import mx.com.fi.proyecto.dao.UrnaDao;
import mx.com.fi.proyecto.dominio.Partido;
import mx.com.fi.proyecto.dominio.Urna;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Servlet implementation class PartidoServletControlador
 */
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
				//doGet(request, response);
				break;
			default:
				//doGet(request, response);
				break;
				
			}
			
		}else {
			//doGet(request, response);
		}
	}
	
	private void insertarPartido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nombrePartido=request.getParameter("partidoPolitico");
		String abreviacion=request.getParameter("abreviacion");
		String nombreImagen=request.getParameter("nombreImagen");
		Part part=request.getPart("emblema");
		InputStream emblema=part.getInputStream();
		//String estado=request.getParameter("estado");
		//int iEstado=Integer.parseInt(estado);
		Partido partidoPolitico=new Partido(nombrePartido, nombreImagen, abreviacion, nombreImagen);
		PartidoDao insertPartidoDao=new PartidoDao();
		insertPartidoDao.insertarPartido(partidoPolitico);
		

	}

}

