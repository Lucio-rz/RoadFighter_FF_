package Entidades;

import java.awt.Point;

import Entidades_Graficas.Label_proyectil_tommy;
import Visitors.Visitor;

public class ProyectilTommy extends ProyectilJugador {

	public ProyectilTommy(Point posicion) {
		super(new Label_proyectil_tommy(posicion));
		velocidad = 6;
		//damage = 5; DAÑO
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
