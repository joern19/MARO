package Manager;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import Npc.NPC;
import Objects.Inventory;
import Objects.Item;
import Objects.MapItem;
import Objects.Player;
import Rendering.GameImage;

public class CollisionManager {
	
	private static CollisionManager instance = null;
	private boolean[][] obstacles;
	private ArrayList<Item> items;
	private ArrayList<NPC> npcs;
	private int tileSize;
	
	public static CollisionManager getInstance() {	
		if(instance == null) {
			instance = new CollisionManager();
		}		
		return instance;
	}
	
	public CollisionManager() {
		this.obstacles = new boolean[0][0];
//		this.npc = new ArrayList<NPC>();
		this.items = new ArrayList<Item>();
		this.tileSize = 64;
	}
	
//ADD OBJECTS WITH COLLISION
	public void addObstacle(int x, int y) {
		this.obstacles[x][y] = true;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void addNpc(NPC npc) {
		this.npcs.add(npc);
	}
	
//TEST FOR A COLLISION
	public boolean getObstacleCollision(int x, int y) {
		if (this.obstacles[x/this.tileSize][y/this.tileSize]) {
			return true;
		}
		return false;
	}
	
	public NPC getNPCCollision() {
		Rectangle playerBBox = GameManager.getInstance().GetPlayer().getBoundingBox();

		for (int i = 0; i < this.npcs.size(); i++) {
			NPC npc = this.npcs.get(i);

			Rectangle npcBBox = new Rectangle(npc.getX(), npc.getY(), npc.getWidth(), npc.getHeight());

			if (playerBBox.intersects(npcBBox)) {
				return npc;
			}
		}
		return null;
	}
	
	public Item getItemCollision() {
		Rectangle playerBBox = GameManager.getInstance().GetPlayer().getBoundingBox();

		for (int i = 0; i < this.items.size(); i++) {
			Item item = this.items.get(i);

			Rectangle itemBBox = new Rectangle(((MapItem)item).getX(), ((MapItem)item).getY(), ((MapItem)item).getWidth(), ((MapItem)item).getHeight());

			if (playerBBox.intersects(itemBBox)) {
				//if (Inventory.addItem(item)) {
				//	this.items.remove(i);
				//}
				return item;
			}
		}
		return null;
	}
	
	// do not move if collides with obstacle
	public boolean collidesWithObstacle(Player player, List<GameImage> gameImages) {
		for(int i=0; i<gameImages.size(); i++) {
			if(player.getBoundingBox().intersects(gameImages.get(i).getBoundingBox())) {
				return true;
			}
		}
		
		return false;
	}
	
	// do not move if collides with obstacle
	public boolean collidesWithObstacle(NPC npc, List<GameImage> gameImages) {
		for(int i=0; i<gameImages.size(); i++) {
			if(npc.getBoundingBox().intersects(gameImages.get(i).getBoundingBox())) {
				return true;
			}
		}

		return false;
	}

	// do not move if collides with obstacle
	public boolean collidesWithObstacle(NPC npc, Player player) {
			if(npc.getBoundingBox().intersects(player.getBoundingBox())) {
				return true;
			}

		return false;
	}
	
	// collides with map item -> if consumable put in inventory
	public MapItem collidesWithMapItem(Player player, List<MapItem> mapItems) {
		if(mapItems != null) {
			for(int i=0; i<mapItems.size(); i++) {
				if(player.getBoundingBox().intersects(mapItems.get(i).getBoundingBox())) {
					return mapItems.get(i);
				}
			}		
		}
		return null;
	}
}
