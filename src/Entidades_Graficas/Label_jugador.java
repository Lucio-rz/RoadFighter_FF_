package Entidades_Graficas;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Label_jugador extends EntidadGrafica {
	//agregar imagenes de giro al chocar
	private String[] rutasImagen = {"/Recursos/Toretto.png"};

	public Label_jugador() {
		super();
		this.setSize(96, 91);
		ImageIcon imagen = new ImageIcon(getClass().getResource(rutasImagen[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(280, 480);
		this.setVisible(true);
	}

	public void spawn() {
		this.setLocation(310, 480);
	}
}
