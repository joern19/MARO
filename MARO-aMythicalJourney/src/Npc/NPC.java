package Npc;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Manager.CollisionManager;
import Manager.GameManager;
import Objects.Player;
import Objects.Player.Movement; 

public class NPC {

	private int healthPoints;
	private int moveSpeed;
	private int Width;
	private int Height;
	private int x;
	private int y;
	private int retreatFrames;
	private int retreatFrameCounter;
	private int retreatSpeed;
	
	private BufferedImage sprite;

	public NPC(int hp, int speed, int spriteWidth, int spriteHeight, int retreatFrames, int retreatSpeed, BufferedImage sprite) {
		this.healthPoints = hp;
		this.moveSpeed = speed;
		this.Width = spriteWidth;
		this.Height = spriteHeight;
		this.retreatFrames = retreatFrames;
		this.retreatSpeed = retreatSpeed;
		this.retreatFrameCounter = 0;
		
		this.sprite = sprite;
	}

// GETTER
	public int getHealthPoints() {
		return this.healthPoints;
	}

	public int getMoveSpeed() {
		return this.moveSpeed;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.Width;
	}

	public int getHeight() {
		return this.Height;
	}


// SETTER
	public BufferedImage getSprite() {
		return sprite;
	}

	public void setHealthPoints(int hp) {
		this.healthPoints = hp;
	}

	public void setmoveSpeed(int speed) {
		this.moveSpeed = speed;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int Width) {
		this.Width = Width;
	}

	public void setHeight(int Height) {
		this.Height = Height;
	}

// DAMAGE
	public void damage(int damage) {
		healthPoints -= damage;
		this.retreatFrameCounter = this.retreatFrames;
	}

// MOVEMENT
	private void playerCollision() {
		//if (CollisionManager.getInstance().getNPCCollision() == this) {
		//	this.retreatFrameCounter = this.retreatFrames;
		//}
	}
	
	public void move(int x, int y) {
		/*if (!CollisionManager.getInstance().getObstacleCollision(this.x + x, this.y)) {
			this.x += x;
		}

		if (!CollisionManager.getInstance().getObstacleCollision(this.x, this.y + y)) {
			this.y += y;
		}*/
		this.x += x;
		this.y += y;
	}
	
	private void SetYPosition(boolean MoveUp) {
		if (MoveUp)
			this.y=this.y-32;
		else
			this.y=this.y+32;
	}
	
	private void SetXPosition(boolean MoveRight) {
		if (MoveRight)
			this.x=this.x+32;
		else 
			this.x=this.x-32;
	}
	
	public void MoveUP() {
		this.SetYPosition(true);
	}
	
	public void MoveDown() {
		this.SetYPosition(false);	
	}
	
	public void MoveRight() {
		this.SetXPosition(true);
	}
	
	public void MoveLeft() {
		this.SetXPosition(false);
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(this.x+1, this.x+1, 64-1, 64-1);
	}
	
	public void moveToPlayer(Player currentPlayer) {
		int xMove = 0;
		int yMove = 0;
		
		// es wird sich nur bewegt, wenn der Abstand zur Spielerkooridinate relevant
		// groß ist
		if ((currentPlayer.GetXPosition() - this.x) > this.moveSpeed) {				
			xMove += this.moveSpeed;
		} else if ((currentPlayer.GetXPosition() - this.x) < -this.
				moveSpeed) {
			xMove -= this.moveSpeed;
		}

		if ((currentPlayer.GetYPosition() - this.y) > this.moveSpeed) {
			yMove += this.moveSpeed;
		} else if ((currentPlayer.GetYPosition() - this.y) < -this.moveSpeed) {
			yMove -= this.moveSpeed;
		} else {
			if ((currentPlayer.GetXPosition() - this.x) > 0) {
				xMove -= this.retreatSpeed;
			} else if ((currentPlayer.GetXPosition() - this.x) < 0) {
				xMove += this.retreatSpeed;
			}

			if ((currentPlayer.GetYPosition() - this.y) > 0) {
				yMove -= this.retreatSpeed;
			} else if ((currentPlayer.GetYPosition() - this.y) < 0) {
				yMove += this.retreatSpeed;
			}

			move(-xMove, yMove);
		}
	}
}