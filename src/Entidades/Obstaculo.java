package Entidades;

import java.awt.Point;

import Entidades_Graficas.Label_obstaculo;
import Visitors.Visitor;
import Visitors.VisitorObstaculo;

public class Obstaculo extends VehiculoRuta {

	public Obstaculo(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_obstaculo(p), tiempoQuieto, enEspera);//color amarillo
		visitor = new VisitorObstaculo(this);
	}


	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void setVelocidad(int vel) {
		velocidad = vel*3;
	}
}
