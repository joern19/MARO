package Npc;

import Rendering.IOUtils;

public class Spider extends NPC {

	public Spider(int x, int y) {
		super(3, 3, 64, 64, 20, 6, IOUtils.getBufferedImage("spider.png"), x, y);
	}
}
