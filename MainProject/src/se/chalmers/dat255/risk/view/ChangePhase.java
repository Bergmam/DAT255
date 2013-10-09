package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class ChangePhase extends AbstractView {

	private IGame model;
	private Label label;

	public ChangePhase(IGame model) {
		super(Resource.getInstance().circleSelected, Resource.getInstance().circleSelected);
		this.model = model;
		size(width, height);
		label = new Label(getText(), new LabelStyle(font, Color.RED));
		label.setPosition(getTextX(), getTextY());

	}

	/**
	 * changes text output. If param isn't correct the text/behavior of the
	 * class will not be used
	 * 
	 * @param s
	 *            use one of the static strings in this class
	 */
	/**
	 * public void setCurrent(String s) { current = s; label.setText(getText());
	 * }
	 * 
	 * public String getCurrent() { return current; }
	 */

	private String getText() {
		if ((model.getCurrentPhase() == Phase.F1)
				|| (model.getCurrentPhase() == Phase.FBuild)) {
			if (model.getBonusUnitsLeft() == 0) {
				return "Next";
			}
			return "Units: " + model.getBonusUnitsLeft();
		} else if (model.getCurrentPhase() == Phase.F2) {
			return "Next Phase";
		} else if (model.getCurrentPhase() == Phase.F3) {
			return "End Turn";
		}
		return "value not found";
	}

	private float getTextX() {
		return getX() + (width/2) - (label.getTextBounds().width/2);
	}

	private float getTextY() {
		return getY() + getHeight() / 3;
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		batch.setColor(isClicked? Color.DARK_GRAY: Color.BLACK);
		label.setText(getText());
		label.setPosition(getTextX(), getTextY());
		super.draw(batch, alpha);
		label.draw(batch, alpha);
	}

}
