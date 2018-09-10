package Objects;

import Manager.CollisionManager;
import Manager.GameManager;
import Manager.InputManager;
import Rendering.IOUtils;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player {

    public enum Movement {
        Left, Right, Up, Down
    }

    private Movement currentDirection = Movement.Up;
    private int YPosition;
    private int XPosition;
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
        if (this.currentDirection == Movement.Up && !CollisionManager.playerCollidesWithObstacle()) {
            MovementTimer.init(currentDirection);
            (new MovementTimer()).start();
            return;
        }
        this.currentDirection = Movement.Up;
    }

    public void MoveDown() {
        if (this.currentDirection == Movement.Down && !CollisionManager.playerCollidesWithObstacle()) {
            MovementTimer.init(currentDirection);
            (new MovementTimer()).start();
            return;
        }
        this.currentDirection = Movement.Down;
    }

    public void MoveRight() {
        if (this.currentDirection == Movement.Right && !CollisionManager.playerCollidesWithObstacle()) {
            MovementTimer.init(currentDirection);
            (new MovementTimer()).start();
            return;
        }
        this.currentDirection = Movement.Right;
    }

    public void MoveLeft() {
        if (this.currentDirection == Movement.Left && !CollisionManager.playerCollidesWithObstacle()) {
            MovementTimer.init(currentDirection);
            (new MovementTimer()).start();
            return;
        }
        this.currentDirection = Movement.Left;
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

    public Point getTileInFront() {
        Point p = null;
        switch (currentDirection) {
            case Right:
                p = new Point((XPosition / 64) + 1, YPosition / 64);
                break;
            case Left:
                p = new Point((XPosition / 64) - 1, YPosition / 64);
                break;
            case Up:
                p = new Point(XPosition / 64, (YPosition / 64) - 1);
                break;
            case Down:
                p = new Point(XPosition / 64, (YPosition / 64) + 1);
                break;
        }
        return p;
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

    public static class MovementTimer extends Thread {

        private static int start;

        private static final int SPEED = 250;//ms
        private static int status;

        private static boolean horizontal = true;//x
        private static int multiplier = 1;

        public static void init(Movement m) {
            status = 0;
            switch (m) {
                case Right:
                    start = GameManager.getInstance().GetPlayer().GetXPosition();
                    multiplier = 1;
                    horizontal = true;
                    break;
                case Down:
                    start = GameManager.getInstance().GetPlayer().GetYPosition();
                    multiplier = 1;
                    horizontal = false;
                    break;
                case Up:
                    start = GameManager.getInstance().GetPlayer().GetYPosition();
                    horizontal = false;
                    multiplier = -1;
                    break;
                case Left:
                    start = GameManager.getInstance().GetPlayer().GetXPosition();
                    horizontal = true;
                    multiplier = -1;
                    break;
            }
        }

        @Override
        public void run() {
            InputManager.blockInput = true;
            try {
                for (int time = 0; time < SPEED; time++) {
                    status = time;
                    Thread.sleep(1);
                }
            } catch (InterruptedException ex) {
                //     Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            status = SPEED;
            setPosition();
            InputManager.blockInput = false;
        }

        public static void setPosition() {
            if (InputManager.blockInput != true) {
                return;
            }
            int px = ((int) Math.round(((double) status / SPEED) * 64));
            if (horizontal) {
                GameManager.getInstance().GetPlayer().setXPosition(start + (multiplier * px));
            } else {
                GameManager.getInstance().GetPlayer().setYPosition(start + (multiplier * px));
            }
        }
    }
}
