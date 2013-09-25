package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.util.List;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Card.CardType;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

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
 * I think we will add CardViews when player gets more card, and when using them
 * we will destroy the cardViews. So we will get a propertyChange when player
 * removes this card from the hand.
 * 
 * So we have one cardStage for every player and just changing the stage?
 */
public class CardStage extends AbstractStage {
	Image background;

	public CardStage(List<Card> cards) {
		super();
		background = new Image(Resource.getInstance().backGround);
		addActor(background);
		
		for (int i = 0; i < cards.size(); i++) {
			actor.add(new CardView(getTexture(cards.get(i)), cards.get(i)));
		}

		actor.add(new CardView(
				getTexture(new Card(CardType.ARTILLERY, "Moskva")), new Card(
						CardType.ARTILLERY, "Moskva")));

		System.out.println("this is nnumber of cards: " + actor.size());

		for (Actor a : actor) {
			addActor(a);
		}
	}
	
	public List<AbstractView> getViews(){
		return actor;
	}

	private Texture getTexture(Card card) {
		// TODO Auto-generated method stub
		if (card.getType() == CardType.ARTILLERY) {
			return new Texture(Gdx.files.internal("Gfx/card1.png"));
		} else if (card.getType() == CardType.CAVALRY) {
			return new Texture(Gdx.files.internal("Gfx/card1.png"));
		}
		return new Texture(Gdx.files.internal("Gfx/card3.png"));
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
