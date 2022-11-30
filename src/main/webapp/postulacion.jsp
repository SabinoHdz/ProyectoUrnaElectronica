<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Control de Candidatos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

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
						<li class="nav-item"><a class="nav-link"
							aria-current="page" href="${pageContext.request.contextPath}/indexServletControlador">Home</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/BoletaServletControlador">Boletas</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/CasillaServletControlador">Casillas</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/UrnaServletControlador">Urnas</a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page"
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
 <jsp:param name="btnTitulo" value="Agregar Postulación"/>
  <jsp:param name="idName" value="Postulacion"/>     
 </jsp:include>
	
	<!-- Mostrar Postulaciónes-->
	<jsp:include page="/WEB-INF/paginas/postulacion/mostrarPostulaciones.jsp"/>
		<!-- Agregar Postulaciónes -->
	<jsp:include page="/WEB-INF/paginas/postulacion/agregarPostulacion.jsp"/> 

<script src="https://kit.fontawesome.com/60e65bec08.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>