package Logica;


import java.awt.Point;
import Entidades.VehiculoRuta;
import Entidades.VehiculoRutaPremio;

/**
 * clase que se encarga de construir los infectados de tipo Beta
 */
public class FactoryPremio extends Factory {

	public FactoryPremio() {
		super();
	}

	@Override
	public VehiculoRuta crearVehiculoRuta(boolean enEspera) {
		Point p = posicion();
		VehiculoRuta car = new VehiculoRutaPremio(p, tiempo, enEspera);
		tiempo = tiempo + 5000;// cada infectado aparecera con una diferencia de 5 segundos
		return car;
	}



	private Point posicion() {//210
		return new Point(r.nextInt(290)+210, -100);
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;

	}

}
