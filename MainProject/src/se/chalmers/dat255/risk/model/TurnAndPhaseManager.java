package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

public class TurnAndPhaseManager {
	private int activePlayer;
	private Phase currentPhase;


	// CLICK VARIABLES
	
	
	public TurnAndPhaseManager(){
////////////////DEV ////////////////////
	//	currentPhase=Phase.FBuild;
		currentPhase=Phase.F1;
////////////////DEV ///////////////////			
		activePlayer=0;
	}
	public static enum Phase {FBuild, F1, F2, F3}	
	public Phase getPhase(){
		return currentPhase;
	}
	
	/*
	 * Changing phase and then pokes on other methods.
	 * 
	 * Return is 2 if if a new bonus shall be computed. == 0 for F0
	 * Return is 1 if a change of phase has taken place.
	 * Return is 0 if a new turn has begun.
	 * Return is -1 if phase didn't change.
	 */
	
	public int changePhase(Player currentPlayer, ArrayList<Player> players) {
		if (currentPhase == Phase.FBuild) {
			if (currentPlayer == players.get(players.size() - 1)) {
				changeTurn(players);
				currentPhase = Phase.F1;
				return 0; // Special, no need to compute troops
			} else {
				System.out.println("Old active player: " + getActivePlayer());
				System.out.println("Number of players: " + players.size());
				changeTurn(players);
				System.out.println("New active player: " + getActivePlayer());
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
		return 1;
	}
	
	private void changeTurn(ArrayList<Player> players) {
		activePlayer = (activePlayer + 1) % players.size();
		System.out.println("Nu pillades det med activePlayer och det nya v�rdet �r: " + activePlayer);
	}
	
	public int getActivePlayer(){
		return activePlayer;
	}
}
