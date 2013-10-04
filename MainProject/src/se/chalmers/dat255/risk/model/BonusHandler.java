package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

public class BonusHandler {

	private int bonus, startingTroopNr, currentCardBonus = 4;
	public WorldMap worldMap;
	
	public BonusHandler(WorldMap worldMap){
		this.worldMap = worldMap;
	}
	
	public void calcProvinceBonusesFromCards(ArrayList<String> names){
		
		
		
		//kod
		/* (skr�p fr�n game)
		 * if (card2 != null) { getActivePlayer().exchangeCard((Card) card1,
		 * (Card) card2, (Card) card); // GIVE BONUS // Check if extra bonus
		 * from owned province cards card1 = null; card2 = null; } else { if
		 * (card1 == null) { card1 = card; } else { card2 = card; } }
		 */
		
	}
	
	public void calcStartBonus() {
		// INITIALIZING STARTING NUMBER OF TROOPS
		startingTroopNr = 50 - players.length * 5;

		// /////////////////// ONLY FOR DEV ///////////////////////////
		// bonus = startingTroopNr - getActivePlayer().getNrOfProvinces();
		bonus = 3;
	}
	
	public void calcBonusUnits() {
		int provinces = getActivePlayer().getNrOfProvinces();
		if (provinces <= 9) {
			this.bonus = 3;
		} else {
			this.bonus = provinces / 3;
		}

		this.bonus += worldMap.getBonus(getActivePlayer());

	}
	
	public int getBonus(){
		return bonus;
	}
	
	public void placeBonusUnits(int units, IProvince province) {
		province.addUnits(units);
		bonus = bonus - units;
	}
	
	public void calcBonusForF0(int numberOfProvinces){
		bonus = startingTroopNr - numberOfProvinces;		

	}
}
