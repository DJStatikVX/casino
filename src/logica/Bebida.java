// Paquete al que pertenece la clase
package logica;

/**
 * Clase que implementa las bebidas ofrecidas
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class Bebida {
	
	private String codigo;			// código de la bebida
	private String denominacion;	// denominación de la bebida
	private int tipo;				// tipo de bebida según cantidad de alcohol
	private double precio;			// precio de la bebida
	private int unidades;			// unidades de la bebida
	
	/**
	 * Constante para el tipo de las bebidas alcohólicas
	 */
	public final static int ALCOHOLICA = 0;
	
	/**
	 * Constante para el tipo de las bebidas no alcohólicas
	 */
	public final static int NO_ALCOHOLICA = 1;
	
	/**
	 * Constructor que recibe como parámetros los atributos a establecer
	 * @param codigo código de la bebida a instanciar, de tipo String
	 * @param denominacion denominación de la bebida a instanciar, de tipo String
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
	 * Constructor que recibe como parámetro otra bebida
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
	 * Establece o modifica el código de la bebida
	 * @param codigo código a establecer para la bebida, de tipo String
	 */
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Devuelve el código de la bebida
	 * @return Código de la bebida, de tipo String
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Establece o modifica la denominación de la bebida
	 * @param denominacion denominación a establecer para la bebida, de tipo String
	 */
	private void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	/**
	 * Devuelve la denominación de la bebida
	 * @return Denominación de la bebida, de tipo String
	 */
	public String getDenominacion() {
		return this.denominacion;
	}
	
	/**
	 * Establece o modifica el tipo de la bebida
	 * @param tipo tipo a establecer para la bebida, de tipo int
	 * @throws IllegalStateException si el tipo no es 0 ó 1
	 */
	private void setTipo(int tipo) {
		checkTipo(tipo);
		this.tipo = tipo;
	}
	
	/**
	 * Devuelve el tipo de la bebida expresado como 0 ó 1
	 * @return Tipo de la bebida (0 alcohólica, 1 no alcohólica), de tipo int
	 */
	public int getTipo() {
		return this.tipo;
	}
	
	/**
	 * Comprueba que el tipo de bebida pasado como parámetro sea válido
	 * @param tipo tipo de bebida a comprobar, de tipo int
	 * @throws IllegalStateException si el tipo no es 0 ó 1
	 */
	private void checkTipo(int tipo) {
		if (tipo != NO_ALCOHOLICA && tipo != ALCOHOLICA) {
			throw new IllegalStateException(
					"Error: No se pudo instanciar la bebida "
					+ "porque su tipo es inválido.");
		}
	}
	
	/**
	 * Establece o modifica el precio de la bebida
	 * @param precio precio a establecer para la bebida, de tipo double
	 * @throws IllegalStateException si el precio pasado como parámetro es negativo
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
	 * Comprueba que el precio de bebida pasado como parámetro no sea negativo
	 * @param precio precio de bebida a comprobar, de tipo double
	 * @throws IllegalStateException si el precio pasado como parámetro es negativo
	 */
	private void checkPrecio(double precio) {
		if (precio < 0.00) {
			throw new IllegalStateException(
					"Error: No se pudo instanciar la bebida " 
					+ "porque su precio es inválido.");
		}
	}
	
	/**
	 * Establece el número de unidades de la bebida, si el valor pasado es válido
	 * @param unidades número de unidades a establecer, de tipo int
	 * @throws IllegalStateException si el número de unidades es menor o igual a 0
	 */
	protected void setUnidades(int unidades) {
		checkUnidades(unidades);
		this.unidades = unidades;
	}
	
	/**
	 * Devuelve el número de unidades de la bebida
	 * @return Número de unidades de la bebida, de tipo int
	 */
	protected int getUnidades() {
		return this.unidades;
	}
	
	/**
	 * Comprueba si el número de unidades pasado como parámetro es válido
	 * @param unidades número de unidades a comprobar, de tipo int
	 * @throws IllegalStateException si unidades es menor o igual a 0
	 */
	private void checkUnidades(int unidades) {
		if (unidades < 0) {
			throw new IllegalStateException(
					"Error: No se pudo instanciar la bebida "
					+ "porque el número de unidades es ilegal.");
		}
	}
	
	/**
	 * Devuelve una cadena con información útil sobre la bebida
	 * @return Cadena del formato: denominacion - precio, de tipo String
	 */
	@Override
	public String toString() {
		return getDenominacion() + " - " + getPrecio() + "€";
	}

}