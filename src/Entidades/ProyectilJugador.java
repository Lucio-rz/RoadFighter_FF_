package Entidades;

import Entidades_Graficas.EntidadGrafica;
import Movilidad.Vertical;
import Movilidad.Vertical_remove;
import Movilidad.Vertical_remove_proyectil;
import Visitors.VisitorProyectilJugador;

public abstract class ProyectilJugador extends Entidad {

	public ProyectilJugador(EntidadGrafica entidad_graf) {
		super(entidad_graf);
		movimiento = new Vertical_remove_proyectil(this, Vertical.ARRIBA,0);
		visitor = new VisitorProyectilJugador(this);
	}

}

