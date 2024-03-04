package Entidades;

import java.awt.Point;
import Entidades_Graficas.Label_classic_car;
import Visitors.Visitor;

public class VehiculoRutaClasico extends VehiculoRuta {


	public VehiculoRutaClasico(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_classic_car(p), tiempoQuieto, enEspera);
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}



}
