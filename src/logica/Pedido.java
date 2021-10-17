// Paquete al que pertenece la clase
package logica;

// Importaci�n de clases
import java.util.*;

/**
 * Clase Pedido para implementar los pedidos en la secci�n de bebidas
 * @author Samuel Rodr�guez Ares (UO271612)
 */
public class Pedido {
	
	private List<Bebida> listaBebidasPedidas = null; // lista de bebidas pedidas
	String observaciones;							 // observaciones del pedido
	
	/**
	 * Constructor por defecto, que inicializa la lista de bebidas pedidas
	 */
	public Pedido() {
		listaBebidasPedidas = new ArrayList<Bebida>();
	}

	/**
	 * A�ade un art�culo del cat�logo en tantas unidades al pedido
	 * @param drink bebida a a�adir al pedido, de tipo Bebida
	 * @param amount unidades de la bebida a a�adir al pedido, de tipo int
	 */
	public void add(Bebida drink, int amount) {
		Bebida bebidaEnPedido = null;
	
		// Se busca si ya hay alguna bebida igual en el pedido
		for (Bebida d : listaBebidasPedidas) {
			if (d.getCodigo().equals(drink.getCodigo()))
				bebidaEnPedido = d;
		}
		
		// Si no lo encontr�, se a�aden tantas unidades como se especifique 
		if (bebidaEnPedido == null) {
			Bebida drinkToAdd = new Bebida(drink);
			drinkToAdd.setUnidades(amount);
			listaBebidasPedidas.add(drinkToAdd);
			
		// En caso contrario, a�ade las unidades a la bebida ya existente
		} else {
			int newUnidades = bebidaEnPedido.getUnidades() + amount;
			bebidaEnPedido.setUnidades(newUnidades);
		}
	}
	
	/**
	 * Elimina las unidades especificadas de una bebida en cuesti�n en el peiddo
	 * @param drink bebida de la cual se quieren eliminar unidades, de tipo Bebida
	 * @param units n�mero de unidades a eliminar de drink, de tipo int
	 */
	public void remove(Bebida drink, int units) {
		Bebida bebidaEnPedido = null;
		
		// Se busca la bebida en el pedido
		for (Bebida d : listaBebidasPedidas) {
			if (d.getCodigo().equals(drink.getCodigo()))
				bebidaEnPedido = d;
		}
		
		// Si se encontr�, se restan las unidades
		if (bebidaEnPedido != null) {
			int newUnidades = bebidaEnPedido.getUnidades() - units;
			
			// Si se borran menos unidades de las que hay, no se borra del pedido
			if (newUnidades >= 0) {
				bebidaEnPedido.setUnidades(newUnidades);
				
				// En caso contrario, s� se elimina del pedido
				if (newUnidades == 0)
					listaBebidasPedidas.remove(bebidaEnPedido);	
				}
		}
	}
	
	/**
	 * Calcula el precio total del pedido y lo devuelve
	 * @return Precio total del pedido, de tipo float
	 */
	public float calcularTotal() {
		float total = 0.0f;
		
		// Se recorre el pedido para sumar su precio y sus unidades
		for (Bebida d : listaBebidasPedidas) {
			total += d.getPrecio() * d.getUnidades();
		}
		
		return total;
	}
	
	/**
	 * Establece las observaciones del cliente en el pedido
	 * @param observaciones comentarios a establecer en el pedido, de tipo String
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	/**
	 * Reinicia el pedido, eliminando todos los elementos de la lista
	 */
	public void inicializar() {
		listaBebidasPedidas.clear();
	}
}