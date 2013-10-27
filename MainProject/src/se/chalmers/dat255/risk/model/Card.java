package se.chalmers.dat255.risk.model;

/**
 * A class for representing a card in the game. A card either has a type of unit
 * and the id of a province in the form of a string or has the type joker and
 * the id joker. A joker is equal to any other card according to the overwritten
 * equals method.
 * 
 */
public class Card implements ICard {

	private String provinceName;
	private Card.CardType type;
	private boolean active;

	/**
	 * Constructor for creating a card with the given type and string or the
	 * string "Joker" if the given type is JOKER.
	 * 
	 * @param type
	 *            the type of the card.
	 * @param name
	 *            the name of the province belonging to the card being created.
	 */
	public Card(Card.CardType type, String name) {
		if (type == CardType.JOKER) {
			provinceName = "Joker";
		} else {
			provinceName = name;
		}
		this.type = type;
	}

	public String getName() {
		return provinceName;
	}

	public Card.CardType getType() {
		return this.type;
	}

	/**
	 * Compares two Cards. Returns true if cards are of the same type and when
	 * comparing with a card of the type JOKER.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Card) {
			Card tmp = (Card) o;
			return this.type == tmp.type;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean isActive() {
		return active;
	}
}
