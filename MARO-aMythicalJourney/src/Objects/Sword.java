package Objects;

public class Sword extends MapItem {
	private int damage;
	
	public Sword(int x, int y, int damage) {
		super("Sword", false, false, x, y, 64, 64, "");
		this.damage = damage;
	}
	
	public MapItem getParent() {
		return super.getInstance();
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
}
