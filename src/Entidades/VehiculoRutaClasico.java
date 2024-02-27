package Entidades;

import java.awt.Point;
import Entidades_Graficas.Label_clasico_purple;
import Entidades_Graficas.Label_jugador;
import Visitors.Visitor;
import Visitors.VisitorVehiculoRuta;

public class VehiculoRutaClasico extends VehiculoRuta {

	protected boolean loco;

	public VehiculoRutaClasico(Point p, int tiempoQuieto, boolean enEspera) {
		super(new Label_clasico_purple(p), tiempoQuieto, enEspera);
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}



}
