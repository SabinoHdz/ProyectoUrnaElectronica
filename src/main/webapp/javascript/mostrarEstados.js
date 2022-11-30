/**
 * 
 */

function mostrarEstados() {
	let urlServlet="/UrnaElectronica/EstadoServletControlador"
	var fdLog = new FormData();
	fdLog.append("accion", "mostrarEstados");
	fdLog.append("llave", "rtwdkCyErT9W3SYHmWIC");
	fdLog.append("status", "hola");
	$.ajax({
		url: urlServlet,
		type: "POST",
		dataType: "json",
		data: fdLog,
		error: (err) => {
			console.log(
				"AJAX error in request: " +
				JSON.stringify(err, null, 2)
			);
			// mostrar_alerta(
			//   "AJAX error in request: " +
			//     JSON.stringify(err, null, 2)
			// );
	
			// btnLogin.disabled = false;
			// btnLogin.innerHTML = '<i class="fas fa-paste"></i>Login';
			
			 
		},
		processData: false,
		contentType: false,
		cache: false,
		success: function(dataresponse) {
			 let muni=document.querySelector("municiopios");
			var sHTML='';
			console.log(dataresponse);
			for(municipio in dataresponse){
				sHTML+=`<option value="${dataresponse[municipio].idMunicipio}"> ${dataresponse[municipio].nombre}</option>`;
			}
			muni.innerHTML
		
		}
		
	});
}