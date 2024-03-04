package Entidades_Graficas;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Label_jugador extends Label_vehiculo {
	//agregar imagenes de giro al chocar
	protected String[] rutasClasica = {"/Recursos/ClassicCar.png","/Recursos/ClassicCarRight.png","/Recursos/ClassicCarLeft.png"};
	protected String[] rutasAtaque = {"/Recursos/ClassicCarAttack.png", "/Recursos/ClassicCarAttackRight.png","/Recursos/ClassicCarAttackLeft.png"};
	protected  ImageIcon imagen;
	protected boolean enAtaque;

	public Label_jugador() {
		super();
		enAtaque = false;
		this.setSize(50, 115);
		imagen = new ImageIcon(getClass().getResource(rutasClasica[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(280, 420);
		this.setVisible(true);
	}

	public void spawn(int x) {
		this.setSize(50, 115);
		this.setLocation(x, 420);
		this.setIcon(imagen);
		this.repaint();
	}

	public void accidente(int i) {//1,2
		this.setSize(100, 127);
		if (enAtaque) 	
			imagen = new ImageIcon(getClass().getResource(rutasAtaque[i]));
		else imagen = new ImageIcon(getClass().getResource(rutasClasica[i]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.repaint();
	}

	public void normal() {
		this.setSize(50, 115);
		imagen = new ImageIcon(getClass().getResource(rutasClasica[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.repaint();
	}

	public void ataque() {
		enAtaque = true;
		this.setSize(50, 115);
		imagen = new ImageIcon(getClass().getResource(rutasAtaque[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.repaint();
	}

	public void setAtaque(boolean b) {
		enAtaque = b;
	}


}
