package EinSehrSchoenerStartBidlschirm;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected JButton[] sbuttons;

	public LoadPanel(String[] gameSaves) {
		setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
		
		sbuttons = new JButton[gameSaves.length];
		
		JLabel loadLabel = new JLabel("Load Game");
		loadLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		loadLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(loadLabel);
		
		int i=0;
		for(String s : gameSaves) {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
			add(jp);
			
			sbuttons[i] = new JButton(s);
			jp.add(sbuttons[i]);
			
			i++;
		}
		
		
		
	}
}
