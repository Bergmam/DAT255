package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PlayerView extends Table {
	Player p;

	public PlayerView(Player p) {
		super(Resource.getInstance().skin);
		this.p = p;
		add("Player: " + p.getName()).expandX().fill().row();
		add("Number of Provinces: " +p.getNrOfProvinces()).expandX().fill().row();
		
		
		
		
	}
	
	public Player getPlayer(){
		return p;
	}
}
