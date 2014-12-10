package berger_may_muehlehner_lights_out;

/**
 * Model Klasse fuer die eigentliche Aufgabenstellung Hier wird ein Array mit
 * Wahrheitswerten intialisiert und Methoden zum "switchen" von Lichtern
 * angeboten. Der Koordinaten Ursprung ist links oben
 * 
 * @author Daniel May
 * @version 1.0
 *
 */
public class LightsModel {

	private static final int size = 5;
	private boolean[][] lights;
	private boolean win;

	/**
	 * Std Konstruktor
	 */
	public LightsModel() {
		/*
		 * false ist ausgeschalten; true ist eingeschalten
		 */
		lights = new boolean[size][size];
		init();
		win();
	}

	/**
	 * Methode zum Inntialisieren der Buttons
	 */
	public void init() {
		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights[i].length; j++) {
				int tmp = (int) (Math.random() * 2);
				if (tmp == 0) {
					lights[i][j] = true;
				} else {
					lights[i][j] = false;
				}
			}
		}
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
		if (x < 0 || x > size - 1 || y < 0 || y > size - 1) {
			throw new IllegalArgumentException();
		}
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
	 * Gibt zurueck ob man das Spiel gewonnen hat
	 * 
	 * @return wahr wenn das spiel gewonnen wurde
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
}