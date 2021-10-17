// Paquete al que pertenece la clase
package igu;

// Importación de clases
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import com.jtattoo.plaf.noire.NoireLookAndFeel;

import javazoom.jlgui.basicplayer.BasicPlayer;
import logica.Bebida;
import logica.Carta;
import logica.Cliente;
import logica.Database;
import logica.Ficha;
import logica.Juego;
import logica.Pedido;
import player.MusicPlayer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;

import javax.help.*;
import java.net.*;
import java.io.*;

/**
 * Clase VentanaJuego sobre la que se desarrolla toda la interfaz del juego
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class VentanaJuego extends JFrame {
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	private Font fuenteDigital;		// fuente especial Montserrat
	
	private Cliente user;			// cliente usuario de la aplicación
	private boolean pagoVinculado;	// si el cliente ha vinculado algún método
	private Database db;			// base de datos de usuario
	private Carta carta;			// carta de fichas
	private Juego game;				// gestor de las apuestas
	
	private ResourceBundle strings;	// paquete de localización
	private String lang;			// idioma del usuario

	private JPanel contentPane;		// panel principal de contenidos
	private MusicPlayer player;		// reproductor de música
	private boolean muted = false;	// indica si está silenciada la música
	private JPanel pnContenidos;	// panel de contenidos
	private JMenuBar menuBar;		// barra de menús
	private JMenu mnJuego;			// menú Juego
	private JMenuItem mntmExit;		// opción Salir del menú Juego
	private JPanel pnInicio;		// primer panel en la interfaz
	private JPanel pnInicioBotones; // panel con botones del primer panel
	private JButton btnStart;		// botón para ir al acceso de usuario
	private JButton btnHowToPlay;	// botón ¿Cómo jugar?
	private JButton btnAboutUs;		// botón Sobre nosotros
	private JLabel lblLogo;			// etiqueta con el logo del juego
	private JPanel pnInicioIzda;	// panel oeste del panel de inicio
	private JPanel pnInicioDcha;	// panel este del panel de inicio
	private JPanel pnInicioSur;		// panel sur del panel de inicio
	private JButton btnSalir;		// botón Salir del panel de inicio
	private JButton btnMusic;		// botón para reproducir/pausar música
	private JMenuItem mntmBanca;	// opción de menú para ir a la banca
	private JMenuItem mntmBebidas;	// opción de menú para ir a las bebidas
	// private JMenuItem mntmNRonda;// opción de menú para empezar nueva ronda
	
	private JSeparator separatorMnJuego;	// separador en el menú Juego
	
	private JMenu mnUsuario;			// menú Usuario
	private JMenuItem mntmLinkCard;		// opción Vincular tarjeta
	private JMenuItem mntmLogOut;		// opción Cerrar sesión
	
	private JMenu mnIdioma;				// menú Idioma
	private JRadioButton rdbtnSpanish;	// opción Español
	private JRadioButton rdbtnEnglish;	// opción English
	
	// Objeto receptor para el evento de cambio de idioma
	private ProcesaCambiarIdioma pci = new ProcesaCambiarIdioma();
	
	// Objeto receptor para la reproducción continua de música
	private ProcesaMusica pm = new ProcesaMusica();
	
	private JMenu mnHelp;				// menú Ayuda
	private JMenuItem mntmContenidos;	// opción Contenidos
	private JMenuItem mntmAbout;		// opción Acerca de
	private JSeparator separatorMnHelp;	// separador en el menú Ayuda
	
	private JPanel pnInicioAcceso;		// segundo panel para login o registro
	private JButton btnLogin;			// botón Iniciar Sesión
	private JButton btnRegistro;		// botón Registrarse
	private JButton btnAtras;			// botón Atrás para volver a 1ª pantalla
	
	// Panel principal
	private JPanel pnJuego;
	private JPanel pnJuegoNorte;
	private JLabel lblLogo2;
	private JButton btnMusic2;
	private JPanel pnJuegoCentro;
	private JButton btnRuleta;
	private JPanel pnJuegoSur;
	private JButton btnCerrarSesion;
	private JPanel pnSaldo;
	private JLabel lblSaldoDisponible;
	private JButton btnVincularTarjeta;
	private JPanel pnBotonesFichas;
	private JRadioButton rdbtnFicha5;
	private JRadioButton rdbtnFicha10;
	private JRadioButton rdbtnFicha20;
	private JRadioButton rdbtnFicha50;
	private JRadioButton rdbtnFicha100;
	private JPanel pnIconosFichas;
	private JPanel pnJuegoFichas;
	private JLabel lblFicha5;
	private JLabel lblFicha10;
	private JLabel lblFicha20;
	private JLabel lblFicha50;
	private JLabel lblFicha100;
	private JPanel pnCuentaFichas;
	private JLabel lblCountFichas5;
	private JLabel lblCountFichas10;
	private JLabel lblCountFichas20;
	private JLabel lblCountFichas50;
	private JLabel lblCountFichas100;
	private JPanel pnJuegoOpciones;
	private JButton btnComprarFichas;
	private JButton btnRecargarSaldo;
	private JButton btnPedirBebida;
	private JPanel pnTablero;
	
	// Comprar Fichas
	private JPanel pnComprarFichas;
	private JPanel pnComprarFichasLogo;
	private JLabel lblComprarFichasLogo;
	private JPanel pnComprarFichasSeleccion;
	private JPanel pnComprarFichas5;
	private JLabel lblComprarFichas5;
	private JSpinner spinnerComprarFichas5;
	private JTextField textFieldComprarFichas5;
	private JPanel pnComprarFichas10;
	private JLabel lblComprarFichas10;
	private JSpinner spinnerComprarFichas10;
	private JTextField textFieldComprarFichas10;
	private JPanel pnComprarFichas20;
	private JLabel lblComprarFichas20;
	private JSpinner spinnerComprarFichas20;
	private JTextField textFieldComprarFichas20;
	private JPanel pnComprarFichas50;
	private JLabel lblComprarFichas50;
	private JSpinner spinnerComprarFichas50;
	private JTextField textFieldComprarFichas50;
	private JPanel pnComprarFichas100;
	private JLabel lblComprarFichas100;
	private JSpinner spinnerComprarFichas100;
	private JTextField textFieldComprarFichas100;
	private JPanel pnComprarFichasSur;
	private JLabel lblComprarFichasMetodoPago;
	private JButton btnComprarFichasComprar;
	private JButton btnComprarFichasCancelar;
	private JPanel pnComprarFichasBotones;
	private JPanel pnComprarFichasCalculos;
	private JPanel pnComprarFichasSaldo;
	private JPanel pnComprarFichasSaldoSub1;
	private JPanel pnComprarFichasSaldoSub1Saldo;
	private JPanel pnComprarFichasSaldoSub1Precio;
	private JLabel lblComprarFichasSaldo;
	private JTextField textFieldComprarFichasSaldo;
	private JLabel lblComprarFichasPrecio;
	private JTextField textFieldComprarFichasPrecio;
	private JPanel pnComprarFichasSaldoFinal;
	private JLabel lblComprarFichasSaldoFinal;
	private JTextField textFieldComprarFichasSaldoFinal;
	private JPanel pnComprarFichasValor;
	private JPanel pnComprarFichasValorInicial;
	private JPanel pnComprarFichasValorInicialSub;
	private JLabel lblComprarFichasValorInicial;
	private JTextField textFieldComprarFichasValorInicial;
	private JPanel pnComprarFichasValorAñadido;
	private JLabel lblComprarFichasValorAñadido;
	private JTextField textFieldComprarFichasValorAñadido;
	private JPanel pnComprarFichasValorFinal;
	private JLabel lblComprarFichasValorFinal;
	private JTextField textFieldComprarFichasValorFinal;
	private JPanel pnComprarFichasEste;
	
	// Objeto receptor para activar el botón de Comprar fichas
	private ProcesaComprarFichas pcf = new ProcesaComprarFichas();
	
	// Objeto receptor para vincular tarjeta cuando no hay método vinculado
	private ProcesaVincularTarjeta pvt = new ProcesaVincularTarjeta();
	
	// Objeto receptor para exportar saldo tras vincular un método de pago
	private ProcesaExportarSaldo pes = new ProcesaExportarSaldo();
	
	// Cargar Saldo
	private JPanel pnCargarSaldo;
	private JPanel pnCargarSaldoLogo;
	private JLabel lblCargarSaldoLogo;
	private JLabel lblCargarSaldoTitle;
	private JPanel pnCargarSaldoSeleccion;
	private JLabel lblCargarSaldoAñadir;
	private JTextField textFieldCargarSaldoAñadir;
	private JPanel pnCargarSaldoBotones;
	private JLabel lblCargarSaldoMetodoPago;
	private JButton btnCargarSaldoAñadir;
	private JButton btnCargarSaldoCancelar;
	
	// Objeto receptor para evitar añadir saldo vacío
	private ProcesaPulsaTecla ppt = new ProcesaPulsaTecla();
	
	// Pedir Bebidas
	private JPanel pnBebidas;
	private JPanel pnBebidasOeste;
	private JPanel pnBebidasOesteLogo;
	private JLabel lblPnBebidasLogo;
	private JLabel lblPnBebidasMetodoPago;
	private JPanel pnBebidasSaldo;
	private JLabel lblPnBebidasSaldo;
	private JScrollPane scrollPaneBebidasEste;
	private JPanel pnBebidasEste;
	
	private Pedido pedido;		// pedido del cliente
	
	// Objeto receptor para añadir una bebida de un botón al pedido
	private ProcesaAñadirBebida pab = new ProcesaAñadirBebida();
	
	private JPanel pnBebidasPedido;
	private JPanel pnBebidasBotones;
	private JButton btnBebidasPedir;
	private JButton btnBebidasCancelar;
	private JPanel pnBebidasListaPedido;
	private JLabel lblBebidasPedido;
	private JScrollPane scrollPaneBebidasPedido;
	private JPanel pnBebidasListaPedidoPrecio;
	private JPanel pnBebidasPrecio;
	private JPanel pnBebidasPrecioSaldo;
	private JPanel pnBebidasPrecioSaldo1;
	private JLabel lblBebidasPrecio;
	private JTextField textFieldBebidasPrecio;
	private JPanel pnBebidasPrecioSaldo2;
	private JLabel lblBebidasSaldoFinal;
	private JTextField textFieldBebidasSaldoFinal;
	private JLabel lblBebidasSinSaldo;
	private JList<Bebida> listBebidasPedido;
	private DefaultListModel<Bebida> modeloListaPedido;
	
	// Si el usuario ha añadido o eliminado algún artículo del pedido
	private boolean interactedWithOrder = false;
	
	// Objeto receptor para la eliminación de bebidas del pedido
	private ProcesaBorrarBebida pbb = new ProcesaBorrarBebida();
	
	// Tapete del juego
	private JButton btnPnTableroBtn0;
	private JPanel pnTableroNumeros;
	private JButton btnPnTableroBtn1;
	private JButton btnPnTableroBtn2;
	private JButton btnPnTableroBtn3;
	private JButton btnPnTableroBtn4;
	private JButton btnPnTableroBtn5;
	private JButton btnPnTableroBtn6;
	private JButton btnPnTableroBtn7;
	private JButton btnPnTableroBtn8;
	private JButton btnPnTableroBtn9;
	private JButton btnPnTableroBtn10;
	private JButton btnPnTableroBtn11;
	private JButton btnPnTableroBtn12;
	private JButton btnPnTableroBtn13;
	private JButton btnPnTableroBtn14;
	private JButton btnPnTableroBtn15;
	private JButton btnPnTableroBtn16;
	private JButton btnPnTableroBtn17;
	private JButton btnPnTableroBtn18;
	private JButton btnPnTableroBtn19;
	private JButton btnPnTableroBtn20;
	private JButton btnPnTableroBtn21;
	private JButton btnPnTableroBtn22;
	private JButton btnPnTableroBtn23;
	private JButton btnPnTableroBtn24;
	private JButton btnPnTableroBtn25;
	private JButton btnPnTableroBtn26;
	private JButton btnPnTableroBtn27;
	private JButton btnPnTableroBtn28;
	private JButton btnPnTableroBtn29;
	private JButton btnPnTableroBtn30;
	private JButton btnPnTableroBtn31;
	private JButton btnPnTableroBtn32;
	private JButton btnPnTableroBtn33;
	private JButton btnPnTableroBtn34;
	private JButton btnPnTableroBtn35;
	private JButton btnPnTableroBtn36;
	private JPanel pnTablero2a1;
	private JButton btnPnTableroBtn2a1_1;
	private JButton btnPnTableroBtn2a1_2;
	private JButton btnPnTableroBtn2a1_3;
	private JPanel pnTableroInferior;
	private JButton btnPnTableroPrimeraDocena;
	private JButton btnPnTableroSegundaDocena;
	private JButton btnPnTableroTerceraDocena;
	private JButton btnPnTablero1al18;
	private JButton btnPnTableroPar;
	private JButton btnPnTableroNegro;
	private JButton btnPnTableroRojo;
	private JButton btnPnTableroImpar;
	private JButton btnPnTablero19al36;
	private JPanel pnTableroInferiorSub1;
	private JPanel pnTableroInferiorSub2;
	private JPanel pnTableroInferiorSub3;
	private JPanel pnBebidasObservaciones;
	private JLabel lblPnBebidasObservaciones;
	private JTextArea textAreaObservaciones;
	private JButton btnPnTableroApostar;
	
	// Objetos receptores de eventos para las apuestas
	private ProcesaGestionarApuesta pga = new ProcesaGestionarApuesta();
//	private ProcesaRuletaSinApuesta prsa = new ProcesaRuletaSinApuesta();
	private ProcesaRuletaConApuesta prca = new ProcesaRuletaConApuesta();
	private ProcesaFijarApuesta pfa = new ProcesaFijarApuesta();
	
	/**
	 * Launch the application.
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties props = new Properties();
					props.put("logoString", "");
					NoireLookAndFeel.setCurrentTheme(props);
					UIManager.setLookAndFeel(
							"com.jtattoo.plaf.noire.NoireLookAndFeel");
					VentanaJuego frame = new VentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		
		// Al pulsar el botón de la X, cierra sesión si hay alguna iniciada
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (user != null) {
					logOut();
				}
			}
		});
		
		// Carga la fuente especial
		cargarFuente();
		
		// Tamaño mínimo para la correcta visualización de componentes
		setMinimumSize(new Dimension(900, 535));
		
		// Primero, se intenta localizar acorde al usuario
		localizar(Locale.getDefault(Locale.Category.FORMAT));
		Locale.setDefault(new Locale("es"));
		
		// Se establecen las propiedades de la ventana y se añaden los paneles
		setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("files/img/icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 600);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		
		// Se instancia la carta de bebidas
		carta = new Carta();
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.add(getPnContenidos());
		setContentPane(contentPane);
		((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pnInicio");
		
		// Se instancia el reproductor de música
		player = new MusicPlayer();
		addMouseMotionListener(pm);
		
		// Comienza la partida sin medio de pago vinculado
		pagoVinculado = false;
		
		// Inicializa el juego
		game = new Juego();
		
		// Se carga la ayuda
		cargarAyuda();
	}
	
	/**
	 * Carga la ayuda en línea para el usuario
	 */
	private void cargarAyuda() {
		URL hsURL;
		HelpSet hs;
		
		try {
			File fichero = new File("help/Ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		} catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}
		
		HelpBroker hb = hs.createHelpBroker();
		
		hb.enableHelpKey(getRootPane(), "introduccion", hs);
		hb.enableHelpOnButton(getMntmContenidos(), "introduccion", hs);
		hb.enableHelpOnButton(getBtnHowToPlay(), "inicio_registro", hs);
		
		// Ayuda sensible al contexto
		hb.enableHelp(getBtnLogin(), "inicio_registro", hs);
		hb.enableHelp(getBtnRegistro(), "inicio_registro", hs);
		hb.enableHelp(getPnJuegoCentro(), "juego_apuestas", hs);
		hb.enableHelp(getPnJuegoFichas(), "juego_apuestas", hs);
		hb.enableHelp(getPnJuego(), "pantalla_principal", hs);
		hb.enableHelp(getPnComprarFichas(), "comprar_fichas", hs);
		hb.enableHelp(getPnCargarSaldo(), "saldo", hs);
		hb.enableHelp(getPnBebidas(), "pedir_bebidas", hs);
	}
	
	/**
	 * Carga la fuente especializada de la aplicación
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
	 * Clase receptora de eventos para el cambio de idioma a través del menú
	 * @author Samuel Rodríguez Ares (UO271612)
	 */
	class ProcesaCambiarIdioma implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			localizar(new Locale(e.getActionCommand()));
		}
	}
	
	/**
	 * Clase receptora de eventos para mantener una reproducción musical
	 * constante, siempre y cuando el usuario permanezca activo
	 * @author Samuel Rodríguez Ares (UO271612)
	 */
	class ProcesaMusica extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			if (!muted && player.getStatus() == BasicPlayer.STOPPED) {
				player.checkPlayTime();
			}
		}
	}
	
	/**
	 * Clase receptora para los botones del tapete, que envía
	 * a la lógica del juego la información de la casilla pulsada
	 * y la ficha seleccionada al pulsar
	 */
	class ProcesaGestionarApuesta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (game.isCasillaVacia(Integer.parseInt(e.getActionCommand()))) {
				realizarApuesta(e.getActionCommand(), (JButton) e.getSource());
			} else {
				if (game.getTablero()[Integer.parseInt(e.getActionCommand())]
						.getValorFichaApostada() == getFichaSeleccionada()) {
					retirarApuesta(e.getActionCommand(), (JButton) e.getSource());
				}
			}
		}
	}
	
	/**
	 * Clase receptora de eventos que actualizan
	 * los saldos y valores calculados al comprar fichas
	 */
	class ProcesaComprarFichas implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			if (!getBtnComprarFichasComprar().isEnabled()) {
				getBtnComprarFichasComprar().setEnabled(true);
			}
			
			actualizaCalculosComprarFichas();
		}
	}
	
	/**
	 * Clase receptora de eventos para la fijación de apuestas
	 */
	class ProcesaFijarApuesta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (hayAlgoApostado()) {
				fijarApuesta();
			} else {
				JOptionPane.showMessageDialog(null, strings.getString("dialog_no_bet_msg"),
						strings.getString("dialog_no_fix_bet_title"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Clase receptora para el giro de ruleta sin fichas apostadas
	 */
	class ProcesaRuletaSinApuesta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, 
					strings.getString("dialog_no_bet_msg"), 
					strings.getString("dialog_no_bet_title"), 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Clase receptora para el giro de ruleta con fichas apostadas
	 */
	class ProcesaRuletaConApuesta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			girarRuleta();
		}
	}
	
	/**
	 * Clase receptora al pulsar el botón de Vincular Tarjeta
	 */
	class ProcesaVincularTarjeta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showVincularTarjeta();
		}
	}
	
	/**
	 * Clase receptora al pulsar el botón de Exportar Saldo
	 */
	class ProcesaExportarSaldo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			exportarSaldo();
		}
	}
	
	/**
	 * Clase receptora al pulsar una tecla en el campo de texto de cargar saldo
	 */
	class ProcesaPulsaTecla extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (pagoVinculado) {
				getBtnCargarSaldoAñadir().setEnabled(true);
			}
		}
	}
	
	/**
	 * Clase receptora al pulsar un botón en el menú de bebidas
	 */
	class ProcesaAñadirBebida implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			addToCart(Integer.parseInt(btn.getActionCommand()));
		}
	}
	
	/**
	 * Clase receptora para borrar bebidas del pedido al pulsar Supr
	 */
	class ProcesaBorrarBebida extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_DELETE) {
				borrarBebida();
			}
		}
	}
	
	/**
	 * Adapta los contenidos de la interfaz a la localización pasada como parámetro
	 * @param localizacion localización sobre la que se adaptan los contenidos (Locale)
	 */
	private void localizar(Locale localizacion) {
		// Se obtiene el paquete de recursos del idioma correspondiente
		strings = ResourceBundle.getBundle("rcs/strings", localizacion);
		
		// Modificación de los textos de la interfaz
		lang = strings.getString("lang");
		getRdbtnEnglish().setSelected(lang.equals("en"));
		setTitle("Casino: " + strings.getString("window_title"));
		getMnJuego().setText(strings.getString("menu_juego"));
		getMntmExit().setText(strings.getString("menu_item_exit"));
		getBtnStart().setText(strings.getString("btn_start"));
		getBtnHowToPlay().setText(strings.getString("btn_how_to_play"));
		getBtnAboutUs().setText(strings.getString("btn_about_us"));
		getBtnSalir().setText(strings.getString("btn_exit"));
		getBtnMusic().setToolTipText(strings.getString("btn_music_tooltip"));
		getBtnMusic2().setToolTipText(strings.getString("btn_music_tooltip"));
		getBtnSalir().setToolTipText(strings.getString("btn_exit_tooltip"));
		getMntmBanca().setText(strings.getString("menu_item_banca"));
		getMntmBebidas().setText(strings.getString("menu_item_bebidas"));
//		getMntmNRonda().setText(strings.getString("menu_item_round"));
		getMnUsuario().setText(strings.getString("menu_usuario"));
		getMntmLinkCard().setText(strings.getString("btn_link_card"));
		getMntmLogOut().setText(strings.getString("menu_item_log_out"));
		getMnIdioma().setText(strings.getString("menu_idioma"));
		getMnHelp().setText(strings.getString("menu_ayuda"));
		getMntmContenidos().setText(strings.getString("menu_item_contenidos"));
		getMntmAbout().setText(strings.getString("menu_item_about"));
		getBtnLogin().setText(strings.getString("btn_login"));
		getBtnRegistro().setText(strings.getString("btn_registro"));
		getBtnAtras().setText(strings.getString("btn_back"));
		getBtnCerrarSesion().setText(strings.getString("btn_exit"));
		
		if (user != null) {
			getLblSaldoDisponible().setText(strings.getString("lbl_balance") 
					+ user.getBalance() + "€");
		}
		
		if (!pagoVinculado) {
			getBtnVincularTarjeta().setText(strings.getString("btn_link_card"));
		} else {
			getBtnVincularTarjeta().setText(strings.getString("btn_export_balance"));
		}
		
		getBtnComprarFichas().setText(strings.getString("btn_buy_tokens"));
		getBtnRecargarSaldo().setText(strings.getString("btn_cargar_saldo"));
		getBtnPedirBebida().setText(strings.getString("btn_pedir_bebida"));
		
		getLblComprarFichasLogo().setText(strings.getString("btn_buy_tokens"));
		getLblComprarFichasMetodoPago().setText(strings.getString("lbl_no_linked_mean"));
		getBtnComprarFichasComprar().setText(strings.getString("btn_buy"));
		getBtnComprarFichasCancelar().setText(strings.getString("opt_cancel"));
		getPnComprarFichasSeleccion().setToolTipText(strings.getString("tooltip_buy_tokens"));
		getLblComprarFichasSaldo().setText(strings.getString("lbl_balance_buy"));
		getLblComprarFichasPrecio().setText(strings.getString("lbl_price_tokens"));
		getLblComprarFichasSaldoFinal().setText(strings.getString("lbl_balance_result"));
		getLblComprarFichasValorInicial().setText(strings.getString("lbl_value_buy"));
		getLblComprarFichasValorAñadido().setText(strings.getString("lbl_value_add"));
		getLblComprarFichasValorFinal().setText(strings.getString("lbl_value_result"));
		
		getLblCargarSaldoLogo().setText(strings.getString("lbl_charge_balance"));
		getLblCargarSaldoTitle().setText(strings.getString("lbl_charge_title"));
		getLblCargarSaldoAñadir().setText(strings.getString("lbl_balance_to_add"));
		getLblCargarSaldoMetodoPago().setText(strings.getString("lbl_no_linked_mean"));
		getBtnCargarSaldoAñadir().setText(strings.getString("btn_add"));
		getBtnCargarSaldoCancelar().setText(strings.getString("opt_cancel"));
		
		getLblPnBebidasLogo().setText(strings.getString("lbl_drinks_logo"));
		getLblPnBebidasMetodoPago().setText(strings.getString("lbl_no_linked_mean"));
		getLblBebidasPedido().setText(strings.getString("lbl_drinks_field"));
		getListBebidasPedido().setToolTipText(strings.getString("tooltip_drinks_list"));
		getLblBebidasPrecio().setText(strings.getString("lbl_drinks_price"));
		getLblBebidasSaldoFinal().setText(strings.getString("lbl_drinks_result"));
		getLblBebidasSinSaldo().setText(strings.getString("lbl_not_enough_balance"));
		getBtnBebidasPedir().setText(strings.getString("btn_drinks_order"));
		getBtnBebidasCancelar().setText(strings.getString("opt_cancel"));
		getLblPnBebidasSaldo().setText(strings.getString("lbl_balance_buy"));
		getLblPnBebidasObservaciones().setText(strings.getString("lbl_drinks_comments"));
		
		getBtnRuleta().setToolTipText(strings.getString("tooltip_roulette"));
		getBtnPnTableroApostar().setText(strings.getString("btn_game_bet"));
		getBtnPnTableroApostar().setToolTipText(strings.getString("tooltip_bet"));
		getPnJuegoFichas().setToolTipText(strings.getString("tooltip_buttons"));
		getBtnPnTableroBtn2a1_1().setText(strings.getString("btn_board_2a1"));
		getBtnPnTableroBtn2a1_2().setText(strings.getString("btn_board_2a1"));
		getBtnPnTableroBtn2a1_3().setText(strings.getString("btn_board_2a1"));
		getBtnPnTableroPrimeraDocena().setText(strings.getString("btn_board_dozen_1"));
		getBtnPnTableroSegundaDocena().setText(strings.getString("btn_board_dozen_2"));
		getBtnPnTableroTerceraDocena().setText(strings.getString("btn_board_dozen_3"));
		getBtnPnTableroPar().setText(strings.getString("btn_board_pair"));
		getBtnPnTableroImpar().setText(strings.getString("btn_board_odd"));
		getBtnPnTableroNegro().setToolTipText(strings.getString("tooltip_board_black"));
		getBtnPnTableroRojo().setToolTipText(strings.getString("tooltip_board_red"));

		if (user != null) {
			getLblPnBebidasSaldo().setText(strings.getString("lbl_balance_buy")
					+ user.getBalance() + "€");
		}
		
		// Adaptación de mnemónicos a la localización
		getBtnStart().setMnemonic(strings.getString("mnem_start").charAt(0));
		getBtnHowToPlay().setMnemonic(strings.getString("mnem_how_to_play").charAt(0));
		getBtnAboutUs().setMnemonic(strings.getString("mnem_about_us").charAt(0));
		getMntmExit().setMnemonic(strings.getString("mnem_mntm_exit").charAt(0));
		getMntmLogOut().setMnemonic(strings.getString("mnem_mntm_log_out").charAt(0));
		getMnIdioma().setMnemonic(strings.getString("mnem_menu_lang").charAt(0));
		getMnHelp().setMnemonic(strings.getString("mnem_menu_help").charAt(0));
		getBtnLogin().setMnemonic(strings.getString("mnem_login").charAt(0));
		getBtnRegistro().setMnemonic(strings.getString("mnem_signup").charAt(0));
		getBtnAtras().setMnemonic(strings.getString("mnem_back").charAt(0));
		getBtnRecargarSaldo().setMnemonic(strings.getString("mnem_charge_balance").charAt(0));
		getLblCargarSaldoAñadir().setDisplayedMnemonic(strings.getString("mnem_charge_lbl").charAt(0));
		getBtnCargarSaldoAñadir().setMnemonic(strings.getString("mnem_charge_add").charAt(0));
		getBtnComprarFichasComprar().setMnemonic(strings.getString("mnem_tokens_buy").charAt(0));
		
		// changeMnemonics();
	}
	
	/**
	 * Devuelve el idioma establecido en forma de cadena
	 * @return Localización establecida por el usuario, de tipo String
	 */
	public String getLang() {
		return this.lang;
	}
	
	/**
	 * Devuelve el paquete de recursos de localización utilizado
	 * @return Paquete de recursos de localización establecida, tipo ResourceBundle
	 */
	public ResourceBundle getStrings() {
		return this.strings;
	}
	
//	/**
//	 * Adapta todos los mnemónicos de los botones y menús de la interfaz
//	 * tras realizar un cambio en la localización de la aplicación
//	 */
//	private void changeMnemonics() {
//		// Botón Comenzar
//		if (lang.equals("en")) {
//			btnStart.setMnemonic('S');
//		} else {
//			btnStart.setMnemonic('O');
//		}
//		
//		// Botón ¿Cómo Jugar?
//		if (lang.equals("en")) {
//			btnHowToPlay.setMnemonic('H');
//		} else {
//			btnHowToPlay.setMnemonic('C');
//		}
//		
//		// Botón Sobre Nosotros
//		if (lang.equals("en")) {
//			btnAboutUs.setMnemonic('A');
//		} else {
//			btnAboutUs.setMnemonic('S');
//		}
//		
//		// Opción Salir del menú Juego
//		if (lang.equals("en")) {
//			mntmExit.setMnemonic('E');
//		} else {
//			mntmExit.setMnemonic('L');
//		}
//		
//		// Opción Cerrar sesión del menú Usuario
//		if (lang.equals("en")) {
//			mntmLogOut.setMnemonic('O');
//		} else {
//			mntmLogOut.setMnemonic('E');
//		}
//		
//		// Menú Idioma
//		if (lang.equals("en")) {
//			mnIdioma.setMnemonic('L');
//		} else {
//			mnIdioma.setMnemonic('D');
//		}
//		
//		// Menú Ayuda
//		if (lang.equals("en")) {
//			mnHelp.setMnemonic('E');
//		} else {
//			mnHelp.setMnemonic('A');
//		}
//		
//		// Botón Iniciar Sesión
//		if (lang.equals("en")) {
//			btnLogin.setMnemonic('O');
//		} else {
//			btnLogin.setMnemonic('N');
//		}
//		
//		// Botón Registrarse
//		if (lang.equals("en")) {
//			btnRegistro.setMnemonic('P');
//		} else {
//			btnRegistro.setMnemonic('R');
//		}
//		
//		// Botón Atrás
//		if (lang.equals("en")) {
//			btnAtras.setMnemonic('B');
//		} else {
//			btnAtras.setMnemonic('T');
//		}
//		
//		// Botón Recargar Saldo
//		if (lang.equals("en")) {
//			btnRecargarSaldo.setMnemonic('H');
//		} else {
//			btnRecargarSaldo.setMnemonic('S');
//		}
//		
//		// Botón Añadir en Cargar Saldo
//		if (lang.equals("en")) {
//			btnCargarSaldoAñadir.setMnemonic('D');
//		} else {
//			btnCargarSaldoAñadir.setMnemonic('R');
//		}
//		
//		// Botón Comprar en Comprar Fichas
//		if (lang.equals("en")) {
//			btnComprarFichasComprar.setMnemonic('Y');
//		} else {
//			btnComprarFichasComprar.setMnemonic('M');
//		}
//	}

	/**
	 * Devuelve o crea el panel de contenidos, si no está creado
	 * @return Panel de contenidos, de tipo JPanel
	 */
	private JPanel getPnContenidos() {
		if (pnContenidos == null) {
			// Se establecen sus propiedades y se añaden los paneles a alternar
			pnContenidos = new JPanel();
			pnContenidos.setVisible(true);
			pnContenidos.setBackground(new Color(128, 0, 0));
			pnContenidos.setLayout(new CardLayout(0, 0));
			pnContenidos.add(getPnInicio(), "pnInicio");
			pnContenidos.add(getPnJuego(), "pnJuego");
			pnContenidos.add(getPnComprarFichas(), "pnComprarFichas");
			pnContenidos.add(getPnCargarSaldo(), "pnCargarSaldo");
			pnContenidos.add(getPnBebidas(), "pnBebidas");
		}
		
		return pnContenidos;
	}
	
	/**
	 * Devuelve o crea la barra de menús del juego, si no está creada
	 * @return Barra de menús, de tipo JMenuBar
	 */
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			
			// Se añaden los menús correspondientes
			menuBar.add(getMnJuego());
			menuBar.add(getMnUsuario());
			menuBar.add(getMnIdioma());
			menuBar.add(getMnHelp());
		}
		
		return menuBar;
	}
	
	/**
	 * Devuelve o crea el menú Juego, si no está creado
	 * @return Menú Juego, de tipo JMenu
	 */
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu();
			mnJuego.setMnemonic('G');
			
			// Se añaden las opciones del menú
			mnJuego.add(getMntmBanca());
			mnJuego.add(getMntmBebidas());
//			mnJuego.add(getMntmNRonda());
			mnJuego.add(getSeparatorMnJuego());
			mnJuego.add(getMntmExit());
		}
		
		return mnJuego;
	}
	
	/**
	 * Devuelve o crea la opción Salir del menú Juego, si no está creada
	 * @return Opción Salir del menú Juego, de tipo JMenuItem
	 */
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				mntmExit.setMnemonic('E');
			} else {
				mntmExit.setMnemonic('L');
			}
			
			// Al pulsarlo, termina el programa
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (user != null) {
						logOut();
					}
					
					System.exit(0);
				}
			});
		}
		
		return mntmExit;
	}

	/**
	 * Devuelve o crea el primer panel de la aplicación, si no está creado
	 * @return Primer panel de la aplicación, de tipo JPanel
	 */
	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setBorder(new MatteBorder(40, 15, 15, 15, (Color) new Color(128, 0, 0)));
			pnInicio.setBackground(new Color(128, 0, 0));
			pnInicio.setLayout(new BorderLayout(200, 50));
			
			// Se añaden los componentes del panel en cada posición
			pnInicio.add(getPnInicioBotones(), BorderLayout.CENTER);
			pnInicio.add(getLblLogo(), BorderLayout.NORTH);
			pnInicio.add(getPnInicioIzda(), BorderLayout.WEST);
			pnInicio.add(getPnInicioDcha(), BorderLayout.EAST);
			pnInicio.add(getPnInicioSur(), BorderLayout.SOUTH);
		}
		
		return pnInicio;
	}
	
	/**
	 * Devuelve o crea el panel de botones del panel de inicio, si no está creado
	 * @return Panel de botones del panel de inicio, de tipo JPanel
	 */
	private JPanel getPnInicioBotones() {
		if (pnInicioBotones == null) {
			pnInicioBotones = new JPanel();
			pnInicioBotones.setBackground(new Color(128, 0, 0));
			pnInicioBotones.setLayout(new GridLayout(3, 1, 0, 20));
			
			// Se añaden los botones al panel
			pnInicioBotones.add(getBtnStart());
			pnInicioBotones.add(getBtnHowToPlay());
			pnInicioBotones.add(getBtnAboutUs());
		}
		
		return pnInicioBotones;
	}
	
	/**
	 * Devuelve o crea el panel de botones del acceso de usuario, si no está creado
	 * @return Panel de botones del acceso de usuario, de tipo JPanel
	 */
	private JPanel getPnInicioAcceso() {
		if (pnInicioAcceso == null) {
			pnInicioAcceso = new JPanel();
			pnInicioAcceso.setBackground(new Color(128, 0, 0));
			pnInicioAcceso.setLayout(new GridLayout(3, 1, 0, 20));
			
			// Se añaden los botones al panel
			pnInicioAcceso.add(getBtnLogin());
			pnInicioAcceso.add(getBtnRegistro());
			pnInicioAcceso.add(getBtnAtras());
		}
		
		return pnInicioAcceso;
	}
	
	/**
	 * Devuelve o crea el botón Iniciar Sesión, si no está creado
	 * @return Botón Iniciar Sesión, de tipo JButton
	 */
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("");
			btnLogin.setFocusPainted(false);
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 20);
			btnLogin.setFont(fuente);
			btnLogin.setBackground(new Color(0, 0, 0));
			btnLogin.setForeground(new Color(255, 255, 255));
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				btnLogin.setMnemonic('N');
			} else {
				btnLogin.setMnemonic('O');
			}
			
			// Al pulsarlo, se abre un diálogo de inicio de sesión
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showLogin();
				}
			});
		}
		
		return btnLogin;
	}
	
	/**
	 * Devuelve o crea el botón Registrarse, si no está creado
	 * @return Botón Registrarse, de tipo JButton
	 */
	private JButton getBtnRegistro() {
		if (btnRegistro == null) {
			btnRegistro = new JButton("");
			btnRegistro.setFocusPainted(false);
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 18);
			btnRegistro.setFont(fuente);
			btnRegistro.setBackground(new Color(0, 0, 0));
			btnRegistro.setForeground(new Color(255, 255, 255));
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				btnRegistro.setMnemonic('P');
			} else {
				btnRegistro.setMnemonic('R');
			}
			
			// Al pulsarlo, muestra el diálogo de registro
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showRegistro();
				}
			});
		}
		
		return btnRegistro;
	}
	
	/**
	 * Devuelve o crea el botón Atrás, si no está creado
	 * @return Botón Atrás, de tipo JButton
	 */
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("");
			btnAtras.setFocusPainted(false);
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 18);
			btnAtras.setFont(fuente);
			btnAtras.setBackground(Color.DARK_GRAY);
			btnAtras.setForeground(new Color(255, 255, 255));
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				btnAtras.setMnemonic('B');
			} else {
				btnAtras.setMnemonic('T');
			}
			
			// Al pulsarlo, vuelve a la pantalla anterior
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backFromLogin();
				}
			});
		}
		
		return btnAtras;
	}
	
	/**
	 * Devuelve o crea el botón Comenzar, si no está creado
	 * @return Botón Comenzar, de tipo JButton
	 */
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 24);
			btnStart.setFont(fuente);
			btnStart.setForeground(Color.WHITE);
			btnStart.setFocusPainted(false);
			btnStart.setBackground(new Color(0, 0, 0));
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				btnStart.setMnemonic('S');
			} else {
				btnStart.setMnemonic('C');
			}
			
			// Al pulsarlo, muestra las opciones de acceso
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					start();
				}
			});
		}
		
		return btnStart;
	}
	
	/**
	 * Tras pulsar el botón Comenzar, muestra la opción
	 * para iniciar sesión o registrarse
	 */
	private void start() {
		// Primero se reemplaza el primer panel por el segundo
		pnInicio.remove(getPnInicioBotones());
		pnInicio.repaint();
		pnInicio.add(getPnInicioAcceso());
		
		// A continuación, se revalida el panel para reflejar los cambios
		pnInicio.invalidate();
		pnInicio.validate();
	}
	
	/**
	 * Retrocede para volver a la pantalla de inicio
	 */
	private void backFromLogin() {
		// Primero se reemplaza el segundo panel por el primero
		pnInicio.remove(pnInicioAcceso);
		pnInicio.repaint();
		pnInicio.add(getPnInicioBotones());
		
		// A continuación, se revalida el panel para reflejar los cambios
		pnInicio.invalidate();
		pnInicio.validate();
	}
	
	/**
	 * Tras pulsar el botón Iniciar Sesión, muestra el diálogo
	 * de introducción de datos del cliente
	 */
	private void showLogin() {
		// Se prepara la base de datos de usuario
		db = new Database();
		
		// Se muestra el diálogo de inicio de sesión al usuario
		VentanaLogin dialog = new VentanaLogin(this);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	/**
	 * Verifica las credenciales del usuario para el inicio de sesión
	 * @param username nombre de usuario a iniciar sesión, de tipo String
	 * @param password contraseña del usuario a iniciar sesión, de tipo char[]
	 */
	protected void login(String username, char[] password) {
		
		// Si se encontró, se muestra un mensaje de bienvenida y se continúa
		if (db.buscarCliente(username, password) != null) {
			JOptionPane.showMessageDialog(null, strings.getString("ok_login_welcome") 
					+ username + strings.getString("ok_login_msg"), 
					strings.getString("ok_login_title"), JOptionPane.PLAIN_MESSAGE);
			
			user = db.buscarUsuario(username);
			pedido = new Pedido();
			
			nuevaRonda();
			goToMainScreen();
			
		// Si no se encontró, se muestra un aviso y a continuación el formulario
		} else {
			JOptionPane.showMessageDialog(null, strings.getString("err_login_msg"),
					strings.getString("err_login_title"), JOptionPane.ERROR_MESSAGE);
			
			showLogin();
		}
	}
	
	/**
	 * Verifica las credenciales del usuario para el registro en la base de datos
	 * @param fullName nombre completo del usuario, de tipo String
	 * @param DNI número de documentación del usuario, de tipo String
	 * @param userName nombre de usuario a registrar, de tipo String
	 * @param password contraseña del usuario a registrar, de tipo char[]
	 * @param passwordRep contraseña repetida del usuario, de tipo char[]
	 */
	protected void signUp(String fullName, String DNI, String userName,
			char[] password, char[] passwordRep) {
		
		// Si ya se encontró un usuario con ese nombre o DNI, muestra un diálogo
		if (db.buscarUsuario(userName) != null || db.buscarDNI(DNI) != null) {
			JOptionPane.showMessageDialog(null, strings.getString("err_reg_duplicate"),
					strings.getString("err_reg_title"), JOptionPane.ERROR_MESSAGE);
			
			showRegistro();
			
		// Si no lo encontró, comprueba las contraseñas introducidas
		} else {
			
			// Si las contraseñas introducidas no coinciden, muestra un diálogo
			if (!String.valueOf(password).equals(String.valueOf(passwordRep))) {
				JOptionPane.showMessageDialog(null, strings.getString("err_reg_pass"),
						strings.getString("err_reg_title"), JOptionPane.ERROR_MESSAGE);
				
				showRegistro();
				
			// En caso contrario, procede a registrar el usuario
			} else {
				db.registrarUsuario(fullName, DNI, userName, password);
				JOptionPane.showMessageDialog(null, strings.getString("ok_reg_welcome")
						+ userName + strings.getString("ok_reg_msg"), 
						strings.getString("ok_reg_title"), JOptionPane.PLAIN_MESSAGE);
				
				user = db.buscarUsuario(userName);
				
				nuevaRonda();
				goToMainScreen();
			}
		}
	}
	
	/**
	 * Tras pulsar el botón Registrarse, muestra el diálogo
	 * de introducción de datos del cliente
	 */
	private void showRegistro() {
		// Se prepara la base de datos de usuario
		db = new Database();
		
		// Se muestra el diálogo de registro para nuevos usuarios
		VentanaRegistro dialog = new VentanaRegistro(this);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	/**
	 * Cambia el panel mostrado por el principal con el tablero y la ruleta
	 */
	private void goToMainScreen() {
		// Si la opción de menú Banca está deshabilitada, se activa
		if (!getMntmBanca().isEnabled()) {
			getMntmBanca().setEnabled(true);
		}
		
		// Si la opción de menú Bebidas está deshabilitada, se activa
		if (!getMntmBebidas().isEnabled()) {
			getMntmBebidas().setEnabled(true);
		}
		
		// Si la opción Nueva ronda está deshabilitada, se activa
//		if (!getMntmNRonda().isEnabled()) {
//			getMntmNRonda().setEnabled(true);
//		}
		
		getMntmLinkCard().setEnabled(true);
		getMntmLogOut().setEnabled(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		((CardLayout) pnContenidos.getLayout()).show(pnContenidos, "pnJuego");
		getLblSaldoDisponible().setText(strings.getString("lbl_balance") + user.getBalance() + "€");
	}
	
	/**
	 * Devuelve o crea el botón ¿Cómo jugar?, si no está creado
	 * @return Botón ¿Cómo jugar?, de tipo JButton
	 */
	private JButton getBtnHowToPlay() {
		if (btnHowToPlay == null) {
			btnHowToPlay = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			btnHowToPlay.setFont(fuente);
			btnHowToPlay.setForeground(new Color(255, 255, 255));
			btnHowToPlay.setBackground(new Color(0, 0, 0));
			btnHowToPlay.setFocusPainted(false);
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				btnHowToPlay.setMnemonic('H');
			} else {
				btnHowToPlay.setMnemonic('C');
			}
		}
		
		return btnHowToPlay;
	}
	
	/**
	 * Devuelve o crea el botón Sobre Nosotros, si no está creado
	 * @return Botón Sobre Nosotros, de tipo JButton
	 */
	private JButton getBtnAboutUs() {
		if (btnAboutUs == null) {
			btnAboutUs = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			btnAboutUs.setFont(fuente);
			btnAboutUs.setForeground(new Color(255, 255, 255));
			btnAboutUs.setBackground(new Color(0, 0, 0));
			btnAboutUs.setFocusPainted(false);
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				btnAboutUs.setMnemonic('A');
			} else {
				btnAboutUs.setMnemonic('S');
			}
			
			// Al pulsarlo, muestra información sobre la aplicación
			btnAboutUs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showAbout();
				}
			});
		}
		
		return btnAboutUs;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el título del juego, si no está creada
	 * @return Etiqueta con el título del juego, de tipo JLabel
	 */
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel();
			lblLogo.setFont(new Font("Mistral", Font.BOLD, 48));
			lblLogo.setBackground(new Color(255, 255, 255));
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setText("CASINO");
		}
		
		return lblLogo;
	}
	
	/**
	 * Devuelve o crea el panel al oeste del panel de inicio, si no está creado
	 * @return Panel oeste del panel de inicio, de tipo JPanel
	 */
	private JPanel getPnInicioIzda() {
		if (pnInicioIzda == null) {
			pnInicioIzda = new JPanel();
			pnInicioIzda.setBackground(new Color(128, 0, 0));
		}
		
		return pnInicioIzda;
	}
	
	/**
	 * Devuelve o crea el panel al este del panel de inicio, si no está creado
	 * @return Panel este del panel de inicio, de tipo JPanel
	 */
	private JPanel getPnInicioDcha() {
		if (pnInicioDcha == null) {
			pnInicioDcha = new JPanel();
			pnInicioDcha.setBackground(new Color(128, 0, 0));
		}
		
		return pnInicioDcha;
	}
	
	/**
	 * Devuelve o crea el panel al sur del panel de inicio, si no está creado
	 * @return Panel sur del panel de inicio, de tipo JPanel
	 */
	private JPanel getPnInicioSur() {
		if (pnInicioSur == null) {
			pnInicioSur = new JPanel();
			pnInicioSur.setBackground(new Color(128, 0, 0));
			pnInicioSur.setLayout(new BorderLayout(0, 0));
			pnInicioSur.add(getBtnSalir(), BorderLayout.EAST);
			pnInicioSur.add(getBtnMusic(), BorderLayout.WEST);
		}
		
		return pnInicioSur;
	}
	
	/**
	 * Devuelve o crea el botón Salir del panel de inicio, si no está creado
	 * @return Botón Salir del panel de inicio, de tipo JButton
	 */
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 16);
			btnSalir.setFont(fuente);
			btnSalir.setFocusPainted(false);
			btnSalir.setBackground(Color.RED);
			btnSalir.setPreferredSize(new Dimension(100, 30));
			btnSalir.setMnemonic('I');
			
			// Al pulsarlo, termina el programa
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		
		return btnSalir;
	}
	
	/**
	 * Devuelve o crea el botón de pausar o reproducir música, si no está creado
	 * @return Botón de pausar o reproducir música, de tipo JButton
	 */
	private JButton getBtnMusic() {
		if (btnMusic == null) {
			btnMusic = new JButton("");
			btnMusic.setFocusPainted(false);
			btnMusic.setMnemonic('M');
			
			if (muted) {
				btnMusic.setIcon(new ImageIcon(new ImageIcon("files/img/music_muted.png")
				    .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			} else {
				btnMusic.setIcon(new ImageIcon(new ImageIcon("files/img/music_active.png")
					    .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			}

			// Al pulsarlo, pausa o reproduce la música
			btnMusic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					muted = !muted;
					changeMusic();
				}
			});
		}
		
		return btnMusic;
	}
	
	/**
	 * Método ejecutado al pulsar el botón de la música.
	 * Si la música está silenciada, activa el volumen
	 * y en caso contrario, lo silencia
	 */
	private void changeMusic() {
		if (player.getStatus() == BasicPlayer.PLAYING) {
			player.pause();
			btnMusic.setIcon(new ImageIcon(new ImageIcon("files/img/music_muted.png")
					.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			
			btnMusic2.setIcon(new ImageIcon(new ImageIcon("files/img/music_muted.png")
					.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			
		} else if (player.getStatus() == BasicPlayer.PAUSED) {
			player.resume();
			btnMusic.setIcon(new ImageIcon(new ImageIcon("files/img/music_active.png")
					.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			
			btnMusic2.setIcon(new ImageIcon(new ImageIcon("files/img/music_active.png")
					.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		}
	}
	
	/**
	 * Devuelve o crea la opción Banca del menú Juego, si no está creada
	 * @return Opción Banca del menú Juego, de tipo JMenuItem
	 */
	private JMenuItem getMntmBanca() {
		if (mntmBanca == null) {
			mntmBanca = new JMenuItem("");
			mntmBanca.setEnabled(false);
			mntmBanca.setMnemonic('B');
			mntmBanca.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_B, InputEvent.CTRL_MASK));
			
			// Al seleccionar esta opción, se dirige al panel Comprar Fichas
			mntmBanca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarComprarFichas();
				}
			});
		}
		
		return mntmBanca;
	}
	
	/**
	 * Devuelve o crea la opción Bebidas del menú Juego, si no está creada
	 * @return Opción Bebidas del menú Juego, de tipo JMenuItem
	 */
	private JMenuItem getMntmBebidas() {
		if (mntmBebidas == null) {
			mntmBebidas = new JMenuItem("");
			mntmBebidas.setEnabled(false);
			mntmBebidas.setMnemonic('D');
			mntmBebidas.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
			
			// Al pulsarlo, muestra el panel de bebidas
			mntmBebidas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPedirBebidas();
				}
			});

		}
		
		return mntmBebidas;
	}
	
//	/**
//	 * Devuelve o crea la opción Nueva ronda del menú Juego, si no está creada
//	 * @return Opción Nueva Ronda del menú Juego, de tipo JMenuItem
//	 */
//	private JMenuItem getMntmNRonda() {
//		if (mntmNRonda == null) {
//			mntmNRonda = new JMenuItem("");
//			mntmNRonda.setEnabled(false);
//			mntmNRonda.setMnemonic('N');
//			mntmNRonda.setAccelerator(
//					KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
//			
//			// Al pulsarlo, muestra el panel de bebidas
//			mntmNRonda.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					if (JOptionPane.showOptionDialog(null, strings.getString("dialog_round_msg"), 
//							strings.getString("dialog_round_title"), 0, JOptionPane.QUESTION_MESSAGE, 
//							null, new String[] {strings.getString("opt_yes"), "No"}, 
//							null) == 0) {
//						nuevaRonda();
//					}
//				}
//			});
//
//		}
//		
//		return mntmNRonda;
//	}
	
	/**
	 * Devuelve o crea el separador del menú Juego, si no está creado
	 * @return Separador del menú Juego, de tipo JMenuItem
	 */
	private JSeparator getSeparatorMnJuego() {
		if (separatorMnJuego == null) {
			separatorMnJuego = new JSeparator();
		}
		
		return separatorMnJuego;
	}
	
	/**
	 * Devuelve o crea el menú Usuario, si no está creado
	 * @return Menú Usuario, de tipo JMenu
	 */
	private JMenu getMnUsuario() {
		if (mnUsuario == null) {
			mnUsuario = new JMenu("");
			mnUsuario.setMnemonic('U');
			
			// Se añaden las opciones del menú
			mnUsuario.add(getMntmLinkCard());
			mnUsuario.add(getMntmLogOut());
		}
		
		return mnUsuario;
	}
	
	/**
	 * Devuelve o crea la opción Vincular tarjeta del menú Usuario, si no está creada
	 * @return Opción Vincular tarjeta del menú Usuario, de tipo JMenuItem
	 */
	private JMenuItem getMntmLinkCard() {
		if (mntmLinkCard == null) {
			mntmLinkCard = new JMenuItem("");
			mntmLinkCard.setEnabled(false);
			mntmLinkCard.setMnemonic('C');
			mntmLinkCard.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_K, InputEvent.CTRL_MASK));
			
			// Al pulsarlo, accede a la opción de Vincular tarjeta
			mntmLinkCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showVincularTarjeta();
				}
			});
		}
		
		return mntmLinkCard;
	}
	
	/**
	 * Devuelve o crea la opción Cerrar sesión del menú Usuario, si no está creada
	 * @return Opción Cerrar sesión del menú Usuario, de tipo JMenuItem
	 */
	private JMenuItem getMntmLogOut() {
		if (mntmLogOut == null) {
			mntmLogOut = new JMenuItem("");
			mntmLogOut.setEnabled(false);
			mntmLogOut.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_L, InputEvent.CTRL_MASK));
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				mntmLogOut.setMnemonic('O');
			} else {
				mntmLogOut.setMnemonic('E');
			}
			
			// Al pulsarlo, cierra la sesión del usuario
			mntmLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logOut();
				}
			});
		}
		
		return mntmLogOut;
	}
	
	/**
	 * Devuelve o crea el menú Idioma, si no está creado
	 * @return Menú Idioma, de tipo JMenu
	 */
	private JMenu getMnIdioma() {
		if (mnIdioma == null) {
			mnIdioma = new JMenu("");
			mnIdioma.add(getRdbtnSpanish());
			mnIdioma.add(getRdbtnEnglish());
			
			// Se agrupan sus botones de forma excluyente
			ButtonGroup idiomas = new ButtonGroup();
			idiomas.add(getRdbtnSpanish());
			idiomas.add(getRdbtnEnglish());
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				mnIdioma.setMnemonic('L');
			} else {
				mnIdioma.setMnemonic('D');
			}
			
		}
		
		return mnIdioma;
	}
	
	/**
	 * Devuelve o crea el botón Español, si no está creado
	 * @return Botón Español, de tipo JRadioButton
	 */
	private JRadioButton getRdbtnSpanish() {
		if (rdbtnSpanish == null) {
			rdbtnSpanish = new JRadioButton("");
			rdbtnSpanish.setFocusPainted(false);
			rdbtnSpanish.setText("Español");
			rdbtnSpanish.setMnemonic('E');
			rdbtnSpanish.setActionCommand("es");
			rdbtnSpanish.addActionListener(pci);
		}
		
		return rdbtnSpanish;
	}
	
	/**
	 * Devuelve o crea el botón English, si no está creado
	 * @return Botón English, de tipo JRadioButton
	 */
	private JRadioButton getRdbtnEnglish() {
		if (rdbtnEnglish == null) {
			rdbtnEnglish = new JRadioButton("");
			rdbtnEnglish.setFocusPainted(false);
			rdbtnEnglish.setText("English");
			rdbtnEnglish.setMnemonic('N');
			rdbtnEnglish.setActionCommand("en");
			rdbtnEnglish.addActionListener(pci);
		}
		
		return rdbtnEnglish;
	}
	
	/**
	 * Devuelve o crea el menú Ayuda, si no está creado
	 * @return Menú Ayuda, de tipo JMenu
	 */
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("");
			mnHelp.add(getMntmContenidos());
			mnHelp.add(getSeparatorMnHelp());
			mnHelp.add(getMntmAbout());
			
			// Se establece el mnemónico en función de la localización
			if (lang.equals("en")) {
				mnHelp.setMnemonic('E');
			} else {
				mnHelp.setMnemonic('A');
			}
		}
		
		return mnHelp;
	}
	
	/**
	 * Devuelve o crea la opción Contenidos del menú Ayuda, si no está creada
	 * @return Opción Contenidos del menú Ayuda, de tipo JMenuItem
	 */
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("");
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmContenidos.setMnemonic('C');
		}
		
		return mntmContenidos;
	}
	
	/**
	 * Devuelve o crea la opción Acerca de del menú Ayuda, si no está creada
	 * @return Opción Acerca de del menú Ayuda, de tipo JMenuItem
	 */
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("");
			mntmAbout.setMnemonic('A');
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_I, InputEvent.CTRL_MASK));
			
			// Al pulsarlo, muestra información sobre la aplicación
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showAbout();
				}
			});
		}
		
		return mntmAbout;
	}
	
	/**
	 * Muestra un diálogo con información sobre la aplicación
	 */
	private void showAbout() {
		JOptionPane.showMessageDialog(null, 
				"Casino: Roulette 20.1.7\n\nSamuel Rodríguez Ares (UO271612)\n\nEII 2019-20", 
				"About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Devuelve o crea el separador del menú Ayuda, si no está creado
	 * @return Separador del menú Ayuda, de tipo JMenuItem
	 */
	private JSeparator getSeparatorMnHelp() {
		if (separatorMnHelp == null) {
			separatorMnHelp = new JSeparator();
		}
		
		return separatorMnHelp;
	}
	
	/**
	 * Devuelve o crea el panel principal de la aplicación, si no está creado
	 * @return Panel prnicipal de la aplicación, de tipo JPanel
	 */
	private JPanel getPnJuego() {
		if (pnJuego == null) {
			pnJuego = new JPanel();
			pnJuego.setBorder(new MatteBorder(20, 15, 15, 15, (Color) new Color(128, 0, 0)));
			pnJuego.setBackground(new Color(128, 0, 0));
			pnJuego.setLayout(new BorderLayout(120, 20));
			
			// Se añaden los componentes del panel en cada posición
			pnJuego.add(getPnJuegoNorte(), BorderLayout.NORTH);
			pnJuego.add(getPnJuegoCentro(), BorderLayout.CENTER);
			pnJuego.add(getPnJuegoSur(), BorderLayout.SOUTH);
		}
		
		return pnJuego;
	}

	/**
	 * Devuelve o crea el panel norte de la pantalla de juego, si no está creada
	 * @return Panel norte de la pantalla de juego, de tipo JPanel
	 */
	private JPanel getPnJuegoNorte() {
		if (pnJuegoNorte == null) {
			pnJuegoNorte = new JPanel();
			pnJuegoNorte.setBackground(new Color(128, 0, 0));
			pnJuegoNorte.setLayout(new BorderLayout(0, 0));
			pnJuegoNorte.add(getLblLogo2(), BorderLayout.WEST);
			pnJuegoNorte.add(getBtnMusic2(), BorderLayout.EAST);
		}
		
		return pnJuegoNorte;
	}
	
	/**
	 * Devuelve o crea la etiqueta del logo para la segunew Color(255, 255, 255)a, si no está creada
	 * @return Etiqueta del logo para la pantalla de juego, de tipo JLabel
	 */
	private JLabel getLblLogo2() {
		if (lblLogo2 == null) {
			lblLogo2 = new JLabel();
			lblLogo2.setText(" CASINO");
			lblLogo2.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo2.setFont(new Font("Mistral", Font.BOLD, 36));
			lblLogo2.setBackground(Color.BLACK);
		}
		
		return lblLogo2;
	}
	
	/**
	 * Devuelve o crea el botón de música en el panel principal, si no está creado
	 * @return Botón de música en el panel principal, de tipo JButton
	 */
	private JButton getBtnMusic2() {
		if (btnMusic2 == null) {
			btnMusic2 = new JButton("");
			btnMusic2.setMnemonic('M');
			btnMusic2.setFocusPainted(false);
			btnMusic2.setIcon(btnMusic.getIcon());
			
			// Al pulsarlo, pausa o reproduce la música
			btnMusic2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					muted = !muted;
					changeMusic();
				}
			});
		}
		
		return btnMusic2;
	}
	
	/**
	 * Devuelve o crea el panel central del panel de juego, si no está creado
	 * @return Panel central del panel de juego, de tipo JPanel
	 */
	private JPanel getPnJuegoCentro() {
		if (pnJuegoCentro == null) {
			pnJuegoCentro = new JPanel();
			pnJuegoCentro.setBackground(new Color(128, 0, 0));
			pnJuegoCentro.setLayout(new BorderLayout(10, 0));
			
			// Se añaden los componentes al panel
			pnJuegoCentro.add(getBtnRuleta(), BorderLayout.WEST);
			pnJuegoCentro.add(getPnTablero(), BorderLayout.CENTER);
			pnJuegoCentro.add(getPnJuegoOpciones(), BorderLayout.EAST);
		}
		
		return pnJuegoCentro;
	}
	
	/**
	 * Devuelve o crea el botón de la ruleta, si no está creado
	 * @return Botón de la ruleta, de tipo JButton
	 */
	private JButton getBtnRuleta() {
		if (btnRuleta == null) {
			btnRuleta = new JButton();
			btnRuleta.setEnabled(false);
			btnRuleta.setMnemonic('P');
			btnRuleta.setContentAreaFilled(false);
			btnRuleta.setBorderPainted(false);
			btnRuleta.setFocusPainted(false);
			btnRuleta.setIcon(new ImageIcon(new ImageIcon("files/img/roulette.png")
					.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH)));
			btnRuleta.setDisabledIcon(new ImageIcon(new ImageIcon("files/img/roulette_disabled.png")
					.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH)));
			
			// Si aún no se ha apostado, muestra un aviso al intentar pulsar
			// btnRuleta.addActionListener(prsa);
		}
		
		return btnRuleta;
	}
	
	/**
	 * Devuelve o crea el panel sur del panel de juego, si no está creado
	 * @return Panel sur del panel de juego, de tipo JPanel
	 */
	private JPanel getPnJuegoSur() {
		if (pnJuegoSur == null) {
			pnJuegoSur = new JPanel();
			pnJuegoSur.setBackground(new Color(128, 0, 0));
			pnJuegoSur.setLayout(new BorderLayout(0, 0));
			pnJuegoSur.add(getBtnCerrarSesion(), BorderLayout.EAST);
			pnJuegoSur.add(getPnSaldo(), BorderLayout.WEST);
			pnJuegoSur.add(getPnJuegoFichas(), BorderLayout.CENTER);
		}
		
		return pnJuegoSur;
	}
	
	
	
	/**
	 * Devuelve o crea el botón Cerrar Sesión del panel principal, si no está creado
	 * @return Botón Cerrar Sesión del panel principal, de tipo JButton
	 */
	private JButton getBtnCerrarSesion() {
		if (btnCerrarSesion == null) {
			btnCerrarSesion = new JButton("");
			btnCerrarSesion.setFocusPainted(false);
			btnCerrarSesion.setMnemonic('I');
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			btnCerrarSesion.setFont(fuente);
			btnCerrarSesion.setBackground(Color.RED);
			btnCerrarSesion.setPreferredSize(new Dimension(100, 30));
					
			// Al pulsarlo, cierra la sesión del usuario
			btnCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logOut();
				}
			});
		}
		
		return btnCerrarSesion;
	}
	
	/**
	 * Muestra un mensaje de confirmación, y si el usuario lo confirma,
	 * cierra la sesión del mismo y vuelve a la segunda pantalla
	 */
	protected void logOut() {
		if (JOptionPane.showOptionDialog(null, strings.getString("dialog_log_out_msg"), 
				strings.getString("btn_log_out"), 0, JOptionPane.QUESTION_MESSAGE, 
				null, new String[] {strings.getString("opt_yes"), "No"}, 
				null) == 0) {
			
			// Se devuelve el valor de las fichas al saldo del cliente
			devolverValorFichas();
			
			// Se actualiza la base de datos de usuarios
			db.actualizarUsuarios();
			
			// Se reinicia el tablero de juego
			nuevaRonda();
			
			// Se reinician los valores para la próxima sesión
			user = null;
			pagoVinculado = false;
			
			// Se vuelve a la opción de Vincular Tarjeta
			switchToLinkCard();
			
			// Se deseleccionan los botones de selección de ficha
			deseleccionarJRadioButtons();
			
			// Se deshabilitan los JMenuItems correspondientes
			deshabilitarJMenuItems();
			
			// Se vuelve a la pantalla de inicio
			backToLogin();
		}
	}
	
	/**
	 * Deselecciona los JRadioButtons de selección de ficha
	 */
	private void deseleccionarJRadioButtons() {
		for (Component c : getPnBotonesFichas().getComponents()) {
			((JRadioButton) c).setSelected(false);
		}
	}
	
	/**
	 * Deshabilita los JMenuItems correspondientes tras cerrar sesión
	 */
	private void deshabilitarJMenuItems() {
		getMntmBanca().setEnabled(false);
		getMntmBebidas().setEnabled(false);
		getMntmLinkCard().setEnabled(false);
		getMntmLogOut().setEnabled(false);
	}
	
	/**
	 * Convierte las fichas en posesión en saldo cuando el usuario cierra sesión
	 */
	private void devolverValorFichas() {
		// Se borran los iconos de las fichas apostadas
		for (Component c : getPnTablero().getComponents()) {
			if (c instanceof JButton) {
				((JButton) c).setIcon(null);
			}
		}
		
		// Se devuelven momentáneamente las fichas al usuario
		for (int i = 0; i < 49; i++) {
			if (!game.isCasillaVacia(i)) {
				user.addFicha(new Ficha(game.getTablero()[i].getValorFichaApostada()));
			}
		}
		
		// Se convierten esas fichas a saldo
		for (Ficha f : db.buscarUsuario(user.getUserName()).getFichas()) {
			db.buscarUsuario(user.getUserName()).setBalance(db.buscarUsuario(
					user.getUserName()).getBalance() + f.getValor());
		}
		
		// Se eliminan todas las fichas del usuario
		db.buscarUsuario(user.getUserName()).limpiarFichas();
		actualizarFichas();
	}
	
	/**
	 * Vuelve al panel de opciones para inicio de sesión y registro
	 */
	private void backToLogin() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		((CardLayout) pnContenidos.getLayout()).show(pnContenidos, "pnInicio");
		start();
	}
	
	/**
	 * Devuelve o crea el panel correspondiente al saldo, si no está creado
	 * @return Panel del saldo, de tipo JPanel
	 */
	private JPanel getPnSaldo() {
		if (pnSaldo == null) {
			pnSaldo = new JPanel();
			pnSaldo.setBackground(new Color(128, 0, 0));
			pnSaldo.setLayout(new GridLayout(2, 1, 0, 0));
			pnSaldo.add(getLblSaldoDisponible());
			pnSaldo.add(getBtnVincularTarjeta());
		}
		
		return pnSaldo;
	}
	
	/**
	 * Devuelve la etiqueta Saldo Disponible:, si no está creada
	 * @return Etiqueta Saldo Disponible:, de tipo JLabel
	 */
	private JLabel getLblSaldoDisponible() {
		if (lblSaldoDisponible == null) {
			lblSaldoDisponible = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 14);
			lblSaldoDisponible.setFont(fuente);
			lblSaldoDisponible.setHorizontalTextPosition(SwingConstants.CENTER);
			lblSaldoDisponible.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return lblSaldoDisponible;
	}
	
	/**
	 * Devuelve el botón para Vincular Tarjeta, si no está creado
	 * @return Botón Vincular Tarjeta, de tipo JButton
	 */
	private JButton getBtnVincularTarjeta() {
		if (btnVincularTarjeta == null) {
			btnVincularTarjeta = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 16);
			btnVincularTarjeta.setFont(fuente);
			btnVincularTarjeta.setForeground(new Color(255, 255, 255));
			btnVincularTarjeta.setBackground(new Color(34, 139, 34));
			btnVincularTarjeta.setFocusPainted(false);
			btnVincularTarjeta.setMnemonic('C');
			
			// Al pulsar el botón, se abre el diálogo para vincular la tarjeta
			btnVincularTarjeta.addActionListener(pvt);
		}
		
		return btnVincularTarjeta;
	}
	
	/**
	 * Añade un método de pago exitosamente a la sesión del usuario
	 */
	public void addPaymentMethod() {
		pagoVinculado = true;
		getBtnVincularTarjeta().setToolTipText(strings.getString("tooltip_added_payment_mean"));
		getLblComprarFichasMetodoPago().setVisible(false);
		getLblCargarSaldoMetodoPago().setVisible(false);
		getLblPnBebidasMetodoPago().setVisible(false);
		
		// Se activa la opción para exportar saldo
		switchToExportBalance();
	}
	
	/**
	 * Muestra un diálogo de confirmación. Si el usuario lo acepta,
	 * exporta todo el saldo del juego a su método de pago vinculado
	 */
	private void exportarSaldo() {
		// Si no hay saldo por exportar, directamente se avisa y no se hace nada
		if (db.buscarUsuario(user.getUserName()).getBalance() == 0.0) {
			JOptionPane.showMessageDialog(null, strings.getString("err_export_msg"), 
					strings.getString("err_export_title"), JOptionPane.ERROR_MESSAGE);
			
		// En caso contrario, se requiere la confirmación del usuario
		} else {
			if (JOptionPane.showOptionDialog(null, strings.getString("dialog_export_msg"),
					strings.getString("dialog_export_title"), 0, JOptionPane.QUESTION_MESSAGE, null,
					new String[] { strings.getString("opt_yes"), "No" }, null) == 0) {
				
				db.buscarUsuario(user.getUserName()).setBalance(0);
				goToMainScreen();
			}
		}
	}
	
	/**
	 * Cambia la opción de Vincular Tarjeta por Exportar Saldo
	 */
	private void switchToExportBalance() {
		getBtnVincularTarjeta().removeActionListener(pvt);
		getBtnVincularTarjeta().addActionListener(pes);
		getBtnVincularTarjeta().setText(strings.getString("btn_export_balance"));
		getBtnVincularTarjeta().setMnemonic('X');
	}
	
	/**
	 * Cambia la opción de Exportar Saldo por Vincular Tarjeta
	 */
	private void switchToLinkCard() {
		getBtnVincularTarjeta().removeActionListener(pes);
		getBtnVincularTarjeta().addActionListener(pvt);
		getBtnVincularTarjeta().setText(strings.getString("btn_link_card"));
		getBtnVincularTarjeta().setMnemonic('C');
	}
	
	/**
	 * Muestra el diálogo para vincular la tarjeta u otro método de pago
	 */
	private void showVincularTarjeta() {
		VentanaMetodoPago dialog = new VentanaMetodoPago(this);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	/**
	 * Devuelve o crea el panel que alberga los botones de fichas, si no está creado
	 * @return Panel de botones de fichas, de tipo JPanel
	 */
	private JPanel getPnJuegoFichas() {
		if (pnJuegoFichas == null) {
			pnJuegoFichas = new JPanel();
			pnJuegoFichas.setBackground(new Color(128, 0, 0));
			pnJuegoFichas.setLayout(new GridLayout(3, 1, 0, 0));
			
			// Se añaden los subpaneles
			pnJuegoFichas.add(getPnBotonesFichas());
			pnJuegoFichas.add(getPnIconosFichas());
			pnJuegoFichas.add(getPnCuentaFichas());
		}
		
		return pnJuegoFichas;
	}
	
	/**
	 * Devuelve o crea el panel de los radio botones para las fichas, si no está creado
	 * @return Panel de los radio botones de las fichas, de tipo JPanel
	 */
	private JPanel getPnBotonesFichas() {
		if (pnBotonesFichas == null) {
			pnBotonesFichas = new JPanel();
			pnBotonesFichas.setBackground(new Color(128, 0, 0));
			pnBotonesFichas.setLayout(new FlowLayout(FlowLayout.CENTER, 42, 0));
			
			// Se añaden los radio botones de las fichas
			pnBotonesFichas.add(getRdbtnFicha5());
			pnBotonesFichas.add(getRdbtnFicha10());
			pnBotonesFichas.add(getRdbtnFicha20());
			pnBotonesFichas.add(getRdbtnFicha50());
			pnBotonesFichas.add(getRdbtnFicha100());
		}
		
		return pnBotonesFichas;
	}
	
	/**
	 * Devuelve o crea el radio botón de la ficha de 5, si no está creado
	 * @return Radio botón de la ficha de 5, de tipo JRadioButton
	 */
	private JRadioButton getRdbtnFicha5() {
		if (rdbtnFicha5 == null) {
			rdbtnFicha5 = new JRadioButton("");
			rdbtnFicha5.setMnemonic('1');
			rdbtnFicha5.setBackground(new Color(128, 0, 0));
			rdbtnFicha5.setActionCommand("5");
		}
		
		return rdbtnFicha5;
	}
	
	/**
	 * Devuelve o crea el radio botón de la ficha de 10, si no está creado
	 * @return Radio botón de la ficha de 10, de tipo JRadioButton
	 */
	private JRadioButton getRdbtnFicha10() {
		if (rdbtnFicha10 == null) {
			rdbtnFicha10 = new JRadioButton("");
			rdbtnFicha10.setMnemonic('2');
			rdbtnFicha10.setBackground(new Color(128, 0, 0));
			rdbtnFicha10.setActionCommand("10");
		}
		
		return rdbtnFicha10;
	}
	
	/**
	 * Devuelve o crea el radio botón de la ficha de 20, si no está creado
	 * @return Radio botón de la ficha de 20, de tipo JRadioButton
	 */
	private JRadioButton getRdbtnFicha20() {
		if (rdbtnFicha20 == null) {
			rdbtnFicha20 = new JRadioButton("");
			rdbtnFicha20.setMnemonic('3');
			rdbtnFicha20.setBackground(new Color(128, 0, 0));
			rdbtnFicha20.setActionCommand("20");
		}
		
		return rdbtnFicha20;
	}
	
	/**
	 * Devuelve o crea el radio botón de la ficha de 50, si no está creado
	 * @return Radio botón de la ficha de 50, de tipo JRadioButton
	 */
	private JRadioButton getRdbtnFicha50() {
		if (rdbtnFicha50 == null) {
			rdbtnFicha50 = new JRadioButton("");
			rdbtnFicha50.setMnemonic('4');
			rdbtnFicha50.setBackground(new Color(128, 0, 0));
			rdbtnFicha50.setActionCommand("50");
		}
		
		return rdbtnFicha50;
	}
	
	/**
	 * Devuelve o crea el radio botón de la ficha de 100, si no está creado
	 * @return Radio botón de la ficha de 100, de tipo JRadioButton
	 */
	private JRadioButton getRdbtnFicha100() {
		if (rdbtnFicha100 == null) {
			rdbtnFicha100 = new JRadioButton("");
			rdbtnFicha100.setMnemonic('5');
			rdbtnFicha100.setBackground(new Color(128, 0, 0));
			rdbtnFicha100.setActionCommand("100");
		}
		
		return rdbtnFicha100;
	}
	
	/**
	 * Devuelve o crea el panel que alberga los iconos de fichas, si no está creado
	 * @return Panel con botones e iconos de las fichas, de tipo JPanel
	 */
	private JPanel getPnIconosFichas() {
		if (pnIconosFichas == null) {
			pnIconosFichas = new JPanel();
			pnIconosFichas.setBackground(new Color(128, 0, 0));
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
			pnCuentaFichas.setBackground(new Color(128, 0, 0));
			
			// Se añaden las etiquetas con los contadores
			pnCuentaFichas.add(getLblCountFichas5());
			pnCuentaFichas.add(getLblCountFichas10());
			pnCuentaFichas.add(getLblCountFichas20());
			pnCuentaFichas.add(getLblCountFichas50());
			pnCuentaFichas.add(getLblCountFichas100());
			
			// Se crea el grupo de botones excluyentes
			ButtonGroup buttons = new ButtonGroup();
			buttons.add(getRdbtnFicha5());
			buttons.add(getRdbtnFicha10());
			buttons.add(getRdbtnFicha20());
			buttons.add(getRdbtnFicha50());
			buttons.add(getRdbtnFicha100());
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
	
	/**
	 * Devuelve o crea el panel con opciones de usuario, si no está creado
	 * @return Panel con opciones de usuario, de tipo JPanel
	 */
	private JPanel getPnJuegoOpciones() {
		if (pnJuegoOpciones == null) {
			pnJuegoOpciones = new JPanel();
			pnJuegoOpciones.setBackground(new Color(128, 0, 0));
			pnJuegoOpciones.setLayout(new GridLayout(3, 1, 0, 15));
			
			// Se añaden al panel las opciones
			pnJuegoOpciones.add(getBtnComprarFichas());
			pnJuegoOpciones.add(getBtnRecargarSaldo());
			pnJuegoOpciones.add(getBtnPedirBebida());
		}
		
		return pnJuegoOpciones;
	}
	
	/**
	 * Devuelve o crea el botón Comprar Fichas, si no está creado
	 * @return Botón Comprar Fichas, de tipo JButton
	 */
	private JButton getBtnComprarFichas() {
		if (btnComprarFichas == null) {
			btnComprarFichas = new JButton("");
			btnComprarFichas.setBackground(new Color(192, 192, 192));
			btnComprarFichas.setMnemonic('O');
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 12);
			btnComprarFichas.setFont(fuente);
			btnComprarFichas.setFocusPainted(false);
			btnComprarFichas.setHorizontalTextPosition(SwingConstants.LEFT);
			btnComprarFichas.setHorizontalAlignment(SwingConstants.CENTER);
			btnComprarFichas.setIcon(new ImageIcon(new ImageIcon("files/img/token/buy.png")
					.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			
			// Al pulsarlo, muestra el panel de Comprar Fichas
			btnComprarFichas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarComprarFichas();
				}
			});
		}
		
		return btnComprarFichas;
	}
	
	/**
	 * Muestra el panel de Comprar Fichas
	 */
	private void mostrarComprarFichas() {
		// Se inhabilita la opción de menú para ir a la banca
		getMntmBanca().setEnabled(false);
		
		actualizarFichas();
		inicializaCalculosComprarFichas();
		((CardLayout) pnContenidos.getLayout()).show(pnContenidos, "pnComprarFichas");
	}
	
	/**
	 * Inicializa los campos de texto de la página de Comprar Fichas
	 */
	private void inicializaCalculosComprarFichas() {
		getTextFieldComprarFichasSaldo().setText(String.valueOf(user.getBalance()));
		getTextFieldComprarFichasValorInicial().setText(String.valueOf(user.getValorTotal()));
	}
	
	/**
	 * Actualiza los campos de texto al seleccionar alguna ficha a comprar
	 */
	private void actualizaCalculosComprarFichas() {
		// Se coloca en los campos de texto el valor y precio de las fichas seleccionadas
		getTextFieldComprarFichasPrecio().setText(String.valueOf(calculaValorSeleccionado()));
		getTextFieldComprarFichasValorAñadido().setText(String.valueOf(calculaValorSeleccionado()));
		
		// Se calcula el valor y saldo final tras la hipotética compra
		int valorFinal = user.getValorTotal() + calculaValorSeleccionado();
		double saldoFinal = user.getBalance() - calculaValorSeleccionado();
		
		// Se plasma el valor final hipotético en el campo de textos
		getTextFieldComprarFichasValorFinal().setText(String.valueOf(valorFinal));
		
		// Si no puede amortizar la compra, se muestra una X y se impide la compra
		if (saldoFinal < 0) {
			getBtnComprarFichasComprar().setEnabled(false);
			getTextFieldComprarFichasSaldoFinal().setForeground(Color.RED);
			getTextFieldComprarFichasSaldoFinal().setText("X");
			getTextFieldComprarFichasSaldoFinal().setToolTipText(strings.getString("tooltip_not_enough_balance"));
			
		// En caso contrario, muestra el saldo tras la compra y permite realizarla
		} else {
			getBtnComprarFichasComprar().setEnabled(true);
			getTextFieldComprarFichasSaldoFinal().setForeground(Color.WHITE);
			getTextFieldComprarFichasSaldoFinal().setText(String.valueOf(saldoFinal));
			getTextFieldComprarFichasSaldoFinal().setToolTipText("");
		}
	}
	
	/**
	 * Calcula el valor (y precio) total de las fichas seleccionadas para comprar
	 * @return Valor y precio total de las fichas seleccionadas, de tipo int
	 */
	private int calculaValorSeleccionado() {
		return (5 * (Integer) getSpinnerComprarFichas5().getValue() 
			+  10 * (Integer) getSpinnerComprarFichas10().getValue()
			+  20 * (Integer) getSpinnerComprarFichas20().getValue()
		    +  50 * (Integer) getSpinnerComprarFichas50().getValue()
		    + 100 * (Integer) getSpinnerComprarFichas100().getValue());
	}
	
	/**
	 * Devuelve o crea el botón Recargar Saldo, si no está creado
	 * @return Botón Recargar Saldo, de tipo JButton
	 */
	private JButton getBtnRecargarSaldo() {
		if (btnRecargarSaldo == null) {
			btnRecargarSaldo = new JButton("");
			btnRecargarSaldo.setBackground(new Color(192, 192, 192));
			btnRecargarSaldo.setMnemonic('A');
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 12);
			btnRecargarSaldo.setFont(fuente);
			btnRecargarSaldo.setFocusPainted(false);
			btnRecargarSaldo.setHorizontalAlignment(SwingConstants.CENTER);
			btnRecargarSaldo.setHorizontalTextPosition(SwingConstants.LEFT);
			btnRecargarSaldo.setIcon(new ImageIcon(new ImageIcon("files/img/balance.png")
					.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			
			// Al pulsarlo, se accede al panel de cargar saldo
			btnRecargarSaldo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnContenidos.getLayout()).show(pnContenidos, "pnCargarSaldo");
					getTextFieldCargarSaldoAñadir().grabFocus();
				}
			});
		}
		
		return btnRecargarSaldo;
	}
	
	/**
	 * Devuelve o crea el botón Pedir Consumición, si no está creado
	 * @return Botón Pedir Consumición, de tipo JButton
	 */
	private JButton getBtnPedirBebida() {
		if (btnPedirBebida == null) {
			btnPedirBebida = new JButton("");
			btnPedirBebida.setBackground(new Color(192, 192, 192));
			btnPedirBebida.setMnemonic('D');
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 12);
			btnPedirBebida.setFont(fuente);
			btnPedirBebida.setFocusPainted(false);
			btnPedirBebida.setHorizontalAlignment(SwingConstants.CENTER);
			btnPedirBebida.setHorizontalTextPosition(SwingConstants.LEFT);
			btnPedirBebida.setIcon(new ImageIcon(new ImageIcon("files/img/drink.png")
					.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			
			// Al pulsarlo, muestra el panel de las bebidas
			btnPedirBebida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPedirBebidas();
				}
			});
		}
		
		return btnPedirBebida;
	}
	
	/**
	 * Muestra el panel para pedir bebidas
	 */
	private void mostrarPedirBebidas() {
		// Se deshabilita la opción de menú
		getMntmBebidas().setEnabled(false);
		
		// Se actualiza el saldo a mostrar
		getLblPnBebidasSaldo().setText(strings.getString("lbl_balance_buy") + " "
				+ user.getBalance() + "€");
		
		// Se actualizan los campos de texto
		actualizarCamposBebidas();
		
		// Se muestra el panel de bebidas
		((CardLayout) pnContenidos.getLayout()).show(pnContenidos, "pnBebidas");
	}
	
	/**
	 * Devuelve o crea el panel del tablero, si no está creado
	 * @return Panel del tablero, de tipo JPanel
	 */
	private JPanel getPnTablero() {
		if (pnTablero == null) {
			pnTablero = new JPanel();
			pnTablero.setBackground(new Color(128, 0, 0));
			
			// Propiedades del panel
			GridBagLayout gbl_pnTablero = new GridBagLayout();
			gbl_pnTablero.columnWidths = new int[]{70, 410, 45};
			gbl_pnTablero.rowHeights = new int[] {125, 60, 30};
			gbl_pnTablero.columnWeights = new double[]{0.0, 0.0, 0.0};
			gbl_pnTablero.rowWeights = new double[]{0.0, 0.0, 0.0};
			pnTablero.setLayout(gbl_pnTablero);
			
			// Columna 1: Botón 0
			GridBagConstraints gbc_btnPnTableroBtn0 = new GridBagConstraints();
			gbc_btnPnTableroBtn0.anchor = GridBagConstraints.EAST;
			gbc_btnPnTableroBtn0.fill = GridBagConstraints.VERTICAL;
			gbc_btnPnTableroBtn0.insets = new Insets(0, 0, 0, 0);
			gbc_btnPnTableroBtn0.gridx = 0;
			gbc_btnPnTableroBtn0.gridy = 0;
			pnTablero.add(getBtnPnTableroBtn0(), gbc_btnPnTableroBtn0);
			
			// Columna 2: Panel de números
			GridBagConstraints gbc_pnTableroNumeros = new GridBagConstraints();
			gbc_pnTableroNumeros.fill = GridBagConstraints.BOTH;
			gbc_pnTableroNumeros.insets = new Insets(0, 0, 0, 0);
			gbc_pnTableroNumeros.gridx = 1;
			gbc_pnTableroNumeros.gridy = 0;
			pnTablero.add(getPnTableroNumeros(), gbc_pnTableroNumeros);
			
			// Columna 3: Panel con botones 2 a 1
			GridBagConstraints gbc_pnTablero2a1 = new GridBagConstraints();
			gbc_pnTablero2a1.anchor = GridBagConstraints.WEST;
			gbc_pnTablero2a1.fill = GridBagConstraints.VERTICAL;
			gbc_pnTablero2a1.insets = new Insets(0, 0, 0, 0);
			gbc_pnTablero2a1.gridx = 2;
			gbc_pnTablero2a1.gridy = 0;
			pnTablero.add(getPnTablero2a1(), gbc_pnTablero2a1);
			
			// Fila 2: Tablero inferior
			GridBagConstraints gbc_pnTableroInferior = new GridBagConstraints();
			gbc_pnTableroInferior.fill = GridBagConstraints.HORIZONTAL;
			gbc_pnTableroInferior.anchor = GridBagConstraints.NORTH;
			gbc_pnTableroInferior.insets = new Insets(0, 0, 5, 0);
			gbc_pnTableroInferior.gridx = 1;
			gbc_pnTableroInferior.gridy = 1;
			pnTablero.add(getPnTableroInferior(), gbc_pnTableroInferior);
			
			// Fila 3: Botón "Apostar"
			GridBagConstraints gbc_btnPnTableroApostar = new GridBagConstraints();
			gbc_btnPnTableroApostar.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnPnTableroApostar.insets = new Insets(0, 135, 0, 135);
			gbc_btnPnTableroApostar.gridx = 1;
			gbc_btnPnTableroApostar.gridy = 2;
			pnTablero.add(getBtnPnTableroApostar(), gbc_btnPnTableroApostar);
		}
		
		return pnTablero;
	}
	
	/**
	 * Actualiza los contadores con las fichas en posesión del usuario
	 */
	private void actualizarFichas() {	
		lblCountFichas5.setText(String.valueOf(user.contarFichas(5)));
		lblCountFichas10.setText(String.valueOf(user.contarFichas(10)));
		lblCountFichas20.setText(String.valueOf(user.contarFichas(20)));
		lblCountFichas50.setText(String.valueOf(user.contarFichas(50)));
		lblCountFichas100.setText(String.valueOf(user.contarFichas(100)));
		
		textFieldComprarFichas5.setText(String.valueOf(user.contarFichas(5)));
		textFieldComprarFichas10.setText(String.valueOf(user.contarFichas(10)));
		textFieldComprarFichas20.setText(String.valueOf(user.contarFichas(20)));
		textFieldComprarFichas50.setText(String.valueOf(user.contarFichas(50)));
		textFieldComprarFichas100.setText(String.valueOf(user.contarFichas(100)));
	}
	
	/**
	 * Devuelve o crea el panel para comprar fichas, si no está creado
	 * @return Panel para comprar fichas, de tipo JPanel
	 */
	private JPanel getPnComprarFichas() {
		if (pnComprarFichas == null) {
			pnComprarFichas = new JPanel();
			pnComprarFichas.setBorder(new MatteBorder(20, 20, 20, 20, (Color) new Color(128, 0, 0)));
			pnComprarFichas.setBackground(new Color(128, 0, 0));
			pnComprarFichas.setLayout(new BorderLayout(200, 30));
			pnComprarFichas.add(getPnComprarFichasLogo(), BorderLayout.NORTH);
			pnComprarFichas.add(getPnComprarFichasSeleccion(), BorderLayout.WEST);
			pnComprarFichas.add(getPnComprarFichasSur(), BorderLayout.SOUTH);
			pnComprarFichas.add(getPnComprarFichasCalculos(), BorderLayout.CENTER);
			pnComprarFichas.add(getPnComprarFichasEste(), BorderLayout.EAST);
		}
		
		return pnComprarFichas;
	}
	
	/**
	 * Devuelve o crea el panel que contiene el logo al comprar fichas, si no está creado
	 * @return Panel de logo en el panel de comprar fichas, de tipo JPanel
	 */
	private JPanel getPnComprarFichasLogo() {
		if (pnComprarFichasLogo == null) {
			pnComprarFichasLogo = new JPanel();
			pnComprarFichasLogo.setBackground(new Color(128, 0, 0));
			pnComprarFichasLogo.setLayout(new BoxLayout(pnComprarFichasLogo, BoxLayout.X_AXIS));
			pnComprarFichasLogo.add(getLblComprarFichasLogo());
		}
		
		return pnComprarFichasLogo;
	}
	
	/**
	 * Devuelve o crea la etiqueta del logo al comprar fichas, si no está creada
	 * @return Etiqueta del logo al comprar fichas, de tipo JLabel
	 */
	private JLabel getLblComprarFichasLogo() {
		if (lblComprarFichasLogo == null) {
			lblComprarFichasLogo = new JLabel("");
			lblComprarFichasLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblComprarFichasLogo.setHorizontalAlignment(SwingConstants.LEFT);
			lblComprarFichasLogo.setForeground(Color.WHITE);
			lblComprarFichasLogo.setFont(new Font("Mistral", Font.BOLD, 40));
			lblComprarFichasLogo.setIcon(new ImageIcon(new ImageIcon("files/img/plus.png")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		}
		
		return lblComprarFichasLogo;	
	}
	
	/**
	 * Devuelve o crea el panel para seleccionar las fichas a comprar, si no está creado
	 * @return Panel de selección de las fichas a comprar, de tipo JPanel
	 */
	private JPanel getPnComprarFichasSeleccion() {
		if (pnComprarFichasSeleccion == null) {
			pnComprarFichasSeleccion = new JPanel();
			pnComprarFichasSeleccion.setBackground(new Color(128, 0, 0));
			pnComprarFichasSeleccion.setLayout(new GridLayout(5, 1, 0, 0));
			pnComprarFichasSeleccion.add(getPnComprarFichas5());
			pnComprarFichasSeleccion.add(getPnComprarFichas10());
			pnComprarFichasSeleccion.add(getPnComprarFichas20());
			pnComprarFichasSeleccion.add(getPnComprarFichas50());
			pnComprarFichasSeleccion.add(getPnComprarFichas100());
		}
		
		return pnComprarFichasSeleccion;
	}
	
	/**
	 * Devuelve o crea el panel para seleccionar compra de fichas de 5, si no está creado
	 * @return Panel de selección de compra de fichas de 5, de tipo JPanel
	 */
	private JPanel getPnComprarFichas5() {
		if (pnComprarFichas5 == null) {
			pnComprarFichas5 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichas5.getLayout();
			flowLayout.setHgap(10);
			pnComprarFichas5.setBackground(new Color(128, 0, 0));
			pnComprarFichas5.add(getLblComprarFichas5());
			pnComprarFichas5.add(getSpinnerComprarFichas5());
			pnComprarFichas5.add(getTextFieldComprarFichas5());
		}
		
		return pnComprarFichas5;
	}
	
	/**
	 * Devuelve o crea la etiqueta con icono de ficha de 5 al comprar, si no está creada
	 * @return Etiqueta con el icono de la ficha de 5 a comprar, de tipo JLabel
	 */
	private JLabel getLblComprarFichas5() {
		if (lblComprarFichas5 == null) {
			lblComprarFichas5 = new JLabel("");
			lblComprarFichas5.setDisplayedMnemonic('1');
			lblComprarFichas5.setLabelFor(getSpinnerComprarFichas5());
			lblComprarFichas5.setIcon(new ImageIcon(new ImageIcon("files/img/token/5.PNG")
					.getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
		}
		
		return lblComprarFichas5;
	}
	
	/**
	 * Devuelve o crea el selector de fichas de 5 a comprar, si no está creado
	 * @return Selector de fichas de 5 a comprar, de tipo JSpinner
	 */
	private JSpinner getSpinnerComprarFichas5() {
		if (spinnerComprarFichas5 == null) {
			spinnerComprarFichas5 = new JSpinner();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			spinnerComprarFichas5.setFont(fuente);
			spinnerComprarFichas5.setPreferredSize(new Dimension(35, 20));
			
			// Al utilizarlo, actualiza el contador de fichas tras la supuesta compra
			spinnerComprarFichas5.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int valor = (Integer) ((JSpinner) arg0.getSource()).getValue();
					getTextFieldComprarFichas5().setText(String.valueOf(user.contarFichas(5) + valor));
				}
			});
			
			// También activa el botón de Comprar
			spinnerComprarFichas5.addChangeListener(pcf);
			
			spinnerComprarFichas5.setModel(new SpinnerNumberModel(new Integer(0), 
					new Integer(0), null, new Integer(1)));
		}
		
		return spinnerComprarFichas5;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el número de fichas de 5, si no está creado
	 * @return Campo de texto con el número de fichas de 5 a poseer, tipo JSpinner
	 */
	private JTextField getTextFieldComprarFichas5() {
		if (textFieldComprarFichas5 == null) {
			textFieldComprarFichas5 = new JTextField();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			textFieldComprarFichas5.setFont(fuente);
			textFieldComprarFichas5.setEditable(false);
			textFieldComprarFichas5.setColumns(2);
			textFieldComprarFichas5.setHorizontalAlignment(SwingConstants.CENTER);
			
			if (user != null) {
				textFieldComprarFichas5.setText(String.valueOf(user.contarFichas(5)));
			}
		}
		
		return textFieldComprarFichas5;
	}
	
	/**
	 * Devuelve o crea el panel para seleccionar compra de fichas de 10, si no está creado
	 * @return Panel de selección de compra de fichas de 10, de tipo JPanel
	 */
	private JPanel getPnComprarFichas10() {
		if (pnComprarFichas10 == null) {
			pnComprarFichas10 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichas10.getLayout();
			flowLayout.setHgap(10);
			pnComprarFichas10.setBackground(new Color(128, 0, 0));
			pnComprarFichas10.add(getLblComprarFichas10());
			pnComprarFichas10.add(getSpinnerComprarFichas10());
			pnComprarFichas10.add(getTextFieldComprarFichas10());
		}
		
		return pnComprarFichas10;
	}
	
	/**
	 * Devuelve o crea la etiqueta con icono de ficha de 10 al comprar, si no está creada
	 * @return Etiqueta con el icono de la ficha de 10 a comprar, de tipo JLabel
	 */
	private JLabel getLblComprarFichas10() {
		if (lblComprarFichas10 == null) {
			lblComprarFichas10 = new JLabel("");
			lblComprarFichas10.setLabelFor(getSpinnerComprarFichas10());
			lblComprarFichas10.setDisplayedMnemonic('2');
			lblComprarFichas10.setIcon(new ImageIcon(new ImageIcon("files/img/token/10.PNG")
					.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		}
		
		return lblComprarFichas10;
	}
	
	/**
	 * Devuelve o crea el selector de fichas de 10 a comprar, si no está creado
	 * @return Selector de fichas de 10 a comprar, de tipo JSpinner
	 */
	private JSpinner getSpinnerComprarFichas10() {
		if (spinnerComprarFichas10 == null) {
			spinnerComprarFichas10 = new JSpinner();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			spinnerComprarFichas10.setFont(fuente);
			spinnerComprarFichas10.setPreferredSize(new Dimension(35, 20));
			spinnerComprarFichas10.setModel(new SpinnerNumberModel(new Integer(0), 
					new Integer(0), null, new Integer(1)));
			
			// Al utilizarlo, actualiza el contador de fichas tras la supuesta compra
			spinnerComprarFichas10.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int valor = (Integer) ((JSpinner) arg0.getSource()).getValue();
					getTextFieldComprarFichas10().setText(String.valueOf(user.contarFichas(10) + valor));
				}
			});
			
			// También activa el botón de Comprar
			spinnerComprarFichas10.addChangeListener(pcf);
		}
		
		return spinnerComprarFichas10;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el número de fichas de 10, si no está creado
	 * @return Campo de texto con el número de fichas de 10 a poseer, tipo JSpinner
	 */
	private JTextField getTextFieldComprarFichas10() {
		if (textFieldComprarFichas10 == null) {
			textFieldComprarFichas10 = new JTextField();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			textFieldComprarFichas10.setFont(fuente);
			textFieldComprarFichas10.setEditable(false);
			textFieldComprarFichas10.setColumns(2);
			textFieldComprarFichas10.setHorizontalAlignment(SwingConstants.CENTER);
			
			if (user != null) {
				textFieldComprarFichas10.setText(String.valueOf(user.contarFichas(10)));
			}
		}
		
		return textFieldComprarFichas10;
	}
	
	/**
	 * Devuelve o crea el panel para seleccionar compra de fichas de 20, si no está creado
	 * @return Panel de selección de compra de fichas de 20, de tipo JPanel
	 */
	private JPanel getPnComprarFichas20() {
		if (pnComprarFichas20 == null) {
			pnComprarFichas20 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichas20.getLayout();
			flowLayout.setHgap(10);
			pnComprarFichas20.setBackground(new Color(128, 0, 0));
			pnComprarFichas20.add(getLblComprarFichas20());
			pnComprarFichas20.add(getSpinnerComprarFichas20());
			pnComprarFichas20.add(getTextFieldComprarFichas20());
		}
		
		return pnComprarFichas20;
	}
	
	/**
	 * Devuelve o crea la etiqueta con icono de ficha de 20 al comprar, si no está creada
	 * @return Etiqueta con el icono de la ficha de 20 a comprar, de tipo JLabel
	 */
	private JLabel getLblComprarFichas20() {
		if (lblComprarFichas20 == null) {
			lblComprarFichas20 = new JLabel("");
			lblComprarFichas20.setLabelFor(getSpinnerComprarFichas20());
			lblComprarFichas20.setDisplayedMnemonic('3');
			lblComprarFichas20.setIcon(new ImageIcon(new ImageIcon("files/img/token/20.PNG")
					.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		}
		
		return lblComprarFichas20;
	}
	
	/**
	 * Devuelve o crea el selector de fichas de 20 a comprar, si no está creado
	 * @return Selector de fichas de 20 a comprar, de tipo JSpinner
	 */
	private JSpinner getSpinnerComprarFichas20() {
		if (spinnerComprarFichas20 == null) {
			spinnerComprarFichas20 = new JSpinner();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			spinnerComprarFichas20.setFont(fuente);
			spinnerComprarFichas20.setPreferredSize(new Dimension(35, 20));
			spinnerComprarFichas20.setModel(new SpinnerNumberModel(new Integer(0), 
					new Integer(0), null, new Integer(1)));
			
			// Al utilizarlo, actualiza el contador de fichas tras la supuesta compra
			spinnerComprarFichas20.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int valor = (Integer) ((JSpinner) arg0.getSource()).getValue();
					getTextFieldComprarFichas20().setText(String.valueOf(user.contarFichas(20) + valor));
				}
			});
			
			// También activa el botón de Comprar
			spinnerComprarFichas20.addChangeListener(pcf);
		}
		
		return spinnerComprarFichas20;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el número de fichas de 20, si no está creado
	 * @return Campo de texto con el número de fichas de 20 a poseer, tipo JSpinner
	 */
	private JTextField getTextFieldComprarFichas20() {
		if (textFieldComprarFichas20 == null) {
			textFieldComprarFichas20 = new JTextField();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			textFieldComprarFichas20.setFont(fuente);
			textFieldComprarFichas20.setEditable(false);
			textFieldComprarFichas20.setColumns(2);
			textFieldComprarFichas20.setHorizontalAlignment(SwingConstants.CENTER);
			
			if (user != null) {
				textFieldComprarFichas20.setText(String.valueOf(user.contarFichas(20)));
			}
		}
		
		return textFieldComprarFichas20;
	}
	
	/**
	 * Devuelve o crea el panel para seleccionar compra de fichas de 50, si no está creado
	 * @return Panel de selección de compra de fichas de 50, de tipo JPanel
	 */
	private JPanel getPnComprarFichas50() {
		if (pnComprarFichas50 == null) {
			pnComprarFichas50 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichas50.getLayout();
			flowLayout.setHgap(10);
			pnComprarFichas50.setBackground(new Color(128, 0, 0));
			pnComprarFichas50.add(getLblComprarFichas50());
			pnComprarFichas50.add(getSpinnerComprarFichas50());
			pnComprarFichas50.add(getTextFieldComprarFichas50());
		}
		
		return pnComprarFichas50;
	}
	
	/**
	 * Devuelve o crea la etiqueta con icono de ficha de 50 al comprar, si no está creada
	 * @return Etiqueta con el icono de la ficha de 50 a comprar, de tipo JLabel
	 */
	private JLabel getLblComprarFichas50() {
		if (lblComprarFichas50 == null) {
			lblComprarFichas50 = new JLabel("");
			lblComprarFichas50.setLabelFor(getSpinnerComprarFichas50());
			lblComprarFichas50.setDisplayedMnemonic('4');
			lblComprarFichas50.setIcon(new ImageIcon(new ImageIcon("files/img/token/50.PNG")
					.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		}
		
		return lblComprarFichas50;
	}
	
	/**
	 * Devuelve o crea el selector de fichas de 50 a comprar, si no está creado
	 * @return Selector de fichas de 50 a comprar, de tipo JSpinner
	 */
	private JSpinner getSpinnerComprarFichas50() {
		if (spinnerComprarFichas50 == null) {
			spinnerComprarFichas50 = new JSpinner();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			spinnerComprarFichas50.setFont(fuente);
			spinnerComprarFichas50.setPreferredSize(new Dimension(35, 20));
			spinnerComprarFichas50.setModel(new SpinnerNumberModel(new Integer(0), 
					new Integer(0), null, new Integer(1)));
			
			// Al utilizarlo, actualiza el contador de fichas tras la supuesta compra
			spinnerComprarFichas50.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int valor = (Integer) ((JSpinner) arg0.getSource()).getValue();
					getTextFieldComprarFichas50().setText(String.valueOf(user.contarFichas(50) + valor));
				}
			});
			
			// También activa el botón de Comprar
			spinnerComprarFichas50.addChangeListener(pcf);
		}
		
		return spinnerComprarFichas50;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el número de fichas de 50, si no está creado
	 * @return Campo de texto con el número de fichas de 50 a poseer, tipo JSpinner
	 */
	private JTextField getTextFieldComprarFichas50() {
		if (textFieldComprarFichas50 == null) {
			textFieldComprarFichas50 = new JTextField();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			textFieldComprarFichas50.setFont(fuente);
			textFieldComprarFichas50.setEditable(false);
			textFieldComprarFichas50.setColumns(2);
			textFieldComprarFichas50.setHorizontalAlignment(SwingConstants.CENTER);
			
			if (user != null) {
				textFieldComprarFichas50.setText(String.valueOf(user.contarFichas(50)));
			}
		}
		
		return textFieldComprarFichas50;
	}
	
	/**
	 * Devuelve o crea el panel para seleccionar compra de fichas de 100, si no está creado
	 * @return Panel de selección de compra de fichas de 100, de tipo JPanel
	 */
	private JPanel getPnComprarFichas100() {
		if (pnComprarFichas100 == null) {
			pnComprarFichas100 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichas100.getLayout();
			flowLayout.setHgap(10);
			pnComprarFichas100.setBackground(new Color(128, 0, 0));
			pnComprarFichas100.add(getLblComprarFichas100());
			pnComprarFichas100.add(getSpinnerComprarFichas100());
			pnComprarFichas100.add(getTextFieldComprarFichas100());
		}
		
		return pnComprarFichas100;
	}
	
	/**
	 * Devuelve o crea la etiqueta con icono de ficha de 100 al comprar, si no está creada
	 * @return Etiqueta con el icono de la ficha de 100 a comprar, de tipo JLabel
	 */
	private JLabel getLblComprarFichas100() {
		if (lblComprarFichas100 == null) {
			lblComprarFichas100 = new JLabel("");
			lblComprarFichas100.setLabelFor(getSpinnerComprarFichas100());
			lblComprarFichas100.setDisplayedMnemonic('5');
			lblComprarFichas100.setIcon(new ImageIcon(new ImageIcon("files/img/token/100.PNG")
					.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		}
		
		return lblComprarFichas100;
	}
	
	/**
	 * Devuelve o crea el selector de fichas de 100 a comprar, si no está creado
	 * @return Selector de fichas de 100 a comprar, de tipo JSpinner
	 */
	private JSpinner getSpinnerComprarFichas100() {
		if (spinnerComprarFichas100 == null) {
			spinnerComprarFichas100 = new JSpinner();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			spinnerComprarFichas100.setFont(fuente);
			spinnerComprarFichas100.setPreferredSize(new Dimension(35, 20));
			spinnerComprarFichas100.setModel(new SpinnerNumberModel(new Integer(0), 
					new Integer(0), null, new Integer(1)));
			
			// Al utilizarlo, actualiza el contador de fichas tras la supuesta compra
			spinnerComprarFichas100.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int valor = (Integer) ((JSpinner) arg0.getSource()).getValue();
					getTextFieldComprarFichas100().setText(String.valueOf(user.contarFichas(100) + valor));
				}
			});
			
			// También activa el botón de Comprar
			spinnerComprarFichas100.addChangeListener(pcf);
		}
		
		return spinnerComprarFichas100;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el número de fichas de 100, si no está creado
	 * @return Campo de texto con el número de fichas de 100 a poseer, tipo JSpinner
	 */
	private JTextField getTextFieldComprarFichas100() {
		if (textFieldComprarFichas100 == null) {
			textFieldComprarFichas100 = new JTextField();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			textFieldComprarFichas100.setFont(fuente);
			textFieldComprarFichas100.setEditable(false);
			textFieldComprarFichas100.setColumns(2);
			textFieldComprarFichas100.setHorizontalAlignment(SwingConstants.CENTER);
			
			if (user != null) {
				textFieldComprarFichas100.setText(String.valueOf(user.contarFichas(100)));
			}
		}
		
		return textFieldComprarFichas100;
	}
	
	/**
	 * Devuelve o crea el panel de los botones en Comprar Fichas, si no está creado
	 * @return Panel de botones en Comprar Fichas, de tipo JPanel
	 */
	private JPanel getPnComprarFichasSur() {
		if (pnComprarFichasSur == null) {
			pnComprarFichasSur = new JPanel();
			pnComprarFichasSur.setBackground(new Color(128, 0, 0));
			pnComprarFichasSur.setLayout(new BorderLayout(0, 0));
			pnComprarFichasSur.add(getPnComprarFichasBotones(), BorderLayout.EAST);
		}
		
		return pnComprarFichasSur;
	}
	
	/**
	 * Devuelve o crea la etiqueta de aviso si no hay método de pago, si no está creada
	 * @return Etiqueta de aviso si no hay método de pago, de tipo JLabel
	 */
	private JLabel getLblComprarFichasMetodoPago() {
		if (lblComprarFichasMetodoPago == null) {
			lblComprarFichasMetodoPago = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 12);
			lblComprarFichasMetodoPago.setFont(fuente);
			lblComprarFichasMetodoPago.setForeground(Color.RED);
			lblComprarFichasMetodoPago.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblComprarFichasMetodoPago.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		return lblComprarFichasMetodoPago;
	}
	
	/**
	 * Devuelve o crea el botón Comprar del panel Comprar Fichas, si no está creado
	 * @return Botón Comprar del panel Comprar Fichas, de tipo JButton
	 */
	private JButton getBtnComprarFichasComprar() {
		if (btnComprarFichasComprar == null) {
			btnComprarFichasComprar = new JButton("");
			btnComprarFichasComprar.setEnabled(false);
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 16);
			btnComprarFichasComprar.setFont(fuente);
			btnComprarFichasComprar.setHorizontalTextPosition(SwingConstants.RIGHT);
			btnComprarFichasComprar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnComprarFichasComprar.setFocusPainted(false);
			
			// Al pulsarlo, muestra un diálogo de confirmación y añade las fichas
			btnComprarFichasComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// Si no hay nada seleccionado, se avisa y no hace nada
					if (calculaValorSeleccionado() == 0) {
						JOptionPane.showMessageDialog(null, strings.getString("err_bank_empty"),
								strings.getString("err_bank_title"), JOptionPane.ERROR_MESSAGE);
						
					// En caso contrario, se pide confirmación y se añade
					} else {
					
						// Se muestra un diálogo para confirmación del usuario
						if (JOptionPane.showOptionDialog(null, strings.getString("dialog_bank_msg"),
								strings.getString("dialog_bank_title"), 0, JOptionPane.QUESTION_MESSAGE, null,
								new String[] { strings.getString("opt_yes"), "No" }, null) == 0) {

							comprarFichas();
							goToMainScreen();
						}
					}
				}
			});
		}
		
		return btnComprarFichasComprar;
	}
	
	/**
	 * Añade las fichas seleccionadas a la sesión del usuario
	 */
	private void comprarFichas() {
		db.buscarUsuario(user.getUserName()).setBalance(db.buscarUsuario(
				user.getUserName()).getBalance() - calculaValorSeleccionado());
		
		// Si hay fichas de 5 seleccionadas, se añaden
		for (int i = 0; i < (Integer) getSpinnerComprarFichas5().getValue(); i++) {
			db.buscarUsuario(user.getUserName()).addFicha(new Ficha(5));
		}
		
		// Si hay fichas de 10 seleccionadas, se añaden
		for (int i = 0; i < (Integer) getSpinnerComprarFichas10().getValue(); i++) {
			db.buscarUsuario(user.getUserName()).addFicha(new Ficha(10));
		}
		
		// Si hay fichas de 20 seleccionadas, se añaden
		for (int i = 0; i < (Integer) getSpinnerComprarFichas20().getValue(); i++) {
			db.buscarUsuario(user.getUserName()).addFicha(new Ficha(20));
		}
		
		// Si hay fichas de 50 seleccionadas, se añaden
		for (int i = 0; i < (Integer) getSpinnerComprarFichas50().getValue(); i++) {
			db.buscarUsuario(user.getUserName()).addFicha(new Ficha(50));
		}
		
		// Si hay fichas de 100 seleccionadas, se añaden
		for (int i = 0; i < (Integer) getSpinnerComprarFichas100().getValue(); i++) {
			db.buscarUsuario(user.getUserName()).addFicha(new Ficha(100));
		}
		
		// Actualiza los cálculos en el panel de Comprar Fichas
		actualizaCalculosComprarFichas();
		
		// Deshace la selección de fichas
		deshacerSeleccionFichas();
		
		// Por último, actualiza los contadores de fichas en posesión
		actualizarFichas();
	}
	
	/**
	 * Devuelve o crea el botón Cancelar del panel Comprar Fichas, si no está creado
	 * @return Botón Cancelar del panel Comprar Fichas, de tipo JButton
	 */
	private JButton getBtnComprarFichasCancelar() {
		if (btnComprarFichasCancelar == null) {
			btnComprarFichasCancelar = new JButton("");
			btnComprarFichasCancelar.setMnemonic('N');
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 16);
			btnComprarFichasCancelar.setFont(fuente);
			btnComprarFichasCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
			btnComprarFichasCancelar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnComprarFichasCancelar.setFocusPainted(false);
			
			// Al pulsarlo, reinicia el panel Comprar Fichas y vuelve al juego
			btnComprarFichasCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deshacerSeleccionFichas();
					goToMainScreen();
				}
			});
		}
		
		return btnComprarFichasCancelar;
	}
	
	/**
	 * Deshace la selección de fichas, desmarcando los JSpinners
	 * y actualizando los campos de texto
	 */
	private void deshacerSeleccionFichas() {
		// Pone todos los spinners a 0
		getSpinnerComprarFichas5().setValue(0);
		getSpinnerComprarFichas10().setValue(0);
		getSpinnerComprarFichas20().setValue(0);
		getSpinnerComprarFichas50().setValue(0);
		getSpinnerComprarFichas100().setValue(0);

		// Actualiza los campos de texto de Comprar Fichas
		actualizaCalculosComprarFichas();
		
		// Elimina el precio y el valor a añadir mostrados
		getTextFieldComprarFichasPrecio().setText("");
		getTextFieldComprarFichasValorAñadido().setText("");
	}

	/**
	 * Devuelve o crea el panel con los cambios de saldo y valor, si no está creado
	 * @return Panel con los cambios de saldo y valor, de tipo JPanel
	 */
	private JPanel getPnComprarFichasCalculos() {
		if (pnComprarFichasCalculos == null) {
			pnComprarFichasCalculos = new JPanel();
			pnComprarFichasCalculos.setMinimumSize(new Dimension(40, 40));
//			pnComprarFichasCalculos.setBorder(new LineBorder(Color.WHITE, 1, true));
			pnComprarFichasCalculos.setBackground(new Color(128, 0, 0));
			pnComprarFichasCalculos.setLayout(new GridLayout(2, 0, 0, 0));
			pnComprarFichasCalculos.add(getPnComprarFichasSaldo());
			pnComprarFichasCalculos.add(getPnComprarFichasValor());
		}
		
		return pnComprarFichasCalculos;
	}
	
	/**
	 * Devuelve o crea el subpanel con los cambios de saldo, si no está creado
	 * @return Subpanel con los cambios de saldo, de tipo JPanel
	 */
	private JPanel getPnComprarFichasSaldo() {
		if (pnComprarFichasSaldo == null) {
			pnComprarFichasSaldo = new JPanel();
			pnComprarFichasSaldo.setBorder(new LineBorder(Color.WHITE, 1, true));
			pnComprarFichasSaldo.setBackground(new Color(128, 0, 0));
			pnComprarFichasSaldo.setLayout(new GridLayout(2, 0, 0, 0));
			pnComprarFichasSaldo.add(getPnComprarFichasSaldoSub1());
			pnComprarFichasSaldo.add(getPnComprarFichasSaldoFinal());
		}
		
		return pnComprarFichasSaldo;
	}
	
	/**
	 * Devuelve o crea el panel de botones del panel Comprar Fichas, si no está creado
	 * @return Panel de botones del panel Comprar Fichas, de tipo JPanel
	 */
	private JPanel getPnComprarFichasBotones() {
		if (pnComprarFichasBotones == null) {
			pnComprarFichasBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichasBotones.getLayout();
			flowLayout.setHgap(10);
			pnComprarFichasBotones.setBackground(new Color(128, 0, 0));
			pnComprarFichasBotones.add(getLblComprarFichasMetodoPago());
			pnComprarFichasBotones.add(getBtnComprarFichasComprar());
			pnComprarFichasBotones.add(getBtnComprarFichasCancelar());
		}
		
		return pnComprarFichasBotones;
	}
	
	/**
	 * Devuelve o crea el subpanel superior con los cambios de saldo, si no está creado
	 * @return Subpanel superior con los cambios de saldo, de tipo JPanel
	 */
	private JPanel getPnComprarFichasSaldoSub1() {
		if (pnComprarFichasSaldoSub1 == null) {
			pnComprarFichasSaldoSub1 = new JPanel();
			pnComprarFichasSaldoSub1.setBorder(new LineBorder(Color.WHITE, 1, true));
			pnComprarFichasSaldoSub1.setBackground(new Color(128, 0, 0));
			pnComprarFichasSaldoSub1.setLayout(new GridLayout(2, 0, 0, 0));
			pnComprarFichasSaldoSub1.add(getPnComprarFichasSaldoSub1Saldo());
			pnComprarFichasSaldoSub1.add(getPnComprarFichasSaldoSub1Precio());
		}
		
		return pnComprarFichasSaldoSub1;
	}
	
	/**
	 * Devuelve o crea el subpanel superior con el saldo inicial, si no está creado
	 * @return Subpanel superior con el saldo inicial, de tipo JPanel
	 */
	private JPanel getPnComprarFichasSaldoSub1Saldo() {
		if (pnComprarFichasSaldoSub1Saldo == null) {
			pnComprarFichasSaldoSub1Saldo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichasSaldoSub1Saldo.getLayout();
			flowLayout.setHgap(20);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnComprarFichasSaldoSub1Saldo.setBackground(new Color(128, 0, 0));
			pnComprarFichasSaldoSub1Saldo.add(getLblComprarFichasSaldo());
			pnComprarFichasSaldoSub1Saldo.add(getTextFieldComprarFichasSaldo());
		}
		
		return pnComprarFichasSaldoSub1Saldo;
	}
	
	/**
	 * Devuelve o crea el subpanel inferior con el saldo a restar, si no está creado
	 * @return Subpanel inferior con el saldo a restar, de tipo JPanel
	 */
	private JPanel getPnComprarFichasSaldoSub1Precio() {
		if (pnComprarFichasSaldoSub1Precio == null) {
			pnComprarFichasSaldoSub1Precio = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichasSaldoSub1Precio.getLayout();
			flowLayout.setHgap(20);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnComprarFichasSaldoSub1Precio.setBackground(new Color(128, 0, 0));
			pnComprarFichasSaldoSub1Precio.add(getLblComprarFichasPrecio());
			pnComprarFichasSaldoSub1Precio.add(getTextFieldComprarFichasPrecio());
		}
		
		return pnComprarFichasSaldoSub1Precio;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el saldo inicial al comprar fichas, si no está creada
	 * @return Etiqueta con el saldo inicial al comprar fichas, de tipo JLabel
	 */
	private JLabel getLblComprarFichasSaldo() {
		if (lblComprarFichasSaldo == null) {
			lblComprarFichasSaldo = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			lblComprarFichasSaldo.setFont(fuente);
		}
		
		return lblComprarFichasSaldo;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el saldo inicial al comprar fichas, si no está creada
	 * @return Campo de texto con el saldo inicial al comprar fichas, de tipo JTextField
	 */
	private JTextField getTextFieldComprarFichasSaldo() {
		if (textFieldComprarFichasSaldo == null) {
			textFieldComprarFichasSaldo = new JTextField();
			textFieldComprarFichasSaldo.setFont(new Font("Monospaced", Font.BOLD, 14));
			textFieldComprarFichasSaldo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldComprarFichasSaldo.setEditable(false);
			textFieldComprarFichasSaldo.setColumns(10);
		}
		
		return textFieldComprarFichasSaldo;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el saldo a restar al comprar fichas, si no está creada
	 * @return Etiqueta con el saldo inicial al comprar fichas, de tipo JLabel
	 */
	private JLabel getLblComprarFichasPrecio() {
		if (lblComprarFichasPrecio == null) {
			lblComprarFichasPrecio = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			lblComprarFichasPrecio.setFont(fuente);
		}
		
		return lblComprarFichasPrecio;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el saldo a restar al comprar fichas, si no está creada
	 * @return Campo de texto con el saldo a restar al comprar fichas, de tipo JTextField
	 */
	private JTextField getTextFieldComprarFichasPrecio() {
		if (textFieldComprarFichasPrecio == null) {
			textFieldComprarFichasPrecio = new JTextField();
			textFieldComprarFichasPrecio.setFont(new Font("Monospaced", Font.BOLD, 14));
			textFieldComprarFichasPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldComprarFichasPrecio.setEditable(false);
			textFieldComprarFichasPrecio.setColumns(10);
		}
		
		return textFieldComprarFichasPrecio;
	}
	
	/**
	 * Devuelve o crea el subpanel inferior con el saldo final, si no está creado
	 * @return Subpanel inferior con el saldo final, de tipo JPanel
	 */
	private JPanel getPnComprarFichasSaldoFinal() {
		if (pnComprarFichasSaldoFinal == null) {
			pnComprarFichasSaldoFinal = new JPanel();
			pnComprarFichasSaldoFinal.setBorder(new LineBorder(Color.WHITE, 2, true));
			FlowLayout flowLayout = (FlowLayout) pnComprarFichasSaldoFinal.getLayout();
			flowLayout.setHgap(20);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(25);
			pnComprarFichasSaldoFinal.setBackground(new Color(128, 0, 0));
			pnComprarFichasSaldoFinal.add(getLblComprarFichasSaldoFinal());
			pnComprarFichasSaldoFinal.add(getTextFieldComprarFichasSaldoFinal());
		}
		
		return pnComprarFichasSaldoFinal;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el saldo final al comprar fichas, si no está creada
	 * @return Etiqueta con el saldo final al comprar fichas, de tipo JLabel
	 */
	private JLabel getLblComprarFichasSaldoFinal() {
		if (lblComprarFichasSaldoFinal == null) {
			lblComprarFichasSaldoFinal = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			lblComprarFichasSaldoFinal.setFont(fuente);
		}
		
		return lblComprarFichasSaldoFinal;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el saldo final al comprar fichas, si no está creado
	 * @return Campo de texto con el saldo final al comprar fichas, de tipo JTextField
	 */
	private JTextField getTextFieldComprarFichasSaldoFinal() {
		if (textFieldComprarFichasSaldoFinal == null) {
			textFieldComprarFichasSaldoFinal = new JTextField();
			textFieldComprarFichasSaldoFinal.setFont(new Font("Monospaced", Font.BOLD, 14));
			textFieldComprarFichasSaldoFinal.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldComprarFichasSaldoFinal.setEditable(false);
			textFieldComprarFichasSaldoFinal.setColumns(10);
		}
		
		return textFieldComprarFichasSaldoFinal;
	}
	
	/**
	 * Devuelve o crea el subpanel inferior con el valor de las fichas al comprar, si no está creado
	 * @return Subpanel inferior con el valor de fichas al comprar, tipo JPanel
	 */
	private JPanel getPnComprarFichasValor() {
		if (pnComprarFichasValor == null) {
			pnComprarFichasValor = new JPanel();
			pnComprarFichasValor.setBackground(new Color(128, 0, 0));
			pnComprarFichasValor.setLayout(new GridLayout(2, 0, 0, 0));
			pnComprarFichasValor.add(getPnComprarFichasValorInicial());
			pnComprarFichasValor.add(getPnComprarFichasValorFinal());
		}
		
		return pnComprarFichasValor;
	}
	
	/**
	 * Devuelve o crea el panel superior con el valor inicial de las fichas al comprar, si no está creado
	 * @return Panel superior con el valor inicial de fichas al comprar, tipo JPanel
	 */
	private JPanel getPnComprarFichasValorInicial() {
		if (pnComprarFichasValorInicial == null) {
			pnComprarFichasValorInicial = new JPanel();
			pnComprarFichasValorInicial.setBorder(new LineBorder(Color.WHITE, 2, true));
			pnComprarFichasValorInicial.setBackground(new Color(128, 0, 0));
			pnComprarFichasValorInicial.setLayout(new GridLayout(2, 0, 0, 0));
			pnComprarFichasValorInicial.add(getPnComprarFichasValorInicialSub());
			pnComprarFichasValorInicial.add(getPnComprarFichasValorAñadido());
		}
		
		return pnComprarFichasValorInicial;
	}
	
	/**
	 * Devuelve o crea el subpanel superior con el valor inicial de las fichas al comprar, si no está creado
	 * @return Subpanel superior con el valor inicial de fichas al comprar, tipo JPanel
	 */
	private JPanel getPnComprarFichasValorInicialSub() {
		if (pnComprarFichasValorInicialSub == null) {
			pnComprarFichasValorInicialSub = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichasValorInicialSub.getLayout();
			flowLayout.setHgap(20);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnComprarFichasValorInicialSub.setBackground(new Color(128, 0, 0));
			pnComprarFichasValorInicialSub.add(getLblComprarFichasValorInicial());
			pnComprarFichasValorInicialSub.add(getTextFieldComprarFichasValorInicial());
		}
		
		return pnComprarFichasValorInicialSub;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el valor inicial al comprar fichas, si no está creada
	 * @return Etiqueta con el valor inicial al comprar fichas, tipo JLabel
	 */
	private JLabel getLblComprarFichasValorInicial() {
		if (lblComprarFichasValorInicial == null) {
			lblComprarFichasValorInicial = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			lblComprarFichasValorInicial.setFont(fuente);
		}
		
		return lblComprarFichasValorInicial;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el valor inicial al comprar fichas, si no está creado
	 * @return Campo de texto con el valor inicial al comprar fichas, tipo JTextField
	 */
	private JTextField getTextFieldComprarFichasValorInicial() {
		if (textFieldComprarFichasValorInicial == null) {
			textFieldComprarFichasValorInicial = new JTextField();
			textFieldComprarFichasValorInicial.setFont(new Font("Monospaced", Font.BOLD, 14));
			textFieldComprarFichasValorInicial.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldComprarFichasValorInicial.setEditable(false);
			textFieldComprarFichasValorInicial.setColumns(10);
		}
		
		return textFieldComprarFichasValorInicial;
	}
	
	/**
	 * Devuelve o crea el subpanel inferior con el valor añadido de las fichas al comprar, si no está creado
	 * @return Subpanel inferior con el valor añadido de fichas al comprar, tipo JPanel
	 */
	private JPanel getPnComprarFichasValorAñadido() {
		if (pnComprarFichasValorAñadido == null) {
			pnComprarFichasValorAñadido = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnComprarFichasValorAñadido.getLayout();
			flowLayout.setHgap(20);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnComprarFichasValorAñadido.setBackground(new Color(128, 0, 0));
			pnComprarFichasValorAñadido.add(getLblComprarFichasValorAñadido());
			pnComprarFichasValorAñadido.add(getTextFieldComprarFichasValorAñadido());
		}
		
		return pnComprarFichasValorAñadido;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el valor añadido al comprar fichas, si no está creada
	 * @return Etiqueta con el valor añadido al comprar fichas, tipo JLabel
	 */
	private JLabel getLblComprarFichasValorAñadido() {
		if (lblComprarFichasValorAñadido == null) {
			lblComprarFichasValorAñadido = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			lblComprarFichasValorAñadido.setFont(fuente);
		}
		
		return lblComprarFichasValorAñadido;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el valor añadido al comprar fichas, si no está creado
	 * @return Campo de texto con el valor añadido al comprar fichas, tipo JTextField
	 */
	private JTextField getTextFieldComprarFichasValorAñadido() {
		if (textFieldComprarFichasValorAñadido == null) {
			textFieldComprarFichasValorAñadido = new JTextField();
			textFieldComprarFichasValorAñadido.setFont(new Font("Monospaced", Font.BOLD, 14));
			textFieldComprarFichasValorAñadido.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldComprarFichasValorAñadido.setEditable(false);
			textFieldComprarFichasValorAñadido.setColumns(10);
		}
		
		return textFieldComprarFichasValorAñadido;
	}
	
	/**
	 * Devuelve o crea el panel inferior con el valor final de las fichas al comprar, si no está creado
	 * @return Panel inferior con el valor final de fichas al comprar, tipo JPanel
	 */
	private JPanel getPnComprarFichasValorFinal() {
		if (pnComprarFichasValorFinal == null) {
			pnComprarFichasValorFinal = new JPanel();
			pnComprarFichasValorFinal.setBorder(new LineBorder(Color.WHITE, 3, true));
			FlowLayout flowLayout = (FlowLayout) pnComprarFichasValorFinal.getLayout();
			flowLayout.setHgap(20);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(25);
			pnComprarFichasValorFinal.setBackground(new Color(128, 0, 0));
			pnComprarFichasValorFinal.add(getLblComprarFichasValorFinal());
			pnComprarFichasValorFinal.add(getTextFieldComprarFichasValorFinal());
		}
		
		return pnComprarFichasValorFinal;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el valor final al comprar fichas, si no está creada
	 * @return Etiqueta con el valor final al comprar fichas, tipo JLabel
	 */
	private JLabel getLblComprarFichasValorFinal() {
		if (lblComprarFichasValorFinal == null) {
			lblComprarFichasValorFinal = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			lblComprarFichasValorFinal.setFont(fuente);
		}
		
		return lblComprarFichasValorFinal;
	}
	
	/**
	 * Devuelve o crea el campo de texto con el valor final al comprar fichas, si no está creado
	 * @return Campo de texto con el valor final al comprar fichas, tipo JTextField
	 */
	private JTextField getTextFieldComprarFichasValorFinal() {
		if (textFieldComprarFichasValorFinal == null) {
			textFieldComprarFichasValorFinal = new JTextField();
			textFieldComprarFichasValorFinal.setFont(new Font("Monospaced", Font.BOLD, 14));
			textFieldComprarFichasValorFinal.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldComprarFichasValorFinal.setEditable(false);
			textFieldComprarFichasValorFinal.setColumns(10);
		}
		
		return textFieldComprarFichasValorFinal;
	}
	
	/**
	 * Devuelve o crea el panel de relleno al este al Comprar Fichas, si no está creado
	 * @return Panel de relleno al este en Comprar Fichas, de tipo JLabel
	 */
	private JPanel getPnComprarFichasEste() {
		if (pnComprarFichasEste == null) {
			pnComprarFichasEste = new JPanel();
			pnComprarFichasEste.setBackground(new Color(128, 0, 0));
		}
		
		return pnComprarFichasEste;
	}
	
	/**
	 * Devuelve o crea el panel para cargar saldo, si no está creado
	 * @return Panel para cargar saldo, de tipo JPanel
	 */
	private JPanel getPnCargarSaldo() {
		if (pnCargarSaldo == null) {
			pnCargarSaldo = new JPanel();
			pnCargarSaldo.setBorder(new MatteBorder(20, 20, 20, 20, (Color) new Color(128, 0, 0)));
			pnCargarSaldo.setLayout(new BorderLayout(150, 20));
			pnCargarSaldo.setBackground(new Color(128, 0, 0));
			pnCargarSaldo.add(getPnCargarSaldoLogo(), BorderLayout.NORTH);
			pnCargarSaldo.add(getPnCargarSaldoSeleccion(), BorderLayout.CENTER);
			pnCargarSaldo.add(getPnCargarSaldoBotones(), BorderLayout.SOUTH);
		}
		
		return pnCargarSaldo;
	}
	
	/**
	 * Devuelve o crea el panel que contiene el logo al cargar saldo, si no está creado
	 * @return Panel de logo en el panel de cargar saldo, de tipo JPanel
	 */
	private JPanel getPnCargarSaldoLogo() {
		if (pnCargarSaldoLogo == null) {
			pnCargarSaldoLogo = new JPanel();
			pnCargarSaldoLogo.setBackground(new Color(128, 0, 0));
			pnCargarSaldoLogo.setLayout(new BorderLayout(150, 0));
			pnCargarSaldoLogo.add(getLblCargarSaldoLogo(), BorderLayout.WEST);
			pnCargarSaldoLogo.add(getLblCargarSaldoTitle(), BorderLayout.CENTER);
		}
		
		return pnCargarSaldoLogo;
	}
	
	/**
	 * Devuelve o crea la etiqueta del logo al cargar saldo, si no está creada
	 * @return Etiqueta del logo al cargar saldo, de tipo JLabel
	 */
	private JLabel getLblCargarSaldoLogo() {
		if (lblCargarSaldoLogo == null) {
			lblCargarSaldoLogo = new JLabel("");
			lblCargarSaldoLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblCargarSaldoLogo.setHorizontalAlignment(SwingConstants.LEFT);
			lblCargarSaldoLogo.setForeground(Color.WHITE);
			lblCargarSaldoLogo.setFont(new Font("Mistral", Font.BOLD, 40));
			lblCargarSaldoLogo.setIcon(new ImageIcon(new ImageIcon("files/img/plus.png")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		}
		
		return lblCargarSaldoLogo;	
	}
	
	/**
	 * Devuelve o crea la etiqueta descriptiva en el panel de cargar saldo, si no está creada
	 * @return Etiqueta descriptiva al cargar saldo, de tipo JLabel
	 */
	private JLabel getLblCargarSaldoTitle() {
		if (lblCargarSaldoTitle == null) {
			lblCargarSaldoTitle = new JLabel("xd");
			lblCargarSaldoTitle.setForeground(new Color(255, 255, 255));
			lblCargarSaldoTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		
		return lblCargarSaldoTitle;
	}
	
	/**
	 * Devuelve o crea el panel de selección al cargar saldo, si no está creado
	 * @return Panel de selección al cargar saldo, de tipo JPanel
	 */
	private JPanel getPnCargarSaldoSeleccion() {
		if (pnCargarSaldoSeleccion == null) {
			pnCargarSaldoSeleccion = new JPanel();
			pnCargarSaldoSeleccion.setBorder(new MatteBorder(100, 100, 100, 100, (Color) new Color(128, 0, 0)));
			pnCargarSaldoSeleccion.setBackground(new Color(128, 0, 0));
			pnCargarSaldoSeleccion.setLayout(new GridLayout(0, 1, 0, 10));
			
			// Se añaden los componentes
			pnCargarSaldoSeleccion.add(getLblCargarSaldoAñadir());
			pnCargarSaldoSeleccion.add(getTextFieldCargarSaldoAñadir());
		}
		
		return pnCargarSaldoSeleccion;
	}
	
	/**
	 * Devuelve o crea la etiqueta mostrada en el cajón de añadir saldo, si no está creada
	 * @return Etiqueta mostrada sobre el cajón de añadir saldo, de tipo JLabel
	 */
	private JLabel getLblCargarSaldoAñadir() {
		if (lblCargarSaldoAñadir == null) {
			lblCargarSaldoAñadir = new JLabel();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 16);
			lblCargarSaldoAñadir.setFont(fuente);
			lblCargarSaldoAñadir.setDisplayedMnemonic('L');
			lblCargarSaldoAñadir.setLabelFor(getTextFieldCargarSaldoAñadir());
		}
		
		return lblCargarSaldoAñadir;
	}
	
	/**
	 * Devuelve o crea el campo de texto para añadir saldo, si no está creado
	 * @return Campo de texto para añadir saldo, de tipo JLabel
	 */
	private JTextField getTextFieldCargarSaldoAñadir() {
		if (textFieldCargarSaldoAñadir == null) {
			textFieldCargarSaldoAñadir = new JTextField();
			textFieldCargarSaldoAñadir.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldCargarSaldoAñadir.setFont(new Font("Monospaced", Font.PLAIN, 36));
			textFieldCargarSaldoAñadir.setColumns(10);
			textFieldCargarSaldoAñadir.addKeyListener(ppt);
		}
		
		return textFieldCargarSaldoAñadir;
	}
	
	/**
	 * Devuelve o crea el panel de botones en Cargar Saldo, si no está creado
	 * @return Panel de botones en el panel de Cargar Saldo, de tipo JPanel
	 */
	private JPanel getPnCargarSaldoBotones() {
		if (pnCargarSaldoBotones == null) {
			pnCargarSaldoBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnCargarSaldoBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setHgap(10);
			pnCargarSaldoBotones.setBackground(new Color(128, 0, 0));
			pnCargarSaldoBotones.add(getLblCargarSaldoMetodoPago());
			pnCargarSaldoBotones.add(getBtnCargarSaldoAñadir());
			pnCargarSaldoBotones.add(getBtnCargarSaldoCancelar());
		}
		
		return pnCargarSaldoBotones;
	}
	
	/**
	 * Devuelve o crea la etiqueta de aviso si no hay método de pago, si no está creada
	 * @return Etiqueta de aviso si no hay método de pago al cargar saldo, de tipo JLabel
	 */
	private JLabel getLblCargarSaldoMetodoPago() {
		if (lblCargarSaldoMetodoPago == null) {
			lblCargarSaldoMetodoPago = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 16);
			lblCargarSaldoMetodoPago.setFont(fuente);
			lblCargarSaldoMetodoPago.setForeground(Color.RED);
			lblCargarSaldoMetodoPago.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblCargarSaldoMetodoPago.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		return lblCargarSaldoMetodoPago;
	}
	
	/**
	 * Devuelve o crea el botón Comprar del panel Cargar Saldo, si no está creado
	 * @return Botón Comprar del panel Cargar Saldo, de tipo JButton
	 */
	private JButton getBtnCargarSaldoAñadir() {
		if (btnCargarSaldoAñadir == null) {
			btnCargarSaldoAñadir = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 16);
			btnCargarSaldoAñadir.setFont(fuente);
			btnCargarSaldoAñadir.setMnemonic('D');
			btnCargarSaldoAñadir.setHorizontalTextPosition(SwingConstants.RIGHT);
			btnCargarSaldoAñadir.setHorizontalAlignment(SwingConstants.RIGHT);
			btnCargarSaldoAñadir.setFocusPainted(false);
			btnCargarSaldoAñadir.setEnabled(false);
			
			// Al pulsarlo, comprueba el texto introducido y lo añade si es válido
			btnCargarSaldoAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirSaldo();
					goToMainScreen();
				}
			});
		}
		
		return btnCargarSaldoAñadir;
	}
	
	/**
	 * Verifica si el texto introducido es numérico y válido.
	 * Si es así, añade el saldo introducido a la cuenta del usuario
	 */
	private void añadirSaldo() {
		try {
			
			String input = getTextFieldCargarSaldoAñadir().getText();
			
			// Si el valor introducido es correcto, se añade a la cuenta
			if (Double.parseDouble(input) > 0.0) {
				
				// Se avisa al usuario
				JOptionPane.showMessageDialog(null, strings.getString("dialog_charge_balance_1") 
						+ input.toString() + strings.getString("dialog_charge_balance_2"), 
						strings.getString("dialog_charge_title"), JOptionPane.INFORMATION_MESSAGE);
				
				// Se añade el nuevo saldo al usuario
				db.buscarUsuario(user.getUserName()).setBalance(
						db.buscarUsuario(user.getUserName()).getBalance() 
						+ Double.parseDouble(input));
				
				// Se reinicia el campo de texto
				getTextFieldCargarSaldoAñadir().setText("");
			} else {
				JOptionPane.showMessageDialog(null, strings.getString("err_charge_balance"), 
						strings.getString("err_charge_title"), JOptionPane.ERROR_MESSAGE);
				
				getTextFieldCargarSaldoAñadir().setText("");
			}
			
		// Si el valor introducido no es correcto, se avisa y se repite el proceso
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, strings.getString("err_charge_balance"), 
					strings.getString("err_charge_title"), JOptionPane.ERROR_MESSAGE);
			
			getTextFieldCargarSaldoAñadir().setText("");
		}
	}
	
	/**
	 * Devuelve o crea el botón Cancelar del panel Cargar Saldo, si no está creado
	 * @return Botón Cancelar del panel Cargar Saldo, de tipo JButton
	 */
	private JButton getBtnCargarSaldoCancelar() {
		if (btnCargarSaldoCancelar == null) {
			btnCargarSaldoCancelar = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 16);
			btnCargarSaldoCancelar.setFont(fuente);
			btnCargarSaldoCancelar.setMnemonic('C');
			btnCargarSaldoCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
			btnCargarSaldoCancelar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnCargarSaldoCancelar.setFocusPainted(false);
			
			// Al pulsarlo, reinicia el panel Comprar Fichas y vuelve al juego
			btnCargarSaldoCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldCargarSaldoAñadir().setText("");
					goToMainScreen();
				}
			});
		}
		
		return btnCargarSaldoCancelar;
	}
	
	/**
	 * Devuelve o crea el panel de bebidas, si no está creado
	 * @return Panel de bebidas, de tipo JPanel
	 */
	private JPanel getPnBebidas() {
		if (pnBebidas == null) {
			pnBebidas = new JPanel();
			pnBebidas.setForeground(Color.WHITE);
			pnBebidas.setBorder(new EmptyBorder(20, 20, 20, 20));
			pnBebidas.setBackground(new Color(128, 0, 0));
			pnBebidas.setLayout(new GridLayout(0, 2, 10, 0));
			pnBebidas.add(getPnBebidasOeste());
			pnBebidas.add(getScrollPaneBebidasEste());
		}
		
		return pnBebidas;
	}
	
	/**
	 * Devuelve o crea el subpanel oeste del panel de bebidas, si no está creado
	 * @return Subpanel oeste del panel de bebidas, de tipo JPanel
	 */
	private JPanel getPnBebidasOeste() {
		if (pnBebidasOeste == null) {
			pnBebidasOeste = new JPanel();
			pnBebidasOeste.setBackground(new Color(128, 0, 0));
			pnBebidasOeste.setLayout(new BorderLayout(0, 0));
			pnBebidasOeste.add(getPnBebidasOesteLogo(), BorderLayout.NORTH);
			pnBebidasOeste.add(getPnBebidasSaldo(), BorderLayout.SOUTH);
			pnBebidasOeste.add(getPnBebidasPedido(), BorderLayout.CENTER);
		}
		
		return pnBebidasOeste;
	}
	
	/**
	 * Devuelve o crea el subpanel con el logo en el panel de bebidas, si no está creado
	 * @return Subpanel con el logo en el panel de bebidas, de tipo JPanel
	 */
	private JPanel getPnBebidasOesteLogo() {
		if (pnBebidasOesteLogo == null) {
			pnBebidasOesteLogo = new JPanel();
			pnBebidasOesteLogo.setBackground(new Color(128, 0, 0));
			pnBebidasOesteLogo.setLayout(new BorderLayout(0, 0));
			pnBebidasOesteLogo.add(getLblPnBebidasLogo(), BorderLayout.WEST);
			pnBebidasOesteLogo.add(getLblPnBebidasMetodoPago(), BorderLayout.CENTER);
		}
		
		return pnBebidasOesteLogo;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el logo en el panel de bebidas, si no está creada
	 * @return Etiqueta con el logo en el panel de bebidas, de tipo JLabel
	 */
	private JLabel getLblPnBebidasLogo() {
		if (lblPnBebidasLogo == null) {
			lblPnBebidasLogo = new JLabel("");
			lblPnBebidasLogo.setFont(new Font("Mistral", Font.BOLD, 40));
			lblPnBebidasLogo.setForeground(new Color(255, 255, 255));
			lblPnBebidasLogo.setIcon(new ImageIcon(new ImageIcon("files/img/drinks_menu.png")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		}
		
		return lblPnBebidasLogo;
	}
	
	/**
	 * Devuelve o crea la etiqueta mostrada si no hay método de pago en bebidas
	 * @return Etiqueta mostrada si no hay método de pago en bebidas, tipo JLabel
	 */
	private JLabel getLblPnBebidasMetodoPago() {
		if (lblPnBebidasMetodoPago == null) {
			lblPnBebidasMetodoPago = new JLabel("New label");
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 10);
			lblPnBebidasMetodoPago.setFont(fuente);
			lblPnBebidasMetodoPago.setHorizontalAlignment(SwingConstants.CENTER);
			lblPnBebidasMetodoPago.setForeground(Color.RED);
		}
		
		return lblPnBebidasMetodoPago;
	}
	
	/**
	 * Devuelve o crea el subpanel con el saldo en el panel de bebidas, si no está creado
	 * @return Subpanel que muestra el saldo en el panel de bebidas, tipo JPanel
	 */
	private JPanel getPnBebidasSaldo() {
		if (pnBebidasSaldo == null) {
			pnBebidasSaldo = new JPanel();
			pnBebidasSaldo.setBackground(new Color(128, 0, 0));
			FlowLayout flowLayout = (FlowLayout) pnBebidasSaldo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnBebidasSaldo.add(getLblPnBebidasSaldo());
		}
		
		return pnBebidasSaldo;
	}
	
	/**
	 * Devuelve o crea la etiqueta con el saldo en el panel de bebidas, si no está creada
	 * @return Etiqueta con el saldo en el panel de bebidas, de tipo JLabel
	 */
	private JLabel getLblPnBebidasSaldo() {
		if (lblPnBebidasSaldo == null) {
			lblPnBebidasSaldo = new JLabel("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 12);
			lblPnBebidasSaldo.setFont(fuente);
		}
		
		return lblPnBebidasSaldo;
	}
	
	/**
	 * Devuelve o crea el JScrollPane de las bebidas, si no está creado
	 * @return Panel deslizable de las bebidas, de tipo JScrollPane
	 */
	private JScrollPane getScrollPaneBebidasEste() {
		if (scrollPaneBebidasEste == null) {
			
			// Si no esta creado, se instancia y se establecen sus propiedades
			scrollPaneBebidasEste = new JScrollPane();
			scrollPaneBebidasEste.setViewportView(getPnBebidasEste());
		}
		
		return scrollPaneBebidasEste;
	}
	
	/**
	 * Devuelve o crea el panel sobre el que se disponen las bebidas, si no está creado
	 * @return Panel sobre el que se disponen las bebidas, de tipo JPanel
	 */
	private JPanel getPnBebidasEste() {
		if (pnBebidasEste == null) {
			pnBebidasEste = new JPanel();
			pnBebidasEste.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			pnBebidasEste.setBackground(Color.WHITE);
			pnBebidasEste.setLayout(new GridLayout(carta.getBebidas().length / 3, 3, 0, 0));
			
			// Se añaden los botones dinámicos
			creaBotonesBebidas();
		}
		
		return pnBebidasEste;
	}
	
	/**
	 * Añade de forma dinámica los botones en el panel de las bebidas
	 */
	private void creaBotonesBebidas() {
		
		// Se eliminan todos los componentes añadidos anteriormente
		pnBebidasEste.removeAll();
		
		// Se añade un nuevo botón con imagen por cada bebida en la carta
		for (int i = 0; i < carta.getBebidas().length; i++) {
			JButton btn = nuevoBoton(i);
			setImagenAdaptada(btn, "files/img/drinks/" + carta.getBebidas()[i]
					.getCodigo() + ".png");
			
			pnBebidasEste.add(btn);
		}
	}
	
	/**
	 * Crea un nuevo botón para un producto cuya posición en la carta se indica
	 * @param posicion posición en la carta del producto cuyo botón se crea, tipo Integer
	 * @return Botón creado a partir de la posición en la carta del producto, tipo JButton
	 */
	private JButton nuevoBoton(Integer posicion) {
		JButton boton = new JButton("");
		boton.setBackground(Color.WHITE);
		boton.setFocusPainted(false);
		boton.setContentAreaFilled(false);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setToolTipText(carta.getBebidas()[posicion].toString());
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(pab);
		
		return boton;
	}
	
	/**
	 * Establece un icono escalado para el botón pasado como parámetro
	 * @param boton botón al que se quiere establecer el icono, de tipo JButton
	 * @param path ruta en la que se aloja la imagen del icono, de tipo String
	 */
	private void setImagenAdaptada(JButton boton, String path) {
		 Image imgOriginal = new ImageIcon(path).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 
		 boton.setIcon(icon);
	}
	
	/**
	 * Añade una unidad de la bebida seleccionada en el pedido
	 * @param position posición de la bebida en la carta, de tipo int
	 */
	private void addToCart(int position) {
		if (!interactedWithOrder) {
			interactedWithOrder = true;
		}
		
		// Se consigue la bebida seleccionada de la carta y se añade
		Bebida d = carta.getBebidas()[position];
		pedido.add(d, 1);
		modeloListaPedido.addElement(d);
		
		// Se habilita el botón Pedir si no estaba habilitado
		if (!getBtnBebidasPedir().isEnabled()) {
			getBtnBebidasPedir().setEnabled(true);
		}
		
		// Se actualiza el precio y saldo final
		actualizarCamposBebidas();
	}
	
	/**
	 * Devuelve o crea el subpanel del pedido en el panel de bebidas, si no está creado
	 * @return Subpanel del pedido en el panel de bebidas, de tipo JPanel
	 */
	private JPanel getPnBebidasPedido() {
		if (pnBebidasPedido == null) {
			pnBebidasPedido = new JPanel();
			pnBebidasPedido.setBackground(new Color(128, 0, 0));
			pnBebidasPedido.setLayout(new BorderLayout(0, 0));
			pnBebidasPedido.add(getPnBebidasBotones(), BorderLayout.SOUTH);
			pnBebidasPedido.add(getPnBebidasListaPedidoPrecio(), BorderLayout.CENTER);
		}
		
		return pnBebidasPedido;
	}
	
	/**
	 * Devuelve o crea el subpanel con los botones en el pedido, si no está creado
	 * @return Subpanel de botones en el panel de pedido de bebidas, tipo JPanel
	 */
	private JPanel getPnBebidasBotones() {
		if (pnBebidasBotones == null) {
			pnBebidasBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBebidasBotones.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBebidasBotones.setBackground(new Color(128, 0, 0));
			pnBebidasBotones.add(getLblBebidasSinSaldo());
			pnBebidasBotones.add(getBtnBebidasPedir());
			pnBebidasBotones.add(getBtnBebidasCancelar());
		}
		
		return pnBebidasBotones;
	}
	
	/**
	 * Devuelve o crea el botón Pedir en el panel de bebidas, si no está creado
	 * @return Botón Pedir del panel de bebidas, de tipo JButton
	 */
	private JButton getBtnBebidasPedir() {
		if (btnBebidasPedir == null) {
			btnBebidasPedir = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			btnBebidasPedir.setFont(fuente);
			btnBebidasPedir.setFocusPainted(false);
			btnBebidasPedir.setEnabled(false);
			btnBebidasPedir.setMnemonic('R');
			
			// Al pulsar el botón, se confirma el pedido por el usuario
			btnBebidasPedir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showOptionDialog(null, strings.getString("dialog_drinks_confirm_msg"),
							strings.getString("dialog_drinks_confirm_title"), 0, JOptionPane.QUESTION_MESSAGE, null,
							new String[] { strings.getString("opt_yes"), "No" }, null) == 0) {
						
						confirmarPedido();
						goToMainScreen();
					}
				}
			});
		}
		
		return btnBebidasPedir;
	}
	
	/**
	 * Confirma el pedido, restando el saldo correspondiente al usuario
	 * y reiniciando los componentes y el pedido para la próxima interacción
	 */
	private void confirmarPedido() {
		db.buscarUsuario(user.getUserName()).setBalance(db.buscarUsuario(
				user.getUserName()).getBalance() - pedido.calcularTotal());
		
		pedido.setObservaciones(getTextAreaObservaciones().getText());
		
		reiniciarPedido();
	}
	
	/**
	 * Devuelve o crea el botón Cancelar en el panel de bebidas, si no está creado
	 * @return Botón Cancelar del panel de bebidas, de tipo JButton
	 */
	private JButton getBtnBebidasCancelar() {
		if (btnBebidasCancelar == null) {
			btnBebidasCancelar = new JButton("");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 14);
			btnBebidasCancelar.setFont(fuente);
			btnBebidasCancelar.setFocusPainted(false);
			btnBebidasCancelar.setMnemonic('C');
			
			// Al pulsarlo, cancela el pedido y vuelve a la pantalla de juego
			btnBebidasCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (interactedWithOrder) {
						if (JOptionPane.showOptionDialog(null, strings.getString("dialog_drinks_cancel_msg"),
								strings.getString("dialog_drinks_cancel_title"), 0, JOptionPane.QUESTION_MESSAGE, null,
								new String[] { strings.getString("opt_yes"), "No" }, null) == 0) {

							reiniciarPedido();
						}
					}
					
					goToMainScreen();
				}
			});
		}
		
		return btnBebidasCancelar;
	}
	
	/**
	 * Cancela el pedido, reiniciándolo y actualizando el resto de componentes
	 */
	private void reiniciarPedido() {
		getTextAreaObservaciones().setText("");
		pedido.inicializar();
		modeloListaPedido.removeAllElements();
		interactedWithOrder = false;
		actualizarCamposBebidas();
	}
	
	/**
	 * Devuelve o crea el subpanel con el pedido en el panel, si no está creado
	 * @return Subpanel con el pedido en el panel de bebidas, de tipo JPanel
	 */
	private JPanel getPnBebidasListaPedido() {
		if (pnBebidasListaPedido == null) {
			pnBebidasListaPedido = new JPanel();
			pnBebidasListaPedido.setBorder(new EmptyBorder(10, 10, 10, 10));
			pnBebidasListaPedido.setBackground(new Color(128, 0, 0));
			pnBebidasListaPedido.setLayout(new GridLayout(0, 1, 0, 0));
			pnBebidasListaPedido.add(getLblBebidasPedido());
			pnBebidasListaPedido.add(getScrollPaneBebidasPedido());
		}
		
		return pnBebidasListaPedido;
	}
	
	/**
	 * Devuelve o crea la etiqueta Pedido: en el panel de bebidas, si no está creada
	 * @return Etiqueta Pedido: en el panel de bebidas, de tipo JLabel
	 */
	private JLabel getLblBebidasPedido() {
		if (lblBebidasPedido == null) {
			lblBebidasPedido = new JLabel();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			lblBebidasPedido.setFont(fuente);
			lblBebidasPedido.setDisplayedMnemonic('O');
			lblBebidasPedido.setLabelFor(getScrollPaneBebidasPedido());
		}
		
		return lblBebidasPedido;
	}
	
	/**
	 * Devuelve o crea el panel deslizable con el pedido de las bebidas, si no está creado
	 * @return Panel deslizable con el pedido de las bebidas, de tipo JScrollPane
	 */
	private JScrollPane getScrollPaneBebidasPedido() {
		if (scrollPaneBebidasPedido == null) {
			scrollPaneBebidasPedido = new JScrollPane();
			scrollPaneBebidasPedido.setViewportView(getListBebidasPedido());
		}
				
		return scrollPaneBebidasPedido;
	}
	
	/**
	 * Devuelve o crea el subpanel contenedor del pedido y el precio, si no está creado
	 * @return Subpanel contenedor del pedido y el precio, de tipo JPanel
	 */
	private JPanel getPnBebidasListaPedidoPrecio() {
		if (pnBebidasListaPedidoPrecio == null) {
			pnBebidasListaPedidoPrecio = new JPanel();
			pnBebidasListaPedidoPrecio.setBackground(new Color(128, 0, 0));
			pnBebidasListaPedidoPrecio.setLayout(new GridLayout(2, 1, 0, 0));
			pnBebidasListaPedidoPrecio.add(getPnBebidasListaPedido());
			pnBebidasListaPedidoPrecio.add(getPnBebidasPrecio());
		}
		
		return pnBebidasListaPedidoPrecio;
	}
	
	/**
	 * Devuelve o crea el subpanel con el precio y el saldo tras pedir, si no está creado
	 * @return Subpanel con el precio y el saldo tras pedir bebidas, tipo JPanel
	 */
	private JPanel getPnBebidasPrecio() {
		if (pnBebidasPrecio == null) {
			pnBebidasPrecio = new JPanel();
			pnBebidasPrecio.setBackground(new Color(128, 0, 0));
			pnBebidasPrecio.setLayout(new BorderLayout(0, 0));
			pnBebidasPrecio.add(getPnBebidasPrecioSaldo(), BorderLayout.WEST);
			pnBebidasPrecio.add(getPnBebidasObservaciones(), BorderLayout.CENTER);
		}
		
		return pnBebidasPrecio;
	}
	
	/**
	 * Devuelve o crea el subpanel con las etiquetas y cuadros de precio y saldo final, si no está creado
	 * @return Subpanel con etiquetas y cuadros de precio y saldo tras pedir bebidas, tipo JPanel
	 */
	private JPanel getPnBebidasPrecioSaldo() {
		if (pnBebidasPrecioSaldo == null) {
			pnBebidasPrecioSaldo = new JPanel();
			pnBebidasPrecioSaldo.setBackground(new Color(128, 0, 0));
			pnBebidasPrecioSaldo.setLayout(new GridLayout(2, 1, 0, 0));
			pnBebidasPrecioSaldo.add(getPnBebidasPrecioSaldo1());
			pnBebidasPrecioSaldo.add(getPnBebidasPrecioSaldo2());
		}
		
		return pnBebidasPrecioSaldo;
	}
	
	/**
	 * Devuelve o crea el subpanel con la etiqueta y texto del precio, si no está creado
	 * @return Subpanel con la etiqueta y texto del precio, de tipo JPanel
	 */
	private JPanel getPnBebidasPrecioSaldo1() {
		if (pnBebidasPrecioSaldo1 == null) {
			pnBebidasPrecioSaldo1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBebidasPrecioSaldo1.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(30);
			pnBebidasPrecioSaldo1.setBackground(new Color(128, 0, 0));
			pnBebidasPrecioSaldo1.add(getLblBebidasPrecio());
			pnBebidasPrecioSaldo1.add(getTextFieldBebidasPrecio());
		}
		
		return pnBebidasPrecioSaldo1;
	}
	
	/*
	 * Devuelve o crea la etiqueta Precio: en el panel de bebidas, si no está creada
	 * @return Etiqueta Precio: en el panel de bebidas, de tipo JLabel
	 */
	private JLabel getLblBebidasPrecio() {
		if (lblBebidasPrecio == null) {
			lblBebidasPrecio = new JLabel("New label");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			lblBebidasPrecio.setFont(fuente);
		}
		
		return lblBebidasPrecio;
	}
	
	/*
	 * Devuelve o crea el cuadro del precio en el panel de bebidas, si no está creada
	 * @return Cuadro de texto del precio en el panel de bebidas, de tipo JTextField
	 */
	private JTextField getTextFieldBebidasPrecio() {
		if (textFieldBebidasPrecio == null) {
			textFieldBebidasPrecio = new JTextField();
			textFieldBebidasPrecio.setFont(new Font("Monospaced", Font.PLAIN, 11));
			textFieldBebidasPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldBebidasPrecio.setEditable(false);
			textFieldBebidasPrecio.setColumns(7);
		}
		
		return textFieldBebidasPrecio;
	}
	
	/**
	 * Devuelve o crea el subpanel con la etiqueta y texto del saldo final, si no está creado
	 * @return Subpanel con la etiqueta y texto del saldo final, de tipo JPanel
	 */
	private JPanel getPnBebidasPrecioSaldo2() {
		if (pnBebidasPrecioSaldo2 == null) {
			pnBebidasPrecioSaldo2 = new JPanel();
			pnBebidasPrecioSaldo2.setBorder(null);
			pnBebidasPrecioSaldo2.setBackground(new Color(128, 0, 0));
			FlowLayout flowLayout = (FlowLayout) pnBebidasPrecioSaldo2.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(30);
			pnBebidasPrecioSaldo2.add(getLblBebidasSaldoFinal());
			pnBebidasPrecioSaldo2.add(getTextFieldBebidasSaldoFinal());
		}
		
		return pnBebidasPrecioSaldo2;
	}
	
	/*
	 * Devuelve o crea la etiqueta Saldo final: en el panel de bebidas, si no está creada
	 * @return Etiqueta Saldo final: en el panel de bebidas, de tipo JLabel
	 */
	private JLabel getLblBebidasSaldoFinal() {
		if (lblBebidasSaldoFinal == null) {
			lblBebidasSaldoFinal = new JLabel();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			lblBebidasSaldoFinal.setFont(fuente);
		}
		
		return lblBebidasSaldoFinal;
	}
	
	/*
	 * Devuelve o crea el cuadro del saldo final en el panel de bebidas, si no está creada
	 * @return Cuadro de texto del saldo final en el panel de bebidas, de tipo JTextField
	 */
	private JTextField getTextFieldBebidasSaldoFinal() {
		if (textFieldBebidasSaldoFinal == null) {
			textFieldBebidasSaldoFinal = new JTextField();
			textFieldBebidasSaldoFinal.setFont(new Font("Monospaced", Font.PLAIN, 11));
			textFieldBebidasSaldoFinal.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldBebidasSaldoFinal.setEditable(false);
			textFieldBebidasSaldoFinal.setColumns(7);
		}
		
		return textFieldBebidasSaldoFinal;
	}
	
	/**
	 * Devuelve o crea la etiqueta a mostrar cuando no hay saldo para pedir bebidas
	 * @return Etiqueta mostrada cuando no hay saldo al comprar bebidas, tipo JLabel
	 */
	private JLabel getLblBebidasSinSaldo() {
		if (lblBebidasSinSaldo == null) {
			lblBebidasSinSaldo = new JLabel();
			lblBebidasSinSaldo.setVisible(false);
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 11);
			lblBebidasSinSaldo.setFont(fuente);
			lblBebidasSinSaldo.setForeground(Color.RED);
		}
		
		return lblBebidasSinSaldo;
	}
	
	/**
	 * Devuelve o crea la lista de bebidas que se añaden al pedido, si no está creada
	 * @return Lista de bebidas añadidas al pedido, de tipo JList de Bebida
	 */
	private JList<Bebida> getListBebidasPedido() {
		if (listBebidasPedido == null) {
			modeloListaPedido = new DefaultListModel<Bebida>();
			listBebidasPedido = new JList<Bebida>(modeloListaPedido);
			listBebidasPedido.setFont(new Font("Monospaced", Font.PLAIN, 11));
			listBebidasPedido.addKeyListener(pbb);
		}
		
		return listBebidasPedido;
	}
	
	/**
	 * Borra la bebida seleccionada de la lista del pedido
	 */
	private void borrarBebida() {
		for (Bebida d : getListBebidasPedido().getSelectedValuesList()) {
			pedido.remove(d, 1);
			modeloListaPedido.removeElement(d);
			actualizarCamposBebidas();
		}
		
		// Si no hay nada en la lista, deshabilita el botón Pedir
		if (modeloListaPedido.getSize() == 0) {
			getBtnBebidasPedir().setEnabled(false);
		}
	}
	
	/**
	 * Actualiza los campos de texto en el panel de bebidas
	 */
	private void actualizarCamposBebidas() {
		getTextFieldBebidasPrecio().setText(String.valueOf(pedido.calcularTotal()));
		getTextFieldBebidasSaldoFinal().setText(String.valueOf(user.getBalance() - pedido.calcularTotal()));
		
		// Si el precio del pedido excede el saldo, se avisa y se impide la compra
		if (pedido.calcularTotal() > user.getBalance()) {
			getBtnBebidasPedir().setEnabled(false);
			getLblBebidasSinSaldo().setVisible(true);
			getTextFieldBebidasSaldoFinal().setText("");
			
		// En caso contrario, invisibiliza el aviso y muestra de nuevo el valor 
		} else {			
			getLblBebidasSinSaldo().setVisible(false);
			getTextFieldBebidasSaldoFinal().setText(String.valueOf(
						user.getBalance() - pedido.calcularTotal()));
		}
	}
	
	/**
	 * Devuelve o crea el botón 0 del tablero, si no está creado
	 * @return Botón 0 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn0() {
		if (btnPnTableroBtn0 == null) {
			btnPnTableroBtn0 = new JButton("0");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn0.setFont(fuente);
			btnPnTableroBtn0.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn0.setForeground(Color.WHITE);
			btnPnTableroBtn0.setBackground(new Color(0, 100, 0));
			btnPnTableroBtn0.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn0.setActionCommand("0");
			btnPnTableroBtn0.addActionListener(pga);
		}
		
		return btnPnTableroBtn0;
	}
	
	/**
	 * Devuelve o crea el botón 1 del tablero, si no está creado
	 * @return Botón 1 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn1() {
		if (btnPnTableroBtn1 == null) {
			btnPnTableroBtn1 = new JButton("1");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn1.setFont(fuente);
			btnPnTableroBtn1.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn1.setBackground(Color.RED);
			btnPnTableroBtn1.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn1.setActionCommand("1");
			btnPnTableroBtn1.addActionListener(pga);
		}
		
		return btnPnTableroBtn1;
	}
	
	/**
	 * Devuelve o crea el botón 2 del tablero, si no está creado
	 * @return Botón 2 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn2() {
		if (btnPnTableroBtn2 == null) {
			btnPnTableroBtn2 = new JButton("2");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn2.setFont(fuente);
			btnPnTableroBtn2.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn2.setForeground(Color.WHITE);
			btnPnTableroBtn2.setBackground(Color.BLACK);
			btnPnTableroBtn2.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn2.setActionCommand("2");
			btnPnTableroBtn2.addActionListener(pga);
		}
		
		return btnPnTableroBtn2;
	}
	
	/**
	 * Devuelve o crea el botón 3 del tablero, si no está creado
	 * @return Botón 3 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn3() {
		if (btnPnTableroBtn3 == null) {
			btnPnTableroBtn3 = new JButton("3");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn3.setFont(fuente);
			btnPnTableroBtn3.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn3.setBackground(Color.RED);
			btnPnTableroBtn3.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn3.setActionCommand("3");
			btnPnTableroBtn3.addActionListener(pga);
		}
		
		return btnPnTableroBtn3;
	}
	
	/**
	 * Devuelve o crea el botón 4 del tablero, si no está creado
	 * @return Botón 4 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn4() {
		if (btnPnTableroBtn4 == null) {
			btnPnTableroBtn4 = new JButton("4");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn4.setFont(fuente);
			btnPnTableroBtn4.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn4.setForeground(Color.WHITE);
			btnPnTableroBtn4.setBackground(Color.BLACK);
			btnPnTableroBtn4.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn4.setActionCommand("4");
			btnPnTableroBtn4.addActionListener(pga);
		}
		
		return btnPnTableroBtn4;
	}
	
	/**
	 * Devuelve o crea el botón 5 del tablero, si no está creado
	 * @return Botón 5 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn5() {
		if (btnPnTableroBtn5 == null) {
			btnPnTableroBtn5 = new JButton("5");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn5.setFont(fuente);
			btnPnTableroBtn5.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn5.setBackground(Color.RED);
			btnPnTableroBtn5.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn5.setActionCommand("5");
			btnPnTableroBtn5.addActionListener(pga);
		}
		
		return btnPnTableroBtn5;
	}
	
	/**
	 * Devuelve o crea el botón 6 del tablero, si no está creado
	 * @return Botón 6 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn6() {
		if (btnPnTableroBtn6 == null) {
			btnPnTableroBtn6 = new JButton("6");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn6.setFont(fuente);
			btnPnTableroBtn6.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn6.setForeground(Color.WHITE);
			btnPnTableroBtn6.setBackground(Color.BLACK);
			btnPnTableroBtn6.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn6.setActionCommand("6");
			btnPnTableroBtn6.addActionListener(pga);
		}
		
		return btnPnTableroBtn6;
	}
	
	/**
	 * Devuelve o crea el botón 7 del tablero, si no está creado
	 * @return Botón 7 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn7() {
		if (btnPnTableroBtn7 == null) {
			btnPnTableroBtn7 = new JButton("7");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn7.setFont(fuente);
			btnPnTableroBtn7.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn7.setBackground(Color.RED);
			btnPnTableroBtn7.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn7.setActionCommand("7");
			btnPnTableroBtn7.addActionListener(pga);
		}
		
		return btnPnTableroBtn7;
	}
	
	/**
	 * Devuelve o crea el botón 8 del tablero, si no está creado
	 * @return Botón 8 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn8() {
		if (btnPnTableroBtn8 == null) {
			btnPnTableroBtn8 = new JButton("8");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn8.setFont(fuente);
			btnPnTableroBtn8.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn8.setForeground(Color.WHITE);
			btnPnTableroBtn8.setBackground(Color.BLACK);
			btnPnTableroBtn8.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn8.setActionCommand("8");
			btnPnTableroBtn8.addActionListener(pga);
		}
		
		return btnPnTableroBtn8;
	}
	
	/**
	 * Devuelve o crea el botón 9 del tablero, si no está creado
	 * @return Botón 9 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn9() {
		if (btnPnTableroBtn9 == null) {
			btnPnTableroBtn9 = new JButton("9");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn9.setFont(fuente);
			btnPnTableroBtn9.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn9.setBackground(Color.RED);
			btnPnTableroBtn9.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn9.setActionCommand("9");
			btnPnTableroBtn9.addActionListener(pga);
		}
		
		return btnPnTableroBtn9;
	}
	
	/**
	 * Devuelve o crea el botón 10 del tablero, si no está creado
	 * @return Botón 10 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn10() {
		if (btnPnTableroBtn10 == null) {
			btnPnTableroBtn10 = new JButton("10");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn10.setFont(fuente);
			btnPnTableroBtn10.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn10.setForeground(Color.WHITE);
			btnPnTableroBtn10.setBackground(Color.BLACK);
			btnPnTableroBtn10.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn10.setActionCommand("10");
			btnPnTableroBtn10.addActionListener(pga);
		}
		
		return btnPnTableroBtn10;
	}
	
	/**
	 * Devuelve o crea el botón 11 del tablero, si no está creado
	 * @return Botón 11 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn11() {
		if (btnPnTableroBtn11 == null) {
			btnPnTableroBtn11 = new JButton("11");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn11.setFont(fuente);
			btnPnTableroBtn11.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn11.setForeground(Color.WHITE);
			btnPnTableroBtn11.setBackground(Color.BLACK);
			btnPnTableroBtn11.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn11.setActionCommand("11");
			btnPnTableroBtn11.addActionListener(pga);
		}
		
		return btnPnTableroBtn11;
	}
	
	/**
	 * Devuelve o crea el botón 12 del tablero, si no está creado
	 * @return Botón 12 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn12() {
		if (btnPnTableroBtn12 == null) {
			btnPnTableroBtn12 = new JButton("12");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn12.setFont(fuente);
			btnPnTableroBtn12.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn12.setBackground(Color.RED);
			btnPnTableroBtn12.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn12.setActionCommand("12");
			btnPnTableroBtn12.addActionListener(pga);
		}
		
		return btnPnTableroBtn12;
	}
	
	/**
	 * Devuelve o crea el botón 13 del tablero, si no está creado
	 * @return Botón 13 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn13() {
		if (btnPnTableroBtn13 == null) {
			btnPnTableroBtn13 = new JButton("13");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn13.setFont(fuente);
			btnPnTableroBtn13.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn13.setForeground(Color.WHITE);
			btnPnTableroBtn13.setBackground(Color.BLACK);
			btnPnTableroBtn13.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn13.setActionCommand("13");
			btnPnTableroBtn13.addActionListener(pga);
		}
		
		return btnPnTableroBtn13;
	}
	
	/**
	 * Devuelve o crea el botón 14 del tablero, si no está creado
	 * @return Botón 14 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn14() {
		if (btnPnTableroBtn14 == null) {
			btnPnTableroBtn14 = new JButton("14");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn14.setFont(fuente);
			btnPnTableroBtn14.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn14.setBackground(Color.RED);
			btnPnTableroBtn14.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn14.setActionCommand("14");
			btnPnTableroBtn14.addActionListener(pga);
		}
		
		return btnPnTableroBtn14;
	}
	
	/**
	 * Devuelve o crea el botón 15 del tablero, si no está creado
	 * @return Botón 15 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn15() {
		if (btnPnTableroBtn15 == null) {
			btnPnTableroBtn15 = new JButton("15");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn15.setFont(fuente);
			btnPnTableroBtn15.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn15.setForeground(Color.WHITE);
			btnPnTableroBtn15.setBackground(Color.BLACK);
			btnPnTableroBtn15.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn15.setActionCommand("15");
			btnPnTableroBtn15.addActionListener(pga);
		}
		
		return btnPnTableroBtn15;
	}
	
	/**
	 * Devuelve o crea el botón 16 del tablero, si no está creado
	 * @return Botón 16 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn16() {
		if (btnPnTableroBtn16 == null) {
			btnPnTableroBtn16 = new JButton("16");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn16.setFont(fuente);
			btnPnTableroBtn16.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn16.setBackground(Color.RED);
			btnPnTableroBtn16.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn16.setActionCommand("16");
			btnPnTableroBtn16.addActionListener(pga);
		}
		
		return btnPnTableroBtn16;
	}
	
	/**
	 * Devuelve o crea el botón 17 del tablero, si no está creado
	 * @return Botón 17 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn17() {
		if (btnPnTableroBtn17 == null) {
			btnPnTableroBtn17 = new JButton("17");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn17.setFont(fuente);
			btnPnTableroBtn17.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn17.setForeground(Color.WHITE);
			btnPnTableroBtn17.setBackground(Color.BLACK);
			btnPnTableroBtn17.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn17.setActionCommand("17");
			btnPnTableroBtn17.addActionListener(pga);
		}
		
		return btnPnTableroBtn17;
	}
	
	/**
	 * Devuelve o crea el botón 18 del tablero, si no está creado
	 * @return Botón 18 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn18() {
		if (btnPnTableroBtn18 == null) {
			btnPnTableroBtn18 = new JButton("18");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn18.setFont(fuente);
			btnPnTableroBtn18.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn18.setBackground(Color.RED);
			btnPnTableroBtn18.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn18.setActionCommand("18");
			btnPnTableroBtn18.addActionListener(pga);
		}
		
		return btnPnTableroBtn18;
	}
	
	/**
	 * Devuelve o crea el botón 19 del tablero, si no está creado
	 * @return Botón 19 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn19() {
		if (btnPnTableroBtn19 == null) {
			btnPnTableroBtn19 = new JButton("19");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn19.setFont(fuente);
			btnPnTableroBtn19.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn19.setBackground(Color.RED);
			btnPnTableroBtn19.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn19.setActionCommand("19");
			btnPnTableroBtn19.addActionListener(pga);
		}
		
		return btnPnTableroBtn19;
	}
	
	/**
	 * Devuelve o crea el botón 20 del tablero, si no está creado
	 * @return Botón 20 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn20() {
		if (btnPnTableroBtn20 == null) {
			btnPnTableroBtn20 = new JButton("20");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn20.setFont(fuente);
			btnPnTableroBtn20.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn20.setForeground(Color.WHITE);
			btnPnTableroBtn20.setBackground(Color.BLACK);
			btnPnTableroBtn20.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn20.setActionCommand("20");
			btnPnTableroBtn20.addActionListener(pga);
		}
		
		return btnPnTableroBtn20;
	}
	
	/**
	 * Devuelve o crea el botón 21 del tablero, si no está creado
	 * @return Botón 21 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn21() {
		if (btnPnTableroBtn21 == null) {
			btnPnTableroBtn21 = new JButton("21");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn21.setFont(fuente);
			btnPnTableroBtn21.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn21.setBackground(Color.RED);
			btnPnTableroBtn21.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn21.setActionCommand("21");
			btnPnTableroBtn21.addActionListener(pga);
		}
		
		return btnPnTableroBtn21;
	}
	
	/**
	 * Devuelve o crea el botón 22 del tablero, si no está creado
	 * @return Botón 22 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn22() {
		if (btnPnTableroBtn22 == null) {
			btnPnTableroBtn22 = new JButton("22");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn22.setFont(fuente);
			btnPnTableroBtn22.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn22.setForeground(Color.WHITE);
			btnPnTableroBtn22.setBackground(Color.BLACK);
			btnPnTableroBtn22.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn22.setActionCommand("22");
			btnPnTableroBtn22.addActionListener(pga);
		}
		
		return btnPnTableroBtn22;
	}
	
	/**
	 * Devuelve o crea el botón 23 del tablero, si no está creado
	 * @return Botón 23 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn23() {
		if (btnPnTableroBtn23 == null) {
			btnPnTableroBtn23 = new JButton("23");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn23.setFont(fuente);
			btnPnTableroBtn23.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn23.setBackground(Color.RED);
			btnPnTableroBtn23.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn23.setActionCommand("23");
			btnPnTableroBtn23.addActionListener(pga);
		}
		
		return btnPnTableroBtn23;
	}
	
	/**
	 * Devuelve o crea el botón 24 del tablero, si no está creado
	 * @return Botón 24 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn24() {
		if (btnPnTableroBtn24 == null) {
			btnPnTableroBtn24 = new JButton("24");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn24.setFont(fuente);
			btnPnTableroBtn24.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn24.setForeground(Color.WHITE);
			btnPnTableroBtn24.setBackground(Color.BLACK);
			btnPnTableroBtn24.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn24.setActionCommand("24");
			btnPnTableroBtn24.addActionListener(pga);
		}
		
		return btnPnTableroBtn24;
	}
	
	/**
	 * Devuelve o crea el botón 25 del tablero, si no está creado
	 * @return Botón 25 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn25() {
		if (btnPnTableroBtn25 == null) {
			btnPnTableroBtn25 = new JButton("25");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn25.setFont(fuente);
			btnPnTableroBtn25.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn25.setBackground(Color.RED);
			btnPnTableroBtn25.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn25.setActionCommand("25");
			btnPnTableroBtn25.addActionListener(pga);
		}
		
		return btnPnTableroBtn25;
	}
	
	/**
	 * Devuelve o crea el botón 26 del tablero, si no está creado
	 * @return Botón 26 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn26() {
		if (btnPnTableroBtn26 == null) {
			btnPnTableroBtn26 = new JButton("26");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn26.setFont(fuente);
			btnPnTableroBtn26.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn26.setForeground(Color.WHITE);
			btnPnTableroBtn26.setBackground(Color.BLACK);
			btnPnTableroBtn26.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn26.setActionCommand("26");
			btnPnTableroBtn26.addActionListener(pga);
		}
		
		return btnPnTableroBtn26;
	}
	
	/**
	 * Devuelve o crea el botón 27 del tablero, si no está creado
	 * @return Botón 27 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn27() {
		if (btnPnTableroBtn27 == null) {
			btnPnTableroBtn27 = new JButton("27");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn27.setFont(fuente);
			btnPnTableroBtn27.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn27.setBackground(Color.RED);
			btnPnTableroBtn27.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn27.setActionCommand("27");
			btnPnTableroBtn27.addActionListener(pga);
		}
		
		return btnPnTableroBtn27;
	}
	
	/**
	 * Devuelve o crea el botón 28 del tablero, si no está creado
	 * @return Botón 28 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn28() {
		if (btnPnTableroBtn28 == null) {
			btnPnTableroBtn28 = new JButton("28");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn28.setFont(fuente);
			btnPnTableroBtn28.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn28.setForeground(Color.WHITE);
			btnPnTableroBtn28.setBackground(Color.BLACK);
			btnPnTableroBtn28.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn28.setActionCommand("28");
			btnPnTableroBtn28.addActionListener(pga);
		}
		
		return btnPnTableroBtn28;
	}
	
	/**
	 * Devuelve o crea el botón 29 del tablero, si no está creado
	 * @return Botón 29 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn29() {
		if (btnPnTableroBtn29 == null) {
			btnPnTableroBtn29 = new JButton("29");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn29.setFont(fuente);
			btnPnTableroBtn29.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn29.setForeground(Color.WHITE);
			btnPnTableroBtn29.setBackground(Color.BLACK);
			btnPnTableroBtn29.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn29.setActionCommand("29");
			btnPnTableroBtn29.addActionListener(pga);
		}
		
		return btnPnTableroBtn29;
	}
	
	/**
	 * Devuelve o crea el botón 30 del tablero, si no está creado
	 * @return Botón 30 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn30() {
		if (btnPnTableroBtn30 == null) {
			btnPnTableroBtn30 = new JButton("30");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn30.setFont(fuente);
			btnPnTableroBtn30.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn30.setBackground(Color.RED);
			btnPnTableroBtn30.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn30.setActionCommand("30");
			btnPnTableroBtn30.addActionListener(pga);
		}
		
		return btnPnTableroBtn30;
	}
	
	/**
	 * Devuelve o crea el botón 31 del tablero, si no está creado
	 * @return Botón 31 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn31() {
		if (btnPnTableroBtn31 == null) {
			btnPnTableroBtn31 = new JButton("31");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn31.setFont(fuente);
			btnPnTableroBtn31.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn31.setForeground(Color.WHITE);
			btnPnTableroBtn31.setBackground(Color.BLACK);
			btnPnTableroBtn31.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn31.setActionCommand("31");
			btnPnTableroBtn31.addActionListener(pga);
		}
		
		return btnPnTableroBtn31;
	}
	
	/**
	 * Devuelve o crea el botón 32 del tablero, si no está creado
	 * @return Botón 32 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn32() {
		if (btnPnTableroBtn32 == null) {
			btnPnTableroBtn32 = new JButton("32");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn32.setFont(fuente);
			btnPnTableroBtn32.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn32.setBackground(Color.RED);
			btnPnTableroBtn32.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn32.setActionCommand("32");
			btnPnTableroBtn32.addActionListener(pga);
		}
		
		return btnPnTableroBtn32;
	}
	
	/**
	 * Devuelve o crea el botón 33 del tablero, si no está creado
	 * @return Botón 33 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn33() {
		if (btnPnTableroBtn33 == null) {
			btnPnTableroBtn33 = new JButton("33");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn33.setFont(fuente);
			btnPnTableroBtn33.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn33.setForeground(Color.WHITE);
			btnPnTableroBtn33.setBackground(Color.BLACK);
			btnPnTableroBtn33.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn33.setActionCommand("33");
			btnPnTableroBtn33.addActionListener(pga);
		}
		
		return btnPnTableroBtn33;
	}
	
	/**
	 * Devuelve o crea el botón 34 del tablero, si no está creado
	 * @return Botón 34 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn34() {
		if (btnPnTableroBtn34 == null) {
			btnPnTableroBtn34 = new JButton("34");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn34.setFont(fuente);
			btnPnTableroBtn34.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn34.setBackground(Color.RED);
			btnPnTableroBtn34.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn34.setActionCommand("34");
			btnPnTableroBtn34.addActionListener(pga);
		}
		
		return btnPnTableroBtn34;
	}
	
	/**
	 * Devuelve o crea el botón 35 del tablero, si no está creado
	 * @return Botón 35 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn35() {
		if (btnPnTableroBtn35 == null) {
			btnPnTableroBtn35 = new JButton("35");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn35.setFont(fuente);
			btnPnTableroBtn35.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn35.setForeground(Color.WHITE);
			btnPnTableroBtn35.setBackground(Color.BLACK);
			btnPnTableroBtn35.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn35.setActionCommand("35");
			btnPnTableroBtn35.addActionListener(pga);
		}
		
		return btnPnTableroBtn35;
	}
	
	/**
	 * Devuelve o crea el botón 36 del tablero, si no está creado
	 * @return Botón 36 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn36() {
		if (btnPnTableroBtn36 == null) {
			btnPnTableroBtn36 = new JButton("36");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn36.setFont(fuente);
			btnPnTableroBtn36.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn36.setBackground(Color.RED);
			btnPnTableroBtn36.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroBtn36.setActionCommand("36");
			btnPnTableroBtn36.addActionListener(pga);
		}
		
		return btnPnTableroBtn36;
	}
	
	/**
	 * Devuelve o crea el panel de números del 1 al 36 en el tablero, si no está creado
	 * @return Panel de números del 1 al 36 en el tablero, de tipo JPanel
	 */
	private JPanel getPnTableroNumeros() {
		if (pnTableroNumeros == null) {
			pnTableroNumeros = new JPanel();
			pnTableroNumeros.setLayout(new GridLayout(3, 12, 0, 0));
			pnTableroNumeros.setBackground(new Color(128, 0, 0));
			
			// Se añaden los botones de las casillas
			pnTableroNumeros.add(getBtnPnTableroBtn3());
			pnTableroNumeros.add(getBtnPnTableroBtn6());
			pnTableroNumeros.add(getBtnPnTableroBtn9());
			pnTableroNumeros.add(getBtnPnTableroBtn12());
			pnTableroNumeros.add(getBtnPnTableroBtn15());
			pnTableroNumeros.add(getBtnPnTableroBtn18());
			pnTableroNumeros.add(getBtnPnTableroBtn21());
			pnTableroNumeros.add(getBtnPnTableroBtn24());
			pnTableroNumeros.add(getBtnPnTableroBtn27());
			pnTableroNumeros.add(getBtnPnTableroBtn30());
			pnTableroNumeros.add(getBtnPnTableroBtn33());
			pnTableroNumeros.add(getBtnPnTableroBtn36());
			pnTableroNumeros.add(getBtnPnTableroBtn2());
			pnTableroNumeros.add(getBtnPnTableroBtn5());
			pnTableroNumeros.add(getBtnPnTableroBtn8());
			pnTableroNumeros.add(getBtnPnTableroBtn11());
			pnTableroNumeros.add(getBtnPnTableroBtn14());
			pnTableroNumeros.add(getBtnPnTableroBtn17());
			pnTableroNumeros.add(getBtnPnTableroBtn20());
			pnTableroNumeros.add(getBtnPnTableroBtn23());
			pnTableroNumeros.add(getBtnPnTableroBtn26());
			pnTableroNumeros.add(getBtnPnTableroBtn29());
			pnTableroNumeros.add(getBtnPnTableroBtn32());
			pnTableroNumeros.add(getBtnPnTableroBtn35());
			pnTableroNumeros.add(getBtnPnTableroBtn1());
			pnTableroNumeros.add(getBtnPnTableroBtn4());
			pnTableroNumeros.add(getBtnPnTableroBtn7());
			pnTableroNumeros.add(getBtnPnTableroBtn10());
			pnTableroNumeros.add(getBtnPnTableroBtn13());
			pnTableroNumeros.add(getBtnPnTableroBtn16());
			pnTableroNumeros.add(getBtnPnTableroBtn19());
			pnTableroNumeros.add(getBtnPnTableroBtn22());
			pnTableroNumeros.add(getBtnPnTableroBtn25());
			pnTableroNumeros.add(getBtnPnTableroBtn28());
			pnTableroNumeros.add(getBtnPnTableroBtn31());
			pnTableroNumeros.add(getBtnPnTableroBtn34());
		}
		
		return pnTableroNumeros;
	}
	
	/**
	 * Devuelve o crea el panel con los botones de 2 a 1, si no está creado
	 * @return Panel con los botones de 2 a 1, de tipo JPanel
	 */
	private JPanel getPnTablero2a1() {
		if (pnTablero2a1 == null) {
			pnTablero2a1 = new JPanel();
			pnTablero2a1.setLayout(new GridLayout(3, 1, 0, 0));
			pnTablero2a1.setBackground(new Color(128, 0, 0));
			
			// Se añaden los botones al tablero
			pnTablero2a1.add(getBtnPnTableroBtn2a1_1());
			pnTablero2a1.add(getBtnPnTableroBtn2a1_2());
			pnTablero2a1.add(getBtnPnTableroBtn2a1_3());
		}
		
		return pnTablero2a1;
	}
	
	/**
	 * Devuelve o crea el primer botón 2 a 1 del tablero, si no está creado
	 * @return Primer botón 2 a 1 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn2a1_1() {
		if (btnPnTableroBtn2a1_1 == null) {
			btnPnTableroBtn2a1_1 = new JButton("2 a 1");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn2a1_1.setFont(fuente);
			btnPnTableroBtn2a1_1.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn2a1_1.setForeground(Color.WHITE);
			btnPnTableroBtn2a1_1.setBackground(new Color(0, 100, 0));
			btnPnTableroBtn2a1_1.setMargin(new Insets(2, 0, 0, 0));
			btnPnTableroBtn2a1_1.setActionCommand("37");
			btnPnTableroBtn2a1_1.addActionListener(pga);
		}
		
		return btnPnTableroBtn2a1_1;
	}
	
	/**
	 * Devuelve o crea el segundo botón 2 a 1 del tablero, si no está creado
	 * @return Segundo botón 2 a 1 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn2a1_2() {
		if (btnPnTableroBtn2a1_2 == null) {
			btnPnTableroBtn2a1_2 = new JButton("2 a 1");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn2a1_2.setFont(fuente);
			btnPnTableroBtn2a1_2.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn2a1_2.setForeground(Color.WHITE);
			btnPnTableroBtn2a1_2.setBackground(new Color(0, 100, 0));
			btnPnTableroBtn2a1_2.setMargin(new Insets(2, 0, 0, 0));
			btnPnTableroBtn2a1_2.setActionCommand("38");
			btnPnTableroBtn2a1_2.addActionListener(pga);
		}
		
		return btnPnTableroBtn2a1_2;
	}
	
	/**
	 * Devuelve o crea el tercer botón 2 a 1 del tablero, si no está creado
	 * @return Tercer botón 2 a 1 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroBtn2a1_3() {
		if (btnPnTableroBtn2a1_3 == null) {
			btnPnTableroBtn2a1_3 = new JButton("2 a 1");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroBtn2a1_3.setFont(fuente);
			btnPnTableroBtn2a1_3.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroBtn2a1_3.setForeground(Color.WHITE);
			btnPnTableroBtn2a1_3.setBackground(new Color(0, 100, 0));
			btnPnTableroBtn2a1_3.setMargin(new Insets(2, 0, 0, 0));
			btnPnTableroBtn2a1_3.setActionCommand("39");
			btnPnTableroBtn2a1_3.addActionListener(pga);
		}
		
		return btnPnTableroBtn2a1_3;
	}
	
	/**
	 * Devuelve o crea el subpanel inferior del tablero, si no está creado
	 * @return Subpanel inferior del tablero, de tipo JPanel
	 */
	private JPanel getPnTableroInferior() {
		if (pnTableroInferior == null) {
			pnTableroInferior = new JPanel();
			pnTableroInferior.setLayout(new GridLayout(2, 3, 0, 0));
			pnTableroInferior.setBackground(new Color(128, 0, 0));
			
			// Se añaden los componentes al panel
			pnTableroInferior.add(getBtnPnTableroPrimeraDocena());
			pnTableroInferior.add(getBtnPnTableroSegundaDocena());
			pnTableroInferior.add(getBtnPnTableroTerceraDocena());
			pnTableroInferior.add(getPnTableroInferiorSub1());
			pnTableroInferior.add(getPnTableroInferiorSub2());
			pnTableroInferior.add(getPnTableroInferiorSub3());
		}
		
		return pnTableroInferior;
	}
	
	/**
	 * Devuelve o crea el botón Primera Docena del tablero, si no está creado
	 * @return Botón Primera Docena del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroPrimeraDocena() {
		if (btnPnTableroPrimeraDocena == null) {
			btnPnTableroPrimeraDocena = new JButton("1ª DOCENA");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroPrimeraDocena.setFont(fuente);
			btnPnTableroPrimeraDocena.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroPrimeraDocena.setForeground(Color.WHITE);
			btnPnTableroPrimeraDocena.setBackground(new Color(0, 100, 0));
			btnPnTableroPrimeraDocena.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroPrimeraDocena.setActionCommand("40");
			btnPnTableroPrimeraDocena.addActionListener(pga);
		}
		
		return btnPnTableroPrimeraDocena;
	}
	
	/**
	 * Devuelve o crea el botón Segunda Docena del tablero, si no está creado
	 * @return Botón Segunda Docena del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroSegundaDocena() {
		if (btnPnTableroSegundaDocena == null) {
			btnPnTableroSegundaDocena = new JButton("2ª DOCENA");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroSegundaDocena.setFont(fuente);
			btnPnTableroSegundaDocena.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroSegundaDocena.setForeground(Color.WHITE);
			btnPnTableroSegundaDocena.setBackground(new Color(0, 100, 0));
			btnPnTableroSegundaDocena.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroSegundaDocena.setActionCommand("41");
			btnPnTableroSegundaDocena.addActionListener(pga);
		}
		
		return btnPnTableroSegundaDocena;
	}
	
	/**
	 * Devuelve o crea el botón Tercera Docena del tablero, si no está creado
	 * @return Botón Tercera Docena del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroTerceraDocena() {
		if (btnPnTableroTerceraDocena == null) {
			btnPnTableroTerceraDocena = new JButton("3ª DOCENA");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroTerceraDocena.setFont(fuente);
			btnPnTableroTerceraDocena.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroTerceraDocena.setForeground(Color.WHITE);
			btnPnTableroTerceraDocena.setBackground(new Color(0, 100, 0));
			btnPnTableroTerceraDocena.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroTerceraDocena.setActionCommand("42");
			btnPnTableroTerceraDocena.addActionListener(pga);
		}
		
		return btnPnTableroTerceraDocena;
	}
	
	/**
	 * Devuelve o crea el primer subpanel del inferior en el tablero, si no está creado
	 * @return Primer subpanel del inferior en el tablero, de tipo JPanel
	 */
	private JPanel getPnTableroInferiorSub1() {
		if (pnTableroInferiorSub1 == null) {
			pnTableroInferiorSub1 = new JPanel();
			pnTableroInferiorSub1.setLayout(new GridLayout(0, 2, 0, 0));
			
			// Se añaden los componentes
			pnTableroInferiorSub1.add(getBtnPnTablero1al18());
			pnTableroInferiorSub1.add(getBtnPnTableroPar());
		}
		
		return pnTableroInferiorSub1;
	}
	
	/**
	 * Devuelve o crea el botón 1-18 del tablero, si no está creado
	 * @return Botón 1-18 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTablero1al18() {
		if (btnPnTablero1al18 == null) {
			btnPnTablero1al18 = new JButton("1-18");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTablero1al18.setFont(fuente);
			btnPnTablero1al18.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTablero1al18.setForeground(Color.WHITE);
			btnPnTablero1al18.setBackground(new Color(0, 100, 0));
			btnPnTablero1al18.setMargin(new Insets(0, 0, 0, 0));
			btnPnTablero1al18.setActionCommand("43");
			btnPnTablero1al18.addActionListener(pga);
		}
		
		return btnPnTablero1al18;
	}
	
	/**
	 * Devuelve o crea el botón PAR del tablero, si no está creado
	 * @return Botón PAR del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroPar() {
		if (btnPnTableroPar == null) {
			btnPnTableroPar = new JButton("PAR");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroPar.setFont(fuente);
			btnPnTableroPar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroPar.setForeground(Color.WHITE);
			btnPnTableroPar.setBackground(new Color(0, 100, 0));
			btnPnTableroPar.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroPar.setActionCommand("44");
			btnPnTableroPar.addActionListener(pga);
		}
		
		return btnPnTableroPar;
	}
	
	/**
	 * Devuelve o crea el segundo subpanel del inferior en el tablero, si no está creado
	 * @return Segundo subpanel del inferior en el tablero, de tipo JPanel
	 */
	private JPanel getPnTableroInferiorSub2() {
		if (pnTableroInferiorSub2 == null) {
			pnTableroInferiorSub2 = new JPanel();
			pnTableroInferiorSub2.setLayout(new GridLayout(0, 2, 0, 0));
			
			// Se añaden los componentes
			pnTableroInferiorSub2.add(getBtnPnTableroNegro());
			pnTableroInferiorSub2.add(getBtnPnTableroRojo());
		}
		
		return pnTableroInferiorSub2;
	}
	
	/**
	 * Devuelve o crea el botón para apostar color negro del tablero, si no está creado
	 * @return Botón para apostar color negro del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroNegro() {
		if (btnPnTableroNegro == null) {
			btnPnTableroNegro = new JButton("\u2666");
			btnPnTableroNegro.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroNegro.setBackground(new Color(0, 100, 0));
			btnPnTableroNegro.setForeground(Color.BLACK);
			btnPnTableroNegro.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroNegro.setActionCommand("45");
			btnPnTableroNegro.addActionListener(pga);
		}
		
		return btnPnTableroNegro;
	}
	
	/**
	 * Devuelve o crea el botón para apostar color rojo del tablero, si no está creado
	 * @return Botón para apostar color rojo del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroRojo() {
		if (btnPnTableroRojo == null) {
			btnPnTableroRojo = new JButton("\u2666");
			btnPnTableroRojo.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroRojo.setBackground(new Color(0, 100, 0));
			btnPnTableroRojo.setForeground(Color.RED);
			btnPnTableroRojo.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroRojo.setActionCommand("46");
			btnPnTableroRojo.addActionListener(pga);
		}
		
		return btnPnTableroRojo;
	}
	
	/**
	 * Devuelve o crea el tercer subpanel del inferior en el tablero, si no está creado
	 * @return Tercer subpanel del inferior en el tablero, de tipo JPanel
	 */
	private JPanel getPnTableroInferiorSub3() {
		if (pnTableroInferiorSub3 == null) {
			pnTableroInferiorSub3 = new JPanel();
			pnTableroInferiorSub3.setLayout(new GridLayout(0, 2, 0, 0));
			
			// Se añaden los componentes
			pnTableroInferiorSub3.add(getBtnPnTableroImpar());
			pnTableroInferiorSub3.add(getBtnPnTablero19a36());
		}
		
		return pnTableroInferiorSub3;
	}
	
	/**
	 * Devuelve o crea el botón IMPAR del tablero, si no está creado
	 * @return Botón IMPAR del tablero, de tipo JButton
	 */
	private JButton getBtnPnTableroImpar() {
		if (btnPnTableroImpar == null) {
			btnPnTableroImpar = new JButton("IMPAR");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTableroImpar.setFont(fuente);
			btnPnTableroImpar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTableroImpar.setForeground(Color.WHITE);
			btnPnTableroImpar.setBackground(new Color(0, 100, 0));
			btnPnTableroImpar.setMargin(new Insets(0, 0, 0, 0));
			btnPnTableroImpar.setActionCommand("47");
			btnPnTableroImpar.addActionListener(pga);
		}
		
		return btnPnTableroImpar;
	}
	
	/**
	 * Devuelve o crea el botón 19-36 del tablero, si no está creado
	 * @return Botón 19-36 del tablero, de tipo JButton
	 */
	private JButton getBtnPnTablero19a36() {
		if (btnPnTablero19al36 == null) {
			btnPnTablero19al36 = new JButton("19-36");
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			btnPnTablero19al36.setFont(fuente);
			btnPnTablero19al36.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPnTablero19al36.setForeground(Color.WHITE);
			btnPnTablero19al36.setBackground(new Color(0, 100, 0));
			btnPnTablero19al36.setMargin(new Insets(0, 0, 0, 0));
			btnPnTablero19al36.setActionCommand("48");
			btnPnTablero19al36.addActionListener(pga);
		}
		
		return btnPnTablero19al36;
	}
	
	/**
	 * Devuelve o crea el panel con la etiqueta y campos de observaciones, si no está creado
	 * @return Panel con etiqueta y área de texto para observaciones, tipo JPanel
	 */
	private JPanel getPnBebidasObservaciones() {
		if (pnBebidasObservaciones == null) {
			pnBebidasObservaciones = new JPanel();
			pnBebidasObservaciones.setBorder(new EmptyBorder(20, 20, 20, 20));
			pnBebidasObservaciones.setBackground(new Color(128, 0, 0));
			pnBebidasObservaciones.setLayout(new GridLayout(0, 1, 0, 0));
			
			// Se añaden los componentes
			pnBebidasObservaciones.add(getLblPnBebidasObservaciones());
			pnBebidasObservaciones.add(getTextAreaObservaciones());
		}
		
		return pnBebidasObservaciones;
	}
	
	/**
	 * Devuelve o crea la etiqueta Observaciones: de las bebidas, si no está creada
	 * @return Etiqueta Observaciones: de las bebidas, de tipo JLabel
	 */
	private JLabel getLblPnBebidasObservaciones() {
		if (lblPnBebidasObservaciones == null) {
			lblPnBebidasObservaciones = new JLabel();
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 11);
			lblPnBebidasObservaciones.setFont(fuente);
			lblPnBebidasObservaciones.setDisplayedMnemonic('E');
			lblPnBebidasObservaciones.setLabelFor(getTextAreaObservaciones());
		}
		
		return lblPnBebidasObservaciones;
	}
	
	/**
	 * Devuelve o crea el área de texto para observaciones, si no está creada
	 * @return Área de texto para observaciones, de tipo JTextArea
	 */
	private JTextArea getTextAreaObservaciones() {
		if (textAreaObservaciones == null) {
			textAreaObservaciones = new JTextArea();
			textAreaObservaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
			textAreaObservaciones.setFont(new Font("Monospaced", Font.PLAIN, 13));
			textAreaObservaciones.setLineWrap(true);
			textAreaObservaciones.setWrapStyleWord(true);
		}
		
		return textAreaObservaciones;
	}
	
	/**
	 * Devuelve o crea el botón Apostar del panel de juego, si no está creado
	 * @return Botón Apostar del panel de juego, de tipo JButton
	 */
	private JButton getBtnPnTableroApostar() {
		if (btnPnTableroApostar == null) {
			btnPnTableroApostar = new JButton();
			btnPnTableroApostar.setMnemonic('T');
			btnPnTableroApostar.setBackground(new Color(255, 165, 0));
			Font fuente = fuenteDigital.deriveFont(Font.BOLD, 16);
			btnPnTableroApostar.setFont(fuente);
			btnPnTableroApostar.addActionListener(pfa);
		}
		
		return btnPnTableroApostar;
	}
	
	/**
	 * Fija la apuesta del cliente, habilitando la ruleta para su giro
	 */
	private void fijarApuesta() {	
		btnPnTableroApostar.setEnabled(false);
		getBtnRuleta().setEnabled(true);
		// getBtnRuleta().removeActionListener(prsa);
		getBtnRuleta().addActionListener(prca);
	}
	
	/**
	 * Realiza la apuesta de una ficha sobre una casilla del tapete
	 * @param casilla cadena con la información de la casilla sobre la que se apuesta, String
	 * @param btn botón cuyo icono se actualiza, de tipo JButton
	 */
	private void realizarApuesta(String casilla, JButton btn) {
		if (comprobarFichaSeleccionada()) {
			// Se coloca en la casilla el valor de la ficha apostada
			game.getTablero()[Integer.parseInt(casilla)].setValorFichaApostada(getFichaSeleccionada());
			
			// Se establece el icono de la ficha apostada en la casilla seleccionada
			btn.setIcon(new ImageIcon(new ImageIcon("files/img/token/" 
			+ String.valueOf(getFichaSeleccionada()) + ".png").getImage()
					.getScaledInstance(17, 17, Image.SCALE_SMOOTH)));
			
			// Se borra la ficha de la lista del cliente y actualiza contadores
			db.buscarUsuario(user.getUserName()).borrarFicha(getFichaSeleccionada());
			actualizarFichas();
		}
	}
	
	/**
	 * Deshace la apuesta de una ficha sobre una casilla del tapete
	 * @param casilla cadena con la información de la casilla sobre la que se apuesta, String
	 * @param btn botón cuyo icono se actualiza, de tipo JButton
	 */
	private void retirarApuesta(String casilla, JButton btn) {
		int valorPrevio = game.getTablero()[Integer.parseInt(casilla)].getValorFichaApostada();
		
		// Se retira el valor apostado sobre la casilla
		game.getTablero()[Integer.parseInt(casilla)].setValorFichaApostada(0);
		
		// Se elimina el icono del botón correspondiente a la casilla
		btn.setIcon(null);
		
		// Se añade una ficha del valor correspondiente al cliente y actualiza contadores
		db.buscarUsuario(user.getUserName()).addFicha(new Ficha(valorPrevio));
		actualizarFichas();
	}
	
	/**
	 * Comprueba que se haya seleccionado alguna ficha a la hora de hacer la apuesta
	 */
	private boolean comprobarFichaSeleccionada() {
		// Se comprueba si no hay ninguna ficha seleccionada
		if (getFichaSeleccionada() == 0) {
			JOptionPane.showMessageDialog(null, strings.getString("err_board_msg"),
					strings.getString("err_board_title"), JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		// Se comprueba si el usuario tiene alguna ficha del tipo seleccionado
		if (db.buscarUsuario(user.getUserName()).contarFichas(getFichaSeleccionada()) == 0) {
			JOptionPane.showMessageDialog(null, strings.getString("err_no_token"), 
					strings.getString("err_board_title"), JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * Devuelve el valor de la ficha seleccionada por el cliente
	 */
	private int getFichaSeleccionada() {
		for (Component c : getPnBotonesFichas().getComponents()) {
			if (((JRadioButton) c).isSelected()) {
				return Integer.parseInt(((JRadioButton) c).getActionCommand());
			}
		}
		
		return 0;
	}
	
	/**
	 * Gira la ruleta y anuncia el número ganador al cliente
	 */
	private void girarRuleta() {
		int numeroGanador = game.calcularNumeroGanador();
		boolean acertado = game.haGanadoAlgo(numeroGanador);
		mostrarNumeroGanador(numeroGanador, acertado);
	}
	
	/**
	 * Muestra un diálogo con el número ganador
	 * @param numeroGanador número ganador que se pasa al diálogo, tipo int
	 * @param acertado si el cliente ha acertado con la apuesta, de tipo booleano
	 */
	private void mostrarNumeroGanador(int numeroGanador, boolean acertado) {
		VentanaNumeroGanador dialog = new VentanaNumeroGanador(this, numeroGanador, acertado);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	/**
	 * Muestra por pantalla al cliente los resultados de su apuesta
	 * @param acertado si el cliente ha acertado o no, de tipo boolean
	 * @param numeroGanador número que ha sido premiado, de tipo int
	 */
	protected void mostrarResultados(boolean acertado, int numeroGanador) {
		if (!acertado) {
			JOptionPane.showMessageDialog(this, strings.getString("dialog_lose_msg"), 
					strings.getString("dialog_lose_title"), JOptionPane.ERROR_MESSAGE);
		} else {
			mostrarGanancias(game.calcularGanancias(numeroGanador));
		}
		
		nuevaRonda();
	}
	
	/**
	 * Muestra al usuario las ganancias de la apuesta, si ha acertado
	 * @param fichas lista de fichas ganadas, tipo List de Ficha
	 */
	private void mostrarGanancias(List<Ficha> fichas) {	
		// Primero, se cuenta el número de fichas ganadas de cada tipo
		int[] ganancias = game.contarFichasGanadas(fichas);
		
		// Después, se muestra el diálogo con los contadores
		VentanaGanancias dialog = new VentanaGanancias(this, ganancias);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		// Se añaden las fichas ganadas a la colección del cliente
		db.buscarUsuario(user.getUserName()).getFichas().addAll(fichas);
	}
	
	/**
	 * Da comienzo a una nueva ronda en el juego, rehabilitando
	 * los botones de apuesta, modificando la acción de la ruleta
	 * y eliminando las fichas del tablero, iniciando un nuevo juego
	 */
	private void nuevaRonda() {
//		if (hayAlgoApostado()) {
//			db.buscarUsuario(user.getUserName()).getFichas().addAll(game.devolverFichas());
//		}
		
		actualizarFichas();
		getBtnPnTableroApostar().setEnabled(true);
		getBtnRuleta().setEnabled(false);
		getBtnRuleta().removeActionListener(prca);
		// getBtnRuleta().addActionListener(prsa);
		eliminarFichasDelTablero();
		game = new Juego();
	}
	
	/**
	 * Comprueba y devuelve si hay algo apostado en el tapete
	 * @return true si hay algo apostado en el tapete; false en otro caso
	 */
	private boolean hayAlgoApostado() {
		return game.hayApuesta();
	}
	
	/**
	 * Elimina visualmente todas las fichas del tablero
	 */
	private void eliminarFichasDelTablero() {
		getBtnPnTableroBtn0().setIcon(null);
		
		borrarFichas(getPnTableroNumeros());
		borrarFichas(getPnTablero2a1());
		borrarFichas(getPnTableroInferior());
		
		getBtnPnTablero1al18().setIcon(null);
		getBtnPnTableroPar().setIcon(null);
		getBtnPnTableroNegro().setIcon(null);
		getBtnPnTableroRojo().setIcon(null);
	    getBtnPnTableroImpar().setIcon(null);
	    getBtnPnTablero19a36().setIcon(null);
	}
	
	/**
	 * Borra las fichas de un panel determinado
	 * @param panel panel del que se quieren borrar las fichas, de tipo JPanel 
	 */
	private void borrarFichas(JPanel panel) {
		for (Component c : panel.getComponents()) {
			if (c instanceof JButton) {
				((JButton) c).setIcon(null);
			}
		}
	}
}