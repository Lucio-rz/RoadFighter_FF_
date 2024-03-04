package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import Entidades_Graficas.Label_estructura;
import Movilidad.Vertical;
import Movilidad.Vertical_remove;
import Visitors.Visitor;
import Visitors.VisitorEstructura;

public class EstructuraExterna extends VehiculoRuta {

	public EstructuraExterna(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_estructura(p), tiempoQuieto, enEspera);//color amarillo
		visitor = new VisitorEstructura(this);
	}


	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void setVelocidad(int vel) {
		velocidad = vel*3;
	}
	

}
