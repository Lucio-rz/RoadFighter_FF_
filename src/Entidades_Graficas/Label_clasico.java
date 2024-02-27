package Entidades_Graficas;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Label_clasico extends EntidadGrafica {

	//private String movLeft[] = new String[] { };
	//private String movRight[] = new String[] { };

	public Label_clasico(Point p) {
		super();
		this.setSize(51, 79);
		this.setLocation(p);
	}

	public void seVa(int lado) {//desplazar el coche
		System.out.println("SEVAA");
		
		//	Random rand = new Random();
		//int i = rand.nextInt(7);

		//if (lado == 1) {// se va para la der
			//imagen = new ImageIcon(this.getClass().getResource(this.movRight[i]));
		//} else {// se va para la izq
			//imagen = new ImageIcon(this.getClass().getResource(this.movLeft[i]));
		//}

	//	this.setIcon(imagen);
	//	this.setBounds(getX(), getY(), 100, 75);
		//this.repaint();

	}

}
