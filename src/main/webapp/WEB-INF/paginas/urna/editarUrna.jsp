<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="mx.com.fi.proyecto.dominio.Urna" %>
	<%@ page import="mx.com.fi.proyecto.dao.UrnaDao" %>
	<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de Urna Electrónica</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
		
	

</head>
<body>

 <!--<jsp:include page="/WEB-INF/paginas/componentes/mensaje.jsp">  
 <jsp:param name="message" value="este es un mensaje de envio desde otro jsp"/>   
 </jsp:include> -->
 
 <form action="indexServletControlador" method="POST" class="was-validated">
 	<jsp:include page="/WEB-INF/paginas/componentes/btnNavegacionEditar.jsp"/>  
 	
 	<section  class="details">
 		<div class="container">
 			<div class="row">
 				<div class="col-6">
 					<div class="card">
 						<div class="card-header">
 							<h4>Editar Urna</h4>
 						</div>
 						<div class="card-body">
 							<div class="mb-3 form-group">
				   				 <label for="codigoPostal" class="form-label">Código Postal</label>
				   				 <input type="text" class="form-control" id="codigoPostal" name="codigoPostal" required="required" placeholder="Escribe el código Postal" autocomplete="off" value="${urnaedit.codigoPostal}">
							 </div>
				  			<div class="mb-3 form-group">
				    			<label for="codigoActivacion" class="form-label">Código de activación</label>
				    			<input type="text" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32" required="required" autocomplete="off" value="${urnaedit.codigoActivacion}">
				  			</div>
				  			<div class="mb-3 form-group">
				    			<label for="estadoActual" class="form-label">Estado Actual</label>
				    			<input type="text" class="form-control" id="estadoActual" name="estadoActual" placeholder="e.x: 0=Inactivo | 1:Activo " required="required" autocomplete="off" value="${urnaedit.estadoActual}">
				  			</div>
				  			<div>
				  			<input id="accion" name="accion" type="hidden" value="actualizar">
				  			<input id="idUrna" name="idUrna" type="hidden" value="${urnaedit.idUrna}">
				  			</div>
 						</div>
 					</div>
 				</div>
 			</div>
 		</div>
 	
 	</section>
 </form>


	
	
	<script src="https://kit.fontawesome.com/60e65bec08.js" crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>
</html>