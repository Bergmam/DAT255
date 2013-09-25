package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class UIStage extends AbstractStage{

	private ChangePhase phase;
	
	public UIStage(){
		
		phase = new ChangePhase();
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
