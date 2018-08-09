package Objects;

public class Boat extends MapItem {
	public Boat(int x, int y) {
		super("Boat",true,false, x, y, 64, 64, "");
	}
	
	public MapItem getParent() {
		return super.getInstance();
	}
}
