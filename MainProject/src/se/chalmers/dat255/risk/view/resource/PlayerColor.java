package se.chalmers.dat255.risk.view.resource;

import com.badlogic.gdx.graphics.Color;

public class PlayerColor {

	static PlayerColor instance;
	
// ============= ENUM FOR COLOR ================
	public static final String WHITE = null;
	public static final String RED = "RED";
	public static final String YELLOW = "YELLOW";
	public static final String GREEN = "GREEN";
	public static final String BLUE = "BLUE";
	public static final String BLACK = "BLACK";
	public static final String ORANGE = "ORANGE";
// =============================================

	public static PlayerColor getInstance() {
		if (instance == null) {
			instance = new PlayerColor();
		}
		return instance;
	}
	
	public static Color getColor(int i){
		switch (i){
			case 0: return Color.RED;
			case 1: return Color.YELLOW;
			case 2: return Color.GREEN;
			case 3: return Color.BLUE;
			case 4: return Color.BLACK;
			case 5: return Color.ORANGE;
			default: return Color.WHITE;
		}
	}
}
