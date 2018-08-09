import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Image {

	private static HashMap<Integer, ArrayList<Material>> colors = new HashMap<>();
	private static HashMap<Integer, ArrayList<Material>> obstacles = new HashMap<>();
	private static BufferedImage image = null;

	private static final String tree1 = "Tile.TREE_TOP";
	private static final String tree2 = "Tile.TREE1";

	public static void main(String[] args) throws Exception {
		System.out.println("Please enter path");
		Scanner c = new Scanner(System.in);
		//setImage("H:\\Programmieren_3.5\\_Graphics_Screens\\Screen7.png");
		setImage(c.next());
		c.close();
		write();
		writeLists();
	}

	private static void writeLists() {
		System.out.println();
		System.out.println();

		System.out.println("map1 = new Tile[][] {");

		for (Integer i : colors.keySet()) {
			System.out.print("{");
			ArrayList<Material> list = new ArrayList<>();

			int counter = 0;
			for (Material m : colors.get(i)) {
				if (m == Material.DARK_GREEN || m == Material.GRAY) {
					if (counter < 11) {
						System.out.print(Material.GREEN.getOutput() + ", ");
					} else {
						System.out.print(Material.GREEN.getOutput());
					}
					list.add(m);
					m.getOutput();
				} else {
					if (counter < 11) {
						System.out.print(m.getOutput() + ", ");
					} else {
						System.out.print(m.getOutput());
					}
					list.add(null);
				}
				counter++;
			}
			obstacles.put(i, list);
			System.out.print("},");
			System.out.println();
		}
		System.out.println("};");
		System.out.println();

		System.out.println("obstacles = new Tile[][] {");
		for (Integer i : obstacles.keySet()) {
			System.out.print("{");

			int counter = 0;
			for (Material m : colors.get(i)) {
				if (m == null || m == Material.DARK_GREEN || m == Material.GRAY) {
					if (counter < 11) {
						if (m == Material.DARK_GREEN) {
							if (i % 2 == 0) {
								System.out.print(tree1 + ", ");
							} else {
								System.out.print(tree2 + ", ");
							}
						} else {
							System.out.print(m.getOutput() + ", ");
						}
					} else {
						if (m == Material.DARK_GREEN) {
							if (i % 2 == 0) {
								System.out.print(tree1);
							} else {
								System.out.print(tree2);
							}
						} else {
							System.out.print(m.getOutput());
						}
					}
				} else {
					if (counter < 11) {
						System.out.print("Tile.IS_EMPTY, ");
					} else {
						System.out.print("Tile.IS_EMPTY");
					}
				}
				counter++;
			}
			System.out.print("},");
			System.out.println();
		}
		System.out.println("};");

	}

	private static void write() {
		for (int x = 0; x < image.getHeight(); x++) {
			ArrayList<Material> list = new ArrayList<>();
			for (int y = 0; y < image.getWidth(); y++) {
				int rgb = 0;
				try {
					rgb = image.getRGB(y, x);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Y: " + x + " X: " + y);
				}
				Color c = new Color(rgb);
				System.out.print(getImageColor(c).getSymbol());

				list.add(getImageColor(c));
				// colors.add(getImageColor(c));
			}
			colors.put(x, list);
			System.out.println();
		}
	}

	private static void setImage(String path) throws IOException {
		File f = new File(path);
		System.out.println(f.getAbsolutePath());
		image = ImageIO.read(f);
	}

	private static Material getImageColor(Color c) {
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();
		if (red == 56 && green == 72 && blue == 4) {
			return Material.DARK_GREEN;
		} else if (red == 107 && green == 255 && blue == 0) {
			return Material.GREEN;
		} else if (red == 107 && green == 107 && blue == 107) {
			return Material.GRAY;
		} else if (red == 59 && green == 153 && blue == 197) {
			return Material.BLUE;
		}
		return null;
	}

	private enum Material {
		BLUE("Tile.WATER", "W"), GREEN("Tile.GRASS", "G"), DARK_GREEN("Tile.TREE", "T"), GRAY("Tile.STONE", "S");

		String s;
		String symbol;

		Material(String s, String symbol) {
			this.s = s;
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}

		public String getOutput() {
			return s;
		}
	}
}
