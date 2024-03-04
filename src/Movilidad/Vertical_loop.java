package Movilidad;

import Entidades.Entidad;
import Entidades_Graficas.EntidadGrafica;

public class Vertical_loop extends Vertical {

	public Vertical_loop(Entidad entidad, int direccion,int spawn) {
		super(entidad, direccion, spawn);
	}

	@Override
	public void mover() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		if (siguientePosY > limiteY + 120)
			g.setLocation(g.getX(), -120);
		else
			g.setLocation(g.getX(), siguientePosY);

	}

}
