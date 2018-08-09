package Rendering;

import java.awt.Color;

import javax.swing.JLabel;

public class GameText {
	
	private String Text;
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private String fontName;
	private Color color;
	private int fontSize;

	public GameText(String text, int xPos, int yPos, int width, int height, String fontName, Color color, int fontSize) {
		Text = text;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.fontName = fontName;
		this.color = color;
		this.fontSize = fontSize;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFontName() {
		return fontName;
	}

	public Color getColor() {
		return color;
	}

	public int getFontSize() {
		return fontSize;
	}

	public int getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public int getHoehe() {
		return yPos;
	}
	
	public int getBreite() {
		return yPos;
	}
	
	public String getText() {
		return Text;
	}
	
}
