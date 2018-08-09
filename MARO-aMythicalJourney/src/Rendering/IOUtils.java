package Rendering;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class IOUtils {
	public static String Class = "Images"; //Class, in der das Bild abgespeichert ist
	public static String gStone = "stone.png";//Name Bild
	public static String gGrass = "grass.png";
	public static String gWater = "water.png";
	public static String gTree1 = "tree_0.png";
	public static String gTree2 = "tree_1.png";
	

	
	public static BufferedImage load(String resourcePacakge,String name )  {
		try {
			return ImageIO.read(IOUtils.class.getResourceAsStream("/" + resourcePacakge + "/" + name));
		}
		
		catch (Exception ex) {
			return null;
		}
	}
	
	public static BufferedImage getBufferedImage(String picture){
		return load( Class , picture );
	}
}
