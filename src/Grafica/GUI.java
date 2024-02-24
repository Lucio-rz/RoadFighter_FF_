package Grafica;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Entidades.VallaDer;
import Entidades.VallaIzq;
import Logica.Juego;

import javax.swing.JLabel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

public class GUI extends JFrame {

	private Background panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel  showLevel;
	private JLabel[] estados;
	private JLabel fondoJuego;

	/**
	 * Crea el mapa de juego
	 * @param dificultad de juego 
	 * -> 0 si es normal
	 * -> 1 si es dificil
	 */
	public GUI() {

		this.setResizable(false);

		setIconImage(new ImageIcon(getClass().getResource("/Recursos/iconoJuego.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 650); 
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);

		panelJuego = new Background();
		panelJuego.setBounds(0, 0, 900, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);

		fondoJuego = new JLabel("New label");
		fondoJuego.setIcon(new ImageIcon(GUI.class.getResource("/RecursosNivel/fondoNivel1.png")));
		fondoJuego.setBounds(0, 0, 1050,601); 
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);

		panelJuego.repaint();
		
		
		JPanel sideBar = new JPanel();
		sideBar.setBounds(770, 0, 100, 601);
		contentPane.add(sideBar);
		sideBar.setLayout(null);
		sideBar.setBackground(Color.RED);//????????????? no muestra


		showLevel = new JLabel("");
		showLevel.setIcon(new ImageIcon(getClass().getResource("/RecursosNivel/nivel1.png")));
		showLevel.setBounds(0,0, 89, 46);
		showLevel.setOpaque(true);
		sideBar.add(showLevel); 
		

		this.setFocusable(true);

		setContentPane(contentPane);
		setLocationRelativeTo(null);

		juego = Juego.getJuego();
		juego.setGUI(this);
		//Vallas que cubren la ruta
		new VallaIzq();
		new VallaDer();

		this.addKeyListener(new OyenteTeclado(juego));

		hiloJuego = new Thread() {
			public void run() {
				juego.run();

			}
		};

		hiloJuego.start();


		this.repaint();
		panelJuego.repaint();

	}

	/**
	 * Redimensiona el ImageIcon grafico en base al JLabel label
	 * @param label
	 * @param grafico
	 */
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se gano el juego
	 */
	public void gano() {
		System.out.println("gano");

	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se perdio el juego
	 */
	public void perdio() {
		System.out.println("perdio");
	}

	/**
	 * retorna el mapa donde se muestra el juego 
	 * @return mapa de tipo Container
	 */
	public Container getMapa() {
		return panelJuego;
	}

	/**
	 * Muestra en el panel de juego la transicion del nivel. Esta transicion muestra el nivel actual
	 * A su vez que cambia el mapa al correspondiente del nivel actual
	 * @param nivel Nivel actual
	 */
	public void cambioNivel(int nivel) {
		this.reDimensionar(fondoJuego, new ImageIcon(GUI.class.getResource("/RecursosNivel/fondoNivel"+nivel+".png")));
		panelJuego.moveToBack(fondoJuego);
		panelJuego.pantallaNivel(nivel - 1);
		juego.pausa();
		panelJuego.CambioDeLvl();
		panelJuego.repaint();
	}



	/**
	 * actualiza el label que muestra la tanda y nivel actuales
	 * @param nivel
	 * @param tanda
	 */
	public void actualizarNivel(int nivel) {
		ImageIcon im = new ImageIcon(
				getClass().getResource("/RecursosNivel/nivel" + nivel +".png"));
		this.showLevel.setIcon(im);
	}



	/**
	 * Activa el sonido de disparo
	 */


	public void escribirEntradaEnArchivo(int posicion, String nombre, int record) {
		String formatoEntrada = String.format("%d \"%s\" %d", posicion, nombre, record);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Datos/Ranking.txt", true))) {
			// Escribe la entrada en el archivo
			writer.write(formatoEntrada);
			writer.newLine();  // Agrega una nueva línea para la siguiente entrada
			System.out.println("Entrada escrita en el archivo correctamente.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error al escribir la entrada en el archivo.");
		}
	}

	public void frameVentanaClosed() {
		this.getContentPane().requestFocus();
	}

}