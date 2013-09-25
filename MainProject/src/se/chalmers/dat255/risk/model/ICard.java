package se.chalmers.dat255.risk.model;

import se.chalmers.dat255.risk.model.Card.CardType;

public interface ICard {
	/**
	 * Constructor for creating a card with the given type and string
	 * or the string "Joker" if the given type is JOKER.
	 * @param type, the type of the card.
	 * @param name, the name of the province belonging to the card being created.
	 */

	/**
	 * Method for accessing the name(id) of the province belonging to a card.
	 * @return the name of the province.
	 */
	public String getName();
	
	/**
	 * Method for accessing the type of a card. 
	 * @return
	 */
	public Card.CardType getType();
	
	public static enum CardType {INFANTRY, CAVALRY, ARTILLERY, JOKER}
	
}
