package Entidades;

import java.awt.Point;

import Entidades_Graficas.Label_truck_car;
import Visitors.Visitor;
import Visitors.VisitorTruck;


public class VehiculoRutaCamion extends VehiculoRuta {
	public VehiculoRutaCamion(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_truck_car(p), tiempoQuieto, enEspera);
		visitor = new VisitorTruck(this);
	}
	
	


	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
