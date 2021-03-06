package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeListener;
import java.util.List;

import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;

/**
 * Interface for top class in the game risk
 * 
 */
public interface IGame {
	// ============== EVENT-CONSTANTS ================================
	public final static String MOVEMENT = "Movement", ATTACK = "Attack",
			CONQUER = "Occupy", AGAIN = "Again?", WIN = "Congratz",
			SURRENDER = "Surrender", UNITS = "Units", CARDS = "Cards",
			CHANGE_TURN = "ChangeTurn";

	// ===============================================================

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
	public void setupGame(List<String> playersId, String neighboursFile,
			String continentsFile, String missionFile);

	/**
	 * Fetches the player who has the current turn.
	 * 
	 * @return the active player
	 */
	public IPlayer getActivePlayer();

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
	public List<IPlayer> getPlayers();

	/**
	 * Retrieves all provinces
	 * 
	 * @return an arrayList with all provinces in the game
	 */
	public List<IProvince> getGameProvinces();

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

	/**
	 * Sets the game type. changes rules.
	 * 
	 * @param gameMode
	 *            what type of winning condition the game will have
	 */
	public void setGameMode(GameMode gameMode);

	/**
	 * retrieves current gameMode
	 * 
	 * @return current gameMode
	 */
	public GameMode getGameMode();

	/**
	 * Returns a String that discribes your mission. Only used in Secret
	 * Mission-mode
	 */
	public String getMissionText(IPlayer currentPlayer);
}
