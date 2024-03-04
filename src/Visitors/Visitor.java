package Visitors;

import Entidades.Entidad;
import Entidades.EstructuraExterna;
import Entidades.Jugador;
import Entidades.Obstaculo;
import Entidades.ProyectilJugador;
import Entidades.ProyectilTommy;
import Entidades.VehiculoRuta;
import Entidades.VehiculoRutaCamion;
import Entidades.VehiculoRutaClasico;
import Entidades.VehiculoRutaPremio;
import Entidades.PowerUps.Ataque;
import Entidades.Visuales.SensorDer;
import Entidades.Visuales.SensorIzq;
import Entidades.Visuales.VallaDer;
import Entidades.Visuales.VallaIzq;
import Entidades.Visuales.Via;

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

	public void visit(VehiculoRutaCamion truck) {	
	}

	public void visit(Via via) {
		
	}

	public void visit(VallaIzq vi) {
		
	}

	public void visit(VallaDer vd) {	
	}

	public void visit(SensorDer sd) {		
	}
	
	public void visit(SensorIzq sd) {		
	}

	public void visit(Obstaculo obs) {		
	}

	public void visit(EstructuraExterna ee) {
	}

	public void visit(Ataque attk) {		
	}

	public void visit(ProyectilTommy tommy) {
	}

	public void visit(VehiculoRuta vr) {		
	}


}
