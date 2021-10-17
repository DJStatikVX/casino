// Paquete al que pertenece la clase
package igu;

// Importación de clases
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;

import javax.swing.SwingConstants;

/**
 * Clase VentanaNumeroGanador utilizada para mostrar el número ganador
 * @author Samuel Rodríguez Ares (UO271612)
 */
@SuppressWarnings("serial")
public class VentanaNumeroGanador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private Font fuenteDigital;
	
	private VentanaJuego vj;							// juego asociado
	private boolean acertado;							// si acertó algo
	private int numeroGanador;							// número ganador
	
	private JLabel lblBackground;						// imagen de fondo
	private JLabel lblNumeroGanador;					// número ganador
	
	private ProcesaCerrarVentana pcv = new ProcesaCerrarVentana();	// evento
	
	/**
	 * Clase receptora para el evento que muestra los resultados del cliente
	 */
	class ProcesaCerrarVentana extends WindowAdapter {
		@Override
		public void windowClosed(WindowEvent e) {
			vj.mostrarResultados(acertado, numeroGanador);
		}
	}

	/**
	 * Create the dialog.
	 * @param vj ventana de juego de la que surge, de tipo VentanaJuego
	 * @param numeroGanador número que ha salido ganador, de tipo int
	 * @param acertado si el usuario ha ganado algo, de tipo boolean
	 */
	public VentanaNumeroGanador(VentanaJuego vj, int numeroGanador, boolean acertado) {
		this.vj = vj;
		this.acertado = acertado;
		this.numeroGanador = numeroGanador;
		
		cargarFuente();
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(vj);
		setTitle(vj.getStrings().getString("dialog_number_title"));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNumeroGanador());
		contentPanel.add(getLblBackground());
		
		// Muestra el número ganador
		establecerNumeroGanador(numeroGanador, acertado);
		
		// Al cerrarlo, muestra un diálogo sobre el resultado de la apuesta
		addWindowListener(pcv);
	}
	
	/**
	 * Carga la fuente especializada
	 */
	private void cargarFuente() {
		try {
			InputStream myStream = getClass().getResourceAsStream("/ttf/Montserrat-Regular.ttf");
			fuenteDigital = Font.createFont(Font.TRUETYPE_FONT, myStream);
		} catch (Exception e) {
			System.err.println("No se pudo cargar la fuente");
		}
	}
	
	/**
	 * Devuelve o crea la etiqueta con la imagen de fondo, si no está creada
	 * @return Etiqueta con la imagen de fondo, de tipo JLabel
	 */
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon("files/img/result.jpg"));
			lblBackground.setBounds(0, 0, this.getWidth(), this.getHeight());
		}
		
		return lblBackground;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el número ganador, si no está creada
	 * @return Etiqueta con el número ganador, de tipo JLabel
	 */
	private JLabel getLblNumeroGanador() {
		if (lblNumeroGanador == null) {
			lblNumeroGanador = new JLabel("New label");
			lblNumeroGanador.setHorizontalAlignment(SwingConstants.CENTER);
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 99);
			lblNumeroGanador.setFont(fuente);
			lblNumeroGanador.setForeground(Color.WHITE);
			lblNumeroGanador.setBounds(0, 0, 434, 261);
		}
		
		return lblNumeroGanador;
	}
	
	/**
	 * Cambia el número ganador en el diálogo
	 * @param numeroGanador número premiado a mostrar, de tipo int
	 * @param acertado si el cliente ha acertado, de tipo boolean
	 */
	private void establecerNumeroGanador(int numeroGanador, boolean acertado) {
		getLblNumeroGanador().setText(String.valueOf(numeroGanador));
	}
}