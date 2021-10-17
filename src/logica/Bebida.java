// Paquete al que pertenece la clase
package logica;

/**
 * Clase que implementa las bebidas ofrecidas
 * @author Samuel Rodr�guez Ares (UO271612)
 */
public class Bebida {
	
	private String codigo;			// c�digo de la bebida
	private String denominacion;	// denominaci�n de la bebida
	private int tipo;				// tipo de bebida seg�n cantidad de alcohol
	private double precio;			// precio de la bebida
	private int unidades;			// unidades de la bebida
	
	/**
	 * Constante para el tipo de las bebidas alcoh�licas
	 */
	public final static int ALCOHOLICA = 0;
	
	/**
	 * Constante para el tipo de las bebidas no alcoh�licas
	 */
	public final static int NO_ALCOHOLICA = 1;
	
	/**
	 * Constructor que recibe como par�metros los atributos a establecer
	 * @param codigo c�digo de la bebida a instanciar, de tipo String
	 * @param denominacion denominaci�n de la bebida a instanciar, de tipo String
	 * @param tipo tipo de la bebida a instanciar, de tipo int
	 * @param precio precio de la bebida a instanciar, de tipo double
	 */
	public Bebida(String codigo, String denominacion, int tipo, double precio) {
		setCodigo(codigo);
		setDenominacion(denominacion);
		setTipo(tipo);
		setPrecio(precio);
	}
	
	/**
	 * Constructor que recibe como par�metro otra bebida
	 * para instanciarse a partir de los valores de sus atributos
	 * @param drink bebida a partir de la que se instancia, de tipo Bebida
	 */
	public Bebida(Bebida drink) {
		setCodigo(drink.getCodigo());
		setDenominacion(drink.getDenominacion());
		setTipo(drink.getTipo());
		setPrecio(drink.getPrecio());
	}
	
	/**
	 * Establece o modifica el c�digo de la bebida
	 * @param codigo c�digo a establecer para la bebida, de tipo String
	 */
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Devuelve el c�digo de la bebida
	 * @return C�digo de la bebida, de tipo String
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Establece o modifica la denominaci�n de la bebida
	 * @param denominacion denominaci�n a establecer para la bebida, de tipo String
	 */
	private void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	/**
	 * Devuelve la denominaci�n de la bebida
	 * @return Denominaci�n de la bebida, de tipo String
	 */
	public String getDenominacion() {
		return this.denominacion;
	}
	
	/**
	 * Establece o modifica el tipo de la bebida
	 * @param tipo tipo a establecer para la bebida, de tipo int
	 * @throws IllegalStateException si el tipo no es 0 � 1
	 */
	private void setTipo(int tipo) {
		checkTipo(tipo);
		this.tipo = tipo;
	}
	
	/**
	 * Devuelve el tipo de la bebida expresado como 0 � 1
	 * @return Tipo de la bebida (0 alcoh�lica, 1 no alcoh�lica), de tipo int
	 */
	public int getTipo() {
		return this.tipo;
	}
	
	/**
	 * Comprueba que el tipo de bebida pasado como par�metro sea v�lido
	 * @param tipo tipo de bebida a comprobar, de tipo int
	 * @throws IllegalStateException si el tipo no es 0 � 1
	 */
	private void checkTipo(int tipo) {
		if (tipo != NO_ALCOHOLICA && tipo != ALCOHOLICA) {
			throw new IllegalStateException(
					"Error: No se pudo instanciar la bebida "
					+ "porque su tipo es inv�lido.");
		}
	}
	
	/**
	 * Establece o modifica el precio de la bebida
	 * @param precio precio a establecer para la bebida, de tipo double
	 * @throws IllegalStateException si el precio pasado como par�metro es negativo
	 */
	private void setPrecio(double precio) {
		checkPrecio(precio);
		this.precio = precio;
	}
	
	/**
	 * Devuelve el precio de la bebida
	 * @return Precio de la bebida, de tipo double
	 */
	public double getPrecio() {
		return this.precio;
	}
	
	/**
	 * Comprueba que el precio de bebida pasado como par�metro no sea negativo
	 * @param precio precio de bebida a comprobar, de tipo double
	 * @throws IllegalStateException si el precio pasado como par�metro es negativo
	 */
	private void checkPrecio(double precio) {
		if (precio < 0.00) {
			throw new IllegalStateException(
					"Error: No se pudo instanciar la bebida " 
					+ "porque su precio es inv�lido.");
		}
	}
	
	/**
	 * Establece el n�mero de unidades de la bebida, si el valor pasado es v�lido
	 * @param unidades n�mero de unidades a establecer, de tipo int
	 * @throws IllegalStateException si el n�mero de unidades es menor o igual a 0
	 */
	protected void setUnidades(int unidades) {
		checkUnidades(unidades);
		this.unidades = unidades;
	}
	
	/**
	 * Devuelve el n�mero de unidades de la bebida
	 * @return N�mero de unidades de la bebida, de tipo int
	 */
	protected int getUnidades() {
		return this.unidades;
	}
	
	/**
	 * Comprueba si el n�mero de unidades pasado como par�metro es v�lido
	 * @param unidades n�mero de unidades a comprobar, de tipo int
	 * @throws IllegalStateException si unidades es menor o igual a 0
	 */
	private void checkUnidades(int unidades) {
		if (unidades < 0) {
			throw new IllegalStateException(
					"Error: No se pudo instanciar la bebida "
					+ "porque el n�mero de unidades es ilegal.");
		}
	}
	
	/**
	 * Devuelve una cadena con informaci�n �til sobre la bebida
	 * @return Cadena del formato: denominacion - precio, de tipo String
	 */
	@Override
	public String toString() {
		return getDenominacion() + " - " + getPrecio() + "�";
	}

}