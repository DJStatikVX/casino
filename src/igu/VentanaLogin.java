// Paquete al que pertenece la clase
package igu;

// Importación de clases
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * Diálogo VentanaLogin para el formulario de Inicio de Sesión
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class VentanaLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();	// panel de contenidos
	private VentanaJuego vj;							// juego asociado
	
	// Objeto receptor para el evento según la opción seleccionada
	private ProcesaOpcion po = new ProcesaOpcion();
	private JLabel lblUsername;							// etiqueta Usuario
	private JTextField textFieldUsername;				// campo de texto Usuario
	private JLabel lblPassword;							// etiqueta Contraseña
	private JPasswordField passwordField;				// campo de contraseña
	
	/**
	 * Create the dialog.
	 * @param vj ventana de juego a partir de la que se crea, de tipo VentanaJuego
	 */
	public VentanaLogin(VentanaJuego vj) {
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
		contentPanel.setLayout(null);
		contentPanel.add(getLblUsername());
		contentPanel.add(getTextFieldUsername());
		contentPanel.add(getLblPassword());
		contentPanel.add(getPasswordField());

		// Se instancia y configura el panel inferior de opciones
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		// Se instancia y configura el botón OK (opción por defecto)
		JButton okButton = new JButton("OK");
		okButton.setFocusPainted(false);
		okButton.setActionCommand("OK");
		okButton.addActionListener(po);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		// Se instancia y configura el botón Cancelar
		String cancelText = this.vj.getStrings().getString("opt_cancel");
		JButton cancelButton = new JButton(cancelText);
		cancelButton.setFocusPainted(false);
		cancelButton.setMnemonic('C');
		cancelButton.setActionCommand(cancelText);
		cancelButton.addActionListener(po);
		buttonPane.add(cancelButton);
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
							vj.getStrings().getString("err_login_empty"), 
							vj.getStrings().getString("err_login_title"),
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
		if (getTextFieldUsername().getText().equals("") 
				|| getPasswordField().getPassword().length == 0) {			
			return false;
		}
		
		return true;
	}
	
	/**
	 * Pasa a verificar los datos introducidos en la aplicación
	 */
	private void next() {
		this.vj.login(getTextFieldUsername().getText(), getPasswordField().getPassword());
	}
	
	/**
	 * Modifica el contenido de las cadenas en función del idioma del juego
	 * @param strings paquete de recursos para el idioma, de tipo ResourceBundle
	 */
	private void localizar(ResourceBundle strings) {
		// Modifica el título del panel de contenidos
		contentPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0), 5, true), strings.getString("pn_login_title"), 
				TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		
		// Modifica el nombre de los campos del diálogo
		getLblUsername().setText(strings.getString("pn_login_user"));
		getLblPassword().setText(strings.getString("pn_login_pass"));
	}
	
	/**
	 * Devuelve o crea la etiqueta Nombre de usuario:, si no está creada
	 * @return Etiqueta Nombre de usuario:, de tipo JLabel
	 */
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel();
			lblUsername.setDisplayedMnemonic('U');
			lblUsername.setLabelFor(getTextFieldUsername());
			lblUsername.setBounds(37, 48, 128, 14);
		}
		
		return lblUsername;
	}
	
	/**
	 * Devuelve o crea el campo de texto para el nombre de usuario, si no está creado
	 * @return Campo de texto para el nombre de usuario, de tipo JTextField
	 */
	private JTextField getTextFieldUsername() {
		if (textFieldUsername == null) {
			textFieldUsername = new JTextField();
			textFieldUsername.setBounds(175, 45, 128, 20);
			textFieldUsername.setColumns(10);
		}
		
		return textFieldUsername;
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
			lblPassword.setBounds(37, 88, 128, 14);
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
			passwordField.setBounds(175, 85, 128, 20);
		}
		
		return passwordField;
	}
}