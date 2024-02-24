package Entidades;

import java.awt.Point;

import Entidades_Graficas.Label_clasico_premio;
import Visitors.Visitor;

public class VehiculoRutaPremio extends VehiculoRuta {

	public VehiculoRutaPremio(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_clasico_premio(p), tiempoQuieto, enEspera);

	}



	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
