package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.fi.proyecto.dao.CandidatoDao;
import mx.com.fi.proyecto.dao.PostulacionDao;
import mx.com.fi.proyecto.dominio.Candidato;
import mx.com.fi.proyecto.dominio.Postulacion;

import java.io.IOException;

/**
 * Servlet implementation class PostulacionServletControlador
 */
public class PostulacionServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostulacionServletControlador() {
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
		String accion=request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "eliminar":
				eliminarPostulacion(request, response);
				
			default:
				//doGet(request, response);
				response.sendRedirect("postulacion.jsp");
				break;
				
			}
			
		}else {
			//doGet(request, response);
			response.sendRedirect("postulacion.jsp");
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
				insertarPostulacion(request, response);
				doGet(request, response);
				break;
			case "actualizar":
				//actualizarCandidato(request,response);
				//response.sendRedirect("candidato.jsp");
				break;
			default:
				doGet(request, response);
				break;	
			}
		}else {
			doGet(request, response);
		}
	}
	
	private void insertarPostulacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String candidato=request.getParameter("candidato");
		String suplente=request.getParameter("suplente");
		String partido=request.getParameter("partido");
		String tipoEleccion=request.getParameter("eleccion");
		int idCandidato=Integer.parseInt(candidato);
		int idSuplente=Integer.parseInt(suplente);
		int idPartido=Integer.parseInt(partido);
		
		
		Postulacion postulacion=new Postulacion(idCandidato, idSuplente, idPartido, tipoEleccion);
		PostulacionDao insertPostDao=new PostulacionDao();
		int registrosModificado=insertPostDao.insertarPostulacion(postulacion);
		
	}
	private void eliminarPostulacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int idPostulacion=Integer.parseInt(request.getParameter("idPostulacion"));
		Postulacion postulacion=new Postulacion(idPostulacion);
		int registrosEliminados=new PostulacionDao().eliminarPostulacion(postulacion);
		
	}

}
