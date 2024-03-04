package Entidades_Graficas;

import java.awt.Point;
import javax.swing.ImageIcon;
//MODIFICAR purple, usar algun patron
public class Label_obstaculo extends Label_car {

	public Label_obstaculo(Point p) {
		super(p);
		this.setSize(37, 34);
		ImageIcon imagen = new ImageIcon(
			Label_obstaculo.class.getResource("/Recursos/obstacleHole.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	

}
