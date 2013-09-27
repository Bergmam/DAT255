package se.chalmers.dat255.risk.view.resource;

import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.graphics.Color;

public class ColorHandler {
	private static ColorHandler instance;
	private IGame game;
	
	private ColorHandler(){
		
	}
	
	public static ColorHandler getInstance(){
		if(instance == null){
			instance = new ColorHandler(); 
		}
		return instance;
		
	}
	
	public void instantiate(IGame game){
		this.game = game;
	}
	
	public Color getColor(String provinceName){
		return PlayerColor.getColor(game.getOwner(provinceName));
	}
}
