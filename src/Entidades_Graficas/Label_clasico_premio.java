package Entidades_Graficas;

import java.awt.Point;
import javax.swing.ImageIcon;
//MODIFICAR purple, usar algun patron
public class Label_clasico_premio extends Label_clasico {

	public Label_clasico_premio(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(
				Label_clasico_premio.class.getResource("/Recursos/streetCar2.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
