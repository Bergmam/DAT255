package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Game;
import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChangePhase extends AbstractView {

	private IGame model;
	public static String PHASE1 = "PHASE1";// placing units, show number of
											// units left to place and then
											// "Next Phase"
	public static String PHASE2 = "PHASE2";// show "Next Phase"
	public static String PHASE3 = "PHASE3";// show "End Turn"
	public static String NEXT = "NEXT";// "Next Phase"

	private	String current;

	public ChangePhase(IGame model) {
		super(Resource.getInstance().bucket, Resource.getInstance().bucket);
		this.model = model;
		size(64, 64);
	}

	public void setStyle() {

	}

	public void setCurrent(String s) {
		current = s;
	}

	private String getString() {

		return null;

	}

	private String getText() {
		if (current == PHASE1) {
			return "" + model.getBonusUnitsLeft();
		} else if (current == PHASE2) {
			return "Next Phase";
		} else if (current == PHASE3) {
			return "End Turn";
		} else if (current == NEXT) {

		}

		return "value not found";
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		super.draw(batch, alpha);

		font.draw(batch, "" + getText(), getX(), getY());
	}

}
