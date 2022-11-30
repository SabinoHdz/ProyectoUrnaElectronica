package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.fi.proyecto.dao.CandidatoDao;
import mx.com.fi.proyecto.dao.UrnaDao;
import mx.com.fi.proyecto.dominio.Candidato;
import mx.com.fi.proyecto.dominio.Urna;

import java.io.IOException;

/**
 * Servlet implementation class CandidatoServletControlador
 */
public class CandidatoServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatoServletControlador() {
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
		//request.getRequestDispatcher("candidato.jsp").forward(request, response);

		String accion=request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "editar": 
				obtenerCandidato(request, response);
				
				//doGet(request, response);
				break;
			case "eliminar":
				eliminarCandidato(request, response);
				
			default:
				//doGet(request, response);
				response.sendRedirect("candidato.jsp");
				break;
				
			}
			
		}else {
			//doGet(request, response);
			response.sendRedirect("candidato.jsp");
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
				insertarCandidato(request, response);
				doGet(request, response);
				break;
			case "actualizar":
				actualizarCandidato(request,response);
				response.sendRedirect("candidato.jsp");
				break;
			default:
				doGet(request, response);
				break;	
			}
		}else {
			doGet(request, response);
		}
	}
	
	private void insertarCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nombreCompleto=request.getParameter("nombreCompleto");
		String cargo=request.getParameter("cargo");
		String edad=request.getParameter("edad");
		int iedad=Integer.parseInt(edad);
		String sexo=request.getParameter("sexo");
		
		Candidato candidato=new Candidato(nombreCompleto, cargo, sexo, iedad);
		CandidatoDao insertCandDao=new CandidatoDao();
		int registrosModificado=insertCandDao.insertarCandidato(candidato);
		
	}
	private void obtenerCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Recuperar IdUrna
		int idUrna=Integer.parseInt(request.getParameter("idCandidato"));
		
		Candidato candidatoSearch=new CandidatoDao().buscarCandidato(new Candidato(idUrna));
		String jspEditar="/WEB-INF/paginas/candidato/editarCandidato.jsp";
		request.setAttribute("candidatoedit",candidatoSearch );
		request.getRequestDispatcher(jspEditar).forward(request, response);
	}
	
	private void actualizarCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idCandidato=request.getParameter("idCandidato");
		int iCandidato=Integer.parseInt(idCandidato);
		String nombreCompleto=request.getParameter("nombreEdit");
		String cargo=request.getParameter("cargoEdit");
		String edad=request.getParameter("edadEdit");
		int iedad=Integer.parseInt(edad);
		String sexo=request.getParameter("sexoEdit");
		
		Candidato candidato=new Candidato(iCandidato,nombreCompleto, cargo, sexo, iedad);
		CandidatoDao updateCandDao=new CandidatoDao();
		int registrosModificado=updateCandDao.actualizarCandidato(candidato);
		
	}
	private void eliminarCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int idCandidato=Integer.parseInt(request.getParameter("idCandidato"));
		Candidato candidato=new Candidato(idCandidato);
		int registrosEliminados=new CandidatoDao().eliminarCandidato(candidato);
		
	}

}
