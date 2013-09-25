package se.chalmers.dat255.risk.model;

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
	
	public static String getStringColor(int i){
		switch (i){
			case 1: return RED;
			case 2: return YELLOW;
			case 3: return GREEN;
			case 4: return BLUE;
			case 5: return BLACK;
			case 6: return ORANGE;
			default: return WHITE;
		}
	}
}
