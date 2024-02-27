package Visitors;

import Entidades.*;

public class VisitorVehiculoRuta extends Visitor {

	public VisitorVehiculoRuta(VehiculoRuta entidad){
		super(entidad);
	}
	
	public void visit(Jugador j) {
		//desplazar entidad a diagonal derecha y vehiculo en izquierda si vehiculo esta en izquierda
		//desplazar entidad a diagonal izquierda y vehiculo a derecha si vehiculo esta en derecha
		//en el choque el vehiculo debe setear la velocidad en 260
		
		VehiculoRuta vr = (VehiculoRuta) entidad;
		j.setVelocidad(260);
		
		double centroCocheRuta = vr.getRectangle().getCenterX();
		double centroJugador = j.getRectangle().getCenterX();
		
		if (centroCocheRuta < centroJugador) {
			j.setImpactoDerecha(true,j.getGrafico().getX()+50);
			//vr.impactoDiagSupIzq();
		}
		else { 
			j.setImpactoIzquierda(true,j.getGrafico().getX()-50);
			//3vr.impactoDiagSupDer();
		}
	}
}
