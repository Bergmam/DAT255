package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PopUp extends Window {
	private Slider slider;

	public PopUp(String title) {
		super(title, Resource.getInstance().skin);
		setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		setModal(true);
		slider = new Slider(0, 5, 1, false, Resource.getInstance().skin);
		add("Choose how many \n to attack with", "default");
		addActor(slider);
		setSize(slider.getWidth(), getHeight());
	}

	public void setSliderStop(int stop) {
		slider.setRange(0, stop);
	}

}
