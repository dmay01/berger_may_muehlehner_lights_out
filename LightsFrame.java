package berger_may_muehlehner_lights_out;

import javax.swing.JFrame;

/**
 * Frame Klasse zur Darstellung der GUI
 * 
 * @author Daniel May
 * @version 1.0
 * 
 */
public class LightsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Standard Konstruktor
	 * 
	 * @param mp
	 *            Panel
	 * @param header
	 *            Titel
	 */
	public LightsFrame(LightsPanel mp, String header) {
		super(header);
		this.add(mp);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}