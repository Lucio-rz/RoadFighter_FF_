package Grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GameOver_Win extends JFrame {

	private JPanel contentPane;
	private int pantalla;
	
	/**
	 * Create the frame.
	 */
	public GameOver_Win( int p ) {// si es 1 entonces gano, 0 caso contrario :)
		
		this.pantalla = p;
		
		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.png")).getImage());
		
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		setAlwaysOnTop(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		

		JButton tryAgain = new JButton("");
		tryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		tryAgain.setBackground(Color.BLACK);
		tryAgain.setBorder(new LineBorder(Color.BLACK));
		tryAgain.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/tryAgain"+pantalla+".png")));
		tryAgain.setBounds(459, 527, 198, 49);
		contentPane.add(tryAgain);
		
		JButton salir = new JButton("");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.setBorder(new LineBorder(Color.BLACK));
		salir.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/salir"+pantalla+".png")));
		salir.setBounds(669, 527, 184, 49);
		contentPane.add(salir);
		
		JLabel gameOver = new JLabel("");
		gameOver.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/pantalla"+pantalla+".gif")));
		gameOver.setOpaque(false);
		gameOver.setBounds(0, 0, 921, 643);
		contentPane.add(gameOver);
		
	}
}
