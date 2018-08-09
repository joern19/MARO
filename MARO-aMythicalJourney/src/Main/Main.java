package Main;

import Manager.Gameloop;

public class Main {

	public static void main(String[] args) {
		Gameloop run = new Gameloop();
		new Thread(run).start();
	}
}
