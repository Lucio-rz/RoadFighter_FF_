package EstadoJugador;

import Entidades.Jugador;
import Visitors.VisitorJugador;

public class EstadoAtaque extends ConPowerUp {

	public EstadoAtaque(Jugador jugador) {
		super(jugador);
		velocidad = 4;
		this.jugador.setVisitor(new VisitorJugador(jugador));
		fuegoHabilitado = true;
	}

}
