package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PopUp extends Dialog {
	private Slider slider;
	private Button confirm;
	private Button cancel;
	private Label label;
	private Label slideMin, slideMax;

	public PopUp(String title) {
		super(title, Resource.getInstance().skin);
		setPosition((Gdx.graphics.getWidth() / 2) - (getWidth() / 2),
				(Gdx.graphics.getHeight() / 2) - (getHeight() / 2));

		fadeDuration = 0f; // want to have fade but it doesn't work for some
							// reason. (0.4f default)
		// checks button names in listener to decide action
		confirm = new Button(Resource.getInstance().skin);
		confirm.add("Ok", "default");
		confirm.setName("confirm");

		cancel = new Button(Resource.getInstance().skin);
		cancel.add("cancel", "default");
		cancel.setName("cancel");

		slider = new Slider(0, 5, 1, false, Resource.getInstance().skin);
		slider.setName("PopUpSlider");

		label = new Label("ewihroiefjo\nefdfsfew", Resource.getInstance().skin);
		label.setTouchable(Touchable.disabled);

		slideMin = new Label("0.0", Resource.getInstance().skin);
		slideMin.setTouchable(Touchable.disabled);

		slideMax = new Label("0.0", Resource.getInstance().skin);
		slideMax.setTouchable(Touchable.disabled);

		Table t = getContentTable();
		t.pad(5);
		t.add(label);
		t.row();
		t.add(slider);
		t.row();
		t.add(slideMin).left();
		t.add(slideMax).left().padLeft(-15);
		button(confirm);
		button(cancel);
	}

	public void setSliderStop(int start, int stop) {
		slider.setRange(start, stop);
		slider.setValue(stop);
		slideMin.setText("" + (int) slider.getMinValue());
		slideMax.setText("" + (int) slider.getMaxValue());

	}

	public void setTexts(String title, String msg) {
		setTitle(title);
		label.setText(msg);
		if(title.equalsIgnoreCase("Occupy")){
			cancel.setVisible(false);
		} else if(!cancel.isVisible()){
			cancel.setVisible(true);
		}
		
		if(title.equalsIgnoreCase("Congratz")){
			slider.setVisible(false);
			cancel.setVisible(false);
			slideMin.setVisible(false);
			slideMax.setVisible(false);
		} 
	}

	public float getValue() {
		return slider.getValue();
	}

}
