package se.chalmers.dat255.risk.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


/**
 *
 */
public class Deck {


	private static LinkedList<Card> deck = new LinkedList<Card>();
	private static LinkedList<Card> discardPile = new LinkedList<Card>();

	public Deck(ArrayList<String> provinces, int nbrOfJokers){
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
	}//contructor
	
	public static Card giveCard(){
		return deck.removeFirst();
	}
	
	public static void discard(Card card){
		discardPile.add(card);
	}
	
	public static void recycleCards(){
		if(deck.size() == 0){
			deck=discardPile;
			discardPile.clear();
			Collections.shuffle(deck);
		}else{
			//If there are cards left in the deck, the recycled ones are added to the bottom of the deck.
			Collections.shuffle(discardPile);
			for(Card c : discardPile){
				deck.add(c);
			}
			discardPile.clear();
		}
	}	
}
