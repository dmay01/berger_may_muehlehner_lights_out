package berger_may_muehlehner_lights_out;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Controller Klasse als Verbindung von View und Model instanziert ausserdem die
 * anderen Klassen und dient als ActionListener
 * 
 * @author Muehlehner Moritz
 * @version 1.0
 * 
 */
public class LightsController implements ActionListener {

	private LightsPanel p;
	private LightsModel m;

	/**
	 * LightsController-Konstruktor Initialisiert die Buttons zufällig
	 */
	public LightsController() {
		p = new LightsPanel(this);
		m = new LightsModel();
		m.init();
		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 5; a++) {
				p.control(i, a, m.getLight(i, a));
			}
		}
		new LightsFrame(p, "Lights Out");
	}

	/**
	 * Main Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new LightsController();
	}

	/**
	 * ActionListener
	 * 
	 * @param e
	 *            ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				if (p.getLight()[y][x].equals(e.getSource()))
					m.toggle(x, y);
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 5; a++)
				p.control(i, a, m.getLight(i, a));
		}
		String ac = e.getActionCommand();
		if (ac == "reset") {
			m.init();
			for (int i = 0; i < 5; i++) {
				for (int a = 0; a < 5; a++)
					p.control(i, a, m.getLight(i, a));
			}
		}
		if (m.isWin())
			JOptionPane.showMessageDialog(p, "Congratulations! You won!");
	}
}