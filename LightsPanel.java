package berger_may_muehlehner_lights_out;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Optische Oberflaeche des Programms
 * 
 * @author benedikt berger
 * @version 1.0
 * 
 */
public class LightsPanel extends JPanel {

	private static int amount = 5;
	
	private JButton[][] lights;
	private static final long serialVersionUID = 1L;
	private JPanel buttons;
	private LightsController control;

	public LightsPanel(LightsController controller){
		this.control = controller;
		buttons = new JPanel();
		
		this.setLayout(new BorderLayout());
		buttons.setLayout(new GridLayout(amount,amount,5,5));
		
		lights = new JButton[amount][amount];
		
		
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				lights[x][y] = new JButton();
				lights[x][y].setBackground(Color.BLACK);
				lights[x][y].setOpaque(true);
				lights[x][y].setBorderPainted(false);
				lights[x][y].addActionListener(control);
				lights[x][y].setActionCommand(y+" "+x);
				buttons.add(lights[x][y], BorderLayout.CENTER);
			}
		}
		buttons.setBounds(20, 20, 200, 100);
		
		this.add(buttons,BorderLayout.CENTER);
	}
	
	public void control(int x, int y, boolean status){
		if(status){
			lights[y][x].setBackground(Color.YELLOW);
		} else {
			lights[y][x].setBackground(Color.BLACK);
		}
	}
}