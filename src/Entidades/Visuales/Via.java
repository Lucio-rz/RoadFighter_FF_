package Entidades.Visuales;

import Entidades.Entidad;
import Entidades_Graficas.Label_valla;
import Entidades_Graficas.Label_via;
import Movilidad.Estatico;
import Movilidad.Vertical;
import Movilidad.Vertical_loop;
import Visitors.Visitor;
import Visitors.VisitorVallaIzq;
import Visitors.VisitorVia;

public class Via extends Entidad {
	public Via() {
		super(new Label_via(370, 70));
		movimiento = new Vertical_loop(this, Vertical.ABAJO,0);
		visitor = new VisitorVia(this);
		velocidad = 0;
	}
	

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void accionar() {
			this.movimiento.mover();
		}
	
	public void setVelocidad(int vel) {
		velocidad = vel*3;
	}
}
