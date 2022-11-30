package mx.com.fi.proyecto.interfaz;

import java.util.ArrayList;

import mx.com.fi.proyecto.dominio.Candidato;

public interface CandidatoInterfaz {
	public ArrayList<Candidato> mostrarCandidatos();
	public ArrayList<Candidato>mostrarPropietarios();
	public ArrayList<Candidato>mostrarSuplentes();
	public Candidato buscarCandidato(Candidato candidato);
	public int insertarCandidato(Candidato candidato);
	public int actualizarCandidato(Candidato candidato);
	public int eliminarCandidato(Candidato partido);
	
	

}
