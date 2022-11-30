<%@page import="mx.com.fi.proyecto.dao.PartidoDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Partido"%>
<%@page import="mx.com.fi.proyecto.dao.CandidatoDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Candidato"%>
<%@page import="mx.com.fi.proyecto.dao.PostulacionDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Postulacion"%>
<%@page import="mx.com.fi.proyecto.dao.MunicipioDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Municipio"%>
<%@page import="mx.com.fi.proyecto.dao.EstadoDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Estado"%>
<%@ page import="mx.com.fi.proyecto.dominio.Boleta" %>
<%@ page import="mx.com.fi.proyecto.dao.BoletaDao" %>
<%@ page import="java.util.*" %>
<section id="listaCandidatos" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h4>Listado de Boletas</h4>
						</div>
						
						<table class="table table-striped table-hover">
						<thead class="thead-dark">
							<tr>
						      <th scope="col">#</th>
						      <th scope="col">Proceso Electoral</th>
						      <th scope="col">Tipo de Elección</th>
						      <th scope="col">Entidad Federativa </th>
						      <th scope="col">Municipio </th>
						      <th scope="col">Distrito Electoral </th>
						      <th scope="col">Periodo </th>
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
							
							BoletaDao boletadao=new BoletaDao();
							ArrayList<Boleta>boletas=boletadao.mostrarBoletas();
							
						
							for(Boleta boleta:boletas){

								Estado estado= new Estado(boleta.getEntidadFederativa());
							 	Estado estadoSearch=new  EstadoDao().buscarEstado(estado);
							 	
							 	Municipio municipio= new Municipio(boleta.getMunicipio());
							 	Municipio municipioSearch=new  MunicipioDao().buscarMunicipio(municipio);
							%>	
							<tr>
								<td><%=boleta.getIdBoleta() %></td>
								<td><%=boleta.getProcesoElectoral()%></td>
								<td><%=boleta.getTipoEleccion()%></td>
								<td><%=estadoSearch.getNombre()%></td>
								<td><%=municipioSearch.getNombre()%></td>
								<td><%=boleta.getDistritoElectoral()%></td>
								<td><%=boleta.getPeriodo()%></td>
								<td>
									<a href="${pageContext.request.contextPath}/BoletaServletControlador?accion=editar&idBoleta=<%=boleta.getIdBoleta()%>"  class="btn btn-secondary">
											 <i class="fas fa-angle-double-right"></i> Editar </a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/CandidatoServletControlador?accion=eliminar&idBoleta=<%=boleta.getIdBoleta()%>"  class="btn btn-danger">
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