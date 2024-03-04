package Visitors;

import Entidades.Jugador;
import Entidades.Obstaculo;

public class VisitorObstaculo extends Visitor{
	public VisitorObstaculo(Obstaculo entidad){
		super(entidad);
	}

	public void visit(Jugador j) {
	    double randomValue = Math.random();//número aleatorio entre 0 y 1
	    if (randomValue < 0.5)
		j.setImpactoDerecha(true, j.getGrafico().getX()+50);
		j.setImpactoIzquierda(true, j.getGrafico().getX()-50);
	}
}
