package Entidades_Graficas;

import java.awt.Point;
import javax.swing.ImageIcon;
//MODIFICAR purple, usar algun patron
public class Label_clasico_purple extends Label_clasico {

	public Label_clasico_purple(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Label_clasico_purple.class.getResource("/Recursos/streetCar1.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
