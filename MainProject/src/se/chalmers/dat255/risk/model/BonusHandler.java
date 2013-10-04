package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

public class BonusHandler {

	private int bonus, startingTroopNr, currentCardBonus = 4;
	private WorldMap worldMap;
	
	public BonusHandler(WorldMap worldMap){
		this.worldMap = worldMap;
		bonus = 0;
	}
	
	public void calcProvinceBonusesFromCards(ArrayList<String> names, Player currentPlayer){
		for(String name : names){
			if(worldMap.getOwner(name) == currentPlayer){
				bonus =+ 2;
			}
		}
	}
		
		
		//kod
		/* (skr�p fr�n game)
		 * if (card2 != null) { getActivePlayer().exchangeCard((Card) card1,
		 * (Card) card2, (Card) card); // GIVE BONUS // Check if extra bonus
		 * from owned province cards card1 = null; card2 = null; } else { if
		 * (card1 == null) { card1 = card; } else { card2 = card; } }
		 */
	public void calcBonusesFromCards(ArrayList<String> names, Player activePlayer){
		for(String name : names){
			if(worldMap.getOwner(name) == activePlayer){
				bonus =+ 2;
			}
		}
		bonus =+ currentCardBonus;
		currentCardBonus += 2; // Maybe needs to be changed later, may not be linear.
	}
	
	public void calcStartBonus(int playersLength, Player activePlayer) {
		// INITIALIZING STARTING NUMBER OF TROOPS
		startingTroopNr = 50 - playersLength * 5 - activePlayer.getNrOfProvinces();
		bonus = 3;
	}
	
	public void calcBonusUnits(Player activePlayer) {
		int provinces = activePlayer.getNrOfProvinces();
		if (provinces <= 9) {
			this.bonus = 3;
		} else {
			this.bonus = provinces / 3;
		}

		this.bonus += worldMap.getBonus(activePlayer);

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
