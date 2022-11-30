package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;
import java.util.List;

import mx.com.fi.proyecto.dominio.Estado;

public interface EstadoInterfaz {
	public ArrayList<Estado> mostrarEstados();
	public Estado buscarEstado(Estado estado);
}
