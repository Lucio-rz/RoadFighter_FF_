package EstadoJugador;

import Entidades.Jugador;
import Entidades_Graficas.Label_jugador;
import Visitors.VisitorJugador;

public class EstadoAtaque extends ConPowerUp {

	public EstadoAtaque(Jugador jugador) {
		super(jugador);
		velocidad = 4;
		this.jugador.setVisitor(new VisitorJugador(jugador));
		fuegoHabilitado = true;
		Label_jugador lbl = (Label_jugador)jugador.getGrafico();
		lbl.ataque();
		lbl.setAtaque(true);
	}

}
