package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;

import mx.com.fi.proyecto.dominio.Partido;

public interface PartidoInterfaz {
	public ArrayList<Partido> mostrarPartidos();
	public Partido buscarPartido(Partido partido);
	public int insertarPartido(Partido partido);
	public int actualizarPartido(Partido partido);
	public int eliminarPartido(Partido partido);

}
