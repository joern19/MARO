package Objects;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import Manager.GameManager;
import Rendering.GameImage;
import Rendering.GameText;
import Rendering.IOUtils;

//5(0-4) Slots(Typ Item) + coins
public class Inventory {

    private static Inventory instance = null;
    private int coins;
    private int selectedItem = 1;

    private InventoryItem[] inventory = new InventoryItem[4];

    private BufferedImage image;

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public Inventory() {
        image = IOUtils.load("Images", "inventory_empty.png");
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int chosenItem) {
        this.selectedItem = chosenItem;
    }
    
    public void removeCurrentItem() {
    	InventoryItem i = getInventory(selectedItem - 1);
    	if(i != null) {    		
    		if(i.amount >= 2) {
    			i.amount--;
    		} else {
    			setInventoryPos(selectedItem - 1, null);
    		}
    	}
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins) {
        setCoins(getCoins() + coins);
    }

    public void removeCoins(int coins) {
        setCoins(getCoins() - coins);
    }

    public void dropRandomCoins(int x, int y) {
        int rnmnr = new Random().nextInt(10);
        addCoins(rnmnr);
        // Drop Item on Stone Position
    }

    public void setInventoryPos(int pos, Item item) {
        inventory[pos].item = item;
    }

    public InventoryItem getInventory(int pos) {
        return inventory[pos];
    }

    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                if (item.isStackable() && inventory[i].item.getName().equals(item.getName())) {
                    inventory[i].amount++;
                    return;
                }
            } else {
                inventory[i] = new InventoryItem(item, 1);
                return;
            }
        }
    }

    public Item getItemByName(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].item.getName().equals(name)) {
                return inventory[i].item;
            }
        }
        return null;
    }

    public ArrayList<GameImage> getInventoryToRender() {

        ArrayList<GameImage> images = new ArrayList<GameImage>();

        images.add(new GameImage(image, 268, 434));
        images.add(new GameImage(image, 332, 434));
        images.add(new GameImage(image, 396, 434));
        images.add(new GameImage(image, 460, 434));

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
            	images.add(new GameImage(((MapItem) inventory[i].item).getImageToRender(), 268 + (i * 64), 434));
            } 
            if (i + 1 == selectedItem) {
                images.add(new GameImage(IOUtils.load("Images", "item_Selected.png"), 268 + (i * 64), 434));
            }
        }

        return images;
    }

    public ArrayList<GameText> getInventoryAmountToRender() {
        ArrayList<GameText> text = new ArrayList<>();

        if (GameManager.getInstance().getShowInventory()) {

            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null) {
                    // text.add(new GameText(inventory[i].amount+"", 290+(i * 64), 440, 40, 30));
                    text.add(new GameText(inventory[i].amount + "", 310 + (i * 64), 496, 40, 30, "Helvetica", Color.WHITE, 40));
                }
            }

        }

        return text;
    }

    public class InventoryItem {
        public Item item;
        public int amount;

        InventoryItem(Item item, int amount) {
            this.item = item;
            this.amount = amount;
        }

        public Item getItem() {
            return item;
        }
        
        public int getAmount() {
			return amount;
		}
    }
}
