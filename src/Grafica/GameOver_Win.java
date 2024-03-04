package Grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Logica.Ranking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GameOver_Win extends JFrame {

	private JPanel contentPane;
	protected JTextField miBox;
	private int pantalla;
	protected String nombre;
	Ranking ranking;

	/**
	 * Create the frame.
	 * @param puntaje 
	 */
	public GameOver_Win( int p, int puntaje ) { // 1-win, 0-lose

		this.pantalla = p;
		setIconImage(new ImageIcon(getClass().getResource("/Recursos/iconoJuego.png")).getImage());

		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		//////////////////////////////////////////Boton reintentar
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
		tryAgain.setIcon(new ImageIcon(GameOver_Win.class.getResource("/Recursos/tryAgain"+pantalla+".png")));
		tryAgain.setBounds(459, 527, 198, 49);
		contentPane.add(tryAgain);

		/////////////////////////////////////////////Boton salir
		JButton salir = new JButton("");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.setBorder(new LineBorder(Color.BLACK));
		salir.setIcon(new ImageIcon(GameOver_Win.class.getResource("/Recursos/salir"+pantalla+".png")));
		salir.setBounds(669, 527, 184, 49);
		contentPane.add(salir);

		/////////////////////////////////////////////Boton ranking
		JButton rank = new JButton("");
		rank.setEnabled(false);
		rank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRanking vr = new VentanaRanking(GameOver_Win.this);
				vr.setVisible(true);
			}
		});
		rank.setBackground(Color.BLACK);
		rank.setBorder(new LineBorder(Color.BLACK));
		rank.setIcon(new ImageIcon(GameOver_Win.class.getResource("/Recursos/ranking.png")));
		rank.setBounds(100, 527, 198, 49);
		contentPane.add(rank);

		////////////////////////////////////////////ingresar nombre de jugador, habilita boton ranking y lo inicializa

		miBox = new JTextField(20);
		miBox.setEditable(true);
		miBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {;
			ranking = new Ranking("src/Archivos/Ranking.txt");
			ranking.addPlayer(miBox.getText(), puntaje);
			rank.setEnabled(true);
			}
		});

		JLabel nameLabel = new JLabel("Ingrese su nombre");
		nameLabel.setBounds(745, 325, 150, 50);
		miBox.setBounds(750,375, 100, 20);
		contentPane.add(nameLabel);
		contentPane.add(miBox);

		///////////////////////////////////////////////////////////////////////////////////////Game over imagen 
		JLabel gameOver = new JLabel("");
		gameOver.setIcon(new ImageIcon(GameOver_Win.class.getResource("/Recursos/pantalla"+pantalla+".gif")));
		gameOver.setOpaque(false);
		gameOver.setBounds(0, 0, 921, 643);
		contentPane.add(gameOver);

	}
}
