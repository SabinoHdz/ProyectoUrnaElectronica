<%@page import="mx.com.fi.proyecto.dao.PartidoDao"%>
<%@ page import="mx.com.fi.proyecto.dominio.Postulacion" %>
<%@ page import="mx.com.fi.proyecto.dao.PostulacionDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Candidato" %>
<%@ page import="mx.com.fi.proyecto.dao.CandidatoDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Partido" %>
<%@ page import="mx.com.fi.proyecto.dao.PartidoDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Boleta" %>
<%@ page import="mx.com.fi.proyecto.dao.BoletaDao" %>
<%@ page import="java.util.*" %>

<div class="modal fade"  id="AgregarPostulanteBoleta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar partidos a boleta</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
        	<form action="BoletaServletControlador" method="POST" class="was-validated">
        		<div class="modal-body">			
        		<div class="row">
	        		<!-- <div class=" col-6 mb-3 form-group">
					    <label for="procesoElectoral" class="form-label">Escribe el proceso electoral:</label>
					    <input type="text" class="form-control" id="procesoElectoral" name="procesoElectoral" required="required" placeholder="Ejem: Proceso Electoral Estatal" autocomplete="off">
					 </div>-->
					  
					  <div class=" col-10 mb-3 form-group">
					    <label for="Boleta" class="form-label">Selecciona la Boleta</label>
					    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
					    <select class="form-select" aria-label="Default select example" name="Boleta" id="Boleta">
						  	<%
						  	int idEstado=0;
						  	int idMunicipio=0;
						  	ArrayList<Boleta> boletas =new ArrayList<>();
						  	BoletaDao boletadao=new BoletaDao();
						  	boletas=boletadao.mostrarBoletas();
						  	
						  	for(Boleta boleta:boletas){
						  		
						  	
						  	%>
						  	<option value="<%=boleta.getIdBoleta()%>"> <%=boleta.getCodigoBoleta() %>  | <%=boleta.getTipoEleccion()%></option>
						  	<%} %>
						  	
						</select>
					  </div>
				</div>
				
				<div class="row"> 
					  
					  <div class="col-10 mb-3 form-group">
					    <label for="postulantePartido" class="form-label">Selecciona  un postulante con partido politico</label>
					    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
					    <select class="form-select" aria-label="Default select example" name="postulantePartido" id="postulantePartido">
						  <option selected value="">Selecciona una estado:</option>
						  <%
						  //Postulant estadoDao=new EstadoDao();
						  //ArrayList<Estado> estados=new ArrayList<>();
						 //estados=estadoDao.mostrarEstados();
						 PostulacionDao postulantesDao=new PostulacionDao();
						 ArrayList<Postulacion> postulaciones = postulantesDao.mostrarPostulacion();
						 
						 	for(Postulacion postulacion: postulaciones){
						 		Candidato candidato= new Candidato(postulacion.getIdCandidato()); 
								Candidato propietarioSearch=new CandidatoDao().buscarCandidato(candidato);

								Partido partido= new Partido(postulacion.getIdPartido());
								Partido partidoSearch=new PartidoDao().buscarPartido(partido);
						  %>
						  	<option value="<%=postulacion.getIdPostulacion()%>"> <%=propietarioSearch.getNombre()%> | <%= partido.getNombrePartido()%>	</option>
						  <% }%>
						</select>
					  </div>
				</div>   
				
					<!--<div class="row">
						  <div class=" col-12 col-md-6 col-lg-6 mb-3 form-group">
						    <label for="distritoElectoral" class="form-label">Escribe el distrito electoral</label>
						    <input type="text" class="form-control" id="distritoElectoral" name="distritoElectoral" required="required" placeholder="Ejem:015" autocomplete="off">
						 </div>
						 
						  <div class=" col-12 col-md-6 col-lg-6 mb-3 form-group">
						    <label for="periodo" class="form-label">Escribe periodo</label>
						    <input type="text" class="form-control" id="periodo" name="periodo" required="required" placeholder="Ejem: 2021-2022" autocomplete="off">
						 </div>
				  	</div>	-->
				  
				  
				  <input id="accion" name="accion" type="hidden" value="agregarPartido">
        		</div>
        		
        		<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="submit" class="btn btn-primary">Agregar Partido</button>
		   		 </div>
        	</form>
      		
		</div>	
	</div>	
</div>
<scripit>

 </scripit>