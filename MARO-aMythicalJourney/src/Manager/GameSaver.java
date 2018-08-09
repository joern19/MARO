package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Objects.Item;

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
		rows = new ArrayList<>();
	}
	
	public void load() throws IOException {
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		do {
			
			rows.add(br.readLine());
			
		} while (br.ready());
		
		br.close();
	}
	
	public void addItem(String username, Item item) throws IOException {
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		bw.append(username + ":" + item);
		
		bw.close();
		
	}
	
	public loadItem(String username) {
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		if(br.ready()) {
			
		}
		
	}
	
	public String[] getPlayedPlayers() {
		String[] s;
		
		
		
		
		return s;
	}
	
}