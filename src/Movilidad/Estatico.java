package Movilidad;

import Entidades.Entidad;
import Entidades_Graficas.EntidadGrafica;

public class Estatico extends EstrategiaMovimiento {
	public static final int ADIRECCIONAL = 1;

	public Estatico(Entidad entidad, int direccion,int spawn) {
		super(entidad, direccion, spawn);
	}

	@Override
	public void mover() {
		//no hace nada por estatico
		}

	}
