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

	public void incrementarPuntos(int puntos) {
		jugador.setPuntos(jugador.getPuntos() + puntos);
	}

	public void decrementarVida() {
		jugador.setVidas(jugador.getVidas() - 1);
	}
}
