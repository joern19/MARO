package EinSehrSchoenerStartBidlschirm;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewGamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected JButton startButton;
	protected JTextField tf;
	
	public NewGamePanel() {
		setLayout(new FlowLayout());
		
		
		tf = new JTextField(30);
		startButton = new JButton("Start!");
		
		
		add(new JLabel("Name: "));
		add(tf);
		
		add(startButton);
	}
}
