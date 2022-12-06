<%@page import="mx.com.fi.proyecto.dao.MunicipioDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Municipio"%>
<%@page import="mx.com.fi.proyecto.dao.EstadoDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Estado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<meta charset="ISO-8859-1">

<title>Página de visualización de la boleta</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Exo:400,700');

*{
    margin: 0px;
    padding: 00px;
}

body{
    font-family: 'Exo', sans-serif;
    background: #4e54c8;  
    background: -webkit-linear-gradient(to left, #8f94fb, #4e54c8);  
    width: 100%;
    height:100vh;
    color: #fff;
}
.banner{
	background-size: cover;
	background-position:top;
	height:auto;
	display:flex;
	flex-direction: column;
	justify-content:center;
	align-items:center;
	text-align: center;
	padding:0 70px;
}
.datos_boleta{
	align-items:center;
	justify-content:right;
	text-align:right;
	height: auto;
}
td{
	border: 1px #DDD solid;
	padding: 5px;
	cursor: pointer;
}
.selected{
	background-color: brown;
	color: #FFF;
}

.circles{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
    margin-top:150px
}

.circles li{
    position: absolute;
    display: block;
    list-style: none;
    width: 20px;
    height: 20px;
    background: rgba(255, 255, 255, 0.2);
    animation: animate 25s linear infinite;
    bottom: -150px;
    
}

.circles li:nth-child(1){
    left: 25%;
    width: 80px;
    height: 80px;
    animation-delay: 0s;
}


.circles li:nth-child(2){
    left: 10%;
    width: 20px;
    height: 20px;
    animation-delay: 2s;
    animation-duration: 12s;
}

.circles li:nth-child(3){
    left: 70%;
    width: 20px;
    height: 20px;
    animation-delay: 4s;
}

.circles li:nth-child(4){
    left: 40%;
    width: 60px;
    height: 60px;
    animation-delay: 0s;
    animation-duration: 18s;
}

.circles li:nth-child(5){
    left: 65%;
    width: 20px;
    height: 20px;
    animation-delay: 0s;
}

.circles li:nth-child(6){
    left: 75%;
    width: 110px;
    height: 110px;
    animation-delay: 3s;
}

.circles li:nth-child(7){
    left: 35%;
    width: 150px;
    height: 150px;
    animation-delay: 7s;
}

.circles li:nth-child(8){
    left: 50%;
    width: 25px;
    height: 25px;
    animation-delay: 15s;
    animation-duration: 45s;
}

.circles li:nth-child(9){
    left: 20%;
    width: 15px;
    height: 15px;
    animation-delay: 2s;
    animation-duration: 35s;
}

.circles li:nth-child(10){
    left: 85%;
    width: 150px;
    height: 150px;
    animation-delay: 0s;
    animation-duration: 11s;
}



@keyframes animate {

    0%{
        transform: translateY(0) rotate(0deg);
        opacity: 1;
        border-radius: 0;
    }

    100%{
        transform: translateY(-1000px) rotate(720deg);
        opacity: 0;
        border-radius: 50%;
    }
}
</style>

</head>
<body>
 <!--<jsp:include page="/WEB-INF/paginas/componentes/mensaje.jsp">  
 <jsp:param name="message" value="este es un mensaje de envio desde otro jsp"/>   
 </jsp:include> -->
 
 
 			<%
		String id=request.getParameter("idBoleta");
		int idBoleta=Integer.parseInt(id);
		
		%>

		<jsp:include page="/WEB-INF/paginas/componentes/botonRegresar.jsp">
 		<jsp:param name="urlDir" value="boleta.jsp"/>
 	</jsp:include>  
 		<div class="banner">
	  	<%
			//int idBoleta=4;
       		Boleta blt=new Boleta(idBoleta);
			Boleta boletaSearch=new BoletaDao().buscarBoleta(blt);
			String cb = blt.getCodigoBoleta();
			String p = blt.getPeriodo();
			String pe = blt.getProcesoElectoral();
			String te = blt.getTipoEleccion();
			Estado estado=new Estado(boletaSearch.getEntidadFederativa());
			Estado estadoSearch=new EstadoDao().buscarEstado(estado);
			Municipio municipio = new Municipio(boletaSearch.getMunicipio());
			Municipio municipioSearch=new MunicipioDao().buscarMunicipio(municipio);
			String db = municipio.getNombre() + ", " + estado.getNombre() + ", " + blt.getDistritoElectoral();  
		%>
			
		<h4><%= pe + " " + p %></h4>
        <h1>Elección a <%= te %></h1>
        
        <section id="datos_boleta">
        	<h6>Código de Elección: <%=cb %> &nbsp; Número de Boleta: <%= idBoleta %></h6>
        	<h6><%= db %></h6>
        </section>
        <section id="seleccion">  
        	<table id="table">
        	<thead style="color: #ed008c">
        		<tr>
        			<th> Partido </th>
        			<th> Candidato </th>
        			<th> Suplente </th>
        		</tr>
        	</thead>
        	<tbody  style="color: #fff">
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
				for (Postulacion postulacion : postulaciones){
					
					//Candidato
					Candidato candidatoPropietario= new Candidato(postulacion.getIdCandidato());
					Candidato propietarioSearch=new CandidatoDao().buscarCandidato(candidatoPropietario);
					//Propietario
					Candidato candidatoSuplente= new Candidato(postulacion.getIdSuplente());
					Candidato suplenteSearch=new CandidatoDao().buscarCandidato(candidatoSuplente);
					//Partido 
					Partido partido=new Partido(postulacion.getIdPartido());
					Partido partidoSearch= new PartidoDao().buscarPartido(partido);
					
					String icon = "${/webapp/imagenes/"+partidoSearch.getEmblema()+"}";
			%>
			<tr>
				<td><img class="logoPartido" src="${pageContext.request.contextPath}/imagenes/<%=partido.getEmblema()%>" width="120px" height="120px"></td>
				<td><%= propietarioSearch.getNombre()%> </td>
				<td><%=suplenteSearch.getNombre() %></td> 
			</tr>
			<%} %>   	
        	<tr>
            	<td>Candidatura Independiente</td>
            	<td>Candidato <br><input type:"Candidato" name:"candidato" id="candidato"></td>
            	<td>Suplente<br><input type:"Suplente" name:"suplente" id="suplente"></td>
        </tr>
      </tbody>
    </table>
    <a href="../webapp/Instrucciones.html" class="button"> Regresar </a>
    <a href="../webapp/Boleta_2.jsp">Continuar</a>
        </section>
    </div>
<div class="area" >
            <ul class="circles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
    </div >
	
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