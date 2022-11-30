<%@ page import="mx.com.fi.proyecto.dominio.Candidato" %>
<%@ page import="mx.com.fi.proyecto.dao.CandidatoDao" %>
<%@ page import="java.util.*" %>
<section id="listaCandidatos" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<div class="card">
						<div class="card-header">
							<h4>Listado de Candidatos</h4>
						</div>
						
						<table class="table table-striped table-hover">
						<thead class="thead-dark">
							<tr>
						      <th scope="col">#</th>
						      <th scope="col">Nombre Completo</th>
						      <th scope="col">Cargo</th>
						      <th scope="col">Edad </th>
						      <th scope="col">Sexo </th>
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
							
							CandidatoDao candidatoDao=new CandidatoDao();
							ArrayList<Candidato>candidatos=candidatoDao.mostrarCandidatos();
							
						
							for(Candidato candidato:candidatos){
							%>	
							<tr>
								<td><%=candidato.getIdCandidato() %></td>
								<td><%=candidato.getNombre()%></td>
								<td><%=candidato.getCargo()%></td>
								<td><%=candidato.getEdad()%></td>
								<td><%=candidato.getSexo()%></td>
								<td>
									<a href="${pageContext.request.contextPath}/CandidatoServletControlador?accion=editar&idCandidato=<%=candidato.getIdCandidato()%>"  class="btn btn-secondary">
											 <i class="fas fa-angle-double-right"></i> Editar </a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/CandidatoServletControlador?accion=eliminar&idCandidato=<%=candidato.getIdCandidato()%>"  class="btn btn-danger">
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