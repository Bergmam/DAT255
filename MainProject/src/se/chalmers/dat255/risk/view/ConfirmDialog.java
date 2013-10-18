package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class ConfirmDialog extends Message {

	protected Button cancel;

	public ConfirmDialog(String title) {
		super(title);

		cancel = new Button(Resource.getInstance().skin);
		cancel.add("cancel", "default");
		cancel.setName("cancel");

		button(cancel);

	}

}
