package Npc;

import Rendering.IOUtils;

public class Goblin extends NPC {

	public Goblin() {
		super(1, 1, 64, 64, 40, 2, IOUtils.getBufferedImage("Goblin_left.png"));
		
		setX(64); //TEST
		setY(64); //TEST
	}	
}
