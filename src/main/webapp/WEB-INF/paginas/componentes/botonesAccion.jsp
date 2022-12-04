<%  
String btnTituloPrimary  = request.getParameter("btnTituloPrimary");  
String idNamePrimary=request.getParameter("idNamePrimary");

String btnTituloSecond  = request.getParameter("btnTituloSecond");  
String idNameSecond=request.getParameter("idNameSecond");
  
%>  

<section id="accion" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
				<a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" 
				data-bs-target="#Agregar<%=idNamePrimary %>">
					<i class="fas fa-plus"></i> <%=btnTituloPrimary %>
				</a>
				</div>
				
				<div class="col-md-3">
				<a href="#" class="btn btn-success btn-block" data-bs-toggle="modal" 
				data-bs-target="#Agregar<%=idNameSecond %>">
					<i class="fas fa-plus"></i> <%=btnTituloSecond %>
				</a>
				</div>
				
			</div>
		</div>
	</section>