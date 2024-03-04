package EstadoJugador;

import Entidades.Jugador;
import Entidades_Graficas.Label_jugador;
import Visitors.VisitorJugador;

public class EstadoInicial extends EstadoJugador {

	public EstadoInicial(Jugador jugador) {
		super(jugador);
		velocidad = 4; 
		this.jugador.setVisitor(new VisitorJugador(jugador));
	}
}
