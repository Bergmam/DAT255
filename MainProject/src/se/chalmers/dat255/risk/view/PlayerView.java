package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PlayerView extends Table {
	private Player player;
	private Label name, provinces, units;

	public PlayerView(Player p) {
		super(Resource.getInstance().skin);
		this.player = p;
		name = new Label("Player: " + p.getName(), Resource.getInstance().skin);
		provinces = new Label("Number of Provinces: " + p.getNrOfProvinces(),
				Resource.getInstance().skin);
		units = new Label("", Resource.getInstance().skin);
		add(name).expandX().fill().row();
		add("Number of Provinces: " + p.getNrOfProvinces()).expandX().fill()
				.row();

	}

	public Player getPlayer() {
		return player;
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha) {
		name.setText("Player: " + player.getName());
		provinces.setText("Number of Provinces: " + player.getNrOfProvinces());
		super.draw(batch, alpha);
	}
}
