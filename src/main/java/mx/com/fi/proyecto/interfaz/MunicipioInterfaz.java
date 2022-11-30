package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;

import mx.com.fi.proyecto.dominio.Estado;
import mx.com.fi.proyecto.dominio.Municipio;

public interface MunicipioInterfaz {
	public ArrayList<Municipio> mostrarMunicipios();
	public ArrayList<Municipio> mostrarMunicipiosByEstado(int idEstado);
	public Municipio buscarMunicipio(Municipio municipio);
}
