package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.resource.ColorHandler;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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

	}

	public PopUp getPopUp() {
		return pop;
	}

	public void showPopUp(String title, String msg, int value, int minValue) {
		pop.setSliderStop(minValue, value);
		pop.setTexts(title, msg);
		pop.show(this);
	}

	public boolean renderWorld() {
		return renderWorld;
	}

	public void switchRender() {
		renderWorld = !renderWorld;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO mainly for PopUp
		if (event.getPropertyName().equalsIgnoreCase("Attack")) {

			showPopUp("Attack", "How many dice \ndo you want?",
					(Integer) event.getOldValue(), 1);
		} else if (event.getPropertyName().equalsIgnoreCase("Movement")) {
			showPopUp("Movement", "How many units do \nyou want to move?",
					(Integer) event.getOldValue() - 1, 1);
		} else if (event.getPropertyName().equalsIgnoreCase("Again?")) {
			showPopUp("Again?", "Do you want \nto attack again?",
					(Integer) event.getOldValue(), 1);
		} else if (event.getPropertyName().equalsIgnoreCase("takeOver")) {
			showPopUp("Movement", "How many units do \nyou want to move?",
					(Integer) event.getOldValue() - 1,
					Integer.parseInt((String)event.getNewValue()));
		}

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
