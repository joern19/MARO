package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Objects.MapItem;
import Rendering.GameImage;

public class ItemManager {
	private HashMap<String, ArrayList<MapItem>> items;
	
	public ItemManager() {
		items = new HashMap<String, ArrayList<MapItem>>();
	}
	
	public void addItem(String key, MapItem item) {
		if(items.containsKey(key)) {
			items.get(key).add(item);
		} else {
			ArrayList<MapItem> mapItems = new ArrayList<MapItem>();
			mapItems.add(item);
			items.put(key, mapItems);
		}
	}
	
	public void removeItem(String key, MapItem item) {
		items.get(key).remove(item);
	}
	
	public List<GameImage> getItemsForMapToRender(String key) {
		ArrayList<MapItem> mapItems = items.get(key);
		List<GameImage> images = new ArrayList<GameImage>();
		if(mapItems != null) {
			for(MapItem item : mapItems) {
				images.add(new GameImage(item.getImageToRender(), item.getX(), item.getY()));
			}
		}
		return images;
	}
	
	public List<MapItem> getItemsForMap(String key) {
		return items.get(key);
	}
}
