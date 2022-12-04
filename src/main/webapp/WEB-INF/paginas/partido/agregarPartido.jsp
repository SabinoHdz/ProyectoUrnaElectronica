<div class="modal fade"  id="AgregarPartido" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Partido</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
        	<form action="PartidoServletControlador" method="POST" enctype="multipart/form-data" class="was-validated">
        		<div class="modal-body">
        		 <div class="mb-3 form-group">
				    <label for="partidoPolitico" class="form-label">Nomble del Partido Político:</label>
				    <input type="text" class="form-control" id="partidoPolitico" name="partidoPolitico" required="required" placeholder="Nombre del Partido" autocomplete="off">
				 </div>
				 <div class="mb-3 form-group">
				    <label for="abreviacion" class="form-label">Abreviación del partido político:</label>
				    <input type="text" class="form-control" id="abreviacion" name="abreviacion" placeholder="Nombre del Partido" required="required" autocomplete="off">
				  </div>
				  
				  <div class="mb-3 form-group">
				    <label for="nombreImagen" class="form-label">Nombre de la imagen</label>
				    <input type="text" class="form-control" id="nombreImagen" name="nombreImagen" placeholder="Nombre del Partido" required="required" autocomplete="off">
				  </div>
				  
				   <div class="mb-3 form-group">
				    <label for="emblema" class="form-label">Selecciona la imagen:</label>
				    <input type="file" id="emblema" name="emblema">
				  </div>
				  <input id="accion" name="accion" type="hidden" value="insertar">
        		</div>
        		
        		<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="submit" class="btn btn-primary">Guardar Partido</button>
		   		 </div>
        	</form>
      		
		      
		</div>	
	</div>
</div>