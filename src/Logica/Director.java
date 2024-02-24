package Logica;

/**
 * clase que se encarga de dirigir al builderNivel, se encarga de ordenarle
 * cuantos infectados de cada tipo se debera construir para cada tanda de cada
 * nivel y cuantas tandas tiene un nivel
 *
 */
public class Director {

	private int infectadosPorNivel[][];
	// almacena cuantos infectados de cada tipo se deberan construir para cada tanda
	// del juego. Cada fila i de la matriz representa una tanda cada columna j
	// representa un tipo de infectado. entoces el numero en (i,j) representa la
	// cantidad de infectados de tipo j en la tanda i

	private int nivelActual;
	private int ultimoNivel;
	private BuilderNivel builder;

	private final int tandasPorNivel = 2;

	public Director() {
		nivelActual = 0;
		LectorArchivo l = new LectorArchivo();
		infectadosPorNivel = l.obtenerMatrizVehiculosRuta();
		builder = new BuilderDefault();
		ultimoNivel = (infectadosPorNivel.length / tandasPorNivel);
	}

	public Nivel construirSiguienteNivel() {
		int cantInfectados;
		for (int n = 0; n < tandasPorNivel; n++) {// recorre cada tanda del nivel a construir
			for (int j = 0; j < infectadosPorNivel[0].length; j++) {
				// recorre cada columna de la matriz, cada iteracion correspondera a un tipo de
				// infectado distinto
				cantInfectados = infectadosPorNivel[nivelActual * tandasPorNivel + n][j];
				for (int i = 0; i < cantInfectados; i++)
					builder.construirVehiculosRuta(j);
			}
			builder.siguienteTanda();
		}
		Nivel retorno = builder.getNivel();
		retorno.setValor(nivelActual++);
		return retorno;
	}

	public boolean finJuego() {
		return nivelActual == ultimoNivel;
	}
}
