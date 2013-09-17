package se.chalmers.dat255.risk.model;

/**
 * Interface for top class in the game risk
 * 
 * @author Emma Håkansson
 * @since 2013-09-13
 *
 */
public interface GameInterface {
	
	/**
	 * Method for changing the state of the game to 
	 * the next state if it should be changed.
	 */
	public void changePhase();
	
	/**
	 * Method for changing the turn to the next player in turn.
	 */
	public void changeTurn();
	
	
	public Player getActivePlayer();
	
	/**
	 * Method for handeling going in to battle and register the result of the battle.
	 * @param offensiveDice, number of attacking units.
	 * @param offensive, the attacking province. 
	 * @param defensive, the province being attacked.
	 */
	public void attack(int offensiveDice, Province offensiv, Province defensive);
	
	/**
	 * Method for handing a card from the deck to the active player.
	 */
	public void dealCard();
	
	/**
	 * Method for calculating the amount of units
	 * the player will receive at the start of his turn.
	 */
	public void calcBonusUnits();
	
	/**
	 * Method for placing the amount of units the player chooses
	 * the place on the province the player chooses to place them.
	 * @param units, the number of units being placed
	 */
	public void placeBonusUnits(int units, Province province);
	
	/**
	 * Method for retrieving the number of units the player has left to place.
	 * @return The number of units left.
	 */
	public int getBonusUnitsLeft();

}
