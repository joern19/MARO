package Storage;

import java.io.Serializable;

import Manager.TileManager;
import Objects.Inventory;
import Objects.Player;

public class SaveState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3255475302695354376L;
	
	private final Player player;
	private final TileManager timeManager;
	private final Inventory inventory;
	
	public SaveState(Player player, TileManager timeManager, Inventory inventory) {
		this.player = player;
		this.timeManager = timeManager;
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	public Player getPlayer() {
		return player;
	}

	public TileManager getTimeManager() {
		return timeManager;
	}
	
}
