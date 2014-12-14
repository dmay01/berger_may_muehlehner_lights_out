package berger_may_muehlehner_lights_out;

/**
 * Model Klasse fuer die eigentliche Aufgabenstellung Hier wird ein Array mit
 * Wahrheitswerten intialisiert und Methoden zum "switchen" von Lichtern
 * angeboten. Der Koordinaten Ursprung ist links oben
 * 
 * @author Daniel May
 * @version 2.2 Javadoc fixes + getter for all lights
 *
 */
public class LightsModel {

	private static final int minSize = 3;
	private static final int maxSize = 20;
	private int size;
	private boolean[][] lights;
	private boolean win;

	/**
	 * Std Konstruktor
	 * 
	 */
	public LightsModel() {
		/*
		 * false ist ausgeschalten; true ist eingeschalten
		 */
		resize(5);
	}

	/**
	 * Konstruktor fuer waehlbare Groesse
	 * 
	 * @param size
	 *            gewuenschte Groesse
	 * @throws IllegalArgumentException
	 *             wenn die gewaehlte Groesse ungueltig ist
	 */
	public LightsModel(int size) {
		resize(this.size);
	}

	/**
	 * Methode zum Inntialisieren der Buttons
	 * 
	 * kann auch als newGame verwendet werden, wenn die Groesse gleich bleiben
	 * soll
	 */
	public void init() {
		lights = new boolean[size][size];
		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights[i].length; j++) {
				lights[i][j] = false;
			}
		}
		int on = (int) (Math.random() * (size * size)) + 1;
		for (int i = 0; i < on;) {
			int x = (int) (Math.random() * size);
			int y = (int) (Math.random() * size);
			if (!lights[y][x]) {
				lights[y][x] = true;
				i++;
			}
		}
		win();
	}

	/**
	 * switcht alle umliegende Lichter des gewuenschten Lichts inklusive des
	 * gewuenschten Lichts
	 * 
	 * @param x
	 *            x Wert des Lichts von 0 bis size-1
	 * @param y
	 *            y Wert des Lichts von 0 bis size-1
	 * @throws IllegalArgumentException
	 *             wenn der x oder y Wert ausserhalb des gueltigen Bereichs
	 *             liegt
	 */
	public void toggle(int x, int y) throws IllegalArgumentException {
		if (x < 0 || x > size - 1 || y < 0 || y > size - 1)
			throw new IllegalArgumentException();
		lights[y][x] = !lights[y][x];
		if (x != 0)
			lights[y][x - 1] = !lights[y][x - 1];
		if (x != size - 1)
			lights[y][x + 1] = !lights[y][x + 1];
		if (y != 0)
			lights[y - 1][x] = !lights[y - 1][x];
		if (y != size - 1)
			lights[y + 1][x] = !lights[y + 1][x];
		win();
	}

	/**
	 * ueberprueft ob man gewonnen hat und setzt den Wert in dem Attribut win
	 */
	private void win() {
		boolean tmp = true;
		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights[i].length; j++) {
				if (lights[i][j])
					tmp = false;
			}
		}
		win = tmp;
	}

	/**
	 * @return the win
	 */
	public boolean isWin() {
		return win;
	}

	/**
	 * veraendert die Groesse des Feldes ruft automatisch die init() Methode auf
	 * 
	 * @param size
	 *            neue Laenge einer Spielfeldseite
	 * @throws IllegalArgumentException
	 *             wenn die gewuenschte Groesse ausserhalb von min und max liegt
	 */
	public void resize(int size) throws IllegalArgumentException {
		if (size < minSize || size > maxSize)
			throw new IllegalArgumentException();
		this.size = size;
		init();
	}

	/**
	 * Gibt den Status eines bestimmten Lichtes zurueck
	 * 
	 * @param x
	 *            x Wert des Lichts von 0 bis size-1
	 * @param y
	 *            y Wert des Lichts von 0 bis size-1
	 * @return ob das Licht an der betroffenen Stelle ein oder ausgeschalten ist
	 * @throws IllegalArgumentException
	 *             wenn der x oder y Wert ausserhalb des gueltigen Bereichs
	 *             liegt
	 */
	public boolean getLight(int x, int y) throws IllegalArgumentException {
		if (x < 0 || x > size - 1 || y < 0 || y > size - 1)
			throw new IllegalArgumentException();
		return lights[y][x];
	}

	/**
	 * @return the lights
	 */
	public boolean[][] getLights() {
		return lights;
	}
}