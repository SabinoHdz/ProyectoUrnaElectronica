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
		
	

</head>
<body>

 <!--<jsp:include page="/WEB-INF/paginas/componentes/mensaje.jsp">  
 <jsp:param name="message" value="este es un mensaje de envio desde otro jsp"/>   
 </jsp:include> -->
 
 	<jsp:include page="/WEB-INF/paginas/componentes/btnNavegacionEditar.jsp">
 		<jsp:param name="urlDir" value="boleta.jsp"/>
 	</jsp:include>  
 

		<%
		String id=request.getParameter("idBoleta");
		int idBoleta=Integer.parseInt(id);
		
		%>
		<p>id: <%=id %>  </p>
		
		<%
	
			Boleta blt=new Boleta(idBoleta);
			Boleta boletaSearch=new BoletaDao().buscarBoleta(blt);
			Estado estado=new Estado(boletaSearch.getEntidadFederativa());
			Estado estadoSearch=new EstadoDao().buscarEstado(estado);
			Municipio municipio = new Municipio(boletaSearch.getMunicipio());
			Municipio municipioSearch=new MunicipioDao().buscarMunicipio(municipio);
			
		%>
		
		<ul>
			<li>Numero de Boleta: 0000 <%=boletaSearch.getIdBoleta()%> </li>
			<li> Proceso electoral: <%=boletaSearch.getProcesoElectoral() %></li>
			<li>Tipo de elección: <%=boletaSearch.getTipoEleccion() %> </li>
			<li> Entidad Federativa:  <%=estadoSearch.getNombre()%></li>
			<li>Municipio: <%=municipioSearch.getNombre()%>  </li>
			<li>Distrito electoral: <%=boletaSearch.getDistritoElectoral() %></li>
			<li>Periodo: <%=boletaSearch.getPeriodo() %> </li>
		</ul>
		
		<ul>
		
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
		
				<li>Candidato: <%= propietarioSearch.getNombre()%> </li>
				<li>Suplente:  <%=suplenteSearch.getNombre() %></li>
				<li>Partido:<%=partidoSearch.getNombrePartido() %>  | 	<%=partidoSearch.getEmblema() %>  </li>
				<br>
			<%} %>
		</ul>
		
	
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