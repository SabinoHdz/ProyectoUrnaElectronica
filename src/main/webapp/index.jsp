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

	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.html">Urna Electrónica</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/BoletaServletControlador">Boletas</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/CasillaServletControlador">Casillas</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/UrnaServletControlador">Urnas</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/PostulacionServletControlador">Postulación</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/CandidatoServletControlador">Candidatos</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/PartidoServletControlador">Partidos Politicos</a></li>
					</ul>

				</div>
			</div>
		</nav>
	</header>
	
	
<jsp:include page="/WEB-INF/paginas/componentes/botonAgregar.jsp">  
 <jsp:param name="btnTitulo" value="Agregar Algo"/> 
  <jsp:param name="idName" value="Algo"/>    
 </jsp:include>
	
	<section id="listaUrnas" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="card">
						<div class="card-header">
							<h4>Listado de Urnas</h4>
						</div>
						
						<table class="table table-striped table-hover">
						<thead class="thead-dark">
							<tr>
						      <th scope="col">#</th>
						      <th scope="col">Codigo Postal</th>
						      <th scope="col">Codigo Activacio</th>
						      <th scope="col">Estado Actual</th>
						      <th scope="col">Edit</th>
						      <th scope="col">Del</th>
						    </tr>
						</thead>
						<tbody>
						
							<!--<tr>
								<td>1</td>
								<td>50200</td>
								<td>343dfD3DX2</td>
								<td>1</td>
								<td>
									<a href="#"  class="btn btn-secondary">
									 <i class="fas fa-angle-double-right"></i> Editar </a>
								</td>
								<td>
									<a href="#"  class="btn btn-danger">
									<i class="fa-solid fa-trash"></i> Eliminar </a>
								</td>
							</tr>-->
							
							
							<%
							
							UrnaDao urnaDao=new UrnaDao();
							ArrayList<Urna>urnas=urnaDao.mostrarUrnas();
							
						
							for(Urna urna:urnas){
							%>	
							<tr>
								<td><%=urna.getIdUrna() %></td>
								<td><%=urna.getCodigoPostal()%></td>
								<td><%=urna.getCodigoActivacion()%></td>
								<td><%=urna.getEstadoActual()%></td>
								<td>
									<a href="${pageContext.request.contextPath}/indexServletControlador?accion=editar&idUrna=<%=urna.getIdUrna()%>"  class="btn btn-secondary">
											 <i class="fas fa-angle-double-right"></i> Editar </a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/indexServletControlador?accion=eliminar&idUrna=<%=urna.getIdUrna()%>"  class="btn btn-danger">
										<i class="fa-solid fa-trash"></i> Eliminar </a>
								</td>
							</tr>	
							
							
							<%} %>				
						</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Fin de Mostrar Urnas -->
	
	<!-- Seccion del modal agregarUrna -->
	<jsp:include page="/WEB-INF/paginas/urna/agregarUrna.jsp"/>  
	
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