package Entidades_Graficas;

import java.awt.Point;
import javax.swing.ImageIcon;
//MODIFICAR purple, usar algun patron
public class Label_prize_car extends Label_car {

	public Label_prize_car(Point p) {
		super(p);
		this.setSize(31, 81);
		ImageIcon imagen = new ImageIcon(
			Label_prize_car.class.getResource("/Recursos/streetCar2.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	

}
