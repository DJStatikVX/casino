// Paquete al que pertenece la clase
package logica;

// Importaci�n de clases
import java.io.*;
import java.util.*;

/**
 * Clase FileUtil para cargar art�culos de ficheros y guardar pedidos
 * @author Samuel Rodr�guez Ares (UO271612)
 */
public abstract class FileUtil {

	/**
 	* Carga los art�culos de un fichero, los convierte a su tipo y los a�ade
 	* a la lista especificada como par�metro
 	* @param inputFile nombre del fichero a leer, de tipo String
 	* @param listaBebidas lista de Bebidas donde se guarda la informaci�n le�da
 	*/
	public static void loadDrinks(String inputFile, List<Bebida> listaBebidas) {
		
	    String linea;						// l�nea que se lee
	    String[] datosBebida = null;		// datos le�dos del fichero
	    
	    try {
	    		
			// Se lee el fichero de bebidas
			BufferedReader fichero = new BufferedReader(new FileReader(inputFile));

			// Mientras el buffer de lectura no est� vac�o...
			while (fichero.ready()) {
				
				linea = fichero.readLine();			// se lee la l�nea
				datosBebida = linea.split("@");		// se divide en campos
				
				// Se crea una nueva bebida a partir de la informaci�n de los campos
				listaBebidas.add(new Bebida(datosBebida[0], datosBebida[1], 
						Integer.parseInt(datosBebida[2]), Double.parseDouble(
								datosBebida[3])));
			}

			// Tras dejar de leer, se cierra el flujo
			fichero.close();
			
		// Control de excepciones
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		} 
	}

	/**
	 * Carga los clientes de un fichero, procesa los par�metros creando un cliente 
	 * y los a�ade a la lista especificada como par�metro
	 * @param inputFile nombre del fichero a leer, de tipo String
	 * @param listaClientes lista de Clientes donde se guarda la informaci�n le�da
	 */
	public static void loadClients(String inputFile, List<Cliente> listaClientes) {
		
	    String linea;						// l�nea que se lee
	    String[] datosCliente = null;		// datos le�dos del fichero
	    
	    try {
	    		
			// Se lee el fichero de bebidas
			BufferedReader fichero = new BufferedReader(new FileReader(inputFile));

			// Mientras el buffer de lectura no est� vac�o...
			while (fichero.ready()) {
				
				linea = fichero.readLine();			// se lee la l�nea
				datosCliente = linea.split("@");	// se divide en campos
				
				// Se crea un cliente a partir de la informaci�n de los campos
				listaClientes.add(new Cliente(datosCliente[0], datosCliente[1], 
						datosCliente[2], datosCliente[3], 
						Double.parseDouble(datosCliente[4])));
			}

			// Tras dejar de leer, se cierra el flujo
			fichero.close();
			
		// Control de excepciones
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		} 
	}
	
	/**
	 * A�ade un nuevo cliente al fichero pasado como par�metro,
	 * escribiendo su informaci�n serializada en una nueva l�nea
	 * @param outputFile fichero sobre el que se escribe la l�nea, tipo String
	 * @param client informaci�n serializada del nuevo cliente, tipo String
	 */
	protected static void addClient(String outputFile, String client) {
		try {
			
			// Se inicializa el buffer de escritura
			BufferedWriter fichero = new BufferedWriter(new FileWriter(outputFile, true));
			
			// Se a�ade un separador y se escribe la nueva l�nea
			fichero.newLine();
			fichero.write(client);
			
			// Por �ltimo, se cierra el fichero
			fichero.close();
			
		// Control de exceptiones
		} catch (FileNotFoundException fnfe) {
			System.err.println("No se ha encontrado el archivo " + outputFile);
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	/**
	 * Guarda la informaci�n de clientes de la lista pasada como par�metro
	 * escribi�ndola en el fichero cuyo nombre tambi�n se especifica
	 * @param outputFile fichero sobre el que se escribe, de tipo String
	 * @param listaClientes lista de clientes que se escriben, List de Client
	 */
	protected static void saveClients(String outputFile, List<Cliente> listaClientes) {
		try {
			
			// Se inicializa el buffer de escritura
			BufferedWriter fichero = new BufferedWriter(new FileWriter(outputFile, false));
			
			// Se escribe la informaci�n de cada cliente
			for (int i = 0; i < listaClientes.size(); i++) {
				fichero.write(listaClientes.get(i).serialize());
				
				// Para todos los elementos menos el �ltimo, inserta un salto
				if (i != listaClientes.size() - 1) {
					fichero.newLine();
				}
			}
			
			// Por �ltimo, se cierra el fichero
			fichero.close();
			
		// Control de excepciones
		} catch (FileNotFoundException fnfe) {
			System.err.println("No se ha encontrado el archivo " + outputFile);
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
}