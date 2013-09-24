package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.dat255.risk.model.Card;

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

/*
 * I think we will add CardViews when player gets more card, 
 * and when using them we will destroy the cardViews. So we will get a propertyChange when
 * player removes this card from the hand. 
 * 
 * So we have one cardStage for every player and just changing the stage?
 */
public class CardStage extends Stage implements PropertyChangeListener {
	private List<CardView> actor;

	public CardStage(List<Card> cards) {
		actor = new ArrayList<CardView>();
		for (int i = 0; i < cards.size(); i++) {
			actor.add(new CardView(cards.get(i)));
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub

	}
}
