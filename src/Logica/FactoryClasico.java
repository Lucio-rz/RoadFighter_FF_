package Logica;

import java.awt.Point;
import Entidades.VehiculoRuta;
import Entidades.VehiculoRutaClasico;

/**
 * clase que se encarga de construir los infectados de tipo Alpha
 *
 */
public class FactoryClasico extends Factory {

	public FactoryClasico() {
		super();
	}

	@Override
	public VehiculoRuta crearVehiculoRuta(boolean enEspera) {
		Point p = posicion();
		VehiculoRuta car= new VehiculoRutaClasico(p, tiempo, enEspera);
		tiempo = 2000;//tiempo + 5000; // cada infectado aparecera con una diferencia de 5 segundos
		return car;
	}

	private Point posicion() {
	
		return new Point(r.nextInt(290)+210, -100);
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;
	}

}
