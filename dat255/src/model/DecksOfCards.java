package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Contains the cardType enum.  
 *
 */
public class DecksOfCards {


	private LinkedList<CardType> cardDeck;
	private List<CardType> discardPile;

	public DecksOfCards(ArrayList<String> provinces){
	}
	
	public CardType takeCard(){
		return cardDeck.removeFirst();
	}
	
	public void discardCard(CardType card){
		discardPile.add(card);
	}
	
	private void shuffle(){
		
	}
	enum CardType{Infantry, Artillery, Cavalry, WildCard};
	
	
}
