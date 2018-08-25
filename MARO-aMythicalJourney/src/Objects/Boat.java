package Objects;

public class Boat extends MapItem {
	
	public enum Movement{
		UP, DOWN , LEFT , RIGHT;
	}
	
	private Movement currentMovement;
	private String[] boatpicture = new String[] { "Boat_Bottom.png", "Boat_Top.png", "Boat_Left.png", "Boat_Right.png" };
	
	public Boat(int x, int y) {
		super("Boat",true,false, x, y, 64, 64, "/Images/Boat_Bottom.png");
	}
	
	public MapItem getParent() {
		return super.getInstance();
	}
	
	public Movement getCurrentMovement() {
		return currentMovement;
	}
	
	public String getSprint() {
		
		switch(currentMovement) {
			
		case UP:
			return boatpicture[1];
		case DOWN:
			return boatpicture[0];
		case LEFT:
			return boatpicture[2];
		case RIGHT:
			return boatpicture[3];
		
		}
		
		return boatpicture[1];
		
	}
	
	
}
