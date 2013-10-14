package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;

/**
 * Interface for top class in the game risk
 * 
 * @since 2013-09-13
 * 
 */
public interface IGame {
	// ============== EVENT-CONSTANTS ==============
	public final static String MOVEMENT = "Movement";
	public final static String ATTACK = "Attack";
	public final static String CONQUER = "takeOver";
	public final static String AGAIN = "Again?";
	public final static String WIN = "Win";
	public final static String SURRENDER = "Surrender";
	public final static String UNITS = "Units";
	public final static String CARDS = "Cards";

	// =============================================

	/**
	 * Sets up a new Game
	 * 
	 * @param playersId
	 *            id's of all players
	 * @param neighboursFile
	 *            relations between provinces
	 * @param continentsFile
	 *            continents and their provinces
	 */
	public void setupGame(String[] playersId, String neighboursFile,
			String continentsFile);

	/**
	 * Fetches the player who has the current turn.
	 * 
	 * @return the active player
	 */
	public Player getActivePlayer();

	/**
	 * Tells the game to do battle with two provinces
	 * 
	 * @param nbrOfDice
	 *            the number of dice to attack with
	 */
	public void battle(int nbrOfDice);

	/**
	 * Method for retrieving the number of units the player has left to place.
	 * 
	 * @return The number of units left.
	 */
	public int getBonusUnitsLeft();

	/**
	 * Fetches the phase the game is in
	 * 
	 * @return the current Phase
	 */
	public Phase getCurrentPhase();

	/**
	 * Fetches all players
	 * 
	 * @return an array with all players
	 */
	public ArrayList<Player> getPlayers();

	/**
	 * Retrieves all provinces
	 * 
	 * @return an arrayList with all provinces in the game
	 */
	public ArrayList<IProvince> getGameProvinces();

	/**
	 * Determines what should be done with the chosen province
	 * 
	 * @param province
	 *            province to be handled
	 */
	public void handleProvinceEvent(IProvince province);

	/**
	 * Determines what should be done with the chosen card
	 * 
	 * @param province
	 *            card to be handled
	 */
	public void handleCardEvent(ICard province);

	/**
	 * Determines if the game should change phase
	 */
	public void handlePhaseEvent();

	/**
	 * Method for finding the owner of an province
	 * 
	 * @param provinceName
	 *            the name of the province
	 * @return the turnId of the owner
	 */
	public int getOwner(String provinceName);

	/**
	 * Adds a listener to receive events
	 * 
	 * @param listener
	 *            listener for events
	 */
	public void addListener(PropertyChangeListener listener);

	/**
	 * Moves the requested number of units from one active province to another
	 * 
	 * @param nrOfUnits
	 *            number of units to be moved
	 */
	public void moveToProvince(int nrOfUnits);

	/**
	 * Adds Listeners to the players, to listen for cards
	 * 
	 * @param list
	 *            a list with listerners to the players
	 */
	public void addPlayerListener(List<PropertyChangeListener> list);

	/**
	 * Called when the current player gives up
	 * 
	 * @param confirm
	 *            true if player has already confirmed their surrender, false
	 *            otherwise
	 */
	public void surrender(boolean confirm);

	/**
	 * Inactivates any saved provinces
	 */
	public void flushProvinces();
	
	public static enum GameMode {
		WORLD_DOMINATION, SECRET_MISSION;
	}
}
