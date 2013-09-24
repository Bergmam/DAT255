package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.model.Province;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * shows the gameboard, including provinces, cards and buttons.
 * 
 */
public class GameScreen extends AbstractScreen {
	private boolean isWorld;
	private Stage worldStage;
	private List<Stage> cardStage;
	// TODO: IPlayer ??
	private Player[] players;
	Texture bg = Resource.getInstance().backGround;

	public GameScreen(GDXGame game, IGame model) {
		super(game, model);
		// Create four provinceViews, players CardViews and one
		// ChangePhaseButton.

		players = model.getPlayer();
		//players[0].addCard();
		
		isWorld = true;
		
		List<IProvince> a = new ArrayList<IProvince>();
		a.add(new Province("Place"));
		
		worldStage = new WorldStage(
		/* TODO model.getProvinces() */a);
		
		//Creates a cardStage for every player
		cardStage = new ArrayList<Stage>();
		
		for(Player i : players)
		cardStage.add(new CardStage(i.getCards()));
		//this.add(cardStage.get(0));

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0f, 0f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();

		getStage().act(Gdx.graphics.getDeltaTime());
		getStage().draw();
		
	}

	public void changeStage() {
		isWorld = !isWorld;

	}

	private Stage getStage() {
		return (Stage) (isWorld ? worldStage : cardStage);
	}

	@Override
	public void dispose() {
		Gdx.app.log("tag", "here be dispose");
		super.dispose();
		Resource.getInstance().dispose();
		worldStage.dispose();
	//cardStage.get(0).dispose();
		bg.dispose();
	}
}
