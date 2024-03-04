package Entidades.Visuales;

import Entidades.Entidad;
import Entidades_Graficas.Label_valla;
import Movilidad.Estatico;
import Movilidad.Horizontal;
import Visitors.Visitor;
import Visitors.VisitorVallaDer;
import Visitors.VisitorVallaIzq;
/*
 * crea vallas que cubren la ruta y porvocan la explosion de coches 
 * que le intersectan
 */
public class VallaDer extends Entidad{

	public VallaDer() {
		super(new Label_valla(570,200));
		movimiento = new Estatico(this, Estatico.ADIRECCIONAL,0);
		visitor = new VisitorVallaDer(this);
	}
	

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	




}