package Movilidad;

import Entidades.Entidad;
import Entidades_Graficas.EntidadGrafica;

public class Vertical_remove extends Vertical {

	public Vertical_remove(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		if (siguientePosY > limiteY+100) {
			entidad.eliminar();
		}else 
			g.setLocation(g.getX(), siguientePosY);	
	}
}
