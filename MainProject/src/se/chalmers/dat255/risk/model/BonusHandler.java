package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

/**
 * Calculates how many units a player should receive every turn and the bonus
 * when trading in cards
 */
public class BonusHandler {

	private int bonus, startingTroopNr, currentCardBonus;
	private WorldMap worldMap;

	public BonusHandler(WorldMap worldMap, int numberOfPlayers) {
		this.worldMap = worldMap;
		bonus = 0;
		startingTroopNr = 50 - numberOfPlayers * 5;
		currentCardBonus = 4;
	}

	/**
	 * Calculates how large the bonus from trading in cards is.
	 * 
	 * @param names
	 *            the provinces connected to the exchanged cards
	 * @param activePlayer
	 *            the player to receive the bonus
	 */
	public void calcBonusesFromCards(ArrayList<String> names,
			IPlayer activePlayer) {
		for (String name : names) {
			if (worldMap.getOwner(name) == activePlayer) {
				bonus += 2;
			}
		}
		bonus += currentCardBonus;
		currentCardBonus += 2; // Maybe needs to be changed later, may not be
								// linear.
	}

	/**
	 * Calculates how many units a player will receive at the start of the turn
	 * 
	 * @param active
	 *            the active player
	 */
	public void calcBonusUnits(IPlayer active) {
		int provinces = active.getNrOfProvinces();
		if (provinces <= 9) {
			this.bonus = 3;
		} else {
			this.bonus = provinces / 3;
		}

		worldMap.updateBonus();
		this.bonus += worldMap.getBonus(active);
	}

	/**
	 * Returns the number of bonus units the current player has.
	 * 
	 * @return number of bonus units
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * Place units from a players bonus on a province
	 * 
	 * @param units
	 *            number of units to place
	 * @param province
	 *            the province to receive the units
	 */
	public void placeBonusUnits(int units, IProvince province) {
		province.addUnits(units);
		bonus = bonus - units;
	}

	/**
	 * Calculates special bonus at the start of the game
	 * 
	 * @param numberOfProvinces
	 *            number of provinces for the current player
	 */
	public void calcBonusForF0(int numberOfProvinces) {
		bonus = startingTroopNr - numberOfProvinces;
	}
}
