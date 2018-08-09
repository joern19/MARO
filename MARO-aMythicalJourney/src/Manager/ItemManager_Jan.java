package Manager;

import java.util.ArrayList;
import java.util.HashMap;

import Objects.*;

public class ItemManager_Jan {
	
	private static ItemManager_Jan instance = null;	
	private HashMap<String,ArrayList<MapItem>> items;	
	
	public static ItemManager_Jan getInstance() {
		if(instance == null) {
			instance = new ItemManager_Jan();
		}		
		return instance;
	}
	
	public ItemManager_Jan() {
		this.items = new HashMap<String,ArrayList<MapItem>>();
		
		ArrayList<MapItem> one = new ArrayList<MapItem>();
			one.add(new Bomb(4,3).getParent());		
		items.put("1", one);
		
		ArrayList<MapItem> two = new ArrayList<MapItem>();
			two.add(new Sword(6,4,1).getParent());		
		items.put("2", two);		
	}
	
	public void createItems() {
		items.get("" + TileManager.getMapID());
	}
}
