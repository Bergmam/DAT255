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
		super(Resource.getInstance().circleSelected, Resource.getInstance().circleSelected);
		current = cards;
		size(width, height);
		label = new Label(current, new LabelStyle(font, Color.RED));
		label.setPosition(getTextX(), getTextY());
		// scale = 1.3f*width;
	}

	public String getText() {
		return current;
	}
	
	private float getTextX() {
		return getX() + (width/2) - (label.getTextBounds().width/2);
	}

	private float getTextY() {
		return getY() + getHeight() / 3;
	}

	public void switchText() {
		label.setText(current = current.equals(cards) ? map : cards);
		label.setPosition(getX()+(label.getWidth()/2)-(label.getTextBounds().width/2), getY()+ getHeight()/3);
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		label.setPosition(getTextX(), getTextY());
		batch.setColor(isClicked ? Color.DARK_GRAY : Color.BLACK);
		super.draw(batch, alpha);
		label.draw(batch, alpha);
	}

}
