package Logica;

import Entidades.Obstaculo;
import Entidades.VehiculoRuta;

/**
 * clase que se encarga de la construccion de un nivel
 */
public class BuilderDefault extends BuilderNivel {

	private Tanda tandaActual;
	private int nivelesCreados;
	private boolean primerTanda;

	public BuilderDefault() {
		super();
		misFabricas.add(new FactoryClasico());
		misFabricas.add(new FactoryPremio());
		misFabricas.add(new FactoryTruck());
		misFabricas.add(new FactoryObstaculo());
		misFabricas.add(new FactoryEstructura());
		nivelesCreados = 0;
		tandaActual = new Tanda();
		primerTanda = true;
	}

	@Override
	public void reset() {
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		primerTanda = true;
	}

	@Override
	public void construirVehiculosRuta(int carType) {
		// tipoInfectado debe coincidir con un indice valido de la lista de fabricas.
		// el tipo i es creado por la fabrica i
		VehiculoRuta car = misFabricas.get(carType).crearVehiculoRuta(!primerTanda);
		tandaActual.agregarVehiculoRuta(car);
	}

	@Override
	public Nivel getNivel() {
		Nivel aRetornar = nivel;
		nivel = new Nivel(nivelesCreados);
		tandaActual = new Tanda();
		primerTanda=true;
		return aRetornar;
	}

	@Override
	public void siguienteTanda() {
		for (Factory f : misFabricas) {
			f.reiniciar();
		}
		nivel.agregarTanda(tandaActual);
		tandaActual = new Tanda(); // se crea la proxima tanda
		primerTanda = false;
	}

}
