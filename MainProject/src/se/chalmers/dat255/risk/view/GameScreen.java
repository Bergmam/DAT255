package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.view.UIStage.Render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameScreen extends AbstractScreen {
	private Render render;
	private AbstractStage worldStage, stats, cards;
	private UIStage uiStage;
	private InputMultiplexer multi;
	private boolean created;

	public GameScreen(IGame model) {
		super(model);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(multi);
	}

	public List<Actor> getSpecActors() {
		return uiStage.getOthers();
	}

	public List<AbstractView> getViews() {
		List<AbstractView> tmp = new ArrayList<AbstractView>();
		tmp.addAll(worldStage.getViews());
		tmp.addAll(uiStage.getViews());
		tmp.addAll(cards.getViews());

		return tmp;
	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 0.7f);// Background color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		checkStageChange();
		getStage().draw();
		uiStage.act();
		uiStage.draw();
	}

	private void checkStageChange() {
		if (render != uiStage.getRender()) {
			changeStage();
		}
	}

	public void changeStage() {
		multi.removeProcessor(getStage().getProcessor());
		render = uiStage.getRender();
		multi.addProcessor(getStage().getProcessor());

	}

	private AbstractStage getStage() {

		switch (render) {
		case Map:
			return worldStage;
		case Card:
			return cards;
		case Stat:
			return stats;
		default:
			return worldStage;
		}

	}

	public void setupGame() {
		worldStage = new WorldStage(model);

		cards = new CardStage(model);

		uiStage = new UIStage(model);

		stats = new StatStage(model);

		multi = new InputMultiplexer(uiStage.getProcessor(),
				worldStage.getProcessor());
		created = true;
		render = uiStage.getRender();

	}

	@Override
	public void dispose() {
		if (created) {
			worldStage.dispose();
			uiStage.dispose();
			cards.dispose();
		}
	}
}
