package Storage;

import java.io.Serializable;

import Manager.GameManager;

public class SaveState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3255475302695354376L;
	
	private static final Float heath = GameManager.getInstance().GetPlayer().GetHealth();
	private static final String PlayerName = GameManager.getInstance().GetPlayer().GetName();
	private static final Integer x =GameManager.getInstance().GetPlayer().GetXPosition();
	private static final Integer y = GameManager.getInstance().GetPlayer().GetYPosition();

	

}
