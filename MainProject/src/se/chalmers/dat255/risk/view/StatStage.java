package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.Player;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class StatStage extends AbstractStage {

	private IGame model;
	private Table main, primary, secondary;
	private List<PlayerView> players;

	public StatStage(IGame model) {
		this.model = model;

		players = new ArrayList<PlayerView>();
		
		for(Player p : model.getPlayers()){
			players.add(new PlayerView(p));
		}
		
		main = new Table();
		main.setFillParent(true);
		primary = new Table();
		secondary = new Table();
		
		primary.add();
		
		main.add(primary);
		main.add(secondary);
		
		show();

		main.debug();
		primary.debug();
		secondary.debug();
	}
	
	public void show(){
		
		primary.clear();
		secondary.clear();
		
		for(PlayerView v:players){
			if(v.getPlayer().getId() != model.getActivePlayer().getId()){
				secondary.add(v).row();
			} else {
				primary.add(v).expand().fill();
			}
		}
		
		
		
	}

	@Override
	public InputProcessor getProcessor() {
		return this;
	}

}
