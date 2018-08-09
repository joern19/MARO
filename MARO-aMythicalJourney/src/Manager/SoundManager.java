package Manager;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class SoundManager {

	private static SoundManager instance;
	private static HashMap<Sound, AudioInputStream> list;
	
	
	public static SoundManager getInstance() {
	
		if(instance == null) {
			instance = new SoundManager();
		}
	
		return instance;
		
	}
	
	public SoundManager() {
		list = new HashMap<>();
	}
	
	
	private void loadSound(Sound sound) {
		if(!list.containsValue(sound)) {
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound.getPath()));
				list.put(sound, audioInputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
	 
	public void playSound(Sound sound) {
		try {
			AudioFormat af = list.get(sound).getFormat();
			int size = (int) (af.getFrameSize() * list.get(sound).getFrameLength());
			byte[] audio = new byte[size];
			DataLine.Info info = new DataLine.Info(Clip.class, af, size);
			list.get(sound).read(audio, 0, size);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(af, audio, 0, size);
			clip.start();			
		}catch(Exception ex) {
			loadSound(sound);
			playSound(sound);
		} 
	}

	public enum Sound {
		
		TEST("src/Sounds/glassbell.wav"),
		TEST2("src/Sounds/chipquest.wav");
		
		String path;
		
		Sound(String path) {
			this.path = path;
		}
		
		public String getPath(){
			return path;
		}
		
	}
	
}