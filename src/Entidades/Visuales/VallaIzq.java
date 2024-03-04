package Entidades.Visuales;

import Entidades.Entidad;
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
		super(new Label_valla(190,200));
		movimiento = new Estatico(this, Estatico.ADIRECCIONAL,0);
		visitor = new VisitorVallaIzq(this);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}



}