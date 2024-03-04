package Entidades_Graficas;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Label_car extends EntidadGrafica {

	public Label_car(Point p) {
		super();
		this.setLocation(p);
	}

	public void explosion() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/Recursos/notasYellow.gif"));
		this.setIcon(imagen);
		this.setBounds(getX(), getY(), 270, 480);
		this.repaint();
}
}
