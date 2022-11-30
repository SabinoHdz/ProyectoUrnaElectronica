<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control de Boletas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

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
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/indexServletControlador">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
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
							href="${pageContext.request.contextPath}/PartidoServletControlador">Partidos
								Politicos</a></li>


					</ul>

				</div>
			</div>
		</nav>
	</header>


	<jsp:include page="/WEB-INF/paginas/componentes/botonAgregar.jsp">
		<jsp:param name="btnTitulo" value="Agregar Boleta" />
		<jsp:param name="idName" value="Boleta" />
	</jsp:include>


	<!-- Agregar boletas -->
	<jsp:include page="/WEB-INF/paginas/boleta/agregarBoleta.jsp" />
	
	<!-- Mostrar boletas -->
	<jsp:include page="/WEB-INF/paginas/boleta/mostrarBoletas.jsp"/>  
	<script src="https://kit.fontawesome.com/60e65bec08.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="./javascript/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="./javascript/mostrarEstados.js"></script>
	<script type="text/javascript">
	$(function(){
        //evento change parececido al onchange de javascript que cambia al seleccionar los Paises
    $("#estado").change(function(){
    	var idEstadoVar=$(this).val();
    	var fdLog = new FormData();
    	fdLog.append("estado", idEstadoVar);
    	$.ajax({
    		url: "MunicipioServletControlador",
    		type: "POST",
    		dataType: "json",
    		data: fdLog,
    		error: (err) => {
    			console.log(
    				"AJAX error in request: " +
    				JSON.stringify(err, null, 2)
    			);
    			// mostrar_alerta(
    			//   "AJAX error in request: " +
    			//     JSON.stringify(err, null, 2)
    			// );
    	
    			// btnLogin.disabled = false;
    			// btnLogin.innerHTML = '<i class="fas fa-paste"></i>Login';
    		},
    		processData: false,
    		contentType: false,
    		cache: false,
    		success: function(dataresponse) {
    			console.log(dataresponse);
    			var  municipios=document.querySelector("#municipio");
    			var sHTML="";
    			console.log(dataresponse);
    			for(municipio in dataresponse){
    				sHTML+="<option value="+dataresponse[municipio].idMunicipio+">"+dataresponse[municipio].nombre+"</option>";
    				console.log("id:"+dataresponse[municipio].idMunicipio +" , " + "nombre:"+dataresponse[municipio].nombre);
    			}
    			
    			municipios.innerHTML=sHTML;
    		},
    	});
    	
    });
});
	</script>
</body>
</html>