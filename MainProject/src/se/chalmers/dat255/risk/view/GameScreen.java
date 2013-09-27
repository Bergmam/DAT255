package se.chalmers.dat255.risk.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;

/**
 * shows the gameboard, including provinces, cards and buttons.
 * 
 */
public class GameScreen extends AbstractScreen {
	private boolean isWorld;
	private AbstractStage worldStage;
	private List<AbstractStage> cardStages;
	private UIStage uiStage;
	private InputMultiplexer multi;

	// TODO: IPlayer ??

	public GameScreen(IGame model) {
		super(model);

		isWorld = true;

		worldStage = new WorldStage(model.getGameProvinces(), Gdx.files.internal("Gfx/Cords.txt").file());

		// Creates a cardStage for every player
		cardStages = new ArrayList<AbstractStage>();

		for (Player i : model.getPlayer()) {
			cardStages.add(new CardStage(i.getCards()));
		}
		uiStage = new UIStage(model);

		multi = new InputMultiplexer(uiStage, worldStage.getProcessor());

		Gdx.input.setInputProcessor(multi);
	}

	@Override
	public void show() {

	}

	public List<AbstractView> getViews() {
		List<AbstractView> tmp = new ArrayList<AbstractView>();

		tmp.addAll(worldStage.getViews());
		tmp.addAll(uiStage.getViews());
		for (AbstractStage s : cardStages) {
			tmp.addAll(s.getViews());
		}

		return tmp;
	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0f, 0f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		checkStageChange();
		getStage().draw();
		uiStage.draw();
	}

	private void checkStageChange() {
		if (isWorld != uiStage.renderWorld()) {
			changeStage();
		}
	}

	public void changeStage() {
		multi.removeProcessor(getStage().getProcessor());
		isWorld = !isWorld;
		multi.addProcessor(getStage().getProcessor());

	}

	private AbstractStage getStage() {
		return isWorld ? worldStage : cardStages.get(model.getActivePlayer()
				.getId());
	}

	@Override
	public void dispose() {
		super.dispose();
		Resource.getInstance().dispose();
		worldStage.dispose();
		uiStage.dispose();
		int i = 0;
		for (AbstractStage s : cardStages) {
			s.dispose();
		}
	}
}
