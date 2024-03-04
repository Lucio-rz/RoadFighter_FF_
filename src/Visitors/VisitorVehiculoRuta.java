package Visitors;

import Entidades.*;
import Entidades.Visuales.SensorDer;
import Entidades.Visuales.SensorIzq;
import Entidades.Visuales.VallaDer;
import Entidades.Visuales.VallaIzq;

public class VisitorVehiculoRuta extends Visitor {

	public VisitorVehiculoRuta(VehiculoRuta entidad){
		super(entidad);
	}
	/*
	 *desplazar entidad a diagonal derecha y vehiculo en izquierda si vehiculo esta en izquierda
	 *desplazar entidad a diagonal izquierda y vehiculo a derecha si vehiculo esta en derecha
	 * en el choque el vehiculo debe reducir la velocidad
	 */
	public void visit(Jugador j) {
		VehiculoRuta vr = (VehiculoRuta) entidad;
		j.reduccionPorImpacto();
		
		double centroCocheRuta = vr.getRectangle().getCenterX();
		double centroJugador = j.getRectangle().getCenterX();
		
		if (centroCocheRuta < centroJugador) {
			j.setImpactoDerecha(true,j.getGrafico().getX()+90);
			vr.setImpactoSupIzq(true,vr.getGrafico().getX()-90);//da igual x o y
		}
		else { 
			j.setImpactoIzquierda(true,j.getGrafico().getX()-90);
			vr.setImpactoSupDer(true,vr.getGrafico().getX()+90);
		}
	}
	
	public void visit(VallaIzq i) {
		VehiculoRuta vr = (VehiculoRuta) entidad;
		vr.explotar();
	}
	
	public void visit(VallaDer i) {
		VehiculoRuta vr = (VehiculoRuta) entidad;
		vr.explotar();	
	}
	
	public void visit(SensorIzq i) {
		VehiculoRuta vr = (VehiculoRuta) entidad;
		if (vr.getCambiarCarril()) {
	    double randomValue = Math.random();//número aleatorio entre 0 y 1
	    if (randomValue < 0.5) { //50% de probabilidad para ejecutar el bloque
		vr.desplazarDerecha(true,vr.getGrafico().getX()+70);
	    }
	    else vr.setCambiarCarril(false);
		}
	}
	
	public void visit(SensorDer i) {
		VehiculoRuta vr = (VehiculoRuta) entidad;
		if (vr.getCambiarCarril()) {
	    double randomValue = Math.random();//número aleatorio entre 0 y 1
	    if (randomValue < 0.5) { //50% de probabilidad para ejecutar el bloque
		vr.desplazarIzquierda(true,vr.getGrafico().getX()-70);
	    }
	    else vr.setCambiarCarril(false);
		}
	}
	


}
