package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import se.chalmers.dat255.risk.controller.PopUpListener;
import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.ColorHandler;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class UIStage extends AbstractStage {

	private ChangePhase phase;
	private SwitchButton switchButton;
	private boolean renderWorld;
	private Label label;
	private IGame model;
	private ColorHandler color;
	private PopUp pop;

	public UIStage(IGame model) {
		this.model = model;
		model.addListener(this);
		phase = new ChangePhase(model);
		actor.add(phase);

		switchButton = new SwitchButton();
		actor.add(switchButton);

		addActor(phase);
		addActor(switchButton);

		renderWorld = true;

		color = ColorHandler.getInstance();

		label = new Label(model.getActivePlayer().getName() + "	\nPhase: "
				+ model.getCurrentPhase(), Resource.getInstance().skin,
				"default-font", color.getColor(0));
		label.setFontScale(label.getFontScaleX() * 1.8f);
		label.setPosition(Gdx.graphics.getWidth() / 2 - label.getWidth(),
				Gdx.graphics.getHeight() - label.getHeight() - 10);

		addActor(label);

		pop = new PopUp("Attack");
		// addActor(pop);// the show() method doesn't seem to work for some
		// reason

	}

	public PopUp getPopUp() {
		return pop;
	}

	public void showPopUp(String[] strings, int value) {
		pop.setSliderStop(value);
		pop.setTexts(strings[0], strings[1]);
		addActor(pop);
	}

	public boolean renderWorld() {
		return renderWorld;
	}

	public void switchRender() {
		renderWorld = !renderWorld;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO mainly for PopUp

	}

	@Override
	public InputProcessor getProcessor() {
		return this;
	}

	@Override
	public void draw() {
		label.setText(model.getActivePlayer().getName() + "	\nPhase: "
				+ model.getCurrentPhase());
		label.setColor(color.getColor(model.getActivePlayer().getId()));
		super.draw();
	}

}
