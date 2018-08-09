package Rendering;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GameImage {
	
	private BufferedImage image;
	private int xPos;
	private int yPos;
	
	public GameImage(BufferedImage image, int xPos, int yPos) {
		this.image = image;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(xPos, yPos, image.getWidth(), image.getHeight());
	}
	
}
