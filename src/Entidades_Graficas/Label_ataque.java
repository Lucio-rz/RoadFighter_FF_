package Entidades_Graficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_ataque extends Label_temporal {

	public Label_ataque(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/Recursos/tommyGun.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
