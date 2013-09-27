package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.util.List;

import se.chalmers.dat255.risk.model.Card;
import se.chalmers.dat255.risk.model.Card.CardType;
import se.chalmers.dat255.risk.model.ICard;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Stage for showing a players cards
 */
public class CardStage extends AbstractStage {
	Image background;

	public CardStage(List<ICard> cards) {
		super();
		background = new Image(Resource.getInstance().cardStageBg2);
		addActor(background);

		for (int i = 0; i < 5; i++) {
			actor.add(new CardView(Resource.getInstance().cardHolder,Resource.getInstance().cardHolder));
		}

		for (int i = 0; i<cards.size(); i++) {
			((CardView)actor.get(i)).addCard(getTexture(cards.get(i)), getTexture(cards.get(i)), cards.get(i));
		}
		System.out.println("this is nnumber of cards: " + actor.size());

		for (Actor a : actor) {
			addActor(a);
		}
	}

	public List<AbstractView> getViews() {
		return actor;
	}

	private Texture getTexture(ICard card) {
		if (card.getType() == CardType.ARTILLERY) {
			return Resource.getInstance().card1;
		} else if (card.getType() == CardType.CAVALRY) {
			return Resource.getInstance().card2;
		}
		return Resource.getInstance().card3;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
	}

	@Override
	public InputProcessor getProcessor() {
		return this;
	}
}
