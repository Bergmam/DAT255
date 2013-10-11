package se.chalmers.dat255.risk.model;

import java.util.ArrayList;

import se.chalmers.dat255.risk.model.TurnAndPhaseManager.Phase;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager.ResultType;

public class EventHandler {
	private TurnAndPhaseManager phaseHandler;
	private CardExanger cardExanger;	
	
	public EventHandler(TurnAndPhaseManager phaseHandler) {
		this.phaseHandler = phaseHandler;
		cardExanger = new CardExanger();
	}

	/*
	 * Makes the exange of three card, when you've chosen three good cards.
	 */
	public ArrayList<String> handleCardEvent(ICard card, Player currentPlayer) {
		return cardExanger.makeExange(card, currentPlayer);
	}

	/*
	 * Tells PhaseHandler to changePhase if some conditions is met.
	 * 
	 * Return is ComputeBonusForF0 if if a new bonus shall be computed in F0. 
	 * Return is ComputeBonusForF1 is 0 if a new turn has begun (and not in F0) so that Game knows it's time to compute a new bonus.
	 * Return is ChangedPhase if a change of phase has taken place.  
	 * Return is DoNothing if the phase didn't change.
	 */
	public ResultType handlePhaseEvent(Player currentPlayer, int bonusUnitsLeft,
			ArrayList<Player> players) {
		Phase currentPhase = phaseHandler.getPhase();
		if (currentPhase == Phase.FBuild || currentPhase == Phase.F1) {
			// CHECKS IF I'M ALLOWED TO PRESS CHANGE PHASE
			if (bonusUnitsLeft == 0 && currentPlayer.getCards().size() < 5) {
				cardExanger.flushCards();
				return phaseHandler.changePhase(currentPlayer, players);
			} 
			
		} else if (currentPhase == Phase.F2 || currentPhase == Phase.F3) {
			return phaseHandler.changePhase(currentPlayer, players);
		}
		return ResultType.DoNothing;
	}
}
