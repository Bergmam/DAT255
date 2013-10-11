package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PopUp extends ConfirmDialog {
	private Slider slider;
	
	private Label slideMin, slideMax;

	public PopUp(String title) {
		super(title);

		slider = new Slider(0, 5, 1, false, Resource.getInstance().skin);
		slider.setName("PopUpSlider");

		slideMin = new Label("0.0", Resource.getInstance().skin);
		slideMin.setTouchable(Touchable.disabled);

		slideMax = new Label("0.0", Resource.getInstance().skin);
		slideMax.setTouchable(Touchable.disabled);

		Table t = getContentTable();
		
		t.row();
		t.add(slider);
		t.row();
		t.add(slideMin).left();
		t.add(slideMax).left().padLeft(-15);
	}

	public void setSliderStop(int start, int stop) {
		slider.setRange(start, stop);
		slider.setValue(stop);
		slideMin.setText("" + (int) slider.getMinValue());
		slideMax.setText("" + (int) slider.getMaxValue());
	}

	@Override
	public void setTexts(String title, String msg) {
		setTitle(title);
		label.setText(msg);
		if(title.equalsIgnoreCase("Occupy")){
			cancel.setVisible(false);
		} else if(!cancel.isVisible()){
			cancel.setVisible(true);
		}
	}

	public float getValue() {
		return slider.getValue();
	}

}
