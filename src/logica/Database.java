// Paquete al que pertenece la clase
package logica;

// Importaci�n de clases
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Database que almacena la base de datos con los clientes del juego,
 * pudiendo importarlos desde un fichero especificado como constante
 * @author Samuel Rodr�guez Ares (UO271612)
 */
public class Database {
	
	/**
	 * Constante que almacena la ruta al fichero de clientes a leer
	 */
	private static final String FICHERO_CLIENTES = "files/data/clientes.dat";
	
	private List<Cliente> listaClientes = null;		// lista de clientes
	
	/**
	 * Constructor de la clase, que inicializa la lista de clientes y los carga
	 */
	public Database() {
		listaClientes = new ArrayList<Cliente>();
		cargarClientes();
	}

	/**
	 * Mediante un FileUtil, procesa la informaci�n del fichero especificado
	 * convirti�ndola en los clientes que pasan a formar parte de la lista
	 */
	private void cargarClientes() {
		FileUtil.loadClients(FICHERO_CLIENTES, listaClientes);
	}
	
	/**
	 * Busca y devuelve un cliente en la base de datos
	 * con el usuario y contrase�a pasados como par�metro
	 * @param username nombre de usuario a buscar, de tipo String
	 * @param password contrase�a del usuario a buscar, de tipo char[]
	 * @return Cliente en cuesti�n si lo encuentra; null en otro caso
	 */
	public Cliente buscarCliente(String username, char[] password) {	
		String pass = String.valueOf(password);
		
		// B�squeda de coincidencias en la base de datos
		for (Cliente cl : getClients()) {
			if (username.equals(cl.getUserName()) 
					&& pass.equals(cl.getPassword())) {
				
				return cl;
			}
		}
		
		return null;
	}
	
	/**
	 * Busca si hay alg�n usuario con el nombre de usuario pasado como par�metro en la base
	 * @param userName nombre de usuario a buscar en la base de datos, de tipo String
	 * @return Cliente coincidente con el nombre de usuario si se encuentra; null si no
	 */
	public Cliente buscarUsuario(String userName) {
		for (Cliente cl : getClients()) {
			if (userName.equals(cl.getUserName())) {
				return cl;
			}
		}
		
		return null;
	}
	
	/**
	 * Busca si hay alg�n usuario con el DNI pasado como par�metro en la base
	 * @param dni DNI a buscar en la base de datos, de tipo String
	 * @return Cliente coincidente con el DNI si se encuentra; null si no
	 */
	public Cliente buscarDNI(String dni) {
		for (Cliente cl : getClients()) {
			if (dni.equals(cl.getDNI())) {
				return cl;
			}
		}
		
		return null;
	}
	
	/**
	 * Registra un nuevo usuario en la base de datos
	 * @param fullName nombre completo del usuario a registrar, de tipo String
	 * @param DNI n�mero de documentaci�n del usuario, de tipo String
	 * @param userName nombre de usuario a registrar, de tipo String
	 * @param password contrase�a del nuevo usuario, de tipo char[]
	 */
	public void registrarUsuario(String fullName, String DNI,
			String userName, char[] password) {
		
		// Se crea el nuevo cliente con un saldo de 100� de bienvenida
		Cliente nuevo = new Cliente(DNI, fullName, userName, 
				String.valueOf(password), 100.0);
		
		// Se a�ade a la lista de clientes
		listaClientes.add(nuevo);
		
		// Se escribe la nueva l�nea con el usuario en el fichero
		FileUtil.addClient(FICHERO_CLIENTES, nuevo.serialize());
	}
	
	/**
	 * Actualiza el fichero de clientes en la base de datos,
	 * limpiando el contenido del fichero y escribiendo
	 * todos los clientes serializados con la informaci�n actualizada
	 */
	public void actualizarUsuarios() {
		FileUtil.saveClients(FICHERO_CLIENTES, listaClientes);
	}

	/**
	 * Devuelve la lista de clientes almacenados en la base de datos
	 * @return Lista de clientes almacenados, de tipo Array de Cliente
	 */
	public Cliente[] getClients() {
		Cliente[] clients = listaClientes.toArray(new Cliente[listaClientes.size()]);
		
		return clients;	
	}

}