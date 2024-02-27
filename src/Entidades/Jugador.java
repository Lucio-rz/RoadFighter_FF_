package Entidades;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.TimerTask;

import Entidades_Graficas.Label_jugador;
import EstadoJugador.EstadoInicial;
import EstadoJugador.EstadoJugador;
import Visitors.Visitor;
import Movilidad.Horizontal;

public class Jugador extends Entidad {
	private EstadoJugador estado_jugador;
	private int vidas;
	private int puntos;
	private int velocidad;
	private int combustible;
	private boolean impactoDerecha;
	private boolean impactoIzquierda;
	private int recorrido ;
	private boolean enValla;
	private static final int MAX_VEL = 400;

	public Jugador() {
		super(new Label_jugador());
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_jugador = new EstadoInicial(this);
		vidas = 3;
		puntos = 0;
		velocidad = 0;
		combustible = 100;
		impactoDerecha = false;
		impactoIzquierda = false;
		enValla = false;
		recorrido = 0;
		iniciarCombustion();
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public void setPuntos(int puntos) {
		if (puntos < 0)
			puntos = 0;
		this.puntos = puntos;
	}

	public int getPuntos() {
		return puntos;
	}
	
	public void setVidas(int vidas) {
		if (vidas < 0)
			vidas = 0;
		this.vidas = vidas;
	}

	public int getVidas() {
		return vidas;
	}
	
	public void setImpactoIzquierda(boolean b,int r) {
		impactoIzquierda = b;
		recorrido = r;
	}
	
	public void setImpactoDerecha(boolean b, int r) {
		impactoDerecha = b;
		recorrido = r;
	}
	
	
	public void incrementarPuntos(int puntos) {//un visitor lo accede
		estado_jugador.incrementarPuntos(puntos);
	}
	
	public void decrementarVida() {//un visitor lo accede
		estado_jugador.decrementarVida();
		
		if (vidas == 0) {
			juego.eliminarEntidad(this);
			juego.perdio();
	}
	}
	
	

	public void accionar() {
		if (juego.moviendoDerecha() && !impactoConVehiculo()) {
			this.movimiento.setDireccion(Horizontal.DERECHA);
			this.movimiento.mover();
		}

		if (juego.moviendoIzquierda() && !impactoConVehiculo()) {
			this.movimiento.setDireccion(Horizontal.IZQUIERDA);
			this.movimiento.mover();
		}
		
		if (impactoIzquierda) {
			if(!finDeImpactoIzq()){ // analiza si se termino el recorrido del impacto
			this.movimiento.setDireccion(Horizontal.IZQUIERDA);
			this.movimiento.mover();
			}
		}
		
		if (impactoDerecha) {
			if(!finDeImpactoDer()) { // analiza si se termino el recorrido del impacto
			this.movimiento.setDireccion(Horizontal.DERECHA);
			this.movimiento.mover();
			}
		}
		
		
		
	}
	
	public boolean impactoConVehiculo() {
		return (impactoDerecha || impactoIzquierda);
	}
	
	public boolean finDeImpactoIzq() {
		boolean finImpacto = (getGrafico().getX() <= recorrido);
		if (finImpacto)
			impactoIzquierda = false;
		return finImpacto;
	}
	

	public boolean finDeImpactoDer() {
		boolean finImpacto = (getGrafico().getX() >= recorrido);
		if (finImpacto)
			impactoDerecha = false;
		return finImpacto;
	}
	
	public void explotar() {
		Label_jugador lbl = (Label_jugador) this.getGrafico();
		lbl.explosion();
		juego.pausa(); 
		finalizarImpacto();
	}
	
	
	private void finalizarImpacto() {
		impactoIzquierda = false;
		impactoDerecha = false;		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void setEstadoJugador(EstadoJugador estado_jugador) {
		this.estado_jugador = estado_jugador;
	}
	
	public void respawn() {
		Label_jugador lbl = (Label_jugador) getGrafico();
		lbl.spawn();
	}

	public EstadoJugador getEstadoJugador() {
		return estado_jugador;
	}

	@Override
	public int getVelocidad() {
		return estado_jugador.getVelocidad();
	}
	
	public int getCombustible() {
		return combustible;
	}
	
	public void iniciarCombustion() {
		  Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combustible--;
				if (combustible <= 0) 
					((Timer)e.getSource()).stop();
			}
		});
		timer.start();
	}

}