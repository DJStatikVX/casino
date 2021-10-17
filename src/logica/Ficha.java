// Paquete al que pertenece la clase
package logica;

/**
 * Clase Ficha para la implementación de las fichas que se apuestan
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class Ficha {
	
	private int valor;	// valor de la ficha
	
	/**
	 * Constructor que instancia la ficha a partir de un valor pasado
	 * @param valor valor a establecer para la nueva ficha, de tipo int
	 */
	public Ficha(int valor) {
		setValor(valor);
	}
	
	/**
	 * Establece el valor pasado como parámetro en la ficha, si es válido
	 * @param valor valor a establecer en la ficha, de tipo int
	 * @throws IllegalStateException si valor es menor que 0
	 */
	private void setValor(int valor) {
		if (valor < 0) {
			throw new IllegalStateException(
					"La casilla no puede tener valor negativo.");
		}
		
		this.valor = valor;
	}
	
	/**
	 * Devuelve el valor de la ficha
	 * @return Valor de la ficha, de tipo int
	 */
	public int getValor() {
		return this.valor;
	}

}