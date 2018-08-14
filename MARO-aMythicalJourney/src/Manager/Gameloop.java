package Manager;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import EinSehrSchoenerStartBidlschirm.StartFrame;
import Manager.SoundManager.Sound;
import Rendering.GameImage;
import Rendering.GameText;
import Rendering.GameFrame;

public class Gameloop implements Runnable {

	private GameFrame gameframe;
	
	private StartFrame startFrame;

	private boolean running = true;

	private long lastLoopTime = System.nanoTime();
	private final int TARGET_FPS = 60;
	private final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
	private double lastFpsTime;
	//private int sound;

	public Gameloop() {
		
		gameframe = new GameFrame("MARO", 64 * 12, (64 * 8) + 20);
		GameManager.getInstance().initInputManager(gameframe);
		
		startFrame = new StartFrame("MARO - StartScreen", new String[] {"Test"});
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		
		startFrame.run();
		
		/*beim Fensterschlieen*/
		
		//gibt den neu erstellten Spieler als String zurck
		startFrame.getNewPlayerName();
		
		//gibt den geladenen Spieler als String zurck
		startFrame.getLoadedPlayerName();
		
		gameframe.setVisible(true);

		while (running) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);

			this.lastFpsTime += updateLength;

			if (lastFpsTime >= 1000000000) {
				lastFpsTime = 0;
			}

			doGameUpdates(delta);
			render();

			try {
				Thread.sleep(100);
			} catch (Exception ex) {
				// System.out.println(ex.getMessage());
			}
		}
	}

	private void render() {
		List<GameImage> list = GameManager.getInstance().GetObjectsToRender(TileManager.getMap());
		gameframe.setMapImages(list);
		list = GameManager.getInstance().GetObjectsToRender(TileManager.getObstacles());
		gameframe.setImages(list);		
		
		//NPCs rendern
		list.addAll(GameManager.getInstance().getNPCsToRender());
		
		// Items for map
		list.addAll(GameManager.getInstance().getItemsToRender());
		
		// PLAYER
		list.add(GameManager.getInstance().getPlayerToRender());
		
		//INVENTORY
		list.addAll(GameManager.getInstance().getInventoryToRender());
		
		List<GameText> textList = new ArrayList<GameText>();
		textList.add(GameManager.getInstance().getCoinsToRender());

		textList.addAll(GameManager.getInstance().getInventory().getInventoryAmountToRender());
		
		textList.add(new GameText("LP:   "+GameManager.getInstance().GetPlayer().GetHealth(), 325, 40, 0, 0, "Helvetica", Color.BLACK, 20));
		
		gameframe.setText(textList);
		
		gameframe.repaint();
	}

	private void doGameUpdates(double delta) {
		GameManager.getInstance().update();
		//sound++;
		/*if(sound==3) {
			SoundManager.getInstance().loadSound(Sound.TEST);
			SoundManager.getInstance().loadSound(Sound.TEST2);
			SoundManager.getInstance().playSound(Sound.TEST);
			SoundManager.getInstance().playSound(Sound.TEST2);
			sound = 0;
		}*/
		/*
		 * if(sound==3) { SoundManager.getInstance().loadSound(Sound.TEST);
		 * SoundManager.getInstance().loadSound(Sound.TEST2);
		 * SoundManager.getInstance().playSound(Sound.TEST);
		 * SoundManager.getInstance().playSound(Sound.TEST2); sound = 0; }
		 */
	}
}
