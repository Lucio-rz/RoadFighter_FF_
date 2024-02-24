package Logica;

import java.awt.Container;
import java.util.Random;

import Entidades.VehiculoRuta;

/**
 * clase abstracta que modela la creacion de los infectados, cada tipo concreto
 * de Factory realiza la construccion de un tipo distinto de Infectado
 */
public abstract class Factory {
	protected Container mapa;
	protected Random r;
	protected int tiempo;

	public Factory() {
		tiempo = 1;
		mapa = Juego.getJuego().getMapa();
		r = new Random();
	}

	/**
	 * @param enEspera boolean que indica si el vehiculo no pertenece a la primer
	 *                 tanda
	 * @return vehiculo creado
	 */
	public abstract VehiculoRuta crearVehiculoRuta(boolean Waiting);

	/**
	 * metodo que debe ser llamado cuando se quiere empezar a construir dinfectados
	 * de una tanda siguiente
	 */
	protected abstract void reiniciar();
}
