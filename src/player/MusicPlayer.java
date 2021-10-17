// Paquete al que pertenece la clase
package player;

// Importación de clases
import java.io.File;

import javazoom.jlgui.basicplayer.*;

/**
 * Clase MusicPlayer para controlar el reproductor interno
 * y la canción actualmente reproducida
 * @author Samuel Rodríguez Ares (UO271612)
 */
public class MusicPlayer {
	
	private BasicPlayer basicPlayer = null;		// reproductor de música básico
	private File song;							// canción siendo reproducida
	private int playTime = 0;				    // milisegundos transcurridos
	
	/**
	 * Constante que referencia a la canción de fondo para reproducir
	 */
	public final static String BG_TRACK = "files/music/loop.mp3";
	
	/**
	 * Constructor por defecto, que inicializa el reproductor básico
	 */
	public MusicPlayer() {
		basicPlayer = new BasicPlayer();
		song = new File(BG_TRACK);
		play();
	}
	
	/**
	 * Reproduce la canción preestablecida del juego
	 */
	public void play() {
		try {
			playTime = (int) System.currentTimeMillis();
			
			basicPlayer.open(song);			// abre el archivo pasado
			basicPlayer.play();				// reproduce el archivo
		} catch (Exception e) {
			System.err.println("Se ha producido un error reproduciendo la música.");
		}
	}
	
	/**
	 * Comprueba si el tiempo transcurrido tras la última reproducción
	 * supera la longitud de la música de fondo. Si es así, se vuelve a reproducir
	 */
	public void checkPlayTime() {
		if (System.currentTimeMillis() - getPlayTime() >= 84000) {
			play();
		}
	}
	
	/**
	 * Pausa la reproducción de la canción de fondo
	 */
	public void pause() {
		try {
			basicPlayer.pause();
		} catch (BasicPlayerException e) {
			System.err.println("Se ha producido un error pausando la música.");
		}
	}
	
	/**
	 * Reanuda la reproducción de la canción de fondo
	 */
	public void resume() {
		try {
			basicPlayer.resume();
		} catch (BasicPlayerException e) {
			System.err.println("Se ha producido un error reanudando la música.");
		}
	}
	
	/**
	 * Modifica el volumen de reproducción
	 * @param vol nivel de volumen a establecer, de tipo double
	 * @param volMax umbral máximo de volumen, de tipo double
	 */
	public void setVolume(double vol, double volMax) {
		try {
			basicPlayer.setGain(vol/volMax);
		} catch (BasicPlayerException e) {
			System.err.println("Se ha producido un error modificando el volumen.");
		}
	}
	
	/**
	 * Devuelve el volumen de reproducción actual
	 * @return Volumen de reproducción actual, de tipo float
	 */
	public float getVolume() {
		return this.basicPlayer.getGainValue();
	}
	
	/**
	 * Devuelve el tiempo que ha transcurrido desde la última reproducción
	 * @return Tiempo transcurrido (en milisegundos) desde última reproducción (int)
	 */
	public int getPlayTime() {
		return this.playTime;
	}
	
	/**
	 * Devuelve el estado de reproducción
	 * @return Estado de reproducción de la música, de tipo int
	 */
	public int getStatus() {
		return this.basicPlayer.getStatus();
	}
}