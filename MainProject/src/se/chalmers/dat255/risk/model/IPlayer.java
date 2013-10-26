package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * Interface for a player class
 */

public interface IPlayer {

	// ============== EVENT-CONSTANTS ==============
	public final static String CARD_ADDED = "addCard";
	public final static String CARD_REMOVED = "removeCard";

	// =============================================

	/**
	 * Adds a listener to this object
	 * 
	 * @param observer
	 *            the listener of this object
	 */
	public void addListener(final PropertyChangeListener observer);

	/**
	 * Takes a card from the deck and puts on the players hand.
	 */
	public void addCard();

	/**
	 * Increments the number of provinces that the player currently controls.
	 */
	public void gainProvince();

	/**
	 * Decrements the number of provinces that the player currently controls.
	 */
	public void loseProvince();

	/**
	 * Returns the number of provinces that the player currently controls.
	 * 
	 * @return Number of provinces.
	 */
	public int getNrOfProvinces();

	/**
	 * Method for trading in cards for troops. Checks if you have three cards of
	 * the same type, or three cards of different types. Also makes sure you can
	 * only trade in one Joker at a time.
	 */
	public boolean exchangeCard(ICard c1, ICard c2, ICard c3);

	/**
	 * Returns the name of the player.
	 * 
	 * @return name of the player.
	 */
	public String getName();

	/**
	 * Returns the cards on the players hand
	 * 
	 * @return The ArrayList of Cards.
	 */
	public ArrayList<ICard> getCards();

	/**
	 * returns a players id
	 * 
	 * @return a players starting turn id
	 */
	public int getId();

	/**
	 * Discards the players cards when s/he loses. The cards are returned to the
	 * Deck
	 */
	public void discard();

}
