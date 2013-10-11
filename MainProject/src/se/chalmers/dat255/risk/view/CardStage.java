package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.util.List;

import se.chalmers.dat255.risk.model.ICard;
import se.chalmers.dat255.risk.model.ICard.CardType;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Stage for showing a players cards
 */
public class CardStage extends AbstractStage {

	private final int maxNbrOfCards = 5;

	public CardStage(List<ICard> cards) {
		super();

		for (int i = 0; i < maxNbrOfCards; i++) {
			views.add(new CardView(Resource.getInstance().cardHolder, Resource
					.getInstance().cardHolder));
		}

		for (Actor a : views) {
			addActor(a);
		}

		/*
		 * almost more problem than it was worth placing all the cards
		 * probably overly complicated as well
		 */
		for (int i = 0; i < 3; i++) {
			views.get(i).setPosition(
					i * (Gdx.graphics.getWidth() / 3) + views.get(i).width / 3,
					Gdx.graphics.getHeight() / 2);
		}
		for (int i = 1, k = 3; k < 5; k++, i += 2) {
			views.get(k).setPosition((i * (Gdx.graphics.getWidth() / 5)) - 8,
					views.get(k).height / 10);
		}

	}

	public List<AbstractView> getViews() {
		return views;
	}

	private Texture getTexture(ICard card) {
		if (card.getType() == CardType.ARTILLERY) {
			return Resource.getInstance().artillery;
		} else if (card.getType() == CardType.CAVALRY) {
			return Resource.getInstance().cavalry;
		} else if (card.getType() == CardType.INFANTRY) {
			return Resource.getInstance().infantry;
		}
		return Resource.getInstance().joker;
	}

	private Texture getCheckedTexture(ICard card) {
		if (card.getType() == CardType.ARTILLERY) {
			return Resource.getInstance().artillery2;
		} else if (card.getType() == CardType.CAVALRY) {
			return Resource.getInstance().cavalry2;
		} else if (card.getType() == CardType.INFANTRY) {
			return Resource.getInstance().infantry2;
		}
		return Resource.getInstance().joker2;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equalsIgnoreCase("addCard")) {
			addCard((ICard) event.getOldValue());
		} else if (event.getPropertyName().equalsIgnoreCase("removeCard")) {
			removeCard((ICard) event.getNewValue());
		}

	}

	private void removeCard(ICard card) {
		for (AbstractView v : views) {
			if (((CardView) v).getCard() == card) {
				((CardView) v).removeCard();
				return;
			}
		}

	}

	private void addCard(ICard newCard) {
		for (AbstractView c : views) {
			if (!((CardView) c).hasCard()) {
				((CardView) c).addCard(getTexture(newCard),
						getCheckedTexture(newCard), newCard);
				return;
			}
		}
	}

	@Override
	public InputProcessor getProcessor() {
		return this;
	}
}
