package Entidades_Graficas;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.Juego;

public abstract class EntidadGrafica extends JLabel{

	public EntidadGrafica() {
		Juego.getJuego().getMapa().add(this);
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(
					grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}

}
