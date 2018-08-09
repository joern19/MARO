package Objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Rendering.IOUtils;

public class MapItem extends Item {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private BufferedImage image;
	
	public MapItem(String name, boolean consumable, boolean stackable, int x, int y, int width, 
			int height, String imageName) {
		super(name, consumable, stackable);
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = IOUtils.load("Images", imageName);
	}
	

//GETTER
	public MapItem getInstance() {
		return this;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public BufferedImage getImageToRender() {
		return image;
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(x, y, width, height);
	}

//SETTER
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

}
