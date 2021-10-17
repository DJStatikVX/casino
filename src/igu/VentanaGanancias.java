// Paquete al que pertenece la clase
package igu;

// Importación de clases
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.InputStream;

/**
 * Clase VentanaGanancias para mostrar las fichas ganadas tras la apuesta
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class VentanaGanancias extends JDialog {
	
	private Font fuenteDigital;
	
	private final JPanel contentPanel = new JPanel();
	private JPanel pnIconosFichas;
	private JPanel pnCuentaFichas;
	private JLabel lblFicha5;
	private JLabel lblFicha10;
	private JLabel lblFicha20;
	private JLabel lblFicha50;
	private JLabel lblFicha100;
	private JLabel lblCountFichas5;
	private JLabel lblCountFichas10;
	private JLabel lblCountFichas20;
	private JLabel lblCountFichas50;
	private JLabel lblCountFichas100;

	/**
	 * Create the dialog.
	 * @param vj ventana de juego a partir de la que se crea, de tipo VentanaJuego
	 * @param contadores lista de contadores a mostrar, de tipo int[]
	 */
	public VentanaGanancias(VentanaJuego vj, int[] contadores) {
		cargarFuente();
		
		setModal(true);
		setTitle(vj.getStrings().getString("dialog_win_title"));
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(vj);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblGanancias = new JLabel("New label");
			lblGanancias.setForeground(Color.WHITE);
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 24);
			lblGanancias.setFont(fuente);
			lblGanancias.setText(vj.getStrings().getString("dialog_win_profit"));
			lblGanancias.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblGanancias, BorderLayout.CENTER);
		}
		{
			JPanel pnJuegoFichas = new JPanel();
			contentPanel.add(pnJuegoFichas, BorderLayout.SOUTH);
			pnJuegoFichas.setLayout(new GridLayout(2, 5, 0, 0));
			pnJuegoFichas.setBackground(new Color(128, 0, 0));
			pnJuegoFichas.setLayout(new GridLayout(2, 1, 0, 0));
					
			// Se añaden los subpaneles
			pnJuegoFichas.add(getPnIconosFichas());
			pnJuegoFichas.add(getPnCuentaFichas());
	    }
		{
//			JPanel buttonPane = new JPanel();
//			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
//			getContentPane().add(buttonPane, BorderLayout.SOUTH);
//			{
//				JButton okButton = new JButton("OK");
//				okButton.setActionCommand("OK");
//				buttonPane.add(okButton);
//				getRootPane().setDefaultButton(okButton);
//			}
		}
		
		// Establece los valores visuales de los contadores
		establecerContadores(contadores);
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
	 * Actualiza el texto de las etiquetas con los contadores
	 * @param contadores array de contadores a utilizar, de tipo int[]
	 */
	private void establecerContadores(int[] contadores) {
		getLblCountFichas5().setText(String.valueOf(contadores[0]));
		getLblCountFichas10().setText(String.valueOf(contadores[1]));
		getLblCountFichas20().setText(String.valueOf(contadores[2]));
		getLblCountFichas50().setText(String.valueOf(contadores[3]));
		getLblCountFichas100().setText(String.valueOf(contadores[4]));
	}
	
	/**
	 * Devuelve o crea el panel que alberga los iconos de fichas, si no está creado
	 * @return Panel con botones e iconos de las fichas, de tipo JPanel
	 */
	private JPanel getPnIconosFichas() {
		if (pnIconosFichas == null) {
			pnIconosFichas = new JPanel();
			pnIconosFichas.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 0));
			
			// Se añaden los botones de las fichas
			pnIconosFichas.add(getLblFicha5());
			pnIconosFichas.add(getLblFicha10());
			pnIconosFichas.add(getLblFicha20());
			pnIconosFichas.add(getLblFicha50());
			pnIconosFichas.add(getLblFicha100());
		}
		
		return pnIconosFichas;
	}
	
	/**
	 * Devuelve o crea la etiqueta de la ficha de 5, si no está creada
	 * @return Etiqueta de la ficha de 5, de tipo JLabel
	 */
	private JLabel getLblFicha5() {
		if (lblFicha5 == null) {
			lblFicha5 = new JLabel();
			lblFicha5.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblFicha5.setVerticalAlignment(SwingConstants.BOTTOM);
			lblFicha5.setIcon(new ImageIcon(new ImageIcon("files/img/token/5.PNG")
					.getImage().getScaledInstance(50, 45, Image.SCALE_SMOOTH)));
		}
		
		return lblFicha5;
	}
	
	/**
	 * Devuelve o crea la etiqueta de la ficha de 10, si no está creada
	 * @return Etiqueta de la ficha de 10, de tipo JLabel
	 */
	private JLabel getLblFicha10() {
		if (lblFicha10 == null) {
			lblFicha10 = new JLabel();
			lblFicha10.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblFicha10.setVerticalAlignment(SwingConstants.BOTTOM);
			lblFicha10.setIcon(new ImageIcon(new ImageIcon("files/img/token/10.PNG")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		}
		
		return lblFicha10;
	}
	
	/**
	 * Devuelve o crea la etiqueta de la ficha de 20, si no está creada
	 * @return Etiqueta de la ficha de 20, de tipo JLabel
	 */
	private JLabel getLblFicha20() {
		if (lblFicha20 == null) {
			lblFicha20 = new JLabel();
			lblFicha20.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblFicha20.setVerticalAlignment(SwingConstants.BOTTOM);
		    lblFicha20.setIcon(new ImageIcon(new ImageIcon("files/img/token/20.PNG")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

		}
		
		return lblFicha20;
	}
	
	/**
	 * Devuelve o crea la etiqueta de la ficha de 50, si no está creada
	 * @return Etiqueta de la ficha de 50, de tipo JLabel
	 */
	private JLabel getLblFicha50() {
		if (lblFicha50 == null) {
			lblFicha50 = new JLabel();
			lblFicha50.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblFicha50.setVerticalAlignment(SwingConstants.BOTTOM);
			lblFicha50.setIcon(new ImageIcon(new ImageIcon("files/img/token/50.PNG")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		}
		
		return lblFicha50;
	}
	
	/**
	 * Devuelve o crea la etiqueta de la ficha de 100, si no está creada
	 * @return Etiqueta de la ficha de 100, de tipo JLabel
	 */
	private JLabel getLblFicha100() {
		if (lblFicha100 == null) {
			lblFicha100 = new JLabel();
			lblFicha100.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblFicha100.setVerticalAlignment(SwingConstants.BOTTOM);
			lblFicha100.setIcon(new ImageIcon(new ImageIcon("files/img/token/100.PNG")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		}
		
		return lblFicha100;
	}
	
	/**
	 * Devuelve o crea el panel con el número de fichas, si no está creado
	 * @return Panel con el número de fichas de cada tipo, de tipo JPanel
	 */
	private JPanel getPnCuentaFichas() {
		if (pnCuentaFichas == null) {
			pnCuentaFichas = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnCuentaFichas.getLayout();
			flowLayout.setHgap(56);
			
			// Se añaden las etiquetas con los contadores
			pnCuentaFichas.add(getLblCountFichas5());
			pnCuentaFichas.add(getLblCountFichas10());
			pnCuentaFichas.add(getLblCountFichas20());
			pnCuentaFichas.add(getLblCountFichas50());
			pnCuentaFichas.add(getLblCountFichas100());
		}
		
		return pnCuentaFichas;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el número de fichas de 5, si no está creada
	 * @return Etiqueta con el número de fichas de 5, de tipo JLabel
	 */
	private JLabel getLblCountFichas5() {
		if (lblCountFichas5 == null) {
			lblCountFichas5 = new JLabel("");
			lblCountFichas5.setForeground(Color.WHITE);
			lblCountFichas5.setFont(new Font("Arial Black", Font.BOLD, 15));
			lblCountFichas5.setText("0");
		}
		
		return lblCountFichas5;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el número de fichas de 10, si no está creada
	 * @return Etiqueta con el número de fichas de 10, de tipo JLabel
	 */
	private JLabel getLblCountFichas10() {
		if (lblCountFichas10 == null) {
			lblCountFichas10 = new JLabel("");
			lblCountFichas10.setForeground(Color.WHITE);
			lblCountFichas10.setFont(new Font("Arial Black", Font.BOLD, 15));
			lblCountFichas10.setText("0");
		}
		
		return lblCountFichas10;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el número de fichas de 20, si no está creada
	 * @return Etiqueta con el número de fichas de 20, de tipo JLabel
	 */
	private JLabel getLblCountFichas20() {
		if (lblCountFichas20 == null) {
			lblCountFichas20 = new JLabel("");
			lblCountFichas20.setForeground(Color.WHITE);
			lblCountFichas20.setFont(new Font("Arial Black", Font.BOLD, 15));
			lblCountFichas20.setText("0");
		}
		
		return lblCountFichas20;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el número de fichas de 5, si no está creada
	 * @return Etiqueta con el número de fichas de 5, de tipo JLabel
	 */
	private JLabel getLblCountFichas50() {
		if (lblCountFichas50 == null) {
			lblCountFichas50 = new JLabel("");
			lblCountFichas50.setForeground(Color.WHITE);
			lblCountFichas50.setFont(new Font("Arial Black", Font.BOLD, 15));
			lblCountFichas50.setText("0");
		}
		
		return lblCountFichas50;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el número de fichas de 100, si no está creada
	 * @return Etiqueta con el número de fichas de 100, de tipo JLabel
	 */
	private JLabel getLblCountFichas100() {
		if (lblCountFichas100 == null) {
			lblCountFichas100 = new JLabel("");
			lblCountFichas100.setForeground(Color.WHITE);
			lblCountFichas100.setFont(new Font("Arial Black", Font.BOLD, 15));
			lblCountFichas100.setText("0");
		}
		
		return lblCountFichas100;
	}

}