package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ChangePhase extends Button {

	private IGame model;
	private Label label;

	public ChangePhase(IGame model) {
		super(Resource.getInstance().skin);
		this.model = model;
		label = new Label("Next Phase", Resource.getInstance().skin);
		add(label);

	}

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

	public float getBoundWidth() {
		return label.getTextBounds().width;
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		label.setText(getText());
		super.draw(batch, alpha);
	}

}
