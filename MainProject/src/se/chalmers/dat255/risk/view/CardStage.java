package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Stage for showing a players cards
 */
/*
 * listen to player? what to do when switching player? have lists for all
 * player?
 * 
 * Perhaps receiving all card player belonging to a player in the property
 * change and refresh all cardViews then?
 */
public class CardStage extends Stage implements PropertyChangeListener {
	private List<CardView> actor;

	public CardStage() {
		actor = new ArrayList<CardView>();
		for (int i = 0; i < 5; i++) {
			actor.add(new CardView());
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub

	}
}
