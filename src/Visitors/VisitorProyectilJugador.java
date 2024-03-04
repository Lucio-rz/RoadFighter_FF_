package Visitors;


import Entidades.ProyectilJugador;
import Entidades.VehiculoRutaClasico;


public class VisitorProyectilJugador extends Visitor{

	public VisitorProyectilJugador(ProyectilJugador entidad) {
		super(entidad);
	}
	
	public void visit(VehiculoRutaClasico vr) {
		ProyectilJugador e = (ProyectilJugador) entidad;
		vr.eliminar();		
		e.eliminar();
	}

}
