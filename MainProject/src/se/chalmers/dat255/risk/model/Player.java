package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * The Player class contains relevant information about the player, such as his
 * name, his ID and what cards he has.
 * 
 * Also contains methods for drawing cards and trading them in for troops.
 */
public class Player implements IPlayer {
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private String name;
	private int turnId, nrOfProvinces;
	private ArrayList<ICard> cards; // The cards the player currently has on
									// his/her hand.

	public Player(int turnId, String name) {
		this.turnId = turnId;
		this.name = name;
		cards = new ArrayList<ICard>();
	}

	@Override
	public void addListener(final PropertyChangeListener observer) {
		this.pcs.addPropertyChangeListener(observer);
	}

	@Override
	public void addCard() {
		ICard newCard = Deck.giveCard();
		cards.add(newCard);
		pcs.firePropertyChange(IPlayer.CARD_ADDED, newCard, null);
	}

	@Override
	public void gainProvince() {
		nrOfProvinces++;
	}

	@Override
	public void loseProvince() {
		nrOfProvinces--;
	}

	@Override
	public int getNrOfProvinces() {
		return nrOfProvinces;
	}

	/*
	 * Throws away three cards on the players hand. Used by the exhangeCard
	 * method.
	 */
	private void removeCard(ICard c1, ICard c2, ICard c3) {
		cards.remove(c1);
		cards.remove(c2);
		cards.remove(c3);
		Deck.discard(c1);
		Deck.discard(c2);
		Deck.discard(c3);
		pcs.firePropertyChange(CARD_REMOVED, null, c1);
		pcs.firePropertyChange(CARD_REMOVED, null, c2);
		pcs.firePropertyChange(CARD_REMOVED, null, c3);
	}

	private void inactivate(ICard c1, ICard c2, ICard c3) {
		c1.setActive(false);
		c2.setActive(false);
		c3.setActive(false);
	}

	@Override
	public boolean exchangeCard(ICard c1, ICard c2, ICard c3) {
		ArrayList<ICard> exhangeList = new ArrayList<ICard>();
		exhangeList.add(c1);
		exhangeList.add(c2);
		exhangeList.add(c3);
		int nrOfJokers = 0;
		// Makes sure you can't trade in more then one Joker together with other
		// cards.
		for (ICard c : exhangeList) {
			if (c.getType() == Card.CardType.JOKER) {
				nrOfJokers++;
			}
		}
		inactivate(c1, c2, c3);
		if (nrOfJokers > 1) {
			return false;
		}
		// 3 Cards of the same type (Not Jokers), or one Joker
		else if (nrOfJokers == 1 || c1.equals(c2) && c2.equals(c3)) {
			removeCard(c1, c2, c3);
			return true;
		}
		// One of each card type
		else if (!(c1.equals(c2)) && !(c2.equals(c3)) && !(c1.equals(c3))) {
			removeCard(c1, c2, c3);
			return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public ArrayList<ICard> getCards() {
		return cards;
	}

	@Override
	public int getId() {
		return turnId;
	}

	@Override
	public void discard() {
		for (ICard c : cards) {
			Deck.discard(c);
		}
	}

}
