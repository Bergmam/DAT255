package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.IGame;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class AbstractStage extends Stage implements
		PropertyChangeListener {
	protected List<AbstractView> views;
	protected List<Actor> others;
	protected IGame model;

	public AbstractStage(IGame model) {
		this.model = model;
		views = new ArrayList<AbstractView>();
		others = new ArrayList<Actor>();
	}

	public List<AbstractView> getViews() {
		return views;
	}

	public List<Actor> getOthers() {
		return others;
	}

	public InputProcessor getProcessor() {
		return this;
	}

	@Override
	public void dispose() {
		super.dispose();
		for (AbstractView v : views) {
			v.dispose();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

	}
}
