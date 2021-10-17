// Paquete al que pertenece la clase
package player;

// Importaci�n de clases
import java.io.File;

import javazoom.jlgui.basicplayer.*;

/**
 * Clase MusicPlayer para controlar el reproductor interno
 * y la canci�n actualmente reproducida
 * @author Samuel Rodr�guez Ares (UO271612)
 */
public class MusicPlayer {
	
	private BasicPlayer basicPlayer = null;		// reproductor de m�sica b�sico
	private File song;							// canci�n siendo reproducida
	private int playTime = 0;				    // milisegundos transcurridos
	
	/**
	 * Constante que referencia a la canci�n de fondo para reproducir
	 */
	public final static String BG_TRACK = "files/music/loop.mp3";
	
	/**
	 * Constructor por defecto, que inicializa el reproductor b�sico
	 */
	public MusicPlayer() {
		basicPlayer = new BasicPlayer();
		song = new File(BG_TRACK);
		play();
	}
	
	/**
	 * Reproduce la canci�n preestablecida del juego
	 */
	public void play() {
		try {
			playTime = (int) System.currentTimeMillis();
			
			basicPlayer.open(song);			// abre el archivo pasado
			basicPlayer.play();				// reproduce el archivo
		} catch (Exception e) {
			System.err.println("Se ha producido un error reproduciendo la m�sica.");
		}
	}
	
	/**
	 * Comprueba si el tiempo transcurrido tras la �ltima reproducci�n
	 * supera la longitud de la m�sica de fondo. Si es as�, se vuelve a reproducir
	 */
	public void checkPlayTime() {
		if (System.currentTimeMillis() - getPlayTime() >= 84000) {
			play();
		}
	}
	
	/**
	 * Pausa la reproducci�n de la canci�n de fondo
	 */
	public void pause() {
		try {
			basicPlayer.pause();
		} catch (BasicPlayerException e) {
			System.err.println("Se ha producido un error pausando la m�sica.");
		}
	}
	
	/**
	 * Reanuda la reproducci�n de la canci�n de fondo
	 */
	public void resume() {
		try {
			basicPlayer.resume();
		} catch (BasicPlayerException e) {
			System.err.println("Se ha producido un error reanudando la m�sica.");
		}
	}
	
	/**
	 * Modifica el volumen de reproducci�n
	 * @param vol nivel de volumen a establecer, de tipo double
	 * @param volMax umbral m�ximo de volumen, de tipo double
	 */
	public void setVolume(double vol, double volMax) {
		try {
			basicPlayer.setGain(vol/volMax);
		} catch (BasicPlayerException e) {
			System.err.println("Se ha producido un error modificando el volumen.");
		}
	}
	
	/**
	 * Devuelve el volumen de reproducci�n actual
	 * @return Volumen de reproducci�n actual, de tipo float
	 */
	public float getVolume() {
		return this.basicPlayer.getGainValue();
	}
	
	/**
	 * Devuelve el tiempo que ha transcurrido desde la �ltima reproducci�n
	 * @return Tiempo transcurrido (en milisegundos) desde �ltima reproducci�n (int)
	 */
	public int getPlayTime() {
		return this.playTime;
	}
	
	/**
	 * Devuelve el estado de reproducci�n
	 * @return Estado de reproducci�n de la m�sica, de tipo int
	 */
	public int getStatus() {
		return this.basicPlayer.getStatus();
	}
}