package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class SwitchButton extends AbstractView {

	private static String cards = "Cards";
	private static String map = "Map";
	private Label label;

	private String current;

	public SwitchButton() {
		super(Resource.getInstance().triangle, Resource.getInstance().triangle);
		current = cards;
		setPosition(0,0);
		size(width, height);
		label = new Label(current, new LabelStyle(font, Color.RED));
		label.setPosition(getX()+label.getWidth()/4, getY() + getHeight()/3);
		//scale = 1.3f*width;
	}

	public String getText() {
		return current;
	}

	public void switchText() {
		label.setText(current = current.equals(cards) ? map : cards);
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		batch.setColor(isClicked? Color.DARK_GRAY: Color.BLACK);
		super.draw(batch, alpha);
		label.draw(batch, alpha);
	}

}
