package Manager;

import Manager.InputManager.Event;

public interface InputListener {
	void onPlayerOpenInventory();
	void onPlayerInteract();
	void onPlayerMove(Event event);
	void OnSelectItem(Event event);
	void onUseSelectedItem(Event event);
	void onEvent(Event event);
}
