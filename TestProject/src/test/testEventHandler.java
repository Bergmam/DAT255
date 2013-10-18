package test;

import org.junit.Test;

import se.chalmers.dat255.risk.model.CardExanger;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.model.TurnAndPhaseManager;

public class testEventHandler {
	private TurnAndPhaseManager phaseHandler;
	private CardExanger cardExanger;
	private IProvince oldClickedProvince = null;
	private boolean movedTroops = false;
	private boolean firstProvinceConqueredThisTurn = true;
	
	@Test
	public void EventHandler() {
		TurnAndPhaseManager phaseHandler = new TurnAndPhaseManager();
		cardExanger = new CardExanger();
	}

}
