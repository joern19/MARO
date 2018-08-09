package Objects;

public class Item {
	private String name;
	private boolean consumable;
	private boolean stackable;
	
	public Item(String name,boolean consumable,boolean stackable) {
		this.name = name;
		this.consumable = consumable;
		this.stackable = stackable;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isConsumable() {
		return consumable;
	}
	
	public boolean isStackable() {
		return stackable;
	}
}