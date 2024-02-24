package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.VehiculoRuta;


/**
 * clase que modela una tanda de infectados
 *
 */
public class Tanda {
	private List<VehiculoRuta> cars;

	public Tanda() {
		cars = new LinkedList<VehiculoRuta>();
	}

	public boolean vacia() {
		return cars.isEmpty();
	}

	public void agregarVehiculoRuta(VehiculoRuta car) {
		cars.add(car);
	}

	public void eliminarVehiculoRuta(VehiculoRuta car) {
		cars.remove(car);
	}

	public void aparecer() {
		for (VehiculoRuta i : cars) {
			i.aparecer();
		}
	}

	public List<VehiculoRuta> getCars() {
		return cars;
	}
}
