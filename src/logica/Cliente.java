// Paquete al que pertenece la clase
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cliente para la gesti�n de datos en los usuarios del juego
 * @author Samuel Rodr�guez Ares (UO271612)
 */
public class Cliente {
	
	private String dni;				// DNI del cliente
	private String fullName;		// nombre y apellidos
	private String userName;		// nombre de usuario
	private String password;		// contrase�a
	private double balance;			// saldo o balance de usuario (EUR)
	
	private List<Ficha> fichas;		// lista de fichas en posesi�n
	
	/**
	 * Constructor de la clase Cliente, que recibe como par�metros el DNI,
	 * el nombre completo, el nombre de usuario, la contrase�a,
	 * saldo y m�todo de pago vinculado
	 * 
	 * @param dni DNI a establecer para el cliente a instanciar, de tipo String
	 * @param fullName nombre completo del cliente, de tipo String
	 * @param userName nombre de usuario del cliente, de tipo String
	 * @param password clave de acceso del cliente, de tipo String
	 * @param balance saldo o balance del cliente en euros, de tipo double
	 * 
	 * @throws IllegalStateException si alguno de los par�metros es ilegal
	 */
	public Cliente(String dni, String fullName, String userName, 
			String password, double balance) {
		fichas = new ArrayList<Ficha>();
		setDNI(dni);
		setFullName(fullName);
		setUserName(userName);
		setPassword(password);
		setBalance(balance);
	}
	
	/**
	 * Devuelve la informaci�n del cliente en una cadena del formato:
	 * 		DNI@Nombre completo@Usuario@Clave@Saldo
	 * @return Cadena con la informaci�n del cliente separada por @, tipo String
	 */
	public String serialize() {
		return (getDNI() + "@" + getFullName() + "@" + getUserName() + "@"
				+ getPassword() + "@" + getBalance());
	}
	
	/**
	 * Devuelve la lista de fichas en posesi�n del cliente
	 * @return Lista de fichas en posesi�n, de tipo ArrayList de Ficha
	 */
	public List<Ficha> getFichas() {
		return this.fichas;
	}
	
	/**
	 * A�ade una nueva ficha al array de fichas del cliente
	 * @param f ficha a a�adir al array del cliente, de tipo Ficha
	 */
	public void addFicha(Ficha f) {
		getFichas().add(f);
	}
	
	/**
	 * Borra una ficha del array de fichas del cliente con el valor espec�fico
	 * @param valor valor de la ficha que se quiere borrar de la lista, tipo int
	 */
	public void borrarFicha(int valor) {
		for (Ficha f : getFichas()) {
			if (f.getValor() == valor) {
				getFichas().remove(f);
				break;
			}
		}
	}
	
	/**
	 * Borra todas las fichas del cliente
	 */
	public void limpiarFichas() {
		getFichas().clear();
	}
	
	/**
	 * Cuenta las fichas en posesi�n del usuario con un valor determinado
	 * @param valor valor para el tipo de ficha a contar, de tipo int
	 * @return N�mero de fichas del tipo especificado, de tipo int
	 */
	public int contarFichas(int valor) {
		int count = 0;
		
		// Se cuenta el n�mero de fichas con ese valor
		for (Ficha f : getFichas()) {
			if (f.getValor() == valor) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Devuelve el valor total en funci�n de las fichas pose�das por el usuario
	 * @return Valor total de las fichas pose�das, de tipo int
	 */
	public int getValorTotal() {
		int total = 0;
		
		// Se va sumando el valor de cada ficha pose�da
		for (Ficha f : getFichas()) {
			total += f.getValor();
		}
		
		return total;
	}
	
	/**
	 * Establece el DNI del cliente, siempre y cu�ndo no sea vac�o
	 * @param dni DNI a establecer para el cliente, de tipo String
	 * @throws IllegalStateException si dni es nulo o vac�o
	 */
	private void setDNI(String dni) {
		checkString(dni, "DNI");
		this.dni = dni;
	}
	
	/**
	 * Devuelve el DNI del cliente
	 * @return DNI del cliente, de tipo String
	 */
	public String getDNI() {
		return this.dni;
	}
	
	/**
	 * Establece el nombre y apellido del cliente, siempre y cu�ndo no sean vac�os
	 * @param fullName nombre completo a establecer, de tipo String
	 * @throws IllegalStateException si fullName es nulo o vac�o
	 */
	private void setFullName(String fullName) {
		checkString(fullName, "Nombre completo");
		this.fullName = fullName;
	}
	
	/**
	 * Devuelve el nombre completo del cliente
	 * @return Nombre completo del cliente, de tipo String
	 */
	public String getFullName() {
		return this.fullName;
	}
	
	/**
	 * Establece el nombre de usuario del cliente, siempre y cu�ndo no sea vac�o
	 * @param userName nombre de usuario a establecer, de tipo String
	 * @throws IllegalStateException si userName es nulo o vac�o
	 */
	private void setUserName(String userName) {
		checkString(userName, "Usuario");
		this.userName = userName;
	}
	
	/**
	 * Devuelve el nombre de usuario del cliente
	 * @return Nombre de usuario del cliente, de tipo String
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * Establece la clave de acceso del cliente, siempre y cu�ndo no sea vac�o
	 * @param password clave de acceso a establecer, de tipo String
	 * @throws IllegalStateException si password es nulo o vac�o
	 */
	private void setPassword(String password) {
		checkString(password, "Clave");
		this.password = password;
	}
	
	/**
	 * Devuelve la clave de acceso de usuario del cliente
	 * @return Clave de acceso del cliente, de tipo String
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Modifica o establece el saldo o balance del usuario
	 * @param balance nuevo saldo a establecer, de tipo double
	 * @throws IllegalStateException si balance es negativo
	 */
	public void setBalance(double balance) {
		checkBalance(balance);
		this.balance = balance;
	}
	
	/**
	 * Comprueba que el saldo a establecer no sea negativo
	 * @param balance saldo a comprobar, de tipo double
	 * @throws IllegalStateException si balance es negativo
	 */
	private void checkBalance(double balance) {
		if (balance < 0.00) {
			throw new IllegalStateException("El campo Saldo del cliente "
					+ "no puede ser negativo.");
		}
	}
	
	/**
	 * Devuelve el saldo disponible del usuario
	 * @return Saldo del usuario, de tipo double
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Comprueba que el campo pasado como par�metro sea v�lido
	 * @param str contenido a comprobar, de tipo String
	 * @param field campo correspondiente al par�metro str, de tipo String
	 * @throws IllegalStateException si str es nulo o vac�o
	 */
	private void checkString(String str, String field) {
		if (str == null || str == "") {
			throw new IllegalStateException("El campo " + field + " del cliente "
					+ "no puede ser nulo o vac�o.");
		}
	}

}