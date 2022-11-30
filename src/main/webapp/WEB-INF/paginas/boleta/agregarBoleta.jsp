<%@page import="mx.com.fi.proyecto.dao.PartidoDao"%>
<%@ page import="mx.com.fi.proyecto.dominio.Postulacion" %>
<%@ page import="mx.com.fi.proyecto.dao.PostulacionDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Candidato" %>
<%@ page import="mx.com.fi.proyecto.dao.CandidatoDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Partido" %>
<%@ page import="mx.com.fi.proyecto.dao.PartidoDao" %>
<%@ page import="mx.com.fi.proyecto.dominio.Estado" %>
<%@ page import="mx.com.fi.proyecto.dao.EstadoDao" %>

<%@ page import="java.util.*" %>

<div class="modal fade"  id="AgregarBoleta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Boleta</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
        	<form action="BoletaServletControlador" method="POST" class="was-validated">
        		<div class="modal-body">			
        		<div class="row">
	        		<div class=" col-6 mb-3 form-group">
					    <label for="procesoElectoral" class="form-label">Escribe el proceso electoral:</label>
					    <input type="text" class="form-control" id="procesoElectoral" name="procesoElectoral" required="required" placeholder="Ejem: Proceso Electoral Estatal" autocomplete="off">
					 </div>
					  
					  <div class=" col-6 mb-3 form-group">
					    <label for="tipoEleccion" class="form-label">Selecciona el tipo de Elección:</label>
					    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
					    <select class="form-select" aria-label="Default select example" name="tipoEleccion" id="tipoEleccion">
						  	<option selected value="">Selecciona una opción:</option>
						 	<option value="Ayuntamiento">Ayuntamiento</option>
						 	<option value="Senadores">Senadores</option>
					  		<option value="Presidente">Presidente de los Estados Unidos Méxicanos </option>
					   		<option value="Diputados Federales">Diputados Federales</option>
						  
						</select>
					  </div>
				</div>
				
				<div class="row"> 
					  
					  <div class="col-6 mb-3 form-group">
					    <label for="estado" class="form-label">Selecciona  la entidad federativa:</label>
					    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
					    <select class="form-select" aria-label="Default select example" name="estado" id="estado">
						  <option selected value="">Selecciona una estado:</option>
						  <%
						  EstadoDao estadoDao=new EstadoDao();
						  ArrayList<Estado> estados=new ArrayList<>();
						 estados=estadoDao.mostrarEstados();
						 
						 	for(Estado estado: estados){
						  %>
						  	<option value="<%=estado.getIdEstado()%>"> <%=estado.getNombre() %></option>
						  <% }%>
						</select>
					  </div>
					  
					  
					  <div class=" col-6 mb-3 form-group">
					    <label for="municipio" class="form-label">Selecciona  el municipio:</label>
					    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
					    <select class="form-select" aria-label="Default select example" name="municipio" id="municipio">
						  <option selected>Selecciona una municipio:</option>
							
						</select>
					  </div>
				</div>   
				
					 <div class="row">
						  <div class=" col-12 col-md-6 col-lg-6 mb-3 form-group">
						    <label for="distritoElectoral" class="form-label">Escribe el distrito electoral</label>
						    <input type="text" class="form-control" id="distritoElectoral" name="distritoElectoral" required="required" placeholder="Ejem:015" autocomplete="off">
						 </div>
						 
						  <div class=" col-12 col-md-6 col-lg-6 mb-3 form-group">
						    <label for="periodo" class="form-label">Escribe periodo</label>
						    <input type="text" class="form-control" id="periodo" name="periodo" required="required" placeholder="Ejem: 2021-2022" autocomplete="off">
						 </div>
				  	</div>	
				  
				  
				  <input id="accion" name="accion" type="hidden" value="insertar">
        		</div>
        		
        		<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="submit" class="btn btn-primary">Guardar Boleta</button>
		   		 </div>
        	</form>
      		
		</div>	
	</div>	
</div>