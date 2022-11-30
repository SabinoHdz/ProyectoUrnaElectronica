<%@page import="mx.com.fi.proyecto.dominio.Partido"%>
<%@page import="mx.com.fi.proyecto.controlador.CandidatoServletControlador"%>
<%@page import="mx.com.fi.proyecto.dao.PostulacionDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Postulacion"%>
<%@page import="mx.com.fi.proyecto.dao.PartidoDao"%>
<%@ page import="mx.com.fi.proyecto.dominio.Candidato" %>
<%@ page import="mx.com.fi.proyecto.dao.CandidatoDao" %>
<%@ page import="java.util.*" %>
<section id="listaPostulaciones" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="card">
						<div class="card-header">
							<h4>Listado de Postulaciones</h4>
						</div>
						
						<table class="table table-striped table-hover">
						<thead class="thead-dark">
							<tr>
						      <th scope="col">#</th>
						      <th scope="col">Propietario</th>
						      <th scope="col">Suplente</th>
						      <th scope="col">Partido Politico </th>
						      <th scope="col"> Tipo de elección</th>
						      <th scope="col">Eliminar</th>
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
							
							PostulacionDao postulacionDao=new PostulacionDao();
							ArrayList<Postulacion>postulaciones=postulacionDao.mostrarPostulacion();
							
						
							for(Postulacion postulacion:postulaciones){
								Candidato candidato= new Candidato(postulacion.getIdCandidato()); 
								Candidato propietarioSearch=new CandidatoDao().buscarCandidato(candidato);
								
								Candidato suplente= new Candidato(postulacion.getIdSuplente()); 
								Candidato suplenteSearch=new CandidatoDao().buscarCandidato(suplente);
								
								Partido partido= new Partido(postulacion.getIdPartido());
								Partido partidoSearch=new PartidoDao().buscarPartido(partido);
							%>	
							<tr>
								<td><%=postulacion.getIdPostulacion()%></td>
								
										
								<td><%=propietarioSearch.getNombre() %></td>
								<td><%=suplenteSearch.getNombre()%></td>
								<td><%=partido.getNombrePartido()%></td>
								<td><%=postulacion.getTipoPostulacion()%></td>
								<td>
									<a href="${pageContext.request.contextPath}/PostulacionServletControlador?accion=eliminar&idPostulacion=<%=postulacion.getIdPostulacion()%>"  class="btn btn-danger">
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