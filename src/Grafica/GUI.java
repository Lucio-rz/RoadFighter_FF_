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
	private JLabel cargaViral, cargaViralMaxima, nivelTanda;
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
		setBounds(100, 100, 900, 650); 
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		panelJuego = new Background();
		panelJuego.setBounds(0, 0, 1050, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);
		
		fondoJuego = new JLabel("New label");
		fondoJuego.setIcon(new ImageIcon(GUI.class.getResource("/Recursos/fondoNivel1.png")));
		fondoJuego.setBounds(0, 0, 1050,601); 
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);
		
		panelJuego.repaint();
		JPanel sideBar = new JPanel();
		sideBar.setBounds(600, 0, 60, 700);
		contentPane.add(sideBar);
		sideBar.setLayout(null);
		sideBar.setBackground(Color.BLACK);

		//sideBar.add(); datos del juego
		
		
	
		
		

		//sideBar.add(); imagen del nivel

		this.setFocusable(true);

		setContentPane(contentPane);
		setLocationRelativeTo(null);

		juego = Juego.getJuego();
		juego.setGUI(this);

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
		this.reDimensionar(fondoJuego, new ImageIcon(GUI.class.getResource("/RecursosGraficosNiveles/FONDO-LVL0"+nivel+".png")));
		panelJuego.moveToBack(fondoJuego);
		panelJuego.pantallaNivel(nivel - 1);
		juego.pausa();
		panelJuego.CambioDeLvl();
		panelJuego.repaint();
	}

	/**
	 * Actualiza la barra de estados de los premios 
	 * @param infeccion
	 */
	public void actualizarBarraViral(int infeccion) {
		cargaViral.setSize((cargaViralMaxima.getWidth() / 100) * infeccion, cargaViral.getHeight());
		this.repaint();
	}

	/**
	 * actualiza el label que muestra la tanda y nivel actuales
	 * @param nivel
	 * @param tanda
	 */
	public void actualizarNivelTanda(int nivel, int tanda) {
		ImageIcon im = new ImageIcon(
		getClass().getResource("/RecursosGraficos_Extras/NivelTanda/nivel" + nivel + "tanda" + tanda + ".png"));
		this.nivelTanda.setIcon(im);
	}

	/**
	 * actualiza la barra que muestra los estados de los premios.
	 * Si un premio esta activo entonces se mostrar� con su label activo
	 * en caso contrario se mostrara con su label desactivado
	 * @param mejoras estado de cada premios
	 */
	public void actualizarPowerUps(boolean[] mejoras) {
		for (int i = 0; i < estados.length; i++) {
			estados[i].setEnabled(mejoras[i]);
		}
	}

	/**
	 * Activa el sonido de disparo
	 */
	public void sonidoDisparar() {
		try {
			
			Clip disparo = AudioSystem.getClip();
			disparo.open(AudioSystem
					.getAudioInputStream(getClass().getResource("/RercursosWAV/disparo_normal.wav")));
			disparo.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}

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