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
		//animar explosion
		j.respawn();
		//Explotar y reaparecer si quedan vidas en vez de eliminar 		
	}
	
	public void visit(VallaDer i) {
		Jugador j = (Jugador) entidad;
		//animar explosion
		j.respawn();
		//Explotar y reaparecer si quedan vidas en vez de eliminar 		
	}

}
