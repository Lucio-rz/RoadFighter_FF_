package Visitors;

import Entidades.EstructuraExterna;
import Entidades.Jugador;
import Entidades.Obstaculo;

public class VisitorEstructura extends Visitor{
	public VisitorEstructura(EstructuraExterna entidad){
		super(entidad);
	}
}

