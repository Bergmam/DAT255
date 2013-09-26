package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import se.chalmers.dat255.risk.model.IGame;

public class UIStage extends AbstractStage{

	private ChangePhase phase;
	
	public UIStage(IGame model){
		
		phase = new ChangePhase(model);
		phase.setPosition(getWidth()-phase.getWidth(), 0);
		addActor(phase);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterStage() {
		// TODO Auto-generated method stub
		
	}
	
}
