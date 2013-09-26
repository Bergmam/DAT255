package se.chalmers.dat255.risk.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * The Player class contains relevant information about the player, 
 * such as his name, his ID and what cards he has.
 *
 * Also contains methods for drawing cards and trading them in for troops.
 */

public class Player {
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private String name;
	private int turnId, nrOfProvinces = 0;
	private boolean current=false;
	private ArrayList<ICard> cards; // The cards the player currently has on his/her hand.
	
	// ============== EVENT-CONSTANTS ==============
	public final static String CARD_ADDED = "addedCard";
	public final static String CARD_REMOVED = "addedCard";
	// =============================================

	
	/**
	 * creating a player with a specified turn an name. 
	 * @param turnId the players turn identification.
	 * @param name the players name in the game
	 * @param color the color of the player
	 */
	public Player(int turnId, String name){
		this.turnId = turnId;
		this.name = name;	
		cards = new ArrayList<ICard>();	
	}
	
	/**
	 * Adds a listener to this object
	 * @param observer the listener of this object
	 */
	public void addListener(final PropertyChangeListener observer) {
		this.pcs.addPropertyChangeListener(observer);
	}
	
	/**
	 * Takes a card from the deck and puts on the players hand.
	 */
	public void addCard(){
		ICard newCard = Deck.giveCard();
		cards.add(newCard);
		pcs.firePropertyChange(this.CARD_ADDED, null, newCard);
	}
	
	/**
	 * Increments the number of provinces that the player currently controls.
	 */
	public void gainProvince(){
		nrOfProvinces++;
	}
	
	/**
	 * Decrements the number of provinces that the player currently controls.
	 */
	public void loseProvince(){
		nrOfProvinces--;
	}
	
	/**
	 * Returns the number of provinces that the player currently controls.
	 * @return Number of provinces.
	 */
	public int getNrOfProvinces(){
		return nrOfProvinces;
	}
	/**
	 * Throws away three cards on the players hand. Used by the exhangeCard method.
	 */
	private void removeCard(ICard c1, ICard c2, ICard c3){
		cards.remove(c1);
		cards.remove(c2); 
		cards.remove(c3); 		
		Deck.discard(c1);
		Deck.discard(c2);
		Deck.discard(c3);
		pcs.firePropertyChange(this.CARD_REMOVED, null, c1);
		pcs.firePropertyChange(this.CARD_REMOVED, null, c2);
		pcs.firePropertyChange(this.CARD_REMOVED, null, c3);
	}

	/**
	 * Method for trading in cards for troops.
	 * Checks if you have three cards of the same type, or three cards of different types.
	 * Also makes sure you can only trade in one Joker at a time.
	 */
	
	public boolean exchangeCard(Card c1, Card c2, Card c3){
		ArrayList<Card> exhangeList = new ArrayList<Card>();
		exhangeList.add(c1);
		exhangeList.add(c2);
		exhangeList.add(c3);
		int nrOfJokers = 0;
		// Makes sure you can't trade in more then one Joker together with other cards.
		for(Card c : exhangeList){
			if(c.getType() == Card.CardType.JOKER){
				nrOfJokers++;
			}
		}
		
		if(nrOfJokers > 1){
			return false;
		}
		// 3 Cards of the same type (Not Jokers), or one Joker
		else if(nrOfJokers==1 || c1.equals(c2) && c2.equals(c3)){ 
			removeCard(c1, c2, c3);
			return true;
		}
		// One of each card type
		else if(!(c1.equals(c2)) && !(c2.equals(c3)) && !(c1.equals(c3))){
			removeCard(c1, c2, c3);
			return true;
		}	
		return false;
	}
	
	/**
	 * Returns the name of the player.
	 * @return name of the player.
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Returns the cards on the players hand
	 * @return The ArrayList of Cards.
	 */
	public ArrayList<ICard> getCards(){
		return cards;
	}
	
	public void setCurrent(Boolean current){
		this.current=current;
	}
	
	public int getId(){
		return turnId;
	}
	
}
