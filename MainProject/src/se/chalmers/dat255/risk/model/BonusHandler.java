package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

public class BonusHandler {

	private int bonus, startingTroopNr, currentCardBonus;
	private WorldHandler worldHandler;
	
	public BonusHandler(WorldHandler worldHandler, int numberOfPlayers){
		this.worldHandler = worldHandler;
		bonus = 0;
		startingTroopNr = 50 - numberOfPlayers * 5;
		currentCardBonus = 4;
	}
			
	public void calcBonusesFromCards(ArrayList<String> names, IPlayer activePlayer){
		for(String name : names){
			if(worldHandler.getOwner(name) == activePlayer){
				bonus += 2;
			}
		}
		bonus += currentCardBonus;
		currentCardBonus += 2; // Maybe needs to be changed later, may not be linear.
	}

	public void calcBonusUnits() {
		int provinces = worldHandler.getActivePlayer().getNrOfProvinces();
		if (provinces <= 9) {
			this.bonus = 3;
		} else {
			this.bonus = provinces / 3;
		}
		
		worldHandler.updateBonus();
		this.bonus += worldHandler.getBonus();
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
