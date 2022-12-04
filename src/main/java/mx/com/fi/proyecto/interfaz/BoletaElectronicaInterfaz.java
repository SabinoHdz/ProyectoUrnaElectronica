package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;

import mx.com.fi.proyecto.dominio.BoletaElectronica;


public interface BoletaElectronicaInterfaz {
	
	public ArrayList<BoletaElectronica> mostrarBoletasElectronicas();
	public ArrayList<BoletaElectronica> mostrarBoletasElectronicasById(int idBoleta);
	public BoletaElectronica buscarBoletaElectronica(BoletaElectronica boleta);
	public int insertarBoleta(BoletaElectronica boleta);

}
