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
	int turnId;
	ArrayList<CardType> cards; // The cards the player currently has on his/her hand.
	
	public Player(int turnId, String name){
		this.turnId = turnId;
		this.name = name;
	}
	
}
