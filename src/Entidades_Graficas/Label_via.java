package Entidades_Graficas;

import java.awt.Point;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Label_via extends EntidadGrafica{

	public Label_via(int posX,int posY) {
		super();
		this.setSize(16,129);
		ImageIcon imagen = new ImageIcon(
				Label_via.class.getResource("/Recursos/via.png"));//
		this.setIcon(imagen);
		this.setLocation(posX,posY);
		this.setVisible(true);
	}
}
