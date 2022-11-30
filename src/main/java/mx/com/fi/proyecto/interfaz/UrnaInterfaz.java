package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;
import java.util.List;

import mx.com.fi.proyecto.dominio.Urna;

public interface UrnaInterfaz {
	public ArrayList<Urna> mostrarUrnas();
	public Urna buscarUrna(Urna urna);
	public int insetarUrna(Urna urna);
	public int actualizarUrna(Urna urna);
	public int eliminarUrna(Urna urna);

}
