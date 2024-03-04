package Logica;


import java.awt.Point;
import Entidades.VehiculoRuta;
import Entidades.VehiculoRutaCamion;

/**
 * clase que se encarga de construir los infectados de tipo Beta
 */
public class FactoryTruck extends Factory {

	public FactoryTruck() {
		super();
	}

	@Override
	public VehiculoRuta crearVehiculoRuta(boolean enEspera) {
		Point p = posicion();
		VehiculoRuta car = new VehiculoRutaCamion(p, tiempo, enEspera);
		tiempo = 500;//tiempo + 5000;// cada infectado aparecera con una diferencia de 5 segundos
		return car;
	}

	private Point posicion() {
		return new Point(r.nextInt(250)+210, -400);
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;
	}

}
