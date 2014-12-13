package berger_may_muehlehner_lights_out;

import javax.swing.JPanel;

/**
 * Optische Oberflaeche des Programms
 * 
 * @author benedikt berger
 * @version 1.0
 * 
 */
public class LightsPanel extends JPanel {

	private static int amount = 3;
	private static final long serialVersionUID = 1L;
	private JPanel buttons, bottom;

	public LightsPanel(LightsController controller){
		buttons = new JPanel();
		bottom = new JPanel();
		
		
	}
}