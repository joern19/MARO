package Objects;

import java.awt.image.BufferedImage;

import Rendering.IOUtils;

public class Boat extends MapItem {
	
	public enum Movement{
		UP, DOWN , LEFT , RIGHT;
	}
	
	private Movement currentMovement;
	private String[] boatpicture = new String[] { "Boat_Bottom.png", "Boat_Top.png", "Boat_Left.png", "Boat_Right.png" };
	
	private int x, y;
	private boolean active;
	
	public Boat(int x, int y) {
		super("Boat",true,false, x, y, 64, 64, "/Images/Boat_Bottom.png");
		this.x = x;
		this.y = y;
		this.active = false;
		this.currentMovement = Movement.DOWN;
	}
	
	public MapItem getParent() {
		return super.getInstance();
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void toggleActive() {
		this.active = !active;
	}
	
	public Movement getCurrentMovement() {
		return currentMovement;
	}
	
	private void SetYPosition(boolean MoveUp) {
        if (MoveUp) {
            this.y = this.y - 3;
        } else {
            this.y = this.y + 3;
        }
    }

    private void SetXPosition(boolean MoveRight) {
        if (MoveRight) {
            this.x = this.x + 3;
        } else {
            this.x = this.x - 3;
        }
    }
    
    public void MoveUP() {
    	this.SetYPosition(true);
        this.currentMovement = Movement.UP;
    }

    public void MoveDown() {
        this.SetYPosition(false);
        this.currentMovement = Movement.DOWN;
    }

    public void MoveRight() {
        this.SetXPosition(true);
        this.currentMovement = Movement.RIGHT;
    }

    public void MoveLeft() {
        this.SetXPosition(false);
        this.currentMovement = Movement.LEFT;
    }
    
    public BufferedImage getSprint() {
    	return IOUtils.load("Images", getPictureString());
    }
	
	public String getPictureString() {
		
		switch(currentMovement) {
			
		case UP:
			return boatpicture[1];
		case DOWN:
			return boatpicture[0];
		case LEFT:
			return boatpicture[2];
		case RIGHT:
			return boatpicture[3];	
			
			default:
				return boatpicture[1];				
				
		}
		
	}
		
}