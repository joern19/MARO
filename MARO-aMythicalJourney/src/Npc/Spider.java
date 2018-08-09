package Npc;

import Rendering.IOUtils;

public class Spider extends NPC {

	public Spider() {
		super(3, 3, 64, 64, 20, 6, IOUtils.getBufferedImage("spider.png"));
		
		setX(128); //TEST
		setY(128); //TEST
	}	
}
