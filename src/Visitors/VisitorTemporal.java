package Visitors;

import Entidades.Entidad;

public class VisitorTemporal extends Visitor {
	
	protected int duracion;

	public VisitorTemporal(Entidad entidad) {
		super(entidad);
	}

}
