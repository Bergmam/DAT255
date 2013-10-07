package se.chalmers.dat255.risk.model;

public interface ICard {
	/**
	 * Constructor for creating a card with the given type and string or the
	 * string "Joker" if the given type is JOKER.
	 * 
	 * @param type
	 *            the type of the card.
	 * @param name
	 *            the name of the province belonging to the card being created.
	 */

	/**
	 * Method for accessing the name(id) of the province belonging to a card.
	 * 
	 * @return the name of the province.
	 */
	public String getName();

	/**
	 * Method for accessing the type of a card.
	 * 
	 * @return the type of this card
	 */
	public Card.CardType getType();

	/**
	 * An enum describing the different card types in the game
	 */
	public static enum CardType {
		INFANTRY, CAVALRY, ARTILLERY, JOKER
	}

	/**
	 * Changes the state of the card
	 * 
	 * @param active
	 *            if the card should be active or not
	 */
	public void setActive(boolean active);

	/**
	 * Checks if the card is active
	 * 
	 * @return true if active, false otherwise
	 */
	public boolean isActive();
}
