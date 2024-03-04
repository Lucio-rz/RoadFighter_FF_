package Logica;

import java.awt.Point;
import java.util.Random;
import Entidades.PowerUps.Ataque;


/**
 * clase que se encarga de crear los premios de forma aleatoria 
 */
public class GeneradorDePremio {

	
	private static final int cantidadPremiosTemporales=1;
	private static final int cantidadPremios=1;
	
	/**
	 * metodo que crea un premio, es llamado de forma estatica
	 */
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(cantidadPremios);
		Juego juego=Juego.getJuego();
		while(indice<cantidadPremiosTemporales && juego.getEstadoPremio(indice)) {
			//se chequea que no se cree un premio temporal que ya este activado
			indice=r.nextInt(cantidadPremios);
		}
		
		switch(indice) {
			case 0: new Ataque(p);
				break;
		}
	}
}
