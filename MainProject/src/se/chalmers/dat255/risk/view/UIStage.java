package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import com.badlogic.gdx.InputProcessor;

import se.chalmers.dat255.risk.model.IGame;

public class UIStage extends AbstractStage{

	private ChangePhase phase;
	private SwitchButton switchButton;
	
	public UIStage(IGame model){
		
		phase = new ChangePhase(model);
		actor.add(phase);
		
		switchButton = new SwitchButton();
		actor.add(switchButton);
		
		addActor(phase);
		addActor(switchButton);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputProcessor getProcessor() {
		return this;
	}
	
}
