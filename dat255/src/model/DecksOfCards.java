package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Contains the cardType enum.  
 *
 */
public class DecksOfCards {


	private static LinkedList<CardType> cardDeck;
	private static List<CardType> discardPile;

	public DecksOfCards(ArrayList<String> provinces){
	}
	
	public static CardType takeCard(){
		return cardDeck.removeFirst();
	}
	
	public static void discardCard(CardType card){
		discardPile.add(card);
	}
	
	private void shuffle(){
		
	}
	enum CardType{Infantry, Artillery, Cavalry, WildCard};
	
	
}
