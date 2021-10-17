// Paquete al que pertenece la clase
package logica;

// Importación de clases
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase Juego para implementar la determinación del número ganador
 * y la recompensa correspondiente al cliente en base a sus apuestas
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class Juego {
	
	private Casilla[] tablero = new Casilla[49];	// tablero del juego
	private Random r = new Random();				// generador de número
	
	/**
	 * Constructor del juego, que inicializa y configura
	 * las propiedades de las casillas
	 */
	public Juego() {
		setUp();
	}
	
	/**
	 * Configura el tablero de juego
	 */
	private void setUp() {
		
		// Configuración de casillas numéricas
		for (int i = 0; i < 37; i++) {
			tablero[i] = new CasillaNumber(i);
		}
		
		// Configuración de casillas especiales (3 fichas devueltas)
		for (int i = 37; i < 43; i++) {
			tablero[i] = new CasillaEspecial(3);
		}
		
		// Configuración de casillas especiales (2 fichas devueltas)
		for (int i = 43; i < 49; i++) {
			tablero[i] = new CasillaEspecial(2);
		}
	}
	
	/**
	 * Genera un número al azar entre el 0 y el 36, declarado como ganador
	 * @return Número ganador, generado entre el 0 y el 36
	 */
	public int calcularNumeroGanador() {
		return r.nextInt(37);
	}
	
	/**
	 * Recorre el tablero para conocer el valor total tras una jugada
	 * @param numero número ganador de la jugada, de tipo int
	 * @return Lista de fichas ganadas, de tipo List de Ficha
	 */
	public List<Ficha> calcularGanancias(int numero) {
		List<Ficha> fichasGanadas = new ArrayList<Ficha>();
		int apostado = getTablero()[numero].getValorFichaApostada();
		
		int totalGanado = 0;  // para calcular ganancias por propiedad
		int numeroFichas = 0; // para calcular fichas ganadas por propiedad
		
		// Si hay algo apostado, se calculan las fichas a ganar
		if (apostado != 0) {
			totalGanado = (apostado + 35 * apostado);
			numeroFichas = totalGanado / apostado;
			
			// A partir del valor ganado, calcula el número de fichas
			for (int i = 0; i < numeroFichas; i++) {
				fichasGanadas.add(new Ficha(apostado));
			}
		}
		
		CasillaNumber casillaGanadora = (CasillaNumber) getTablero()[numero];
		
		// Se comprueban las casillas de las columnas
		
		if (casillaGanadora.getColumna() > 0) {
			int valorColumnaAcertada;
			
			if (casillaGanadora.getColumna() == 1 && getTablero()[39].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[39]).getFichasDevueltas();
				valorColumnaAcertada = getTablero()[39].getValorFichaApostada();
			} else if (casillaGanadora.getColumna() == 2 && getTablero()[38].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[38]).getFichasDevueltas();
				valorColumnaAcertada = getTablero()[38].getValorFichaApostada();
			} else if (casillaGanadora.getColumna() == 3 && getTablero()[37].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[37]).getFichasDevueltas();
				valorColumnaAcertada = getTablero()[37].getValorFichaApostada();
			} else {
				totalGanado = 0;
				valorColumnaAcertada = 0;
			}
			
			if (totalGanado != 0) {			
				// A partir del valor ganado, calcula el número de fichas
				for (int i = 0; i < totalGanado; i++) {
					fichasGanadas.add(new Ficha(valorColumnaAcertada));
				}
			}
		
		// Caso excepcional del 0 para las columnas
		} else {		
			if (getTablero()[37].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(37));
			}
			
			if (getTablero()[38].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(38));
			}
			
			if (getTablero()[39].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(39));
			}
		}
		
		// Se comprueban las docenas apostadas
		if (casillaGanadora.getDocena() > 0) {
			int valorDocenaAcertada;
			
			if (casillaGanadora.getDocena() == 1 && getTablero()[40].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[40]).getFichasDevueltas();
				valorDocenaAcertada = getTablero()[40].getValorFichaApostada();
			} else if (casillaGanadora.getDocena() == 2 && getTablero()[41].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[41]).getFichasDevueltas();
				valorDocenaAcertada = getTablero()[41].getValorFichaApostada();
			} else if (casillaGanadora.getDocena() == 3 && getTablero()[42].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[42]).getFichasDevueltas();
				valorDocenaAcertada = getTablero()[42].getValorFichaApostada();
			} else {
				totalGanado = 0;
				valorDocenaAcertada = 0;
			}
			
			if (totalGanado != 0) {
				// A partir del valor ganado, calcula el número de fichas
				for (int i = 0; i < totalGanado; i++) {
					fichasGanadas.add(new Ficha(valorDocenaAcertada));
				}
			}
			
		// Caso excepcional del 0 para las docenas
		} else {
			if (getTablero()[40].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(40));
			}
			
			if (getTablero()[41].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(41));
			}
			
			if (getTablero()[42].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(42));
			}
		}
		
		// Se comprueban las mitades apostadas
		if (casillaGanadora.getMitad() > 0) {
			int valorMitadAcertada;
			
			if (casillaGanadora.getMitad() == 1 && getTablero()[43].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[43]).getFichasDevueltas();
				valorMitadAcertada = getTablero()[43].getValorFichaApostada();
			} else if (casillaGanadora.getMitad() == 2 && getTablero()[48].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[48]).getFichasDevueltas();
				valorMitadAcertada = getTablero()[48].getValorFichaApostada();
			} else {
				totalGanado = 0;
				valorMitadAcertada = 0;
			}
			
			if (totalGanado != 0) {				
				// A partir del valor ganado, calcula el número de fichas
				for (int i = 0; i < totalGanado; i++) {
					fichasGanadas.add(new Ficha(valorMitadAcertada));
				}
			}
			
		// Caso excepcional del 0 para las mitades
		} else {
			if (getTablero()[43].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(43));
			}
			
			if (getTablero()[48].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(48));
			}
		}
		
		// Se comprueba si hay Par o Impar apostado
		if (casillaGanadora.isPar() >= 0) {
			int valorParImparAcertada;
			
			if (casillaGanadora.isPar() == 1 && getTablero()[44].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[44]).getFichasDevueltas();
				valorParImparAcertada = getTablero()[44].getValorFichaApostada();
			} else if (casillaGanadora.isPar() == 0 && getTablero()[47].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[47]).getFichasDevueltas();
				valorParImparAcertada = getTablero()[47].getValorFichaApostada();
			} else {
				totalGanado = 0;
				valorParImparAcertada = 0;
			}
			
			if (totalGanado != 0) {				
				// A partir del valor ganado, calcula el número de fichas
				for (int i = 0; i < totalGanado; i++) {
					fichasGanadas.add(new Ficha(valorParImparAcertada));
				}
			}
			
		// Caso excepcional del 0 para Par/Impar
		} else {
			if (getTablero()[44].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(44));
			}
			
			if (getTablero()[47].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(47));
			}
		}
		
		// Se comprueba si hay Negro o Rojo apostados
		if (casillaGanadora.getColor() >= 0) {
			int valorColorAcertada;
			
			if (casillaGanadora.getColor() == 1 && getTablero()[46].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[46]).getFichasDevueltas();
				valorColorAcertada = getTablero()[46].getValorFichaApostada();
			} else if (casillaGanadora.getColor() == 0 && getTablero()[45].getValorFichaApostada() != 0) {
				totalGanado = ((CasillaEspecial) getTablero()[45]).getFichasDevueltas();
				valorColorAcertada = getTablero()[45].getValorFichaApostada();
			} else {
				totalGanado = 0;
				valorColorAcertada = 0;
			}
			
			if (totalGanado != 0) {
				numeroFichas = totalGanado;
				
				// A partir del valor ganado, calcula el número de fichas
				for (int i = 0; i < totalGanado; i++) {
					fichasGanadas.add(new Ficha(valorColorAcertada));
				}
			}
			
		// Caso excepcional del 0 para negro/rojo
		} else {
			if (getTablero()[45].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(45));
			}
			
			if (getTablero()[46].getValorFichaApostada() != 0) {
				fichasGanadas.addAll(calculaGananciasCasillaEspecial0(46));
			}
		}
		
		return fichasGanadas;
	}
	
	/**
	 * Calcula las ganancias de las casillas especiales para el caso del 0
	 * @param posicion posición de la casilla a especial a calcular, tipo int
	 * @return Lista de fichas ganadas para esa casilla especial con el 0
	 */
	private List<Ficha> calculaGananciasCasillaEspecial0(int posicion) {
		List<Ficha> fichasGanadas = new ArrayList<Ficha>(); 
		
		int apostado = getTablero()[posicion].getValorFichaApostada();
		fichasGanadas.add(new Ficha(apostado));
		
		if (apostado >= 10) {
			if (apostado != 50) {
				fichasGanadas.add(new Ficha(apostado / 2));
			} else {
				fichasGanadas.add(new Ficha(20));
				fichasGanadas.add(new Ficha(5));
			}
		}
		
		return fichasGanadas;
	}
	
	/**
	 * Devuelve si la casilla del tablero especificada no ha sido apostada
	 * @param posicion posición en el tablero de la casilla, de tipo int
	 * @return true si no hay fichas en la casilla; false en otro caso
	 */
	public boolean isCasillaVacia(int posicion) {
		return getTablero()[posicion].getValorFichaApostada() == 0;
	}
	
	/**
	 * Devuelve si el cliente ha ganado algo o no en su apuesta
	 * @param numeroGanador número que ha salido ganador, de tipo int
	 * @return true si el cliente ha ganado algo; false en otro caso
	 */
	public boolean haGanadoAlgo(int numeroGanador) {
		CasillaNumber casillaGanadora = (CasillaNumber) getTablero()[numeroGanador];
		
		if (numeroGanador != 0) {
		
			// Se comprueba si acertó el número
			if (getTablero()[numeroGanador].getValorFichaApostada() != 0) {
				return true;
			}

			// Se comprueba si acertó la columna
			if (casillaGanadora.getColumna() == 1 && getTablero()[39].getValorFichaApostada() != 0) {
				return true;
			} else if (casillaGanadora.getColumna() == 2 && getTablero()[38].getValorFichaApostada() != 0) {
				return true;
			} else if (casillaGanadora.getColumna() == 3 && getTablero()[37].getValorFichaApostada() != 0) {
				return true;
			}

			// Se comprueba si acertó la docena
			if (casillaGanadora.getDocena() == 1 && getTablero()[40].getValorFichaApostada() != 0) {
				return true;
			} else if (casillaGanadora.getDocena() == 2 && getTablero()[41].getValorFichaApostada() != 0) {
				return true;
			} else if (casillaGanadora.getDocena() == 3 && getTablero()[42].getValorFichaApostada() != 0) {
				return true;
			}

			// Se comprueba si acertó la mitad
			if (casillaGanadora.getMitad() == 1 && getTablero()[43].getValorFichaApostada() != 0) {
				return true;
			} else if (casillaGanadora.getMitad() == 2 && getTablero()[48].getValorFichaApostada() != 0) {
				return true;
			}

			// Se comprueba si acertó a Par/Impar
			if (casillaGanadora.isPar() == 1 && getTablero()[44].getValorFichaApostada() != 0) {
				return true;
			} else if (casillaGanadora.isPar() == 0 && getTablero()[47].getValorFichaApostada() != 0) {
				return true;
			}

			// Se comprueba si acertó al color
			if (casillaGanadora.getColor() == 1 && getTablero()[46].getValorFichaApostada() != 0) {
				return true;
			} else if (casillaGanadora.getColor() == 0 && getTablero()[45].getValorFichaApostada() != 0) {
				return true;
			}

			return false;
		
		// Si el número premiado ha sido el 0...
		} else {
			
			// Se comprueba si acertó el número
			if (getTablero()[numeroGanador].getValorFichaApostada() != 0) {
				return true;
			}
			
			// Se comprueba si gana algo de las columnas
			if (getTablero()[37].getValorFichaApostada() != 0
					|| getTablero()[38].getValorFichaApostada() != 0 
					|| getTablero()[39].getValorFichaApostada() != 0) {
				return true;
			}
			
			// Se comprueba si gana algo de las docenas
			if (getTablero()[40].getValorFichaApostada() != 0
					|| getTablero()[41].getValorFichaApostada() != 0 
					|| getTablero()[42].getValorFichaApostada() != 0) {
				return true;
			}
			
			// Se comprueba si gana algo de las mitades
			if (getTablero()[43].getValorFichaApostada() != 0 
					|| getTablero()[48].getValorFichaApostada() != 0) {
				return true;
			}
			
			// Se comprueba si gana algo del Par/Impar
			if (getTablero()[44].getValorFichaApostada() != 0 
					|| getTablero()[47].getValorFichaApostada() != 0) {
				return true;
			}
			
			// Se comprueba si gana algo del color
			if (getTablero()[45].getValorFichaApostada() != 0 
					|| getTablero()[46].getValorFichaApostada() != 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Cuenta las fichas ganadas de cada tipo en la lista de ganancias
	 * @param fichas lista de fichas ganadas, tipo List de Ficha
	 * @return Lista de contadores de fichas de cada tipo, de tipo int[]
	 */
	public int[] contarFichasGanadas(List<Ficha> fichas) {
		int[] contadores = new int[5];
				
		contadores[0] = contarFichas(fichas, 5);
		contadores[1] = contarFichas(fichas, 10);
		contadores[2] = contarFichas(fichas, 20);
		contadores[3] = contarFichas(fichas, 50);
		contadores[4] = contarFichas(fichas, 100);
		
		return contadores;
	}
	
	/**
	 * Cuenta las fichas de un tipo específico en la colección especificada
	 * @param fichas lista de fichas en la que se quiere contar, List de Ficha
	 * @param valor tipo de ficha que se quiere contar, de tipo int
	 */
	private int contarFichas(List<Ficha> fichas, int valor) {
		int count = 0;
		
		for (Ficha f : fichas) {
			if (f.getValor() == valor) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Devuelve las fichas que hay en el tablero
	 * @return Lista de fichas apostadas en el tablero, de tipo List de Ficha
	 */
	public List<Ficha> devolverFichas() {
		List<Ficha> fichas = new ArrayList<Ficha>();
		
		for (int i = 0; i < getTablero().length; i++) {
			if (getTablero()[i].getValorFichaApostada() != 0) {
				fichas.add(new Ficha(getTablero()[i].getValorFichaApostada()));
			}
		}
		
		return fichas;
	}
	
	/**
	 * Comprueba y devuelve si hay algo apostado en el tablero o no
	 * @return true si hay algo apostado, false si no
	 */
	public boolean hayApuesta() {
		for (int i = 0; i < getTablero().length; i++) {
			if (getTablero()[i].getValorFichaApostada() != 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Devuelve el tablero de juego con sus correspondientes casillas
	 * @return Tablero de juego, de tipo array de Casilla
	 */
	public Casilla[] getTablero() {
		return this.tablero;
	}

}