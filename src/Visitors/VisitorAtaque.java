package Visitors;

import java.util.Timer;
import java.util.TimerTask;
import Entidades.Jugador;
import Entidades.PowerUps.PremioTemporal;
import EstadoJugador.EstadoAtaque;
import EstadoJugador.EstadoJugador;
import Logica.Juego;

public class VisitorAtaque extends VisitorTemporal {

	public VisitorAtaque(PremioTemporal entidad) {
		super(entidad);
		duracion = entidad.getDuracion();
	}
	
	public void visit(Jugador jug) {
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new EstadoAtaque(jug));
		PremioTemporal p = (PremioTemporal) entidad;
		int valor = p.getValor();
		entidad.eliminar();
		Juego.getJuego().setEstadoPowerUp(valor, true);
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			public void run() {
				jug.setEstadoJugador(estado_actual);
				jug.establecerImagenJugador();
				Juego.getJuego().setEstadoPowerUp(valor, false);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion, 1);
	}
}
