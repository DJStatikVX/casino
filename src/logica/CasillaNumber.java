// Paquete al que pertenece la clase
package logica;

/**
 * Clase CasillaNumber para las casillas de números y sus propiedades
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class CasillaNumber extends Casilla {
	
	private int numero;		// número que representa la casilla numérica
	
	private int columna;	// columna en la que se ubica la casilla
	private int docena;		// docena a la que pertenece la casilla
	private int mitad;		// mitad del tapete a la que pertenece la casilla
	private int color;		// color de la casilla, ya sea rojo o negro
	private int par;	    // si el número que representa es par o impar
	
	/**
	 * Constructor de casilla numérica a partir del número que representa
	 * @param numero número que representa la casilla, de tipo int
	 */
	public CasillaNumber(int numero) {
		setNumero(numero);
		inicializar();
	}
	
	/**
	 * Configura todas las propiedades de la casilla según el número,
	 * como si es par o no, la columna, el color, la mitad...
	 */
	private void inicializar() {
		
		// En el caso del 0, ninguno de los atributos se define
		if (getNumero() == 0) {
			setColumna(0);
			setDocena(0);
			setMitad(0);
			setColor(-1);
			setPar(-1);
			
		// Para cualquier otro caso numérico, se comprueba
		} else {
			
			// Si es par o no
			if (getNumero() % 2 == 0) {
				setPar(1);
			} else if (getNumero() % 2 != 0 ){
				setPar(0);
			} else {
				setPar(-1);
			}
			
			// Docena a la que pertenece
			if (getNumero() <= 12) {
				setDocena(1);
			} else if (getNumero() <= 24) {
				setDocena(2);
			} else if (getNumero() <= 36) {
				setDocena(3);
			}
			
			// Mitad a la que pertenece
			if (getNumero() <= 18) {
				setMitad(1);
			} else if (getNumero() <= 36) {
				setMitad(2);
			}
			
			// Columna a la que pertenece y color de la casilla
			calcularColumna();
			calcularColor();
		}
	}
	
	/**
	 * Calcula la columna a la que pertenece la casilla numérica
	 */
	private void calcularColumna() {
		int[] columna1 = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
		int[] columna2 = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
		int[] columna3 = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
		
		// Se busca por las columnas hasta encontrar un número que coincida
		for (int i = 0; i < columna1.length; i++) {
			if (columna1[i] == getNumero()) {
				setColumna(1);
			} else if (columna2[i] == getNumero()) {
				setColumna(2);
			} else if (columna3[i] == getNumero()) {
				setColumna(3);
			}
		}
	}
	
	/**
	 * Calcula el color de la casilla, ya sea rojo o negro
	 */
	private void calcularColor() {
		int[] rojas = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
		
		setColor(0);
		
		// Si encuentra el número en las rojas, es rojo; en otro caso, negro
		for (int i = 0; i < rojas.length; i++) {
			if (rojas[i] == getNumero()) {
				setColor(1);
				break;
			}
		}
	}
	
	/**
	 * Devuelve el número que representa la casilla
	 * @return Número que representa la casilla, de tipo int
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Establece el número que representa la casilla
	 * @param numero número que representa la casilla del 0 al 36, de tipo int
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Devuelve la columna de la casilla
	 * @return Columna de la casilla (1, 2, 3); 0 en otro caso, de tipo int 
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * Establece la columna de la casilla
	 * @param columna Columna de la casilla, de tipo int
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}

	/**
	 * Devuelve la docena de la casilla
	 * @return Docena de la casilla (1, 2, 3); 0 en otro caso, de tipo int 
	 */
	public int getDocena() {
		return docena;
	}

	/**
	 * Establece la docena de la casilla
	 * @param docena Docena de la casilla, de tipo int
	 */
	public void setDocena(int docena) {
		this.docena = docena;
	}

	/**
	 * Devuelve la mitad de la casilla
	 * @return Mitad de la casilla (1, 2); 0 en otro caso, de tipo int 
	 */
	public int getMitad() {
		return mitad;
	}

	/**
	 * Establece la mitad de la casilla
	 * @param mitad Docena de la casilla, de tipo int
	 */
	public void setMitad(int mitad) {
		this.mitad = mitad;
	}

	/**
	 * Devuelve el color de la casilla
	 * @return Color de la casilla, de tipo int 
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Establece el colorde la casilla
	 * @param color Color de la casilla, de tipo int
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Devuelve si el número es par o no
	 * @return 1 si el número es par, 0 si es impar, -1 en otro caso
	 */
	public int isPar() {
		return par;
	}

	/**
	 * Establece si el número es par o no
	 * @param par si el número es par o no, de tipo int
	 */
	public void setPar(int par) {
		this.par = par;
	}
	
}