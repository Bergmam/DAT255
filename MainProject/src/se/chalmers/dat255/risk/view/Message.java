package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Message extends Dialog {

	private Button confirm;
	protected Label label;

	public Message(String title) {
		super(title, Resource.getInstance().skin);
		setPosition((Gdx.graphics.getWidth() / 2) - (getWidth() / 2),
				(Gdx.graphics.getHeight() / 2) - (getHeight() / 2));

		fadeDuration = 0f; // want to have fade but it doesn't work for some
		// reason. (0.4f default)
		
		// checks button names in listener to decide action
		confirm = new Button(Resource.getInstance().skin);
		confirm.add("Ok");
		confirm.setName("confirm");

		label = new Label("", Resource.getInstance().skin);
		label.setTouchable(Touchable.disabled);
		
		text(label);
		
		button(confirm);
	}

	public void setTexts(String title, String msg) {
		setTitle(title);
		label.setText(msg);
	}
	
}
