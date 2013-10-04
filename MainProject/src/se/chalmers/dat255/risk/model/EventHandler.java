package se.chalmers.dat255.risk.model;

import se.chalmers.dat255.risk.model.TurnAndPhaseManager;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;

public class EventHandler {
	private TurnAndPhaseManager phaseHandler;
	private CardExanger cardExanger;
	private IProvince oldClickedProvince = null;
	private boolean movedTroops = false;
	private boolean firstProvinceConqueredThisTurn = true;

	public EventHandler(TurnAndPhaseManager phaseHandler) {
		this.phaseHandler = phaseHandler;
		cardExanger = new CardExanger();
	}

	/*
	 * Makes the exange of three card, when you've chosen three good cards.
	 */
	public void handleCardEvent(ICard card, Player currentPlayer) {
		// TODO Auto-generated method stub
		cardExanger.makeExange(card, currentPlayer);
	}

	/*
	 * Tells PhaseHandler to changePhase.
	 * 
	 * Return is 2 if if a new bonus shall be computed. == 0 for F0 Return is 1
	 * if a change of phase has taken place. Return is 0 if a new turn has
	 * begun. Return is -1 if phase didn't change.
	 */
	public int handlePhaseEvent(Player currentPlayer, int bonusUnitsLeft,
			Player[] players) {
		// TODO Auto-generated method stub
		// Ska kolla så att spelaren är klar med alla sina
		Phase currentPhase = phaseHandler.getPhase();

		if (currentPhase == Phase.FBuild || currentPhase == Phase.F1) {
			// CHECKS IF I'M ALLOWED TO PRESS CHANGE PHASE
			if (bonusUnitsLeft == 0 && currentPlayer.getCards().size() < 5) {
				return phaseHandler.changePhase(currentPlayer, players);
			}
		} else if (currentPhase == Phase.F2 || currentPhase == Phase.F3) {

			return phaseHandler.changePhase(currentPlayer, players);
		}
		System.out.println("Most empty bonus before changing phase!");
		return -1;
		// "actions" och kan byta fas.

	}

	/**
	 * Anv�nds inte i nuvarande implementation
	 */
	private void resetVariables() {
		oldClickedProvince = null;
		movedTroops = false;
		firstProvinceConqueredThisTurn = true;
	}

}
