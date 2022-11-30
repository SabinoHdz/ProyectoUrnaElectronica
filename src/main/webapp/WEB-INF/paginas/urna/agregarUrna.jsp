<div class="modal fade"  id="AgregarAlgo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Urna</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
        	<form action="indexServletControlador" method="POST" class="was-validated">
        		<div class="modal-body">
        		 <div class="mb-3 form-group">
				    <label for="codigoPostal" class="form-label">Código Postal</label>
				    <input type="text" class="form-control" id="codigoPostal" name="codigoPostal" required="required" placeholder="Escribe el código Postal" autocomplete="off">
				 </div>
				  <div class="mb-3 form-group">
				    <label for="codigoActivacion" class="form-label">Código de activación</label>
				    <input type="text" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32" required="required" autocomplete="off">
				  </div>
				  
				   <div class="mb-3 form-group">
				    <label for="estado" class="form-label">Estado:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="estado" id="estado">
					  <option selected>Selecciona una opción:</option>
					  <option value="1">Activo</option>
					  <option value="0">Inactivo</option>
					</select>
				  </div>
				  <input id="accion" name="accion" type="hidden" value="insertar">
        		</div>
        		
        		<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="submit" class="btn btn-primary">Guardar Urna</button>
		   		 </div>
        	</form>
      		
		      
		</div>	
	</div>
</div>