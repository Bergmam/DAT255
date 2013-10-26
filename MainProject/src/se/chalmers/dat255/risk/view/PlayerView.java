package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IPlayer;
import se.chalmers.dat255.risk.view.resource.ColorHandler;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PlayerView extends Table {
	private IPlayer player;
	private Label name, provinces, mission;
	private Table content;
	private boolean main;

	public PlayerView(IPlayer p, String quest) {
		super(Resource.getInstance().skin);
		this.player = p;
		name = new Label("Player: " + p.getName(), Resource.getInstance().skin);
		provinces = new Label("Number of Provinces: " + p.getNrOfProvinces(),
				Resource.getInstance().skin);

		mission = new Label(quest, Resource.getInstance().skin);
		mission.setWrap(true);

		Image i = new Image(Resource.getInstance().border);
		i.setColor(ColorHandler.getInstance().getColor(player.getId()));

		content = new Table();
		content.add(name).fill().row();
		content.add(provinces).fill();
		content.row().fill();
		add(content).expandX().fill();
	}

	public IPlayer getPlayer() {
		return player;
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		name.setText("Player: " + player.getName());
		provinces.setText("Number of Provinces: " + player.getNrOfProvinces());
		batch.setColor(ColorHandler.getInstance().getColor(player.getId()));
		batch.draw(Resource.getInstance().border, getX(), getY(), getWidth(),
				getHeight());
		super.draw(batch, alpha);
	}
	
	public boolean isMain(){
		return main;
	}

	// if view shows current player
	public void setMain(boolean main) {
		this.main = main;
		if (!mission.textEquals("")) {
			if (main) {
				content.add(mission).fill();
			} else {
				content.removeActor(mission);
			}
		}
	}
}
