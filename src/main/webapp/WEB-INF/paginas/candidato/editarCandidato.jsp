<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="mx.com.fi.proyecto.dominio.Candidato" %>
	<%@ page import="mx.com.fi.proyecto.dao.CandidatoDao" %>
	<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de  editar Candidato</title>
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
 
 <form action="CandidatoServletControlador" method="POST" class="was-validated">
 	<jsp:include page="/WEB-INF/paginas/componentes/btnNavegacionEditar.jsp">
 		<jsp:param name="urlDir" value="candidato.jsp"/>
 	</jsp:include>  
 	
 	<section  class="details">
 		<div class="container">
 			<div class="row">
 				<div class="col-6">
 					<div class="card">
 						<div class="card-header">
 							<h4>Editar Candidato</h4>
 						</div>

 						<div class="card-body">
				  			
				  			 <div class="mb-3 form-group">
							    <label for="nombreEdit" class="form-label">Nombre</label>
							    <input type="text" class="form-control" value="${candidatoedit.nombre}" id="nombreEdit" name="nombreEdit" required="required" placeholder="Ejem:Juan Perez Juarez" autocomplete="off">
							 </div>
							 
							   <div class="mb-3 form-group">
							    <label for="cargoEdit" class="form-label">Cargo:</label>
							    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
							    <select class="form-select" aria-label="Default select example" name="cargoEdit" id="cargoEdit">
								  <option selected>Selecciona una opción:</option>
								  <option value="Propietario">Propietario</option>
								  <option value="Suplente">Suplente</option>
								</select>
							  </div>
							  
							   <div class="mb-3 form-group">
							    <label for="edadEdit" class="form-label">Edad</label>
							    <input type="text" class="form-control" value="${candidatoedit.edad}" id="edadEdit" name="edadEdit" placeholder="Ejem: 34" required="required" autocomplete="off">
							  </div>
							  
							  <div class="mb-3 form-group">
							    <label for="sexoEdit" class="form-label">Sexo:</label>
							    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
							    <select class="form-select" aria-label="Default select example" name="sexoEdit" id="sexoEdit">
								  <option value="">Selecciona una opción:</option>
								  <option value="Femenino"  selected>Femenino</option>
								  <option value="Masculino">Masculino</option>
								   <option value="Otro">Otro</option>

								</select>
							  </div>
							 	<input id="accion" name="accion" type="hidden" value="actualizar">
				  				<input id="idCandidato" name="idCandidato" type="hidden" value="${candidatoedit.idCandidato}">
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