package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

public class BonusHandler {

	private int bonus, startingTroopNr, currentCardBonus = 4;
	private WorldMap worldMap;
	
	public BonusHandler(WorldMap worldMap){
		this.worldMap = worldMap;
		bonus = 0;
	}
	
	public void calcBonusesFromCards(ArrayList<String> names, Player activePlayer){
		for(String name : names){
			if(worldMap.getOwner(name) == activePlayer){
				bonus =+ 2;
			}
		}
		bonus =+ currentCardBonus;
		currentCardBonus += 2; // Maybe needs to be changed later, may not be linear.
	}
	
	public void calcStartBonus(int playersLength) {
		// INITIALIZING STARTING NUMBER OF TROOPS
		startingTroopNr = 50 - playersLength * 5;
		
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
