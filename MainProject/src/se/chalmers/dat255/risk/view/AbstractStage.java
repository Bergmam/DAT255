package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class AbstractStage extends Stage implements PropertyChangeListener{
	protected List<AbstractView> actor;
	
	
	public AbstractStage(){
		actor = new ArrayList<AbstractView>();
	}
	
	public List<AbstractView> getViews(){
		return actor;
	}

	public abstract InputProcessor getProcessor();
}
