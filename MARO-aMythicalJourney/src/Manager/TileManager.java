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

	private static int[][] map;

	public TileManager() {

		tileImages = new HashMap<String, BufferedImage>();
		
		map = new int[][] {
			{0, 0, -1, -1},
			{1, 3, -1, -1},
			{4, 5, -1, -1},
			{6, -1, -1, -1}
		};
		
		currMapPosition = new Point(0, 1);
		map1 = new Tile[][] {

			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE},
			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.STONE, Tile.STONE },
			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.STONE },
			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
			{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY } 
		};
		
		obstacle1 = new Tile[][] {
			{Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE}, 
			{Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.STONE},
			{Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE},
			{Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP},
			{Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,	Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.TREE1},
			{Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
			{Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER}
		};
		

	}

	public boolean changeMap(Movement move) {

		try {
			switch (move) {
			case Down:

				if (currMapPosition.getX() < map.length - 1) {
					if (map[((int) currMapPosition.getX() + 1)][(int) currMapPosition.getY()] != -1) {
						currMapPosition.x += 1;
						loadMap(map[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
						return true;
					}
				}

				break;
			case Up:
				if (currMapPosition.getX() > 0) {
					if (map[((int) currMapPosition.getX() - 1)][(int) currMapPosition.getY()] != -1) {
						currMapPosition.x -= 1;
						loadMap(map[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
						return true;
					}
				}

				break;
			case Right:

				if (currMapPosition.getY() < map.length - 1) {
					if (map[(int) currMapPosition.getX()][(int) (currMapPosition.getY() + 1)] != -1) {
						currMapPosition.y += 1;
						loadMap(map[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
						return true;
					}
				}

				break;
			case Left:
				if (currMapPosition.getY() > 0) {
					if (map[(int) currMapPosition.getX()][(int) (currMapPosition.getY() - 1)] != -1) {
						currMapPosition.y -= 1;
						loadMap(map[(int) currMapPosition.getX()][(int) (currMapPosition.getY())]);
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

		switch (mapId) {

		case 4:

			map1 = new Tile[][] {
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS }, };

			obstacle1 = new Tile[][] {
					{ Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP,Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP },
					{ Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1,Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1 },
					{ Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
					{ Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
					{ Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
					{ Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
					{ Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
					{ Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY }, };

			break;

		case 0:

			map1 = new Tile[][] {

				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				};
			obstacle1 = new Tile[][] {
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP},
				{Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
				};

			break;

		case 1:

			map1 = new Tile[][] {

				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS, Tile.GRASS},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS},
				};
				
			obstacle1 = new Tile[][] {
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP},
				{Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1},
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP},
				{Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.TREE1},
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP},
				{Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1},
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.TREE_TOP, Tile.TREE_TOP},
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.TREE1, Tile.TREE1},
				};

			break;

		case 3:

			map1 = new Tile[][] {

				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
			};

			obstacle1 = new Tile[][] {
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER},
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
				{Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY},
			};

			break;
		case 5:

			map1 = new Tile[][] {

				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				{Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS},
				};
				
			obstacle1 = new Tile[][] {
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.TREE_TOP},
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.TREE1},
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.TREE_TOP, Tile.TREE_TOP},
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1},
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP},
				{Tile.WATER, Tile.WATER, Tile.WATER, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.TREE1},
				{Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP},
				{Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1},
				};
				break;


		case 6:

			map1 = new Tile[][] {
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS }, };

			obstacle1 = new Tile[][] {
					{ Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP },
					{ Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1 },
					{ Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP },
					{ Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1 },
					{ Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP },
					{ Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1 },
					{ Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP,Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP },
					{ Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1,Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1 }, 
					};
			break;
		case 7:

			map1 = new Tile[][] {
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS,Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS }, 
					};

			obstacle1 = new Tile[][] {
					{Tile.TREE_TOP,Tile.TREE_TOP,Tile.TREE_TOP,Tile.TREE_TOP,Tile.IS_EMPTY,Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY,Tile.IS_EMPTY,Tile.TREE_TOP,Tile.TREE_TOP},
					{ Tile.TREE1,Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1 },
				    { Tile.TREE_TOP,Tile.TREE_TOP,Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.TREE_TOP, Tile.TREE_TOP},
					{ Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY,Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE1,Tile.TREE1 },
					{ Tile.TREE_TOP,Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP,Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP,Tile.TREE_TOP,Tile.TREE_TOP},
					{ Tile.TREE1,Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY,Tile.IS_EMPTY,Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1,Tile.TREE1, Tile.TREE1 },
					{ Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP,Tile.TREE_TOP,Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP,Tile.TREE_TOP,Tile.TREE_TOP},
					{ Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1,Tile.TREE1 }, 
					};

			break;

		default:


				map1 = new Tile[][] {
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE},
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.STONE, Tile.STONE },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.STONE },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY },
					{ Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY } 
				};
				
				obstacle1 = new Tile[][] {
					{Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE, Tile.STONE}, 
					{Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE, Tile.STONE},
					{Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.STONE},
					{Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP},
					{Tile.TREE_TOP, Tile.TREE_TOP, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY,	Tile.IS_EMPTY, Tile.TREE1, Tile.TREE1, Tile.TREE1},
					{Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
					{Tile.TREE_TOP, Tile.TREE_TOP, Tile.TREE_TOP, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER},
					{Tile.TREE1, Tile.TREE1, Tile.TREE1, Tile.IS_EMPTY, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER, Tile.WATER}
				};
				break;

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
				case TREE1:
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
		return map[currMapPosition.x][currMapPosition.y];
	}

	public enum Tile {
		GRASS(false, "G", true), STONE(true, "S", false), TREE_TOP(true, "TTOP", false), TREE1(true, "T1",
				false), WATER(false, "W", false), IS_EMPTY(false, "E", true);

		String symbol;
		boolean isObstacal;
		boolean allowWalkOn;

		private Tile(boolean isObstacal, String symbol, boolean allowWalkOn) {
			this.symbol = symbol;
			this.isObstacal = isObstacal;
			this.allowWalkOn = allowWalkOn;
		}

		public boolean isObstacal() {
			return isObstacal;
		}

		public boolean allowWalkOn() {
			return allowWalkOn;
		}

		@Deprecated
		public String getSymbol() {
			return symbol;
		}
	}
}