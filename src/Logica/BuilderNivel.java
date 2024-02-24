package Logica;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase abstracta que define los metodos utilizados por un builder. El patron
 * de dise�o builder es implementado con el objetivo de simplificar la creacion
 * de distintos niveles
 */
public abstract class BuilderNivel {

	
	protected List<Factory> misFabricas;//almacena una fabrica por cada tipo de infectado
	protected Nivel nivel;

	public BuilderNivel() {
		nivel = new Nivel(0);
		misFabricas = new LinkedList<Factory>();
	}

	public abstract void reset();

	/**
	 * @param tipoInfectado entero utilizado para identificar que tipo de vehiculo a crear
	 */
	public abstract void construirVehiculosRuta(int carType);

	/**
	 * Termina la creacion del nivel actual
	 * @return el Nivel creado
	 */
	public abstract Nivel getNivel();

	public abstract void siguienteTanda();

}
