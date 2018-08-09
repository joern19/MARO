package Rendering;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	private int xSize;
	private int ySize;
	
	private GamePanel gpanel;

	public GameFrame(String title, int xSize, int ySize) {
		super(title);
		this.xSize = xSize;
		this.ySize = ySize;
		
		setSize(this.xSize, this.ySize);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		gpanel = new GamePanel();
		add(gpanel);
	}
	
	public void addImage(BufferedImage img, int x, int y) {
		gpanel.addImage(img, x, y);
	}
	/*
	public void addText(GameText text ) {
		gpanel.addText(text);
	}
	*/
	public void setMapImages(List<GameImage> list) {
		gpanel.setMapimages(list);
	}
	
	public void setImages(List<GameImage> list) {
		gpanel.setImages(list);
	}
	
	public void setText(List<GameText> gtext) {
		gpanel.setText(gtext);
	}
	
	public void removeLastImage() {
		gpanel.removeLastImage();
	}
	
	public void removeAllImages() {
		gpanel.removeAllImages();
	}

}
