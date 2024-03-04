package Movilidad;

import Entidades.Entidad;
import Entidades_Graficas.EntidadGrafica;

public class Vertical_remove_proyectil extends Vertical{


		public Vertical_remove_proyectil(Entidad entidad, int direccion,int spawn) {
			super(entidad, direccion,spawn);
		}

		@Override
		public void mover() {
			EntidadGrafica g = entidad.getGrafico();
			int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

			if (siguientePosY > limiteY+100) {
				entidad.eliminar();
			}else 
				if (siguientePosY < 0) {
					entidad.eliminar();
				}else
					g.setLocation(g.getX(), siguientePosY);
			
		}
	}

