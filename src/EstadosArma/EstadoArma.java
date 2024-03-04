package EstadosArma;

import Entidades.Jugador;
import Entidades.ProyectilJugador;

public abstract class EstadoArma {
	protected int velocidad_disparo;
	protected Jugador jugador;

	public EstadoArma(Jugador jugador) {
		this.jugador = jugador;
		velocidad_disparo = 10;
	}

	public abstract ProyectilJugador disparar();
}
