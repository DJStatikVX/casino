// Paquete al que pertenece la clase
package igu;

// Importación de clases
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;

/**
 * Diálogo VentanaMetodoPago para vincular un método de pago
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class VentanaMetodoPago extends JDialog {

	private final JPanel contentPanel = new JPanel();	// panel de contenidos
	private VentanaJuego vj;							// juego asociado
	
	// Objeto receptor para el evento según la opción seleccionada
	private ProcesaOpcion po = new ProcesaOpcion();
	
	private JPanel pnTarjeta;
	private JLabel lblNumeroTarjeta;
	private JTextField textFieldNumeroTarjeta;
	private JLabel lblCodigoSeguridad;
	private JPasswordField passwordFieldCodigoSeguridad;
	private JPanel pnOpciones;
	private JPanel pnBtnOtrosMetodos;
	private JButton btnOtrosMetodos;
	private JPanel pnOtrosMetodos;
	private JButton btnTarjetaCredito;
	private JPanel pnOtrosMetodosBotones;
	private JButton btnPayPal;
	private JButton btnPaySafeCard;
	private JPanel pnPayPal;
	private JPanel pnPaySafeCard;
	
	// Credenciales para PayPal
	private JLabel lblMail;
	private JTextField textMail;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	
	// Credenciales para Paysafecard
	private JLabel lblNumeroPaySafeCard;
	private JTextField textFieldNumeroPaySafeCard;
	
	private String paymentMethod;	// método de pago
	
	/**
	 * Create the dialog.
	 * @param vj ventana de juego a partir de la que se crea, de tipo VentanaJuego
	 */
	public VentanaMetodoPago(VentanaJuego vj) {
		setResizable(false);				// no redimensionable (por simplicidad)
		setBackground(Color.LIGHT_GRAY);

		// Se vincula al juego para obtener cadenas internacionalizadas
		this.vj = vj;
		localizar(vj.getStrings());
		setLocationRelativeTo(null);
		
		setModal(true);
		setBounds(510, 320, 350, 210);
		
		// Se configura su panel de contenidos y se establecen los componentes
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		contentPanel.add(getPnTarjeta(), "pnTarjeta");
		contentPanel.add(getPnOtrosMetodos(), "pnOtrosMetodos");
		contentPanel.add(getPnPayPal(), "pnPayPal");
		contentPanel.add(getPnPaySafeCard(), "pnPaySafeCard");

		// Se instancia y configura el panel inferior de opciones
		JPanel pnSur = new JPanel();
		getContentPane().add(pnSur, BorderLayout.SOUTH);

		// Se instancia y configura el botón OK (opción por defecto)
		JButton okButton = new JButton("OK");
		okButton.setFocusPainted(false);
		okButton.setActionCommand("OK");
		okButton.addActionListener(po);
		pnSur.setLayout(new BorderLayout(0, 0));
		getPnOpciones().add(okButton);
		getRootPane().setDefaultButton(okButton);

		// Se instancia y configura el botón Cancelar
		String cancelText = this.vj.getStrings().getString("opt_cancel");
		JButton cancelButton = new JButton(cancelText);
		cancelButton.setFocusPainted(false);
		cancelButton.setMnemonic('C');
		cancelButton.setActionCommand(cancelText);
		cancelButton.addActionListener(po);
		getPnOpciones().add(cancelButton);
		pnSur.add(getPnOpciones(), BorderLayout.EAST);
		pnSur.add(getPnBtnOtrosMetodos(), BorderLayout.CENTER);
		
		// Se comienza suponiendo que el método de pago es tarjeta de crédito
		paymentMethod = "Credit card";
	}
	
	/**
	 * Clase receptora para la selección de opción por parte del usuario
	 * @author Samuel Rodríguez Ares (UO271612)
	 */
	class ProcesaOpcion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().contentEquals("OK")) {
				
				boolean valid = checkBlank();
				
				// Se comprueba que los campos sean válidos
				if (!valid) {
					JOptionPane.showMessageDialog(null, 
							vj.getStrings().getString("err_card_empty"), 
							vj.getStrings().getString("err_card_title"),
							JOptionPane.ERROR_MESSAGE);
				} else {
					// Cuando lo sean, vuelve al juego para buscar el usuario
					setVisible(false);
					next();
					dispose();
				}
				
			} else {
				// Si se escoge cancelar, se cierra directamente
				dispose();
			}
		}
	}
	
	/**
	 * Comprueba que ninguno de los campos a introducir esté vacío
	 * @return true si los valores introducidos son válidos; false en otro caso
	 */
	private boolean checkBlank() {
		if (paymentMethod.equals("Credit card")) {
			if (getTextFieldNumeroTarjeta().getText().equals("")
					|| getPasswordFieldCodigoSeguridad().getPassword().length == 0) {
				return false;
			}
	    } else if (paymentMethod.equals("PayPal")) {
	    	if (getLblMail().getText().equals("")
					|| getPasswordField().getPassword().length == 0) {
				return false;
			}
	    } else if (paymentMethod.equals("PaySafeCard")) {
	    	if (getTextFieldNumeroPaySafeCard().getText().equals("")) {
	    		return false;
	    	}
	    }
		
		return true;
	}
	
	/**
	 * Pasa a verificar los datos introducidos en la aplicación
	 */
	private void next() {
		String cadenaMetodo = "";
		
		if (paymentMethod.equals("Credit card")) {
			cadenaMetodo = vj.getStrings().getString("btn_credit_card");
		} else {
			cadenaMetodo = paymentMethod;
		}
		
		JOptionPane.showMessageDialog(null, vj.getStrings().getString("dialog_linked_msg") 
				+ cadenaMetodo + ".", vj.getStrings().getString("dialog_linked_title"), 
				JOptionPane.INFORMATION_MESSAGE);
		
		this.vj.addPaymentMethod();
	}
	
	/**
	 * Modifica el contenido de las cadenas en función del idioma del juego
	 * @param strings paquete de recursos para el idioma, de tipo ResourceBundle
	 */
	private void localizar(ResourceBundle strings) {
		// Modifica el título del panel de contenidos
		contentPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0), 5, true), strings.getString("btn_link_card"), 
				TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		
		// Modifica el nombre de los campos del diálogo
		getLblNumeroTarjeta().setText(strings.getString("lbl_card_number"));
		getLblCodigoSeguridad().setText(strings.getString("lbl_card_pin"));
		
		getLblMail().setText(strings.getString("lbl_paypal_mail"));
		getLblPassword().setText(strings.getString("pn_login_pass"));
		
		getLblNumeroPaySafeCard().setText(strings.getString("lbl_paysafecard_number"));
	}
	
	/**
	 * Devuelve o crea el panel con los datos de la tarjeta, si no está creado
	 * @return Panel de introducción de datos de tarjeta de crédito, tipo JPanel
	 */
	private JPanel getPnTarjeta() {
		if (pnTarjeta == null) {
			pnTarjeta = new JPanel();
			pnTarjeta.setLayout(null);
			pnTarjeta.add(getLblNumeroTarjeta());
			pnTarjeta.add(getTextFieldNumeroTarjeta());
			pnTarjeta.add(getLblCodigoSeguridad());
			pnTarjeta.add(getPasswordFieldCodigoSeguridad());
		}
		
		return pnTarjeta;
	}
	
	/**
	 * Devuelve o crea la etiqueta Nombre de usuario:, si no está creada
	 * @return Etiqueta Nombre de usuario:, de tipo JLabel
	 */
	private JLabel getLblNumeroTarjeta() {
		if (lblNumeroTarjeta == null) {
			lblNumeroTarjeta = new JLabel();
			lblNumeroTarjeta.setLabelFor(getTextFieldNumeroTarjeta());
			lblNumeroTarjeta.setBounds(37, 35, 128, 14);
			
			// Se establece el mnemónico en función de la localización
			if (vj.getLang().equals("en")) {
				lblNumeroTarjeta.setDisplayedMnemonic('U');
			} else {
				lblNumeroTarjeta.setDisplayedMnemonic('R');
			}
		}
		
		return lblNumeroTarjeta;
	}
	
	/**
	 * Devuelve o crea el campo de texto para el nombre de usuario, si no está creado
	 * @return Campo de texto para el nombre de usuario, de tipo JTextField
	 */
	private JTextField getTextFieldNumeroTarjeta() {
		if (textFieldNumeroTarjeta == null) {
			textFieldNumeroTarjeta = new JTextField();
			textFieldNumeroTarjeta.setBounds(175, 33, 128, 20);
			textFieldNumeroTarjeta.setColumns(10);
		}
		
		return textFieldNumeroTarjeta;
	}
	
	/**
	 * Devuelve o crea la etiqueta Contraseña:, si no está creada
	 * @return Etiqueta Contraseña:, de tipo JLabel
	 */
	private JLabel getLblCodigoSeguridad() {
		if (lblCodigoSeguridad == null) {
			lblCodigoSeguridad = new JLabel();
			lblCodigoSeguridad.setLabelFor(getPasswordFieldCodigoSeguridad());
			lblCodigoSeguridad.setDisplayedMnemonic('S');
			lblCodigoSeguridad.setBounds(37, 78, 128, 14);
		}
		
		return lblCodigoSeguridad;
	}
	
	/**
	 * Devuelve o crea el campo para introducir la contraseña, si no está creado
	 * @return Campo de introducción de contraseña, de tipo JPasswordField
	 */
	private JPasswordField getPasswordFieldCodigoSeguridad() {
		if (passwordFieldCodigoSeguridad == null) {
			passwordFieldCodigoSeguridad = new JPasswordField();
			passwordFieldCodigoSeguridad.setBounds(175, 75, 128, 20);
		}
		
		return passwordFieldCodigoSeguridad;
	}
	
	/**
	 * Devuelve o crea el panel inferior con las opciones OK y Cancelar, si no está creado
	 * @return Panel inferior con las opciones OK y Cancelar, de tipo JPanel
	 */
	private JPanel getPnOpciones() {
		if (pnOpciones == null) {
			pnOpciones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnOpciones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
		}
		
		return pnOpciones;
	}
	
	/**
	 * Devuelve o crea el panel que alberga el botón para otros métodos, si no está creado
	 * @return Panel que alberga el botón para otros métodos de pago, tipo JPanel
	 */
	private JPanel getPnBtnOtrosMetodos() {
		if (pnBtnOtrosMetodos == null) {
			pnBtnOtrosMetodos = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBtnOtrosMetodos.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnBtnOtrosMetodos.add(getBtnOtrosMetodos());
		}
		
		return pnBtnOtrosMetodos;
	}
	
	/**
	 * Devuelve o crea el botón Otros métodos de pago, si no está creado
	 * @return Botón Otros métodos de pago, de tipo JButton
	 */
	private JButton getBtnOtrosMetodos() {
		if (btnOtrosMetodos == null) {
			btnOtrosMetodos = new JButton("");
			btnOtrosMetodos.setFocusPainted(false);
			btnOtrosMetodos.setText(vj.getStrings().getString("btn_other_means"));
			btnOtrosMetodos.setMnemonic('M');
			
			// Al pulsarlo, muestra el panel con otros métodos de pago
			btnOtrosMetodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPanel.getLayout()).show(contentPanel, "pnOtrosMetodos");
					getPnBtnOtrosMetodos().removeAll();
					repaint();
					getPnBtnOtrosMetodos().add(getBtnTarjetaCredito());
				}
			});
		}
		
		return btnOtrosMetodos;
	}
	
	/**
	 * Devuelve o crea el panel para elegir otros métodos de pago, si no está creado
	 * @return Panel de selección de otros métodos de pago, de tipo JPanel
	 */
	private JPanel getPnOtrosMetodos() {
		if (pnOtrosMetodos == null) {
			pnOtrosMetodos = new JPanel();
			pnOtrosMetodos.setLayout(null);
			pnOtrosMetodos.add(getPnOtrosMetodosBotones());
		}
		
		return pnOtrosMetodos;
	}
	
	/**
	 * Devuelve o crea el botón Tarjeta de crédito, si no está creado
	 * @return Botón Tarjeta de crédito, de tipo JButton
	 */
	private JButton getBtnTarjetaCredito() {
		if (btnTarjetaCredito == null) {
			btnTarjetaCredito = new JButton("");
			btnTarjetaCredito.setFocusPainted(false);
			btnTarjetaCredito.setMnemonic('T');
			btnTarjetaCredito.setText(vj.getStrings().getString("btn_credit_card"));
			btnTarjetaCredito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPanel.getLayout()).show(contentPanel, "pnTarjeta");
					getPnBtnOtrosMetodos().removeAll();
					repaint();
					getPnBtnOtrosMetodos().add(getBtnOtrosMetodos());
				}
			});
		}
		
		return btnTarjetaCredito;
	}
	
	/**
	 * Devuelve o crea el panel de botones del panel Otros métodos, si no está creado
	 * @return Panel de botones del panel Otros métodos, de tipo JPanel
	 */
	private JPanel getPnOtrosMetodosBotones() {
		if (pnOtrosMetodosBotones == null) {
			pnOtrosMetodosBotones = new JPanel();
			pnOtrosMetodosBotones.setBounds(24, 40, 279, 41);
			pnOtrosMetodosBotones.setLayout(new GridLayout(0, 2, 30, 0));
			pnOtrosMetodosBotones.add(getBtnPayPal());
			pnOtrosMetodosBotones.add(getBtnPaySafeCard());
		}
		
		return pnOtrosMetodosBotones;
	}
	
	/**
	 * Devuelve o crea el botón para pagar con PayPal, si no está creado
	 * @return Botón para pagar con PayPal, de tipo JButton
	 */
	private JButton getBtnPayPal() {
		if (btnPayPal == null) {
			btnPayPal = new JButton("");
			btnPayPal.setMnemonic('1');
			btnPayPal.setFocusPainted(false);
			btnPayPal.setIcon(new ImageIcon(new ImageIcon("files/img/paypal.png")
					.getImage().getScaledInstance(90, 30, Image.SCALE_SMOOTH)));
			
			// Al pulsarlo, pide iniciar sesión con la cuenta de PayPal
			btnPayPal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paymentMethod = "PayPal";
					getPnBtnOtrosMetodos().removeAll();
					repaint();
					((CardLayout) contentPanel.getLayout()).show(contentPanel, "pnPayPal");
				}
			});
		}
		
		return btnPayPal;
	}
	
	/**
	 * Devuelve o crea el panel para iniciar sesión con PayPal, si no está creado
	 * @return Panel para iniciar sesión con PayPal, de tipo JPanel
	 */
	private JPanel getPnPayPal() {
		if (pnPayPal == null) {
			pnPayPal = new JPanel();
			pnPayPal.setLayout(null);
			pnPayPal.add(getLblMail());
			pnPayPal.add(getTextMail());
			pnPayPal.add(getLblPassword());
			pnPayPal.add(getPasswordField());
		}
		
		return pnPayPal;
	}
	
	/**
	 * Devuelve o crea la etiqueta Nombre de usuario:, si no está creada
	 * @return Etiqueta Nombre de usuario:, de tipo JLabel
	 */
	private JLabel getLblMail() {
		if (lblMail == null) {
			lblMail = new JLabel();
			lblMail.setDisplayedMnemonic('E');
			lblMail.setLabelFor(getTextMail());
			lblMail.setBounds(37, 38, 128, 14);
		}
		
		return lblMail;
	}
	
	/**
	 * Devuelve o crea el campo de texto para el nombre de usuario, si no está creado
	 * @return Campo de texto para el nombre de usuario, de tipo JTextField
	 */
	private JTextField getTextMail() {
		if (textMail == null) {
			textMail = new JTextField();
			textMail.setBounds(175, 35, 128, 20);
			textMail.setColumns(10);
		}
		
		return textMail;
	}
	
	/**
	 * Devuelve o crea la etiqueta Contraseña:, si no está creada
	 * @return Etiqueta Contraseña:, de tipo JLabel
	 */
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel();
			lblPassword.setLabelFor(getPasswordField());
			lblPassword.setDisplayedMnemonic('S');
			lblPassword.setBounds(37, 78, 128, 14);
		}
		
		return lblPassword;
	}
	
	/**
	 * Devuelve o crea el campo para introducir la contraseña, si no está creado
	 * @return Campo de introducción de contraseña, de tipo JPasswordField
	 */
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(175, 75, 128, 20);
		}
		
		return passwordField;
	}
	
	/**
	 * Devuelve o crea el botón para pagar con PaySafeCard, si no está creado
	 * @return Botón para pagar con PaySafeCard, de tipo JButton
	 */
	private JButton getBtnPaySafeCard() {
		if (btnPaySafeCard == null) {
			btnPaySafeCard = new JButton("");
			btnPaySafeCard.setMnemonic('2');
			btnPaySafeCard.setIcon(new ImageIcon(new ImageIcon("files/img/paysafecard.png")
					.getImage().getScaledInstance(110, 30, Image.SCALE_SMOOTH)));
			
			// Al pulsarlo, muestra el panel para introducir número de tarjeta
			btnPaySafeCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paymentMethod = "PaySafeCard";
					getPnBtnOtrosMetodos().removeAll();
					repaint();
					((CardLayout) contentPanel.getLayout()).show(contentPanel, "pnPaySafeCard");
				}
			});
		}
		
		return btnPaySafeCard;
	}
	
	/**
	 * Devuelve o crea el panel para pagar con PaySafeCard, si no está creado
	 * @return Panel de introducción de datos de PaySafeCard, tipo JPanel
	 */
	private JPanel getPnPaySafeCard() {
		if (pnPaySafeCard == null) {
			pnPaySafeCard = new JPanel();
			pnPaySafeCard.setLayout(null);
			pnPaySafeCard.add(getLblNumeroPaySafeCard());
			pnPaySafeCard.add(getTextFieldNumeroPaySafeCard());
		}
		
		return pnPaySafeCard;
	}
	
	/**
	 * Devuelve o crea la etiqueta Número PaySafeCard:, si no está creada
	 * @return Etiqueta Número PaySafeCard:, de tipo JLabel
	 */
	private JLabel getLblNumeroPaySafeCard() {
		if (lblNumeroPaySafeCard == null) {
			lblNumeroPaySafeCard = new JLabel();
			lblNumeroPaySafeCard.setLabelFor(getTextFieldNumeroTarjeta());
			lblNumeroPaySafeCard.setBounds(37, 53, 128, 14);
			
			// Se establece el mnemónico en función de la localización
			if (vj.getLang().equals("en")) {
				lblNumeroPaySafeCard.setDisplayedMnemonic('U');
			} else {
				lblNumeroPaySafeCard.setDisplayedMnemonic('R');
			}
		}
		
		return lblNumeroPaySafeCard;
	}
	
	/**
	 * Devuelve o crea el campo de texto para el número PaySafeCard, si no está creado
	 * @return Campo de texto para el número de PaySafeCard, de tipo JTextField
	 */
	private JTextField getTextFieldNumeroPaySafeCard() {
		if (textFieldNumeroPaySafeCard == null) {
			textFieldNumeroPaySafeCard = new JTextField();
			textFieldNumeroPaySafeCard.setBounds(175, 50, 128, 20);
			textFieldNumeroPaySafeCard.setColumns(10);
		}
		
		return textFieldNumeroPaySafeCard;
	}
}