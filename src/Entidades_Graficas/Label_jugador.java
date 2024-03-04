package Entidades_Graficas;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Label_jugador extends Label_vehiculo {
	//agregar imagenes de giro al chocar
	private String[] rutasImagen = {"/Recursos/ClassicCar.png"};
	ImageIcon imagen;

	public Label_jugador() {
		super();
		this.setSize(50, 125);
		imagen = new ImageIcon(getClass().getResource(rutasImagen[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(280, 480);
		this.setVisible(true);
	}

	public void spawn(int x) {
		this.setSize(31, 79);
		this.setLocation(x, 480);
		this.setIcon(imagen);
		this.repaint();
	}
}
