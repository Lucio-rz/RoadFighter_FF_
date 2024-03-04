package Entidades_Graficas;



@SuppressWarnings("serial")
public class Label_sensor extends EntidadGrafica{

	public Label_sensor(int posX, int posY) {
		super();
		this.setSize(100,1);
		this.setLocation(posX, posY);
		this.setVisible(true);
	}
}
