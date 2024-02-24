package Entidades;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Entidades_Graficas.EntidadGrafica;
import Movilidad.Vertical;
import Movilidad.Vertical_loop;
import Movilidad.Vertical_remove;
import Visitors.VisitorVehiculoRuta;

//vehiculos que transitan por la ruta
public abstract class VehiculoRuta extends Entidad {
	protected boolean chocado;//chocado?
	protected int tiempoEspera;
	protected boolean quieto;
	protected Random random;

	
	/**
	 * Crea un infectado
	 * 
	 * @param entidad_graf entidad grafica de la entidad
	 * @param duracion     tiempo que permanecer� quieto el infectado, en
	 *                     milisegundos desde que empieza su tanda
	 * @param enEspera     parametro necesario para saber si el infectado que se
	 *                     crea pertenece a la primer tanda(en ese caso no estara en
	 *                     espera) o y si deberia quedarse quieto hasta que se
	 *                     notifique(cuando se llegue a su tanda)
	 */
	public VehiculoRuta(EntidadGrafica entidad_graf, int duracion, boolean enEspera) {
		super(entidad_graf);
		velocidad = 4;
		movimiento = null;// en principio no se moveran hasta que se indique que aparezca por pantalla
		random = new Random();
		chocado = false;
		quieto = false;

		tiempoEspera = duracion;
		if (!enEspera)
			aparecer();

		visitor = new VisitorVehiculoRuta(this);
	}

	/**
	 * cuando se llama a este m�todo empieza a contar el tiempo de espera del
	 * infectado para luego aparecer en pantalla
	 */
	public void aparecer() {
		VehiculoRuta car = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new Vertical_remove(car, Vertical.ABAJO);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);

	}
	
	
	public void eliminar() {
		juego.eliminarVehiculoRuta(this);
	}

	public void accionar() {
		if (!quieto || !chocado) {
			if (movimiento != null)
				movimiento.mover();
		}
	}


}
