package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.view.resource.ColorHandler;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

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
		
		Image i = new Image(Resource.getInstance().border);
		i.setColor(ColorHandler.getInstance().getColor(player.getId()));

		Table tmp = new Table();
		tmp.add(name).fill().row();
		tmp.add(provinces).fill();
	
		add(tmp).expandX().fill();
	}

	public Player getPlayer() {
		return player;
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		name.setText("Player: " + player.getName());
		provinces.setText("Number of Provinces: " + player.getNrOfProvinces());
	batch.setColor(ColorHandler.getInstance().getColor(player.getId()));
		batch.draw(Resource.getInstance().border, getX(), getY(), getWidth(), getHeight());
		super.draw(batch, alpha);
	}
}
