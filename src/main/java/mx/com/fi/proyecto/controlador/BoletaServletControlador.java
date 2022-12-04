package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.fi.proyecto.dao.BoletaDao;
import mx.com.fi.proyecto.dao.BoletaElectronicaDao;
import mx.com.fi.proyecto.dao.CandidatoDao;
import mx.com.fi.proyecto.dominio.Boleta;
import mx.com.fi.proyecto.dominio.BoletaElectronica;
import mx.com.fi.proyecto.dominio.Candidato;

import java.io.IOException;
import java.security.SecureRandom;

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
		//request.getRequestDispatcher("boleta.jsp").forward(request, response);
		String accion=request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "mostrar": 
				mostrarBoleta(request, response);
				//doGet(request, response);
				break;
			default:
				//doGet(request, response);
				response.sendRedirect("boleta.jsp");
				break;
				
			}
		}else {
			//doGet(request, response);
			response.sendRedirect("boleta.jsp");
		}
		
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
			case "agregarPartido":
					agregarPartidosABoleta(request, response);
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
	
	private void insertarBoleta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String procesoElectoral=request.getParameter("procesoElectoral");
		String tipoEleccion=request.getParameter("tipoEleccion");
		String estado=request.getParameter("estado");
		String municipio=request.getParameter("municipio");
		int iestado=Integer.parseInt(estado);
		int imunicipio=Integer.parseInt(municipio);
		String distritoElectoral=request.getParameter("distritoElectoral");
		String periodo=request.getParameter("periodo");
		String clave = generateRandomKey(15);
		Boleta boleta=new Boleta(clave,procesoElectoral, tipoEleccion, iestado, imunicipio, distritoElectoral, periodo);
		BoletaDao insertBoletDao=new BoletaDao();
		int registrosModificado=insertBoletDao.insertarBoleta(boleta);
		
	}
	
	private void agregarPartidosABoleta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String boleta=request.getParameter("Boleta");
		String postulante =request.getParameter("postulantePartido");
		
		int iboleta=Integer.parseInt(boleta);
		int ipostulante=Integer.parseInt(postulante);
		
		BoletaElectronica boletaElect=new BoletaElectronica(iboleta, ipostulante);
		BoletaElectronicaDao insertBoletDao=new BoletaElectronicaDao();
		int registrosModificado=insertBoletDao.insertarBoleta(boletaElect);
		
	}
	public void mostrarBoleta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String boletaElectronica=request.getParameter("idBoleta");
		String jspEditar="/WEB-INF/paginas/boleta/viewBoleta.jsp";
		request.setAttribute("idBoleta",boletaElectronica );
		request.getRequestDispatcher(jspEditar).forward(request, response);
		
	}
	 // Método para generar una contraseña alfanumérica aleatoria de una longitud específica
    public static String generateRandomKey(int len)
    {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }

}
