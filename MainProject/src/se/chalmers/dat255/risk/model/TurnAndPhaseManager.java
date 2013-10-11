package se.chalmers.dat255.risk.model;

import java.util.List;

public class TurnAndPhaseManager {
	private int activePlayer;
	private Phase currentPhase;

	public TurnAndPhaseManager() {
		currentPhase = Phase.FBuild;
		activePlayer = 0;
	}

	public static enum Phase {
		FBuild, F1, F2, F3
	}

	public Phase getPhase() {
		return currentPhase;
	}

	/*
	 * Changing phase and then pokes on other methods.
	 * 
	 * Return is 2 if if a new bonus shall be computed. == 0 for F0 Return is 1
	 * if a change of phase has taken place. Return is 0 if a new turn has
	 * begun. Return is -1 if phase didn't change.
	 */

	public int changePhase(Player currentPlayer, List<Player> players) {
		if (currentPhase == Phase.FBuild) {
			if (currentPlayer == players.get(players.size() - 1)) {
				changeTurn(players);
				currentPhase = Phase.F1;
				System.out.println("New phase: " + currentPhase);
				return 0; // Special, no need to compute troops
			} else {
				changeTurn(players);
				return 2;
			}
		} else if (currentPhase == Phase.F3) {
			changeTurn(players);
			currentPhase = Phase.F1;
			return 0;
		} else if (currentPhase == Phase.F1) {
			currentPhase = Phase.F2;
		} else {
			currentPhase = Phase.F3;
		}
		System.out.println("New phase: " + currentPhase);
		return 1;
	}

	private void changeTurn(List<Player> players) {
		activePlayer = (activePlayer + 1) % players.size();
		System.out.println("Changed Turn, new player is: " + activePlayer);
	}

	public int getActivePlayer() {
		return activePlayer;
	}

	/**
	 * called when a player gives up
	 * 
	 * @param players
	 *            the list of players left in the game
	 */
	// change turn not necessary!
	public void surrender(List<Player> players) {
		if (players.size() != 1) {
			if (currentPhase == Phase.FBuild) {
				if (activePlayer == players.size()) {
					changeTurn(players);
					currentPhase = Phase.F1;
				}
			} else {
				currentPhase = Phase.F1;
			}
		} else {
			activePlayer = 0;//safety messure as to not crash the game
			currentPhase = Phase.F1;
		}
	}
}
