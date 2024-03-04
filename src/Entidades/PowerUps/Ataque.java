package Entidades.PowerUps;

import java.awt.Point;

import Entidades_Graficas.Label_ataque;
import Visitors.Visitor;
import Visitors.VisitorAtaque;


public class Ataque extends PremioTemporal {

	public Ataque(Point p) {
		super(new Label_ataque(p));
		duracion = 3000;
		velocidad = 5;
		valor = 0;
		visitor = new VisitorAtaque(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
