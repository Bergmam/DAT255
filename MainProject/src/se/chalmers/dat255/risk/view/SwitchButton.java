package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class SwitchButton extends AbstractView {

	private static String cards = "Show Cards";
	private static String map = "Show Map";
	private Label label;

	private String current;

	public SwitchButton() {
		super(Resource.getInstance().bucket, Resource.getInstance().bucket);
		current = cards;
		setPosition(0,0);
		size(width, height);
		label = new Label(current, new LabelStyle(font, Color.RED));
		label.setPosition(getX(), getY() + getHeight()/2);
		
	}

	public String getText() {
		return current;
	}

	@Override
	public void check() {
		super.check();
		switchText();
		super.check();
	}

	private void switchText() {
		label.setText(current = current.equals(cards) ? map : cards);
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		super.draw(batch, alpha);
		label.draw(batch, alpha);
	}

}
