package Npc;

import Rendering.IOUtils;

public class Goblin extends NPC {

	public Goblin(int x, int y) {
		super(1, 1, 64, 64, 40, 2, IOUtils.getBufferedImage("Goblin_left.png"), x, y);
	}	
}