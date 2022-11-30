package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;

import mx.com.fi.proyecto.dominio.Boleta;

public interface BoletaInterfaz {
	public ArrayList<Boleta> mostrarBoletas();
	public Boleta buscarBoleta(Boleta boleta);
	public int insertarBoleta(Boleta boleta);
	public int actualizarBoleta(Boleta boleta);
	public int eliminarBoleta(Boleta boleta);

}
