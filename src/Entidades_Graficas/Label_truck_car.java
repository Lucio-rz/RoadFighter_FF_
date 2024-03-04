package Entidades_Graficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Label_truck_car extends Label_car{
	public Label_truck_car(Point p) {
		super(p);
		this.setSize(112, 284);
		ImageIcon imagen = new ImageIcon(
			Label_prize_car.class.getResource("/Recursos/streetTruck.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
