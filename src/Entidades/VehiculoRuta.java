package Entidades;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Entidades_Graficas.EntidadGrafica;
import Entidades_Graficas.Label_car;
import Entidades_Graficas.Label_jugador;
import Logica.GeneradorDePremio;
import Movilidad.EstrategiaMovimiento;
import Movilidad.Horizontal;
import Movilidad.Vertical;
import Movilidad.Vertical_loop;
import Movilidad.Vertical_remove;
import Visitors.Visitor;
import Visitors.VisitorVehiculoRuta;

//vehiculos que transitan por la ruta
public abstract class VehiculoRuta extends Entidad {
	private int tiempoEspera;
	private boolean quieto;
	private boolean explotado;
	private boolean tienePowerUp;
	private Random random;
	private EstrategiaMovimiento movimientoAux;
	private boolean impactoSupDer;
	private boolean impactoSupIzq;
	private boolean despIzquierda;
	private boolean despDerecha;
	private boolean cambiarCarril;
	private int destinoImp ;
	private int destinoCambio ;
	/**
	 * Crea un Vehiculo de Ruta
	 * 
	 * @param entidad_graf entidad grafica de la entidad
	 * @param duracion     tiempo que permanecer� quieto el vehiculo, en
	 *                     milisegundos desde que empieza su tanda
	 * @param enEspera     parametro necesario para saber si el vehiculo que se
	 *                     crea pertenece a la primer tanda(en ese caso no estara en
	 *                     espera) o y si deberia quedarse quieto hasta que se
	 *                     notifique(cuando se llegue a su tanda)
	 */
	public VehiculoRuta(EntidadGrafica entidad_graf, int duracion, boolean enEspera) {
		super(entidad_graf);
		velocidad = 1;
		movimiento = null;// en principio no se moveran hasta que se indique que aparezca por pantalla
		movimientoAux = null;
		random = new Random();
		quieto = false;
		explotado = false;
		tienePowerUp = true;//random.nextInt(2) == 1; //50%
		impactoSupDer = false;
		impactoSupIzq = false;
		despIzquierda = false;
		despDerecha = false;
		cambiarCarril = true;
		destinoImp = 0;
		destinoCambio = 0;
		tiempoEspera = duracion;
		if (!enEspera)
			aparecer();
		visitor = new VisitorVehiculoRuta(this);
	}

	/**
	 * cuando se llama a este m�todo empieza a contar el tiempo de espera del
	 * infectado para luego aparecer en pantalla
	 */
	public void aparecer() {
		VehiculoRuta car = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new Vertical_remove(car, Vertical.ABAJO,620);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			}; 
		};

		timer.schedule(timer_task, tiempoEspera, 1);

	}


	public void eliminar() {
		juego.eliminarVehiculoRuta(this);
	}
	
	public void accionar() {
		if (!quieto) {
			if (movimiento != null)
				movimiento.mover();
			if (impactoSupIzq) {
				if(!finDeImpactoSupIzq()){ // analiza si se termino el recorrido del impacto
					this.movimiento.setDireccion(Vertical.ARRIBA);
					movimientoAux = new Horizontal(this, Horizontal.IZQUIERDA,0);
					this.movimiento.mover();
					this.movimientoAux.mover();
				}
			}
			if (impactoSupDer) {
				if(!finDeImpactoSupDer()) { // analiza si se termino el recorrido del impacto
					this.movimiento.setDireccion(Vertical.ARRIBA);
					movimientoAux = new Horizontal(this, Horizontal.DERECHA,0);
					this.movimiento.mover();
					this.movimientoAux.mover();
				}
			}
			if (despIzquierda) {
				if(!finDesplazamientoIzq()) { // analiza si se termino el recorrido del cambio carril
					velocidad = 4;
					movimientoAux = new Horizontal(this, Horizontal.IZQUIERDA,0);
					this.movimientoAux.mover();
				}
			}
			if (despDerecha) {
				if(!finDesplazamientoDer()) { // analiza si se termino el recorrido del cambio carril
					velocidad = 4;
					movimientoAux = new Horizontal(this, Horizontal.DERECHA,0);
					this.movimientoAux.mover();
				}
			}
		}
	}

	public void setImpactoSupIzq(boolean b,int r) {
		impactoSupIzq = b;
		destinoImp = r;
	}

	public void setImpactoSupDer(boolean b, int r) {
		impactoSupDer= b;
		destinoImp = r;
	}	

	public boolean finDeImpactoSupIzq() {
		boolean finImpacto = (getGrafico().getX() <= destinoImp);//vale igual analizar x o y
		if (finImpacto) {
			arranque();
		}
		return finImpacto;
	}

	public boolean finDeImpactoSupDer() {
		boolean finImpacto = (getGrafico().getX() >= destinoImp);
		if (finImpacto) {
			arranque();
		}
		return finImpacto;
	}

	public boolean finDesplazamientoIzq() {
		boolean finDesp = (getGrafico().getX() <= destinoCambio);
		if (finDesp) {
			movimientoAux = null;
			despIzquierda = false;
		}
		return finDesp;
	}
	
	public boolean finDesplazamientoDer() {
		boolean finDesp = (getGrafico().getX() >= destinoCambio);
		if (finDesp) {
			movimientoAux = null;
			despDerecha = false;
		}
		return finDesp;
	}

	public void setVelocidad(int vel) {
		velocidad = vel +1;
	}

	private void arranque() {
		detenerImpacto();
		this.movimiento.setDireccion(Vertical.ABAJO);
		setVelocidad(0);
	}

	private void detenerImpacto() {
		impactoSupIzq = false;
		impactoSupDer = false;
	}

	public void explotar() {
		explotado = true;
		detenerImpacto();
		if (tienePowerUp) 
			GeneradorDePremio.generar(entidad_graf.getLocation());
		arranque();
		Label_car lbl = (Label_car) this.getGrafico();
		lbl.explosion();
	}

	public void desplazarIzquierda(boolean b,int r) {
		despIzquierda = b;
		destinoCambio = r;
	}

	public void desplazarDerecha(boolean b,int r) {
		despDerecha = b;
		destinoCambio = r;
	}
	
	public void setCambiarCarril(boolean b) {
		cambiarCarril = b;
	}
	
	public boolean getCambiarCarril() {
		return cambiarCarril;
	}
	
	
	public Rectangle getRectangle() {
		if (!explotado)
		return getGrafico().getBounds();
		else
			return new Rectangle(getGrafico().getX(),getGrafico().getY(),0,0);
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}


}
