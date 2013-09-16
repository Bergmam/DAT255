package model;

import java.util.ArrayList;

import model.DecksOfCards.CardType;

/**
 * The Player class contains relevant information about the player, 
 * such as his name, his ID and what cards he has.
 *
 */

public class Player {
	String name;
	int turnId, nrOfInf=0, nrOfCav=0, nrOfArt=0, nrOfWild=0;
	ArrayList<CardType> cards; // The cards the player currently has on his/her hand.
	
	public Player(int turnId, String name){
		this.turnId = turnId;
		this.name = name;
		
	}
	
	public void addCard(){
		cards.add(DecksOfCards.takeCard());
	}
	
	private void removeCard(CardType card){
		cards.remove(card);
	}

	/*
	 * Oklart hur den ska implementeras, men mitt förslag är att det
	 * finns ints som håller reda på hur många av varje kort det finns.
	 */
	public boolean exchangeCard(CardType card){
		return false;
	}
	/*
	 * Test test 
	 */
	
}
