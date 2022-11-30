package mx.com.fi.proyecto.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.fi.proyecto.dao.MunicipioDao;
import mx.com.fi.proyecto.dominio.Municipio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class MunicipioServletControlador
 */
@MultipartConfig
public class MunicipioServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MunicipioServletControlador() {
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
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  response.setContentType("text/html;charset=UTF-8");
    	  response.setCharacterEncoding("UTF-8");
    	  
    	PrintWriter out=response.getWriter();
    	
    	
    	String estado=request.getParameter("estado");
    	int  iEstado=Integer.parseInt(estado);
    	ArrayList<Municipio> municipioByEstado= new ArrayList<>();
    	municipioByEstado=new MunicipioDao().mostrarMunicipiosByEstado(iEstado);
    	String nombre="Sabino";
    	String edad="20";
    	
    	String json="[";
    			for (Municipio municipio : municipioByEstado) {
					json+="{\"idMunicipio\":\""+municipio.getIdMunicipio()+"\",\"nombre\":\""+municipio.getNombre()+"\"},";
				}
    			json = json.substring(0, json.length() - 1);
    	json+= "]";
    	out.print(json);
    	out.flush();
    }
    

}
