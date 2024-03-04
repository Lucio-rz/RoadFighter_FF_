package Entidades_Graficas;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidades.Jugador;

public class Label_proyectil_tommy extends EntidadGrafica {

	public Label_proyectil_tommy(Point p) {
		this.setSize(50, 50);
		ImageIcon imagen = new ImageIcon(
				Label_proyectil_tommy.class.getResource("/Recursos/disparo.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(p);
	}
}
