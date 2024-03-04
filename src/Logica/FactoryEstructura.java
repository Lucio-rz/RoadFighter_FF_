package Logica;


import java.awt.Point;

import Entidades.EstructuraExterna;
import Entidades.Obstaculo;
import Entidades.VehiculoRuta;
import Entidades.VehiculoRutaPremio;

/**
 * clase que se encarga de construir los infectados de tipo Beta
 */
public class FactoryEstructura extends Factory {

	public FactoryEstructura() {
		super();
	}

	@Override
	public VehiculoRuta crearVehiculoRuta(boolean enEspera) {
		Point p = posicion();
		VehiculoRuta car = new EstructuraExterna(p, tiempo, enEspera);
		tiempo = tiempo + 5000;// cada infectado aparecera con una diferencia de 5 segundos
		return car;
	}

/*
 * Se realiza reaparicion en cualquier parte del ancho de la autopista
 * exceptuando la via
 * */
	private Point posicion() {
	//	return new Point(r.nextInt(290)+500, -400);
		return new Point(580,-620);
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;

	}

}
