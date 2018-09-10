package Manager;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    public static boolean blockInput = false;
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
        if (blockInput) {
            return;
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                listener.onPlayerMove(Event.MOVE_UP);
                break;
            case KeyEvent.VK_A:
                listener.onPlayerMove(Event.MOVE_LEFT);
                break;
            case KeyEvent.VK_D:
                listener.onPlayerMove(Event.MOVE_RIGHT);
                break;
            case KeyEvent.VK_S:
                listener.onPlayerMove(Event.MOVE_DOWN);
                break;
            case KeyEvent.VK_E:
                listener.onPlayerOpenInventory();
                break;
            case KeyEvent.VK_SPACE:
                listener.onUseSelectedItem(Event.USE_ITEM);
                break;
            case KeyEvent.VK_Q:
                listener.onPlayerInteract();
                break;
            case KeyEvent.VK_T:
                listener.OnSelectItem(Event.SELECT_ITEM);
                break;
            case KeyEvent.VK_I:
                listener.onEvent(Event.TRIGGER_INVENTORY);
                break;
            case KeyEvent.VK_1:
                listener.onEvent(Event.SELECT_ITEM1);
                break;
            case KeyEvent.VK_2:
                listener.onEvent(Event.SELECT_ITEM2);
                break;
            case KeyEvent.VK_3:
                listener.onEvent(Event.SELECT_ITEM3);
                break;
            case KeyEvent.VK_4:
                listener.onEvent(Event.SELECT_ITEM4);
                break;
            case KeyEvent.VK_M:
                listener.onEvent(Event.OPEN_MENU);
                break;
            case KeyEvent.VK_L:
                listener.onEvent(Event.INTERACT_WHIT_SOMTHING);
                break;
            default:
                break;
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
