package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class ChangePhase extends AbstractView {

	private IGame model;

	// By adding more strings here, you can add more behavior
	// as long as the strings are added in getText as well
	// public static String PHASE1 = "PHASE1";// placing units, show number of
	// units left to place and then
	// "Next Phase"
	// public static String PHASE2 = "PHASE2";// show "Next Phase"
	// public static String PHASE3 = "PHASE3";// show "End Turn"

	// private String current = PHASE1;

	private Label label;

	public ChangePhase(IGame model) {
		super(Resource.getInstance().triangle, Resource.getInstance().triangle);
		this.model = model;
		size(width, height);
		setPosition(Gdx.graphics.getWidth() - getWidth(), 0);
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
		if ((model.getPhase() == se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase.F1)
				|| (model.getPhase() == se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase.FBuild)) {
			if (model.getBonusUnitsLeft() == 0) {
				return "Next";
			}
			return "Units: " + model.getBonusUnitsLeft();
		} else if (model.getPhase() == se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase.F2) {
			return "Next Phase";
		} else if (model.getPhase() == se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase.F3) {
			return "End Turn";
		}
		return "value not found";
	}

	private float getTextX() {
		return getX() + width - label.getWidth();
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
