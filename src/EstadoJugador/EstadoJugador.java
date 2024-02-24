package EstadoJugador;

import Entidades.Jugador;

public abstract class EstadoJugador {
	protected Jugador jugador;
	protected int velocidad;

	public EstadoJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void incrementarCargaViral(int carga) {
		jugador.setCargaViral(jugador.getCargaViral() + carga);
	}
}
