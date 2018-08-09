package Storage;

import java.io.File;
import java.util.ArrayList;

public class GameSaver {

	private static File file;

	private static GameSaver instance;
	
	private ArrayList<String> rows;
	
	public static GameSaver getInstance() {
	
		if(instance == null) {
			instance = new GameSaver();
		}
		
		return instance;
	}
	
	
	public GameSaver() {
		file = new File("gameStatus.maro");
	}
	
	public void saveGame() {
		
	}
	
}