package EstadosArma;

import java.awt.Point;

import Entidades.Jugador;
import Entidades.ProyectilJugador;
import Entidades.ProyectilTommy;
import Entidades_Graficas.EntidadGrafica;

public class ConTommyGun extends EstadoArma {

	public ConTommyGun(Jugador jugador) {
		super(jugador);
	}

	@Override
	public ProyectilJugador disparar() {
		EntidadGrafica g = this.jugador.getGrafico();
		return new ProyectilTommy(new Point(g.getX(), g.getY() - 30));
	}
}
