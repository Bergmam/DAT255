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
	
	public Color getProvinceColor(String provinceName){
		return getColor(game.getOwner(provinceName));
	}
	
	public Color getColor(int i){
		switch (i){
			case 0: return Color.CYAN;
			case 1: return Color.GRAY;
			case 2: return Color.GREEN;
			case 3: return Color.BLUE;
			case 4: return Color.BLACK;
			case 5: return Color.ORANGE;
			default: return Color.WHITE;
		}
	}
}
