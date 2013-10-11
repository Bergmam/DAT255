package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


/**
 *A class representing the deck in the game.
 * @author Emma Håkansson
 * @author Christoffer Matsson
 * @since 2013-09-16
 */
public class Deck {

	private static Deck instance = null;
	private static LinkedList<ICard> deck = new LinkedList<ICard>();
	private static LinkedList<ICard> discardPile = new LinkedList<ICard>();

	private Deck(){}
	
	/**
	 * Constructs the cards in the deck given an array containing the names of all provinces 
	 * in the game and the number of jokers there should be in the deck.
	 * @param provinces, array with the names of all provinces.
	 * @param nbrOfJokers number of jokers in the deck.
	 */
	public void CreateCards(ArrayList<String> provinces, int nbrOfJokers){
		int infantry = provinces.size() / 3;
		int cavalry = provinces.size() / 3;
		
		//Assigning a province and a type to each created card.
		for(String p : provinces){
			if (infantry>0){
			deck.add(new Card(Card.CardType.INFANTRY, p));
			infantry--;
			}
			else if(cavalry>0){
				deck.add(new Card(Card.CardType.CAVALRY, p));
				cavalry--;
			}
			else{
				deck.add(new Card(Card.CardType.ARTILLERY, p));
			}
		}
		for(int i = 0; i < nbrOfJokers; i++){
			deck.add(new Card(Card.CardType.JOKER, "Joker"));
		}
		Collections.shuffle(deck);
	}
	
	/**
	 * Method for dealing a card.
	 * @return the top card in the deck.
	 */
	public static ICard giveCard(){
		if(deck.isEmpty()){
			recycleCards();
		}
		return deck.removeFirst();
	}
	
	/**
	 * Method which adds the given card to the list of discarded cards.
	 * @param card, the card being discarded.
	 */
	public static void discard(ICard card){
		discardPile.add(card);
	}
	
	/**
	 * Method for shuffling and moving the discarded cards into the deck.
	 * If deck is not empty methods adds shuffled cards to the end of the deck list.
	 */
	@SuppressWarnings("unchecked")
	public static void recycleCards(){
		if(deck.size() == 0){
			System.out.println("is it empty? " + deck.size());
			deck = (LinkedList<ICard>) discardPile.clone();
			System.out.println("is it empty? " + discardPile.size());
			discardPile.clear();
			System.out.println("is it empty? " + deck.size());
			Collections.shuffle(deck);
		}else{
			//If there are cards left in the deck, the recycled ones are added to the bottom of the deck.
			for(ICard c : discardPile){
				deck.add(c);
			}
			Collections.shuffle(deck);
			discardPile.clear();
		}
	}
	
	public static int getSize(){
		return deck.size();
	}
	
	public static LinkedList<ICard> getDeckList(){
		return deck;
	}
	
	public static LinkedList<ICard> getDiscard(){
		return discardPile;
	}
	
	public static Deck getInstance(){
		if(instance == null){
			instance = new Deck();
		}
		return instance;
	}
}
