// Paquete al que pertenece la clase
package logica;

// Importación de clases
import java.util.*;

/**
 * Clase Carta que almacena las bebidas disponibles, pudiendo importarlas
 * mediante un fichero especificado como constante
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class Carta {
	
	/**
	 * Constante que almacena la ruta al fichero de bebidas a leer
	 */
	private static final String FICHERO_BEBIDAS = "files/data/bebidas.dat";
	
	private List<Bebida> listaBebidas = null;	// lista de bebidas
	
	/**
	 * Constructor de la clase, que inicializa la lista de bebidas y las carga
	 */
	public Carta() {
		listaBebidas = new ArrayList<Bebida>();
		cargarBebidas();
	}

	/**
	 * Mediante un FileUtil, carga los artículos del fichero especificado
	 */
	private void cargarBebidas() {
		FileUtil.loadDrinks(FICHERO_BEBIDAS, listaBebidas);
	}

	/**
	 * Devuelve la lista de bebidas almacenadas
	 * @return Lista de bebidas almacenados, de tipo Array de Bebida
	 */
	public Bebida[] getBebidas() {
		Bebida[] bebidas = listaBebidas.toArray(new Bebida[listaBebidas.size()]);
		
		return bebidas;	
	}
}