package Grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;

	//Primer ejecucion:

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// hilo de despacho de eventos (EDT),
			// este hilo es responsable de manejar las operaciones de la GUI.
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				}
			}
		});
	}

	//Constructor
	public MainMenu() {

		setIconImage(new ImageIcon(getClass().getResource("/Recursos/iconoJuego.png")).getImage()); //icono pequeño
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);//JFrame posicionada al centro de pantalla

		JButton startButton = new JButton("");
		startButton.setBorder(new LineBorder(Color.BLACK));
		startButton.setBackground(new Color(0, 255, 0));
		startButton.setIcon(new ImageIcon(MainMenu.class.getResource("/Recursos/startButton.png")));
		startButton.setOpaque(true);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Boton start detectado");
				GUI frame = new GUI();
				frame.setVisible(true);
				frame.setResizable(false);
				dispose();
			}
		});
		startButton.setBounds(450, 220, 138, 38);
		contentPane.add(startButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/Recursos/menuBackground.png")));
		lblNewLabel.setBounds(0, 0, 1022, 571);
		contentPane.add(lblNewLabel);

	}

}

