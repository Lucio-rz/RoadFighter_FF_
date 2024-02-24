package Entidades;

import Entidades_Graficas.Label_valla;
import Movilidad.Estatico;
import Movilidad.Horizontal;
import Visitors.Visitor;
import Visitors.VisitorVallaIzq;
/*
 * crea vallas que cubren la ruta y porvocan la explosion de coches 
 * que le intersectan
 */
public class VallaIzq extends Entidad{

	public VallaIzq() {
		super(new Label_valla(170,500));
		movimiento = new Estatico(this, Estatico.ADIRECCIONAL);
		visitor = new VisitorVallaIzq(this);
	}
	

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void accionar() {
			this.movimiento.mover();
		}



}