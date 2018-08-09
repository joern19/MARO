package EinSehrSchoenerStartBidlschirm;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StartFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private StartPanel spanel;
	
	private NewGamePanel ngpanel;
	private LoadPanel lpanel;
	
	private String newPlayerName;
	
	private String loadedPlayerName;
	
	public StartFrame(String title, String[] gameSaves) {
		super(title);
		
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(500, 500));
		
		spanel = new StartPanel();
		ngpanel = new NewGamePanel();
		lpanel = new LoadPanel(gameSaves);
		
		initButtons();
				
		add(spanel);
				
		pack();

	}
	
	private void initButtons() {
		spanel.newButton.addActionListener(this);
		spanel.loadButton.addActionListener(this);
		ngpanel.startButton.addActionListener(this);
		for (JButton jb : lpanel.sbuttons) jb.addActionListener(this);
		
	}
	
	public void run() {
		setVisible(true);
		while (true) {
			if (!isActive()) break;
		}
	}
	
	public String getNewPlayerName() {
		return newPlayerName;
	}
	
	public String getLoadedPlayerName() {
		return loadedPlayerName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		remove(spanel);
		
		if(e.getSource() == spanel.newButton) {
			add(ngpanel);
		} else if (e.getSource() == spanel.loadButton) {
			add(lpanel);
			
		} else if (e.getSource() == ngpanel.startButton) {
			dispose();
			newPlayerName = ngpanel.tf.getText();
			return;
			//START GAME
		}
		
		for (JButton jb : lpanel.sbuttons) {
			
			if (e.getSource() == jb) {
				dispose();
				loadedPlayerName = jb.getText();
				return;
			}
		}
		
		repaint();
		setVisible(true);
		
	}

}
