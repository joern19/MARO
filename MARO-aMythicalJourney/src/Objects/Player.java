package Objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Rendering.IOUtils;

public class Player {

    private int XPosition;

    public enum Movement {
        Left, Right, Up, Down
    }

    private Movement currentDirection = Movement.Right;
    private int YPosition;
    private float Health = 10;
    private String Name;
    private String PlayerImageNames[];
    private BufferedImage PlayerImages[];

    public Player(int XPos, int YPos, String PlayerName) {
        this.XPosition = XPos;
        this.YPosition = YPos;
        this.Name = PlayerName;
        this.PlayerImageNames = new String[]{"link_right.png", "link_left.png", "link_right.png", "link_top.png", "link_back.png"};
        this.PlayerImages = new BufferedImage[5];
    }

//SETTER
    public void setXPosition(int xPosition) {
        XPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        YPosition = yPosition;
    }

    private void SetYPosition(boolean MoveUp) {
        if (MoveUp) {
            this.YPosition = this.YPosition - 64;
        } else {
            this.YPosition = this.YPosition + 64;
        }
    }

    private void SetXPosition(boolean MoveRight) {
        if (MoveRight) {
            this.XPosition = this.XPosition + 64;
        } else {
            this.XPosition = this.XPosition - 64;
        }
    }

    public void setHealth(float health) {
        this.Health = health;
    }

    public void Damage() {
        this.Health -= 0.5;
    }

//GETTER
    public int GetXPosition() {
        return this.XPosition;
    }

    public String GetName() {
        return Name;
    }

    public int GetYPosition() {
        return this.YPosition;
    }

    public float GetHealth() {
        return this.Health;
    }

//MOVEMENT
    public void MoveUP() {
        System.out.println("X" + XPosition / 64);
        System.out.println("y" + YPosition / 64);
        this.currentDirection = Movement.Up;
        this.SetYPosition(true);
    }

    public void MoveDown() {
        System.out.println("X" + XPosition / 64);
        System.out.println("y" + YPosition / 64);
        this.currentDirection = Movement.Down;
        this.SetYPosition(false);
    }

    public void MoveRight() {
        System.out.println("X" + XPosition / 64);
        System.out.println("y" + YPosition / 64);
        this.currentDirection = Movement.Right;
        this.SetXPosition(true);
    }

    public void MoveLeft() {
        System.out.println("X" + XPosition / 64);
        System.out.println("y" + YPosition / 64);
        this.currentDirection = Movement.Left;
        this.SetXPosition(false);
    }

    public void setPlayerDirection(Movement movement) {
        this.currentDirection = movement;
    }

    public Movement getPlayerDirection() {
        return currentDirection;
    }

//COLLISION
    public Rectangle getBoundingBox() {
        return new Rectangle(XPosition + 1, YPosition + 1, 64 - 1, 64 - 1);
    }

//GRAPHICS
    public BufferedImage getSprite() {
        switch (this.currentDirection) {
            case Left:
                if (PlayerImages[1] == null) {
                    PlayerImages[1] = IOUtils.load("Images", PlayerImageNames[1]);
                }
                return PlayerImages[1];

            case Right:
                if (PlayerImages[2] == null) {
                    PlayerImages[2] = IOUtils.load("Images", PlayerImageNames[2]);
                }
                return PlayerImages[2];

            case Up:
                if (PlayerImages[4] == null) {
                    PlayerImages[4] = IOUtils.load("Images", PlayerImageNames[4]);
                }
                return PlayerImages[4];

            case Down:
                if (PlayerImages[3] == null) {
                    PlayerImages[3] = IOUtils.load("Images", PlayerImageNames[3]);
                }
                return PlayerImages[3];

            default:
                if (PlayerImages[0] == null) {
                    PlayerImages[0] = IOUtils.load("Images", PlayerImageNames[0]);
                }
                return PlayerImages[0];
        }
    }
}
