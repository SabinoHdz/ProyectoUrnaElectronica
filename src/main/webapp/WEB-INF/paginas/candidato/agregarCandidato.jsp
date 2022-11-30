<div class="modal fade"  id="AgregarCandidato" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Candidato</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
        	<form action="CandidatoServletControlador" method="POST" class="was-validated">
        		<div class="modal-body">
        		 <div class="mb-3 form-group">
				    <label for="nombreCompleto" class="form-label">Nombre</label>
				    <input type="text" class="form-control" id="nombreCompleto" name="nombreCompleto" required="required" placeholder="Ejem:Juan Perez Juarez" autocomplete="off">
				 </div>

				   <div class="mb-3 form-group">
				    <label for="cargo" class="form-label">Cargo:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="cargo" id="cargo">
					  <option selected>Selecciona una opción:</option>
					  <option value="Propietario">Propietario</option>
					  <option value="Suplente">Suplente</option>
					</select>
				  </div>
				  
				   <div class="mb-3 form-group">
				    <label for="edad" class="form-label">Edad</label>
				    <input type="text" class="form-control" id="edad" name="edad" placeholder="Ejem: 34" required="required" autocomplete="off">
				  </div>
				  
				  <div class="mb-3 form-group">
				    <label for="sexo" class="form-label">Sexo:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="sexo" id="sexo">
					  <option selected>Selecciona una opción:</option>
					  <option value="Femenino">Femenino</option>
					  <option value="Masculino">Masculino</option>
					   <option value="Otro">Otro</option>
					</select>
				  </div>
				  
				  <input id="accion" name="accion" type="hidden" value="insertar">
        		</div>
        		
        		<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="submit" class="btn btn-primary">Guardar Candidato</button>
		   		 </div>
        	</form>
      		
		      
		</div>	
	</div>
</div>