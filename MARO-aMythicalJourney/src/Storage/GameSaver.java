package Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaver {

	private static GameSaver instance;
	
	public static GameSaver getInstance() {
		if(instance == null) {
			instance = new GameSaver();
		}
		
		return instance;
	}
	
	public GameSaver() {  }
	
	public void saveGame(SaveState state) {
		try (
			FileOutputStream fos = new FileOutputStream ("src/gameStatus.maro");
			ObjectOutputStream oos = new ObjectOutputStream (fos)){
			oos.writeObject (state);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SaveState loadGame() {
		try (
			FileInputStream fis = new FileInputStream ("src/gameStatus.maro");
			ObjectInputStream ois = new ObjectInputStream (fis)){
			final SaveState state = (SaveState) ois.readObject ();
			return state;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}