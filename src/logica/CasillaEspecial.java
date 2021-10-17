// Paquete al que pertenece la clase
package logica;

/**
 * Clase CasillaEspecial para casillas no num�ricas
 * @author Samuel Rodr�guez Ares (UO271612)
 */
public class CasillaEspecial extends Casilla {
	
	private int fichasDevueltas;	// n�mero de fichas a devolver
	
	/**
	 * Constructor que recibe como par�metro las fichas a devolver
	 * @param fichasDevueltas fichas a devolver, de tipo int
	 */
	public CasillaEspecial(int fichasDevueltas) {
		setFichasDevueltas(fichasDevueltas);
	}

	/**
	 * Devuelve el n�mero de fichas a devolver
	 * @return N�mero de fichas a devolver, de tipo int
	 */
	public int getFichasDevueltas() {
		return fichasDevueltas;
	}

	/**
	 * Establece el n�mero de fichas a devolver
	 * @param fichasDevueltas n�mero de fichas a devolver, de tipo int
	 */
	public void setFichasDevueltas(int fichasDevueltas) {
		this.fichasDevueltas = fichasDevueltas;
	}

}