package Manager;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Objects.Player.Movement;
import Rendering.GameImage;
import Rendering.IOUtils;

public class TileManager {

    public static String gStone = "stone.png";// Name Bild
    public static String gGrass = "grass.png";
    public static String gWater = "water.png";
    public static String gTree1 = "tree_0.png";
    public static String gTree2 = "tree_1.png";
    private static Tile[][] map1;
    private static Tile[][] obstacle1;
    private static Integer MapID = 1;
    private HashMap<String, BufferedImage> tileImages;
    private Point currMapPosition;

    //private static int[][] map;
    private static int[][] mapMap;

    public TileManager() {

        tileImages = new HashMap<String, BufferedImage>();

        mapMap = new int[][]{
            {0, 1, -1, -1},
            {2, 3, -1, -1},
            {4, 5, -1, -1},
            {6, -1, -1, -1}
        };

        currMapPosition = new Point(0, 1);
        map1 = new Tile[][]{
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
            {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

        obstacle1 = new Tile[][]{
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
            {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
    }

    public boolean changeMap(Movement move) {
        try {
            switch (move) {
                case Down:
                    if (mapMap[((int) currMapPosition.getX() + 1)][(int) currMapPosition.getY()] != -1) {
                        currMapPosition.x += 1;
                        loadMap(mapMap[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
                        return true;
                    }
                    break;
                case Up:
                    if (currMapPosition.getX() > 0) {
                        if (mapMap[((int) currMapPosition.getX() - 1)][(int) currMapPosition.getY()] != -1) {
                            currMapPosition.x -= 1;
                            loadMap(mapMap[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
                            return true;
                        }
                    }
                    break;
                case Right:
                    if (currMapPosition.getY() < mapMap.length - 1) {
                        if (mapMap[(int) currMapPosition.getX()][(int) (currMapPosition.getY() + 1)] != -1) {
                            currMapPosition.y += 1;
                            loadMap(mapMap[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
                            return true;
                        }
                    }
                    break;
                case Left:
                    if (currMapPosition.getY() > 0) {
                        if (mapMap[(int) currMapPosition.getX()][(int) (currMapPosition.getY() - 1)] != -1) {
                            currMapPosition.y -= 1;
                            loadMap(mapMap[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
                            return true;
                        }
                    }
                    break;
                default:
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public void loadMap(Integer mapId) {
    	GameManager.getInstance().clearNpc();
    	GameManager.getInstance().spawnNpc();
    	GameManager.getInstance().spawnNpc();
        switch (mapId) {
            case 0:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
                break;
            case 1:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
                break;
            case 2:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
                break;
            case 3:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
                break;
            case 4:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
                break;
            case 5:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
                break;
            case 6:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
                break;
            default:
                map1 = new Tile[][]{
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
                    {Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},};

                obstacle1 = new Tile[][]{
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
                    {Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},};
        }
    }

    public static Tile[][] getObstacles() {
        return obstacle1;
    }

    public static Tile[][] getMap() {
        return map1;
    }

    public List<GameImage> getMapToRender() {
        return convertToImage(getMap());
    }

    public Tile getTileFromMap(int y, int x) {
        return map1[y][x];
    }

    public void RemoveObstacle(int indexOne, int indexTwo) {
        obstacle1[indexOne][indexTwo] = Tile.IS_EMPTY;
    }

    public static Integer getMapID() {
        return MapID;
    }

    public Tile getObstacalFromMap1(int y, int x) {
        return obstacle1[y][x];
    }

    public List<GameImage> convertToImage(Tile[][] name) {
        List<GameImage> list = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                String picture = "";
                switch (name[i][j]) {
                    case GRASS:
                        picture = gGrass;
                        break;
                    case STONE:
                        picture = gStone;
                        break;
                    case WATER:
                        picture = gWater;
                        break;
                    case TREE_TOP:
                        picture = gTree1;
                        break;
                    case TREE_BUTTOM:
                        picture = gTree2;
                        break;
                    default:
                        break;
                }
                if (!picture.isEmpty()) {
                    try {

                        if (tileImages.containsKey(picture)) {
                            list.add(new GameImage(tileImages.get(picture), j * 64, i * 64));
                        } else {
                            BufferedImage img = IOUtils.load("Images", picture);
                            tileImages.put(picture, img);
                            list.add(new GameImage(tileImages.get(picture), j * 64, i * 64));
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }
        return list;
    }

    public int getCurrMapID() {
        return mapMap[currMapPosition.x][currMapPosition.y];
    }

    public enum Tile {
        GRASS(false, true), STONE(true, false), TREE_TOP(true, false), TREE_BUTTOM(true,
                false), WATER(false, false), IS_EMPTY(false, true);

        boolean isObstacal;
        boolean allowWalkOn;

        private Tile(boolean isObstacal, boolean allowWalkOn) {
            this.isObstacal = isObstacal;
            this.allowWalkOn = allowWalkOn;
        }

        public boolean isObstacal() {
            return isObstacal;
        }

        public boolean allowWalkOn() {
            return allowWalkOn;
        }
    }
}
