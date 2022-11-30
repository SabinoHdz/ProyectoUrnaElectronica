<%@page import="mx.com.fi.proyecto.dao.PartidoDao"%>
<%@ page import="mx.com.fi.proyecto.dominio.Postulacion" %>
<%@ page import="mx.com.fi.proyecto.dao.PostulacionDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Candidato" %>
<%@ page import="mx.com.fi.proyecto.dao.CandidatoDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Partido" %>
<%@ page import="mx.com.fi.proyecto.dao.PartidoDao" %>

<%@ page import="java.util.*" %>

<div class="modal fade"  id="AgregarPostulacion" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Postulación</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
        	<form action="PostulacionServletControlador" method="POST" class="was-validated">
        		<div class="modal-body">
        		  <div class="mb-3 form-group">
				    <label for="candidato" class="form-label">Selecciona un Candidato:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="candidato" id="candidato">
						 <%
						 ArrayList<Candidato> propietarios=new ArrayList<>();
						 CandidatoDao candidatoDao=new CandidatoDao();
						 propietarios=candidatoDao.mostrarPropietarios();
						 for(Candidato propietario:propietarios){
						 %>
						 	<option value="<%=propietario.getIdCandidato()%>"><%=propietario.getNombre()%></option>
						 <%}%>
					</select>
				  </div>

				   <div class="mb-3 form-group">
				    <label for="suplente" class="form-label">Selecciona un Suplente:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="suplente" id="suplente">
					  <%
						 ArrayList<Candidato> suplentes=new ArrayList<>();
						 CandidatoDao suplenteDao=new CandidatoDao();
						 suplentes=suplenteDao.mostrarSuplentes();
						 for(Candidato suplente:suplentes){
						 %>
						 	<option value="<%=suplente.getIdCandidato()%>"><%=suplente.getNombre()%></option>
						 <%}%>
					</select>
				  </div>
				  
				  
				  
				   <div class="mb-3 form-group">
				    <label for="partido" class="form-label">Selecciona un Partido Politico:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="partido" id="partido">
					 	  <%
						 ArrayList<Partido> partidos=new ArrayList<>();
						 PartidoDao partidoDao=new PartidoDao();
						 partidos=partidoDao.mostrarPartidos();
						 for(Partido partido:partidos){
						 %>
						 	<option value="<%=partido.getIdPartido()%>"><%=partido.getNombrePartido()%></option>
						 <%}%>
					 
					</select>
				  </div>
				  
				  <div class="mb-3 form-group">
				    <label for="postulacion" class="form-label">Selecciona el tipo de postulación:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="eleccion" id="eleccion">
					  <option selected>Selecciona una opción:</option>
					  <option value="Senador">Senador</option>
					  <option value="Presidente">Presidente</option>
					   <option value="DiputadoFederal">Diputado Federal</option>
					</select>
				  </div>
				  
				  <input id="accion" name="accion" type="hidden" value="insertar">
        		</div>
        		
        		<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="submit" class="btn btn-primary">Guardar Postulacion</button>
		   		 </div>
        	</form>
      		
		      
		</div>	
	</div>
</div>