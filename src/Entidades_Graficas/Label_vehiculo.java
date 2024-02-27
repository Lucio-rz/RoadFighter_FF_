package Entidades_Graficas;

import java.awt.Point;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public abstract class Label_vehiculo extends EntidadGrafica {

	public Label_vehiculo() {
		super();
	}

	public void explosion() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/Recursos/explosion.gif"));
		this.setIcon(imagen);
		this.setBounds(getX(), getY(), 100, 75);
		this.repaint();
}
}
