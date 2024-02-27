package Visitors;


import Entidades.Jugador;
import Entidades.VallaDer;
import Entidades.VallaIzq;

public class VisitorJugador extends Visitor {

	public VisitorJugador(Jugador entidad) {
		super (entidad);
	}
	
	public void visit(VallaIzq i) {
		Jugador j = (Jugador) entidad;
		j.decrementarVida();
		j.explotar();
		j.respawn();
	}
	
	public void visit(VallaDer i) {
		Jugador j = (Jugador) entidad;
		j.decrementarVida();
		j.explotar();
		j.respawn();	
	}

}
