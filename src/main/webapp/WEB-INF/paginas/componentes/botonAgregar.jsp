<%  
String btnTitulo  = request.getParameter("btnTitulo");  
String idName=request.getParameter("idName");
  
%>  

<section id="accion" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
				<a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" 
				data-bs-target="#Agregar<%=idName %>">
					<i class="fas fa-plus"></i> <%=btnTitulo %>
				</a>
				</div>
			</div>
		</div>
	</section>