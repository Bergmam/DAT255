package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class SwitchButton extends Button {

	private static final String CARDS = "Cards";
	private static final String MAP = "Map";
	private Label label;

	private String current;

	public SwitchButton() {
		super(Resource.getInstance().skin);
		current = CARDS;
		label = new Label(current, Resource.getInstance().skin);
		add(label);
	}

	public String getText() {
		return current;
	}

	public void switchText() {
		label.setText(current = current.equals(CARDS) ? MAP : CARDS);
	}

}
