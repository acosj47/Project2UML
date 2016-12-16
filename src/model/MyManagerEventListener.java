package model;

import java.util.EventListener;

public interface MyManagerEventListener extends EventListener {
	public void okBtnClicked(MyEventObject ev);
}
