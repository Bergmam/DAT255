package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Card.CardType;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

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
public class CardStage extends AbstractStage {
	boolean clicked;

	public CardStage(List<Card> cards) {
		super();
		
		clicked = false;
	
		for (int i = 0; i < cards.size(); i++) {
			actor.add(new CardView(getTexture(cards.get(i)),cards.get(i)));
		}
		
		placeActors();
		
	}

	private void placeActors() {
		
	}
	
	private Texture getTexture(Card card) {
		// TODO Auto-generated method stub
		if(card.getType()==CardType.ARTILLERY){
			return new Texture(Gdx.files.internal("Gfx/card1.png"));
		} else if (card.getType()==CardType.CAVALRY) {
			return new Texture(Gdx.files.internal("Gfx/card1.png"));
		}
		return new Texture(Gdx.files.internal("Gfx/card3.png"));
	}
	
	/*
	 * IsCicked makes the button look like it have been clicked or not.
	 */
	public void isClicked(){
		clicked =  !clicked;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStage() {
		Gdx.input.setInputProcessor(this);
		
	}
}
