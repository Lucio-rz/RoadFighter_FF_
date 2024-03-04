package Entidades;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.TimerTask;

import Entidades_Graficas.Label_jugador;
import EstadoJugador.EstadoInicial;
import EstadoJugador.EstadoJugador;
import EstadosArma.ConTommyGun;
import EstadosArma.EstadoArma;
import Visitors.Visitor;
import Movilidad.Horizontal;

public class Jugador extends Entidad {
	private EstadoJugador estado_jugador;
	protected EstadoArma estado_arma;
	private int vidas;
	private int puntos;
	private int rapidez;
	private int aceleracion;
	private int combustible;
	private int tiros;
	private boolean impactoDerecha;
	private boolean impactoIzquierda;
	private int recorrido ;
	private boolean acelerando;
	private static final int MAX_SPEED = 400;

	public Jugador() {
		super(new Label_jugador());
		movimiento = new Horizontal(this, Horizontal.DERECHA,0);
		estado_jugador = new EstadoInicial(this);
		estado_arma = new ConTommyGun(this);
		tiros = 0;
		vidas = 3;
		puntos = 0;
		rapidez = 0;
		aceleracion = 40;
		combustible = 100;
		impactoDerecha = false;
		impactoIzquierda = false;
		acelerando = true;
		recorrido = 0;
		iniciarCombustion();
		iniciarMarcha();
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
		Label_jugador lbl = (Label_jugador) this.getGrafico();
		lbl.accidente(2);
		impactoIzquierda = b;
		recorrido = r;
	}

	public void setImpactoDerecha(boolean b, int r) {
		Label_jugador lbl = (Label_jugador) this.getGrafico();
		lbl.accidente(1);
		impactoDerecha = b;
		recorrido = r;
	}

	public void setRapidez(int num) {
		rapidez = num;
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
		if (juego.disparando() && estado_jugador.getFuegoHabilitado()) {
			tiros++;
			if (tiros == 4) {
				this.estado_arma.disparar();
				tiros = 0;
				juego.seDisparo();
			}
		}
	}

	private boolean impactoConVehiculo() {
		return (impactoDerecha || impactoIzquierda);
	}

	public boolean finDeImpactoIzq() {
		boolean finImpacto = (getGrafico().getX() <= recorrido);
		if (finImpacto) {
			impactoIzquierda = false;
			Label_jugador lbl = (Label_jugador) this.getGrafico();
			lbl.normal();	
		}
		return finImpacto;
	}


	public boolean finDeImpactoDer() {
		boolean finImpacto = (getGrafico().getX() >= recorrido);
		if (finImpacto) {
			impactoDerecha = false;
			Label_jugador lbl = (Label_jugador) this.getGrafico();
			lbl.normal();
		}
		return finImpacto;
	}

	public void explotar() {
		juego.explotado();
		acelerando = false; //ayuda a detener el gaste de combustion
		Label_jugador lbl = (Label_jugador) this.getGrafico();
		lbl.explosion();
		juego.pausa(); 
		finalizarImpacto();
	}


	private void finalizarImpacto() {
		impactoIzquierda = false;
		impactoDerecha = false;		
		acelerando = true;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void setEstadoJugador(EstadoJugador estado_jugador) {
		this.estado_jugador = estado_jugador;
	}

	public void respawn(int x) {
		Label_jugador lbl = (Label_jugador) getGrafico();
		lbl.spawn(x);
		rapidez = 0;
		if (!acelerando)
			iniciarMarcha();
	}

	/*Realiza un respawn evitando la aparicion en la posicion 
	 * enviada, de forma que por ejemplo no quedamos en un bucle de
	 * colision con un camion. Ademas se intenta no reaparecer en
	 * una valla.
	 * */
	public void spawnSeguro(int x,int anchoEvitar) {
		if(x >= 370) { //posicion a evitar en la derecha de la via
			respawn(x-anchoEvitar);
		}
		else respawn(x+anchoEvitar);
		//Izquierda de la via, por lo que me voy a la derecha para no 
		//aparecer en una valla
	}

	public EstadoJugador getEstadoJugador() {
		return estado_jugador;
	}


	public int getVelocidad() {
		return estado_jugador.getVelocidad();
	}

	public int getCombustible() {
		return combustible;
	}

	public int getRapidez() {
		return rapidez;
	}

	/*
	 * Transforma la rapidez del coche en una velocidad que
	 * puedan llevar las otras entidades en su direccion opuesta 
	 * */

	public int simuladorRapidez() {
		return  rapidez/40;
	}


	public void iniciarCombustion() {
		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (acelerando)
					combustible--;
				if (combustible <= 0) 
					((Timer)e.getSource()).stop();
			}
		});
		timer.start();
	}

	public ProyectilJugador disparar() {
		return estado_arma.disparar();
	}

	public void setEstadoArma(EstadoArma estado_arma) {
		this.estado_arma = estado_arma;
	}

	public EstadoArma getEstadoArma() {
		return estado_arma;
	}

	public void iniciarMarcha() {
		acelerando = true;
		Timer timer = new Timer(aceleracion, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rapidez++;
				if (rapidez >= MAX_SPEED) { 
					((Timer)e.getSource()).stop();
					//acelerando = false;
				}
			}
		});
		timer.start();
	}

	public void reduccionPorImpacto() {
		if (rapidez >= 2 && rapidez <= 100 )
			rapidez = rapidez/2;
		else if (rapidez > 100)
			rapidez = 50;
		if(!acelerando)
			iniciarMarcha();
	}

	public void aumentarCombustible(int cant) {
		combustible += cant;
	}
	
	public void establecerImagenJugador() {
		Label_jugador lbl = (Label_jugador) this.getGrafico();
		lbl.normal();
	}

	public void aumentarPuntos(int p) {
		setPuntos(puntos + p);
	}

	public void pasoDeNivel() {
		rapidez = 0;
		iniciarMarcha();
	}

}