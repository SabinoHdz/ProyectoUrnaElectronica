package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.fi.proyecto.dao.UrnaDao;
import mx.com.fi.proyecto.dominio.Urna;

import java.io.IOException;

/**
 * Servlet implementation class indexServletControlador
 */
public class indexServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServletControlador() {
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
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		String accion=request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "editar": 
				obtenerUrna(request, response);
				
				//doGet(request, response);
				break;
			case "eliminar":
				eliminarUrna(request,response);
				
			default:
				//doGet(request, response);
				response.sendRedirect("index.jsp");
				break;
				
			}
			
		}else {
			//doGet(request, response);
			response.sendRedirect("index.jsp");
		}
		
		
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
				insertarUrna(request, response);
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
	
	private void insertarUrna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String codigoPostal=request.getParameter("codigoPostal");
		String codigoActivacion=request.getParameter("codigoActivacion");
		String estado=request.getParameter("estado");
		int iEstado=Integer.parseInt(estado);
		Urna urna=new Urna(codigoPostal, codigoActivacion, iEstado);
		UrnaDao insertUrnaDao=new UrnaDao();
		int registrosModificado=insertUrnaDao.insetarUrna(urna);
		
	}
	
	private void obtenerUrna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Recuperar IdUrna
		int idUrna=Integer.parseInt(request.getParameter("idUrna"));
		
		Urna urnaSearch=new UrnaDao().buscarUrna(new Urna(idUrna));
		String jspEditar="/WEB-INF/paginas/urna/editarUrna.jsp";
		request.setAttribute("urnaedit",urnaSearch );
		request.getRequestDispatcher(jspEditar).forward(request, response);
	}
	private void eliminarUrna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int idUrna=Integer.parseInt(request.getParameter("idUrna"));
		Urna urna=new Urna(idUrna);
		int registrosEliminados=new UrnaDao().eliminarUrna(urna);
		
	}

}
