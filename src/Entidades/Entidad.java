package Entidades;


import Entidades_Graficas.EntidadGrafica;
import Logica.Juego;
import Movilidad.EstrategiaMovimiento;
import Visitors.Element;
import Visitors.Visitor;

public abstract class Entidad extends Element{

	protected int velocidad;
	protected EntidadGrafica entidad_graf;
	protected EstrategiaMovimiento movimiento;
	protected Juego juego;
	protected Visitor visitor;

	public Entidad(EntidadGrafica entidad_graf) {
		this.juego = Juego.getJuego();
		this.juego.agregarEntidad(this);
		this.entidad_graf = entidad_graf;
	}

	public void accionar() {
		this.movimiento.mover();
	}

	@Override
	public abstract void accept(Visitor visitor);

	public void setMovimiento(EstrategiaMovimiento movimiento) {
		this.movimiento = movimiento;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void eliminar() {
		juego.eliminarEntidad(this);
	}

	public EntidadGrafica getGrafico() {
		return entidad_graf;
	}

	public Visitor getVisitor() {
		return visitor;
	}
}
