package EinSehrSchoenerStartBidlschirm;

import Rendering.IOUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected JLabel topHeadline;
	protected JLabel subHeadline;
	
	protected JButton newButton;
	protected JButton loadButton;
	
	public StartPanel() {
		
		setLayout( null );
		
		
		initButtons();
		initHeadlines();
		
		
		
		add(newButton);
		add(loadButton);
	
		add(topHeadline);
		add(subHeadline);
	}
	
	private void initHeadlines() {
		topHeadline = new JLabel("MARO");
		subHeadline = new JLabel("a mythical Journey");
		
		topHeadline.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		subHeadline.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		topHeadline.setFont(new Font("Times new Roman", Font.ITALIC, 50));
		
		subHeadline.setFont(new Font("Times new Roman", Font.ITALIC, 30));
		
		topHeadline.setBounds(30,10,200,40);
		subHeadline.setBounds(30,50,400,40);
	}
	
	private void initButtons() {
		newButton = new JButton("new Game");
		loadButton = new JButton("load Game");
		
		//BufferedImage image = IOUtils.load("Images", "Holz.jpg");
		//newButton.setIcon(new ImageIcon(image));
		newButton.setBounds(30,90, 400, 100);
		loadButton.setBounds(30, 250, 400, 100);
		
		Font f = new Font("Arial", Font.CENTER_BASELINE, 20);
		newButton.setFont(f);
		loadButton.setFont(f);
		
		Insets ins = new Insets(50, 100, 50, 100);
		
		newButton.setMargin(ins);
		loadButton.setMargin(ins);
		
		newButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		loadButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		
	}

}
