package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Player;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PlayerView extends Table {
	Player p;

	public PlayerView(Player p) {
		this.p = p;
	}
	
	public Player getPlayer(){
		return p;
	}
}
