// Paquete al que pertenece la clase
package logica;

/**
 * Clase Casilla para implementar cada casilla del tablero
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class Casilla {
	
	private int valorFichaApostada = 0;
	
	/**
	 * Devuelve el valor de la ficha que haya apostada, si la hay
	 * @return Valor de la ficha apostada sobre la casilla si la hay; 0 si no
	 */
	public int getValorFichaApostada() {
		return this.valorFichaApostada;
	}
	
	/**
	 * Establece el valor de la ficha apostada en la casilla
	 * @param valor valor que se apuesta en la casilla, de tipo int
	 */
	public void setValorFichaApostada(int valor) {
		this.valorFichaApostada = valor;
	}

}