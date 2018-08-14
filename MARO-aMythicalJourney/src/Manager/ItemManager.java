package Manager;

import Manager.TileManager.Tile;
import Objects.Bomb;
import Objects.Inventory;
import Objects.Inventory.InventoryItem;
import Objects.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Objects.MapItem;
import Objects.Player;
import Rendering.GameImage;

public class ItemManager {

    private HashMap<String, ArrayList<MapItem>> items;

    public ItemManager() {
        items = new HashMap<String, ArrayList<MapItem>>();
    }

    public void addItem(String key, MapItem item) {
        if (items.containsKey(key)) {
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
        if (mapItems != null) {
            for (MapItem item : mapItems) {
                images.add(new GameImage(item.getImageToRender(), item.getX(), item.getY()));
            }
        }
        return images;
    }

    public List<MapItem> getItemsForMap(String key) {
        return items.get(key);
    }
    
    public static void useCurrentItem() {
        InventoryItem invItem = Inventory.getInstance().getInventory(Inventory.getInstance().getSelectedItem() - 1);
        if (invItem == null) {
            return;
        }
        Item currentItem = invItem.getItem();
        if (currentItem instanceof MapItem) {
            MapItem mi = (MapItem) currentItem;
            if (mi.getName().equals("Bomb")) {
                Player currentPlayer = GameManager.getInstance().GetPlayer();
                int x = currentPlayer.GetXPosition() / 64;
                int y = currentPlayer.GetYPosition() / 64;
                switch(currentPlayer.getPlayerDirection()) {
                    case Right:
                        x++;
                        break;
                    case Left:
                        x--;
                        break;
                    case Up:
                        y--;
                        break;
                    case Down:
                        y++;
                        break;
                    default:
                        return;
                }    
                Tile toDestroy = TileManager.getObstacal(y, x);
                if (toDestroy.isObstacal()) {
                    TileManager.RemoveObstacle(y, x);
                    //remove Inventory Item..
                }
            }
        }
    }
}
