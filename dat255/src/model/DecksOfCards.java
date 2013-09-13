package model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Contains the cardType enum.
 * 
 */
public class DecksOfCards {

	private static LinkedList<CardType> cardDeck;
	private static LinkedList<CardType> discardPile;

	/**
	 * Creates a new Deck of cards.
	 * 
	 * @param provinces
	 *            String representives of all provinces
	 */
	public DecksOfCards(ArrayList<String> provinces) {
	}

	/**
	 * Draws a card from the deck.
	 * 
	 * @return the first cardType in the deck
	 */
	public static CardType takeCard() {
		return cardDeck.removeFirst();
	}

	/**
	 * Throws a card into the discard pile.
	 * 
	 * @param card
	 *            the cardType to be put in the discardPile
	 */
	public static void discardCard(CardType card) {
		discardPile.add(card);
	}

	/*
	 * Shuffles the Cardtypes in the discardPile and adds them to the CardDeck.
	 */
	private void shuffle() {

	}

	/**
	 * Simulates the different cards in the game.
	 */
	enum CardType {
		Infantry, Artillery, Cavalry, WildCard
	};

}
