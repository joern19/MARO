package Manager;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

	private static InputManager instance = null;
	private static Event event;
	private Frame gframe;
	private InputListener listener;

	public static InputManager getInstance() {

		if (instance == null) {
			instance = new InputManager();
		}

		return instance;
	}

	public void setFrame(Frame frame) {
		gframe = frame;
		gframe.addKeyListener(this);
	}

	public void setInputListener(InputListener inputlistener) {
		listener = inputlistener;
	}

	public InputManager() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			listener.onPlayerMove(Event.MOVE_UP);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			listener.onPlayerMove(Event.MOVE_LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			listener.onPlayerMove(Event.MOVE_RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			listener.onPlayerMove(Event.MOVE_DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_E) {
			listener.onPlayerOpenInventory();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			listener.onPlayerInteract();
		} else if (e.getKeyCode() == KeyEvent.VK_Q) {
			listener.onUseSelectedItem(Event.USE_ITEM);
		} else if (e.getKeyCode() == KeyEvent.VK_T) {
			listener.OnSelectItem(Event.SELECT_ITEM);
		} else if (e.getKeyCode() == KeyEvent.VK_I) {
			listener.onEvent(Event.TRIGGER_INVENTORY);
		} else if (e.getKeyCode() == KeyEvent.VK_1) {
			listener.onEvent(Event.SELECT_ITEM1);
		}else if (e.getKeyCode() == KeyEvent.VK_2) {
			listener.onEvent(Event.SELECT_ITEM2);
		}else if (e.getKeyCode() == KeyEvent.VK_3) {
			listener.onEvent(Event.SELECT_ITEM3);
		}else if (e.getKeyCode() == KeyEvent.VK_4) {
			listener.onEvent(Event.SELECT_ITEM4);
		}else if (e.getKeyCode() == KeyEvent.VK_M) {
			listener.onEvent(Event.OPEN_MENU);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public enum Event {
		MOVE_LEFT, MOVE_RIGHT, MOVE_UP, MOVE_DOWN, OPEN_INVENTORY, INTERACT_WHIT_SOMTHING, SELECT_ITEM, SELECT_ITEM1, SELECT_ITEM2, SELECT_ITEM3, SELECT_ITEM4, TRIGGER_INVENTORY, USE_ITEM, OPEN_MENU;
	}

	public Event getAction() {
		return event;
	}

}
