package Grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Ranking;

@SuppressWarnings("serial")
public class VentanaRanking extends JFrame{
	private JFrame padre;
	private Background panelJuego;
	private JLabel[] estados;
	private JLabel fondoJuego;


	public VentanaRanking(JFrame parent) {
		padre = parent;
		this.setResizable(false);

		setIconImage(new ImageIcon(getClass().getResource("/Recursos/iconoJuego.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 700);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);

		panelJuego = new Background();
		panelJuego.setBounds(0, 60, 933, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);

		fondoJuego = new JLabel("New label");
		fondoJuego.setIcon(new ImageIcon(GUI.class.getResource("/Recursos/rankingFondo.png")));
		fondoJuego.setBounds(1, 0, 933,601);
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);


		JPanel labelsPanel = new JPanel(new GridBagLayout());
		labelsPanel.setOpaque(false); // Make the panel transparent

		// Add headers
		JLabel headerPosicion = new JLabel("Posicion");
		JLabel headerJugador = new JLabel("Jugador");
		JLabel headerPuntaje = new JLabel("Puntaje");

		Font headerFont = new Font(headerPosicion.getFont().getName(), Font.BOLD, 20);
		headerPosicion.setFont(headerFont);
		headerJugador.setFont(headerFont);
		headerPuntaje.setFont(headerFont);

		headerPosicion.setForeground(Color.WHITE);
		headerJugador.setForeground(Color.WHITE);
		headerPuntaje.setForeground(Color.WHITE);

		// Add headers to the panel
		GridBagConstraints gbcHeaders = new GridBagConstraints();
		gbcHeaders.gridx = 0;
		gbcHeaders.gridy = 0;
		gbcHeaders.anchor = GridBagConstraints.CENTER;
		gbcHeaders.insets = new Insets(10, 20, 10, 20); // Adjust spacing as needed

		labelsPanel.add(headerPosicion, gbcHeaders);

		gbcHeaders.gridx = 1;
		labelsPanel.add(headerJugador, gbcHeaders);

		gbcHeaders.gridx = 2;
		labelsPanel.add(headerPuntaje, gbcHeaders);

		Ranking rangos_actuales = new Ranking("src/Archivos/Ranking.txt");

		for (int i = 0; i < 5; i++) {
		    int j = i + 1;

		    JLabel pos = new JLabel(Integer.toString(j));
		    pos.setFont(new Font(pos.getFont().getName(), Font.PLAIN, 20));
		    pos.setForeground(Color.WHITE);
		    pos.setHorizontalAlignment(JLabel.CENTER);
		    pos.setVerticalAlignment(JLabel.CENTER);

		    // Create JLabel for player rank
		    String nombreJugador = " " + rangos_actuales.nombreJugador(i);
		    JLabel label = new JLabel(nombreJugador);
		    label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		    label.setForeground(Color.WHITE);
		    label.setHorizontalAlignment(JLabel.CENTER);
		    label.setVerticalAlignment(JLabel.CENTER);

		    String puntajeJugador = " " + rangos_actuales.puntajeJugador(i);
		    JLabel puntaje = new JLabel(puntajeJugador);
		    puntaje.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		    puntaje.setForeground(Color.WHITE);
		    puntaje.setHorizontalAlignment(JLabel.CENTER);
		    puntaje.setVerticalAlignment(JLabel.CENTER);

		    // Add labels to the panel
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridx = 0;
		    gbc.gridy = i + 1; // Start from row 1 for player data
		    gbc.anchor = GridBagConstraints.CENTER;
		    gbc.insets = new Insets(10, 20, 10, 20); // Adjust spacing as needed

		    labelsPanel.add(pos, gbc);

		    gbc.gridx = 1;
		    labelsPanel.add(label, gbc);

		    gbc.gridx = 2;
		    labelsPanel.add(puntaje, gbc);
		}

		// Center the labelsPanel within panelJuego
		int x = (panelJuego.getWidth() - labelsPanel.getPreferredSize().width) / 2;
		int y = (panelJuego.getHeight() - labelsPanel.getPreferredSize().height) / 2;

		labelsPanel.setBounds(x, y, labelsPanel.getPreferredSize().width, labelsPanel.getPreferredSize().height);

		panelJuego.add(labelsPanel);
		panelJuego.moveToFront(labelsPanel);
		panelJuego.repaint();
		
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		barraSuperior.setBackground(Color.BLACK);

		JPanel panelVolver = new JPanel();

		panelVolver.setBounds(700, 0, 120, 70);
		panelVolver.setBackground(Color.BLACK);
		panelVolver.setLayout(new GridLayout(1, 1));
		panelVolver.setVisible(true);
		estados = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			estados[i] = new JLabel();
			estados[i].setSize(70, 70); 
			//			panelMejoras.add(estados[i]);
			//			estados[i].setEnabled(true);

		}

		JButton volver = new JButton();
		volver.setSize(115,60);
		panelVolver.add(volver);
		volver.setEnabled(true);
		volver.setIcon(new ImageIcon(getClass().getResource("/Recursos/exit.png")));//back.png
		volver.setBackground(Color.BLACK);
		volver.setBorder(new EmptyBorder(0, 0, 0, 0)); // Set an EmptyBorder with zero thickness
		reDimensionar(volver, (ImageIcon) volver.getIcon());

		volver.addActionListener(new ActionListener() {//anula oyente teclado
			public void actionPerformed(ActionEvent e) {
				dispose();
			}        
		});

		barraSuperior.add(panelVolver);

		this.setFocusable(true);

		setContentPane(contentPane);
		setLocationRelativeTo(null);
	}

	public void dispose() {
		super.dispose();
	}
	


	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	private void reDimensionar(JButton boton, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(boton.getWidth(), boton.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			boton.setIcon(grafico);
			boton.repaint();
		}
	}
	
}