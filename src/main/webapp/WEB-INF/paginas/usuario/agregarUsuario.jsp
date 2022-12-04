<div class="modal fade"  id="AgregarUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Usuario</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			
        	<form action="CandidatoServletControlador" method="POST" class="was-validated">
        		<div class="modal-body">
        		 <div class="mb-3 form-group">
				    <label for="nombreCompleto" class="form-label">Nombre</label>
				    <input type="text" class="form-control" id="nombreCompleto" name="nombreCompleto" required="required" placeholder="Ejem:Juan Perez Juarez" autocomplete="off">
				 </div>

				   <div class="mb-3 form-group">
				    <label for="tipoUsuario" class="form-label">Tipo de usuario:</label>
				    <!--  <input type="password" class="form-control" id="codigoActivacion" name="codigoActivacion" placeholder="e.x:1FSJDJF32">-->
				    <select class="form-select" aria-label="Default select example" name="tipoUsuario" id="tipoUsuario">
					  <option selected>Selecciona una opción:</option>
					  <option value="Administrador">Administrador</option>
					  <option value="Funcionario">Funcionario</option>
					</select>
				  </div>
				  
				   <div class="mb-3 form-group">
				    <label for="correo" class="form-label">Correo Electronico</label>
				    <input type="email" class="form-control" id="correo" name="correo" placeholder="Ejem:usuario@domain.com" required="required" autocomplete="off">
				  </div>
				  
				   <div class="mb-3 form-group">
				    <label for="password" class="form-label">Contraseña</label>
				    <input type="password" class="form-control" id="password" name="password" placeholder="Ejem:***********" required="required" autocomplete="off">
				  </div>
				  <input id="accion" name="accion" type="hidden" value="insertar">
        		</div>
        		
        		<div class="modal-footer">
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="submit" class="btn btn-primary">Guardar usuario</button>
		   		 </div>
        	</form>
		</div>	
	</div>
</div>