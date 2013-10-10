package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class SwitchButton extends Button {

	private static String cards = "Cards";
	private static String map = "Map";
	private Label label;

	private String current;

	public SwitchButton() {
		super(Resource.getInstance().skin);
		current = cards;
		label = new Label(current, Resource.getInstance().skin);
		add(label);
	}

	public String getText() {
		return current;
	}

	public void switchText() {
		label.setText(current = current.equals(cards) ? map : cards);
		label.setPosition(getX()+(label.getWidth()/2)-(label.getTextBounds().width/2), getY()+ getHeight()/3);
	}

}
