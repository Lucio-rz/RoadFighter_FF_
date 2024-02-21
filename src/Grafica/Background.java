package Grafica;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Background extends JLayeredPane{

	private String[] nivelesTransicion = new String[] {};//fondos de nivel
	private JLabel nivelTransicionLabel;

	public Background() {

		setLayout(null);
		nivelTransicionLabel = new JLabel();
		this.add(nivelTransicionLabel);
		this.repaint();
	}

	@Override
	public Component add(Component p) {
		Component comp = super.add(p);
		this.moveToFront(p);
		return comp;
	}

	/**
	 * Actualiza el panel y sus componentes
	 * 
	 * @param nivelActual
	 */
	public void CambioDeLvl() {
		this.nivelTransicionLabel.setVisible(false);
		this.repaint(); 
	}

	/**
	 * actualiza el mapa al correspondiente nivel actual
	 * 
	 * @param nivel Nivel actual
	 */
	public void pantallaNivel(int nivel) {// 1, 2, .... , n		
		this.nivelTransicionLabel.setIcon(new ImageIcon(getClass().getResource(this.nivelesTransicion[nivel])));
		this.nivelTransicionLabel.setVisible(true);
		this.nivelTransicionLabel.repaint();
		this.nivelTransicionLabel.setBounds(this.getX(), (this.getY() + this.getHeight() - 165) / 2, this.getWidth(),
				165);
	}

}
