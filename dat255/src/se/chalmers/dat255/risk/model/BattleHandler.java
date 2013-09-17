package se.chalmers.dat255.risk.model;

import java.util.Random;

public class BattleHandler {
	private Random generator = new Random();
	private int[] diceOffensive;
	private int[] diceDefensive;
	
	/**
	 * Handling the attack between two provinces. 
	 * @param offensive number of offensive attackers.
	 * @param defensive number of defensive attackers.
	 * @return ??
	 */
	
	public int[] doBattle(int offensive, int defensive){
		
		diceOffensive = rollDice(offensive);
		diceDefensive = rollDice(defensive);
		
		
		
		return null;
	}
	
	/**
	 * Creates dice
	 * @param armies number of attacking armies
	 * @return the two largest dice.
	 */
	private int[] rollDice(int armies){
		Random generator = new Random();
		int[] dice = null;
		dice[0] = 0;
		dice[1] = 0;
		
		for(int i = 0 ; i < armies ; i++){
			int newDice = generator.nextInt(6)+1;
			if(newDice > dice[0]){
				dice[1] = dice[0];
				dice[0] = newDice;
			} else if (newDice > dice[1]){
				dice[1] = newDice;
			}
		}
		
		return dice;
	}
}
