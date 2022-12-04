<%@page import="mx.com.fi.proyecto.dao.UsuarioDao"%>
<%@page import="mx.com.fi.proyecto.dao.UsuarioDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Usuario"%>
<%@page import="mx.com.fi.proyecto.dao.CandidatoDao"%>
<%@page import="mx.com.fi.proyecto.dominio.Candidato"%>

<%@ page import="java.util.*" %>
<section id="listaCandidatos" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h4>Listado de Usuarios</h4>
						</div>
						
						<table class="table table-striped table-hover">
						<thead class="thead-dark">
							<tr>
						      <th scope="col">#</th>
						      <th scope="col">Nombre</th>
						      <th scope="col">Puesto</th>
						      <th scope="col">Correo</th>
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
							
							UsuarioDao usuarioDao=new UsuarioDao();
							ArrayList<Usuario>usuarios=usuarioDao.mostrarUsuarios();
							
						
							for(Usuario usuario:usuarios){
							%>	
							<tr>
								<td><%= usuario.getIdUsuario()%></td>
								<td><%=usuario.getNombre()%></td>
								<td><%=usuario.getTipoUsuario()%></td>
								<td><%=usuario.getCorreo()%></td>
								

								<td>
									<a href="${pageContext.request.contextPath}/UsuarioServletControlador?accion=editar&idUsuario=<%=usuario.getIdUsuario()%>"  class="btn btn-secondary">
											 <i class="fas fa-angle-double-right"></i> Editar </a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/UsuarioServletControlador?accion=eliminar&idUsuario=<%=usuario.getIdUsuario()%>"  class="btn btn-danger">
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