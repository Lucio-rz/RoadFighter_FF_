package Visitors;

import Entidades.Jugador;
import Entidades.VehiculoRutaCamion;
import Entidades.VehiculoRutaPremio;

public class VisitorTruck extends Visitor{
	public VisitorTruck(VehiculoRutaCamion entidad){
		super(entidad);
	}

	public void visit(Jugador j) {
		VehiculoRutaCamion vrc = (VehiculoRutaCamion) entidad;
		j.explotar();
		j.decrementarVida();
		j.spawnSeguro(vrc.getGrafico().getX(),vrc.getGrafico().getWidth());
	}
}
