<%  
String urlDir  = request.getParameter("urlDir");  
  
%>  


		<section id="navegacionEditar" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<a href="<%=urlDir%>" class="btn btn-primary btn-block">
						<i class="fas fa-arrow-left"></i> Regresar al incio
					</a>
				</div>
				
				<div class="col-md-3">
					<button type="submit" class="btn btn-success btn-block">
						<i class="fas fa-check"></i> Guardar Urna
					</button>
					
				</div>
			
			</div>
		</div>
		</section>
	
	