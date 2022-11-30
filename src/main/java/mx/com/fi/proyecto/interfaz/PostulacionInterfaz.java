package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;

import mx.com.fi.proyecto.dominio.Postulacion;

public interface PostulacionInterfaz {
	public ArrayList<Postulacion> mostrarPostulacion();
	public Postulacion buscarPostulacion(Postulacion postulacion);
	public int insertarPostulacion(Postulacion postulacion);
	public int actualizarPostulacion(Postulacion postulacion);
	public int eliminarPostulacion(Postulacion postulacion);

}
