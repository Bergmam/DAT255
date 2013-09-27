package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.resource.ColorHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class UIStage extends AbstractStage {

	private ChangePhase phase;
	private SwitchButton switchButton;
	private boolean renderWorld;
	private Label label;
	private IGame model;
	private ColorHandler color;

	public UIStage(IGame model) {
		this.model = model;
		phase = new ChangePhase(model);
		actor.add(phase);

		switchButton = new SwitchButton();
		actor.add(switchButton);

		addActor(phase);
		addActor(switchButton);

		renderWorld = true;

		color = ColorHandler.getInstance();
		
		label = new Label(model.getActivePlayer().getName() + "	\nPhase: "
				+ model.getCurrentPhase(), new LabelStyle(new BitmapFont(),
				color.getColor(0)));
		label.setFontScale(label.getFontScaleX() * 2);
		label.setPosition(Gdx.graphics.getWidth() / 2 - label.getWidth(),
				Gdx.graphics.getHeight() - label.getHeight()-10);

		addActor(label);
	}

	public boolean renderWorld() {
		return renderWorld;
	}

	public void switchRender() {
		renderWorld = !renderWorld;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub

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
