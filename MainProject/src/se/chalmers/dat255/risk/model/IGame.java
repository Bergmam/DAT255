package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;

/**
 * Interface for top class in the game risk
 * 
 * @since 2013-09-13
 * 
 */
public interface IGame {

	/**
	 * Sets up a new game
	 * 
	 * @param nrOfPlayers field with all player names
	 * @throws IllegalArgumentException if nbrOfPlayers is smaller than 2 or larger than 6
	 */
	public void newGame(String[] nrOfPlayers) throws IllegalArgumentException;

	
	/**
	 * Fetches the player who has the current turn.
	 * 
	 * @return the active player
	 */
	public Player getActivePlayer();

	/**
	 * Method for handling going in to battle and register the result of the
	 * battle.
	 * 
	 * @param offensiveDice
	 *            number of attacking units.
	 * @param offensive
	 *            the attacking province.
	 * @param defensive
	 *            the province being attacked.
	 */
	public boolean attack(int offensiveDice, IProvince offensive,
			IProvince defensive);

	/**
	 * Method for handing a card from the deck to the active player.
	 */
	public void dealCard();

	/**
	 * Method for calculating the amount of units the player will receive at the
	 * start of his turn.
	 */
	public void calcBonusUnits();

	/**
	 * Method for retrieving the number of units the player has left to place.
	 * 
	 * @return The number of units left.
	 */
	public int getBonusUnitsLeft();

	/**
	 * Method for moving a number of units from one province to another.
	 * 
	 * @param nbrOfUnits
	 *            The number of units to move
	 * @param from
	 *            Province to move units from
	 * @param goTo
	 *            Province to move units to
	 */
	
	/**
	 * Fetches the phase the game is in
	 * 
	 * @return the current Phase
	 */
	public Phase getCurrentPhase();
		
	/**
	 * Fetches all players
	 * @return an array with all players
	 */
	public Player[] getPlayers();
	
	/**
	 * Retrieves all provinces
	 * @return an arrayList with all provinces in the game
	 */
	public ArrayList<IProvince> getGameProvinces();
	
	/**
	 * Determines what should be done with the chosen province
	 * 
	 * @param province province to be handled
	 */
	public void handleProvinceClick(IProvince province);

	/**
	 * Determines what should be done with the chosen card
	 * 
	 * @param province card to be handled
	 */
	public void handleCardClick(ICard province);
	
	/**
	 * Determines if the game should change phase
	 */
	public void handlePhaseClick();
	
	/**
	 * Method for finding the owner of an province 
	 * @param provinceName the name of the province
	 * @return the turnId of the owner
	 */
	public int getOwner(String provinceName);
	
	/**
	 * Adds a listener to receive events
	 * 
	 * @param listener listener for events
	 */
	public void addListener(PropertyChangeListener listener);
}
