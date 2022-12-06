<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="mx.com.fi.proyecto.dao.MunicipioDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Municipio"%>
<%@page import="mx.com.fi.proyecto.dao.EstadoDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Estado"%>
	<%@ page import="mx.com.fi.proyecto.dominio.Boleta" %>
	<%@ page import="mx.com.fi.proyecto.dao.BoletaDao" %>
	<%@ page import="mx.com.fi.proyecto.dominio.BoletaElectronica" %>
	<%@ page import="mx.com.fi.proyecto.dao.BoletaElectronicaDao" %>
	<%@ page import="mx.com.fi.proyecto.dominio.Postulacion" %>
	<%@ page import="mx.com.fi.proyecto.dao.PostulacionDao" %>
			<%@ page import="mx.com.fi.proyecto.dominio.Candidato" %>
	<%@ page import="mx.com.fi.proyecto.dao.CandidatoDao" %>
			<%@ page import="mx.com.fi.proyecto.dominio.Partido" %>
	<%@ page import="mx.com.fi.proyecto.dao.PartidoDao" %>
	<%@ page import="java.util.*" %>
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de Urna Electrónica</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
	
<style type="text/css">
:root{
    --backgroud-color:#2EC5CE;
    --color-primary:#fff;
    --color-secondary:#eeee
}
*{
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
}
body{
 background-color: var(--backgroud-color);
}
/* header{
position: relative;
display: flex;
flex-direction: row;
justify-content: center;
align-items: center;
width: 100%;
min-width: 320px;
height: 334px;
flex-wrap: wrap;
}
header img{
    
    margin-top: 60px;
    align-self: center;
}
.header-title-container{
    width: 90%;
    min-width: 288px;
    max-width: 900px;
    height: 218px;
    margin-top: 40px;
    text-align: center;
    align-self: center;
}
.header-title-container h1{
    font-size: 2.4rem;
    font-weight: bold;
    line-height: 2.6rem;
    color:black;
}
.header-title-container p{
    margin-top: 25px;
    font-size: 1.4rem;
    font-weight: 500;
    line-height: 1.8rem;
    color: var(--soft-orange);
} */
/*Contenido principal o urna electronica*/
.header-casilla-one{
	display:flex;
justify-content:center;
align-items:center;

margin-top:36px;
margin-bottom:36px;
	text-align: center;

}	
.container {
    width: 100%;
    max-width: 1200px;
    height: auto;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items:center;
    margin: auto;
  }
  .container .card {
    width: 350px;
    height: 370px;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.2);
    margin: 20px;
    padding-top: 10px;
    padding-bottom: 10px;
    text-align: center;
    transition: all 0.25s;
    background-color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .container .card:hover {
    transform: translateY(-15px);
    box-shadow: 0px 12px 16px rgba(0, 0, 0, 0.2);
  }
  .container img {
    width: 120px;
    height: 120px;
    
  }
  .container h4 {
    font-weight: 600;
  }
  .container p {
    padding: 0px 16px;
    font-size: 16px;
    font-weight: 300;
  }
  .container a {
    font-weight: 600;
    text-decoration: none;
    color: #3498db;
    font-size: 18px;
  }

</style>
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
	
	<%
			int idBoleta=4;
			Boleta blt=new Boleta(idBoleta);
			Boleta boletaSearch=new BoletaDao().buscarBoleta(blt);
			Estado estado=new Estado(boletaSearch.getEntidadFederativa());
			Estado estadoSearch=new EstadoDao().buscarEstado(estado);
			Municipio municipio = new Municipio(boletaSearch.getMunicipio());
			Municipio municipioSearch=new MunicipioDao().buscarMunicipio(municipio);
			
		%>
	 <section class="header-casilla-one">

        <section class="header-title-container">
         <h1> <%=boletaSearch.getProcesoElectoral()%>  <%=boletaSearch.getPeriodo() %></h1>
         <h3>Elección  a <%=boletaSearch.getTipoEleccion() %></h3>
         <h4> Código de elección:<%=boletaSearch.getCodigoBoleta() %> 		Número de Boleta <%=boletaSearch.getIdBoleta()%></h4>
         <h4 style="text-align: center"><%=boletaSearch.getMunicipio()%>. <%=boletaSearch.getEntidadFederativa()%>, <%=boletaSearch.getDistritoElectoral() %> </h4>
        </section>
    </section>

    <main class="container">
        <%
				BoletaElectronicaDao bdao=new BoletaElectronicaDao();
				ArrayList<BoletaElectronica> bltElectronica=new ArrayList<>();
				bltElectronica=bdao.mostrarBoletasElectronicasById(idBoleta);	
				ArrayList<Postulacion> postulaciones=new ArrayList<>();
				for (BoletaElectronica boletaElectronica : bltElectronica) {
					Postulacion postulacion= new Postulacion(boletaElectronica.getIdPostulacion());
					Postulacion postulacionSearch=new PostulacionDao().buscarPostulacion(postulacion);
					postulaciones.add(postulacionSearch);
				}
				
				for (Postulacion postulacion : postulaciones) {
					//System.out.println(postulacion);
					//Candidato
				Candidato candidatoPropietario= new Candidato(postulacion.getIdCandidato());
				Candidato propietarioSearch=new CandidatoDao().buscarCandidato(candidatoPropietario);
				
				//Propietario
				Candidato candidatoSuplente= new Candidato(postulacion.getIdSuplente());
				Candidato suplenteSearch=new CandidatoDao().buscarCandidato(candidatoSuplente);
				//Partido 
				Partido partido=new Partido(postulacion.getIdPartido());
				Partido partidoSearch= new PartidoDao().buscarPartido(partido);
				
			%>
			<div class="card">
            <img src="${pageContext.request.contextPath}/imagenes/<%=partidoSearch.getEmblema()%>" alt="<%=partidoSearch.getNombreImagen()%>">
            <h4 class="partido"><%=partidoSearch.getNombrePartido() %> </h4>
            <h5 style="color:#DE1B8E" ><strong>Propietario </strong></h5>
            <h6><%=propietarioSearch.getNombre() %></h6>
            
             <h5 style="color:#DE1B8E "><strong>Suplente </strong></h5>
            <h6><%=suplenteSearch.getNombre() %></h6>
         
        	</div>
				
			<%} %>
        
        
       
        <div class="card">
            <img src="${pageContext.request.contextPath}/imagenes/nulo.png" alt="Voto Nulo">
            <h4> VOTO NULO</h4>
            <p>El voto no sera valido</p>
        </div>

        <div class="card">
            <img src="${pageContext.request.contextPath}/imagenes//independiente.png" alt="Partido Independiente">
            <h4> Partido Independiente</h4>
            <p>Escribe el nombre del Propietario</p>    
        </div>
    </main>
	
	
	
	
	
	
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