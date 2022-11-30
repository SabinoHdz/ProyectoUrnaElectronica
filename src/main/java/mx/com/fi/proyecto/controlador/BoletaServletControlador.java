package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.fi.proyecto.dao.BoletaDao;
import mx.com.fi.proyecto.dao.CandidatoDao;
import mx.com.fi.proyecto.dominio.Boleta;
import mx.com.fi.proyecto.dominio.Candidato;

import java.io.IOException;

/**
 * Servlet implementation class BoletaServletControlador
 */
public class BoletaServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoletaServletControlador() {
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
		request.getRequestDispatcher("boleta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "insertar": 
				insertarBoleta(request, response);
				doGet(request, response);
				break;
			case "actualizar":
				//actualizarBoleta(request,response);
				response.sendRedirect("boleta.jsp");
				break;
			default:
				doGet(request, response);
				break;	
			}
		}else {
			doGet(request, response);
		}
	}
	
	private void insertarBoleta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String procesoElectoral=request.getParameter("procesoElectoral");
		String tipoEleccion=request.getParameter("tipoEleccion");
		String estado=request.getParameter("estado");
		String municipio=request.getParameter("municipio");
		int iestado=Integer.parseInt(estado);
		int imunicipio=Integer.parseInt(municipio);
		String distritoElectoral=request.getParameter("distritoElectoral");
		String periodo=request.getParameter("periodo");
		
		Boleta boleta=new Boleta(procesoElectoral, tipoEleccion, iestado, imunicipio, distritoElectoral, periodo);
		BoletaDao insertBoletDao=new BoletaDao();
		int registrosModificado=insertBoletDao.insertarBoleta(boleta);
		
	}

}
