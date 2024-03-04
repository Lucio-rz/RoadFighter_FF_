package Entidades_Graficas;

import java.awt.Point;
import javax.swing.ImageIcon;
//MODIFICAR purple, usar algun patron
public class Label_classic_car extends Label_car {

	public Label_classic_car(Point p) {
		super(p);
		this.setSize(36, 77);
		ImageIcon imagen = new ImageIcon(
				Label_classic_car.class.getResource("/Recursos/streetCar1.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
