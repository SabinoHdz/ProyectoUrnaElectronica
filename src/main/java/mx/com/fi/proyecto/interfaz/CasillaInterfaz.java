package mx.com.fi.proyecto.interfaz;

import java.util.List;

import mx.com.fi.proyecto.dominio.Casilla;

public interface CasillaInterfaz {
	
	public List<Casilla> mostrarCasillas();
	public Casilla buscarCasilla(Casilla casilla);
	public int insetarCasilla(Casilla casilla);
	public int actualizarCasilla(Casilla casilla);
	public int eliminarCasilla(Casilla casilla);

}
