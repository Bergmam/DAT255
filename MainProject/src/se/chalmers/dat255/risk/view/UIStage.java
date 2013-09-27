package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.InputProcessor;

public class UIStage extends AbstractStage{

	private ChangePhase phase;
	private SwitchButton switchButton;
	private boolean renderWorld;

	public UIStage(IGame model){
		
		phase = new ChangePhase(model);
		actor.add(phase);
		
		switchButton = new SwitchButton();
		actor.add(switchButton);
		
		addActor(phase);
		addActor(switchButton);
		
		renderWorld = true;
		
	}
	
	public boolean renderWorld(){
		return renderWorld;
	}
	
	public void switchRender(){
		renderWorld = !renderWorld;
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
