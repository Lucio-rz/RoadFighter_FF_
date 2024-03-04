package Entidades;

import java.awt.Point;

import Entidades_Graficas.Label_prize_car;
import Visitors.Visitor;
import Visitors.VisitorVehiculoRuta;
import Visitors.VisitorVehiculoRutaPremio;

public class VehiculoRutaPremio extends VehiculoRuta {

	public VehiculoRutaPremio(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_prize_car(p), tiempoQuieto, enEspera);//color amarillo
		visitor = new VisitorVehiculoRutaPremio(this);
	}


	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
