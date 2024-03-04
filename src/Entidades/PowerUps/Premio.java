package Entidades.PowerUps;

import Entidades.Entidad;
import Entidades_Graficas.EntidadGrafica;
import Movilidad.Vertical;
import Movilidad.Vertical_remove;
import Visitors.Visitor;

/**
 * Clase que modela un premio del juego
 *
 */
public abstract class Premio extends Entidad {

	public Premio(EntidadGrafica entidad_graf) {
		super(entidad_graf);
		velocidad = 4;
		movimiento = new Vertical_remove(this,Vertical.ABAJO,0);		
	}
	
	public abstract void accept(Visitor visitor);
}
