package Entidades.Visuales;

import Entidades.Entidad;
import Entidades_Graficas.Label_sensor;
import Entidades_Graficas.Label_valla;
import Movilidad.Estatico;
import Visitors.Visitor;
import Visitors.VisitorSensorDer;
import Visitors.VisitorSensorIzq;
import Visitors.VisitorVallaDer;

public class SensorIzq extends Entidad{

	public SensorIzq() {
		super(new Label_sensor(240,100));
		movimiento = new Estatico(this, Estatico.ADIRECCIONAL,0);
		visitor = new VisitorSensorIzq(this);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void accionar() {
			this.movimiento.mover();
		}



}