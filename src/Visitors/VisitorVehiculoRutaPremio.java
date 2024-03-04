package Visitors;

import Entidades.*;

public class VisitorVehiculoRutaPremio extends Visitor {

	public VisitorVehiculoRutaPremio(VehiculoRutaPremio entidad){
		super(entidad);
	}
	
	public void visit(Jugador j) {
	VehiculoRutaPremio vrp = (VehiculoRutaPremio) entidad;
	j.aumentarCombustible(10);
	j.aumentarPuntos(1000);
	vrp.eliminar();
	}
}
