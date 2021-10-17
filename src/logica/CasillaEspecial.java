// Paquete al que pertenece la clase
package logica;

/**
 * Clase CasillaEspecial para casillas no numéricas
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class CasillaEspecial extends Casilla {
	
	private int fichasDevueltas;	// número de fichas a devolver
	
	/**
	 * Constructor que recibe como parámetro las fichas a devolver
	 * @param fichasDevueltas fichas a devolver, de tipo int
	 */
	public CasillaEspecial(int fichasDevueltas) {
		setFichasDevueltas(fichasDevueltas);
	}

	/**
	 * Devuelve el número de fichas a devolver
	 * @return Número de fichas a devolver, de tipo int
	 */
	public int getFichasDevueltas() {
		return fichasDevueltas;
	}

	/**
	 * Establece el número de fichas a devolver
	 * @param fichasDevueltas número de fichas a devolver, de tipo int
	 */
	public void setFichasDevueltas(int fichasDevueltas) {
		this.fichasDevueltas = fichasDevueltas;
	}

}