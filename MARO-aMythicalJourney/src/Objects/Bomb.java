package Objects;

public class Bomb extends MapItem{
	public Bomb(int x, int y) {
		super("Bomb", false, false, x, y, 64, 64, "");
	}
	
	public MapItem getParent() {
		return super.getInstance();
	}
}
