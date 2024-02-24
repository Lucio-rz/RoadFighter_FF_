package Entidades;


import Entidades_Graficas.Label_jugador;
import EstadoJugador.EstadoInicial;
import EstadoJugador.EstadoJugador;
import Visitors.Visitor;
import Movilidad.Horizontal;

public class Jugador extends Entidad {
	protected EstadoJugador estado_jugador;
	protected int carga_viral;
	protected int tiros;

	
	public Jugador() {
		super(new Label_jugador());
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_jugador = new EstadoInicial(this);
		carga_viral = 0;
		tiros = 0;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public void setCargaViral(int carga) {
		if (carga < 0)
			carga = 0;
		this.carga_viral = carga;
	}

	public int getCargaViral() {
		return carga_viral;
	}

	public void incrementarCargaViral(int carga) {
		estado_jugador.incrementarCargaViral(carga);

		if (carga_viral >= 100) {
			juego.eliminarEntidad(this);
			juego.perdio();
		}
	}

	public void accionar() {
		if (juego.moviendoDerecha()) {
			this.movimiento.setDireccion(Horizontal.DERECHA);
			this.movimiento.mover();
		}

		if (juego.moviendoIzquierda()) {
			this.movimiento.setDireccion(Horizontal.IZQUIERDA);
			this.movimiento.mover();
		}
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

}