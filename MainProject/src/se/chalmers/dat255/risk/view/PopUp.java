package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PopUp extends Dialog {
	private Slider slider;
	private Button confirm;
	private Button cancel;
	private Label label;

	public PopUp(String title) {
		super(title, Resource.getInstance().skin);
		setPosition((Gdx.graphics.getWidth() / 2) - (getWidth() / 2),
				(Gdx.graphics.getHeight() / 2) - (getHeight() / 2));

		fadeDuration = 0f;	// want to have fade but it doesn't work for some
							// reason. (0.4f default)

		//checks button names in listener to decide action
		confirm = new Button(Resource.getInstance().skin);
		confirm.add("Ok", "default");
		confirm.setName("confirm");

		cancel = new Button(Resource.getInstance().skin);
		cancel.add("cancel", "default");
		cancel.setName("cancel");

		slider = new Slider(0, 5, 1, false, Resource.getInstance().skin);
		slider.setName("PopUpSlider");
		slider.setPosition(5, getHeight() / 3);

		label = new Label("", Resource.getInstance().skin);
		label.setPosition(5, (2 * getHeight()) / 3);

		addActor(label);
		addActor(slider);

		button(confirm);
		button(cancel);

	}

	public void setSliderStop(int stop) {
		slider.setRange(1, stop);
		slider.setValue(1);
	}

	public void setTexts(String title, String msg) {
		setTitle(title);
		label.setText(msg);
		
	}

	public void setListener(ClickListener listener) {
		confirm.addListener(listener);
		cancel.addListener(listener);

	}

	public float getValue() {
		return slider.getValue();
	}

}
