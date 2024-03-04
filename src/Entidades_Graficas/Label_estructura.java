package Entidades_Graficas;

import java.awt.Point;
import javax.swing.ImageIcon;
//MODIFICAR purple, usar algun patron
public class Label_estructura extends Label_car {
	ImageIcon imagen;

	public Label_estructura(Point p) {
		super(p);
		//this.setSize(173, 256);//347,513
		this.setSize(172, 620);//347,513
	    
		//double randomValue = Math.random();//número aleatorio entre 0 y 1
	    //if (randomValue < 0.5) 
		//imagen = new ImageIcon(
		//	Label_estructura.class.getResource("/Recursos/estructura1.png"));
		//else
			imagen = new ImageIcon(
					Label_estructura.class.getResource("/Recursos/estructura3.png"));//344x1241
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
