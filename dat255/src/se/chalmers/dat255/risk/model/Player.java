package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

import se.chalmers.dat255.risk.model.Deck.CardType;


/**
 * The Player class contains relevant information about the player, 
 * such as his name, his ID and what cards he has.
 *
 */

public class Player {
	String name;
	int turnId;
	ArrayList<CardType> cards; // The cards the player currently has on his/her hand.
	
	public Player(int turnId, String name){
		this.turnId = turnId;
		this.name = name;
		
	}
	
	public void addCard(){
		cards.add(Deck.takeCard());
	}
	
	private void removeCard(CardType c1, CardType c2, CardType c3){
		cards.remove(c1); // G�rs alltid x3
		cards.remove(c2); 
		cards.remove(c3); 		
		Deck.discardCard(c1);
		Deck.discardCard(c2);
		Deck.discardCard(c3);
	}

	/*
	 * Vidare �r inte provinces knutna till korten.
	 */
	public boolean exchangeCard(CardType c1, CardType c2, CardType c3){
		if(c1.equals(c2) && c2.equals(c3)){ // 3 Lika, dock f�r vi Wildcardbug
			removeCard(c1, c2, c3);
			return true;
		}
		else if(!(c1.equals(c2)) && !(c2.equals(c3)) && !(c1.equals(c3))){ // En av varje
			
		}
		return false;
	}
	/*
	 * Test test 
	 */
	
}
