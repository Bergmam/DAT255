package se.chalmers.dat255.risk.model;

import java.util.Random;

/**
 * Battle simulator. rolls dice and determine how many units are lost.
 * 
 */
public class BattleHandler {
	private Random generator = new Random();

	/**
	 * Handles the battle between two provinces.
	 * 
	 * @param offensive
	 *            number of attackers.
	 * @param defensive
	 *            number of defenders.
	 * @return lost units, offensive and defensive.
	 */
	public int[] doBattle(int offensive, int defensive) {
		int[] lostArmies = new int[2];
		int[] diceDefensive = rollDice(defensive);
		int[] diceOffensive = rollDice(offensive);

		for (int i = 0; (i < defensive) && (i < offensive); i++) {
			if (diceOffensive[i] <= diceDefensive[i]) {
				lostArmies[0]++;
			} else {
				lostArmies[1]++;
			}
		}
		return lostArmies;
	}

	/*
	 * Creates dice.
	 * 
	 * @param armies
	 *            number of attacking armies
	 * @return the two largest dice.
	 */
	private int[] rollDice(int armies) {
		// Random generator = new Random();
		int[] dice = new int[2];
		for (int i = 0; i < armies; i++) {
			int newDice = generator.nextInt(6) + 1;
			if (newDice > dice[0]) {
				dice[1] = dice[0];
				dice[0] = newDice;
			} else if (newDice > dice[1]) {
				dice[1] = newDice;
			}
		}

		return dice;
	}
}
