package Movilidad;

import Entidades.Entidad;
import Entidades_Graficas.EntidadGrafica;

public class Estatico extends EstrategiaMovimiento {
	public static final int ADIRECCIONAL = 1;

	public Estatico(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		//no hace nada por estatico
		}

	}
