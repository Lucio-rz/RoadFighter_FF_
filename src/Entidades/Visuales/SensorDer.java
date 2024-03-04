package Entidades.Visuales;

import Entidades.Entidad;
import Entidades_Graficas.Label_sensor;
import Entidades_Graficas.Label_valla;
import Movilidad.Estatico;
import Visitors.Visitor;
import Visitors.VisitorSensorDer;
import Visitors.VisitorVallaDer;

public class SensorDer extends Entidad{

	public SensorDer() {
		super(new Label_sensor(440,100));
		movimiento = new Estatico(this, Estatico.ADIRECCIONAL,0);
		visitor = new VisitorSensorDer(this);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void accionar() {
			this.movimiento.mover();
		}



}