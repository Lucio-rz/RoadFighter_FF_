package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import Entidades.VallaDer;
import Entidades.VallaIzq;
import Entidades.VehiculoRutaClasico;
import Entidades.VehiculoRutaPremio;

public abstract class Visitor {
	protected Entidad entidad;

	public Visitor(Entidad entidad) {
		this.entidad = entidad;
	}

	public void visit(Jugador jugador) {
	}
	
	public void visit(VehiculoRutaClasico car) {
	}
	
	public void visit(VehiculoRutaPremio car) {
	}
	
	public void visit(VallaIzq car) {
	}
	
	public void visit(VallaDer car) {
	}
	


}
