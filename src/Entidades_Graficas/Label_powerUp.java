package Entidades_Graficas;

import java.awt.Point;

public abstract class Label_powerUp extends EntidadGrafica{

	public Label_powerUp(Point p) {
		super();
		this.setLocation(p);
		this.setSize(80,29);
	}
}
