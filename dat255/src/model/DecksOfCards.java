package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Contains the cardType enum.  
 *
 */
public class DecksOfCards {


	private static LinkedList<CardType> cardDeck;
	private static LinkedList<CardType> discardPile;

	public DecksOfCards(ArrayList<String> provinces){
		int infantry=14; //Antaget värde hittade inget i reglerna
		int cavalry=14; //Antaget värde hittade inget i reglerna
		/*
		 * Förutsätter att rätt antal provincer finns, inte generell lösning.
		 */
		for(String p:provinces){
			if (infantry>0){
			//discardPile.add(new Card(p), INFANTRY);
			infantry--;
			}
			else if(cavalry>0){
				//discardPile.add(new Card(p), CAVALRY);
				cavalry--;
			}
			else{
				//discardPile.add(new Card(p), ARTILLERY);
			}
		}
		for(int i=0; i<3 ;i++){
			//discardPile.add(new Card(null), WILDCARD);
		}
		
	}
	
	public static CardType takeCard(){
		return cardDeck.removeFirst();
	}
	
	public static void discardCard(CardType card){
		discardPile.add(card);
	}
	
	private void shuffle(){
		Collections.shuffle(discardPile);
		cardDeck=discardPile;
		discardPile=null;
	}
	enum CardType{Infantry, Artillery, Cavalry, WildCard};
	
	
}
