package Logica;

import java.util.LinkedList;
import Grafica.GUI;

public class Juego implements Runnable {
	
	// Atributo utilizado para el patron singleton
	private static Juego juego;
	private GUI gui;
	private int dificultad;
	
	
	/**
	 * metodo estatico para que se pueda obtener la instancia de Juego desde
	 * cualquier parte del programa
	 * 
	 * @return instancia actual del juego
	 */
	public static Juego getJuego() {
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
	}
	
	private Juego() {
		juego = this;
		dificultad = 0;
		}
	
	public void setGUI(GUI gui) {
		this.gui = gui;
	}
	

	/**
	 * detiene la ejecucion del juego brevemente, por 3 segundos
	 */
	public void pausa() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	public void run() {
		
		/**
		 * metodo estatico para que se pueda obtener la instancia de Juego desde
		 * cualquier parte del programa
		 * 
		 * @return instancia actual del juego
		 */

}

	
	public void setDificultad(int dificultad) {
		if (dificultad > 0)
			this.dificultad = 1;
	}
}