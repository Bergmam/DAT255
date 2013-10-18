package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.view.Message;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MessageListener extends ClickListener {

	@Override
	public void clicked(InputEvent event, float x, float y) {

		Message msg = (Message) event.getListenerActor();
		String title = msg.getTitle();
		if (title.equalsIgnoreCase("Congratz")) {
			ScreenManager.getInstance().gameOver();
		}
	}
}
