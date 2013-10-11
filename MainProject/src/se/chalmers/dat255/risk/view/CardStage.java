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
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Stage for showing a players cards
 */
public class CardStage extends AbstractStage {

	private final int maxNbrOfCards = 5;
	Table main,top,bottom;

	public CardStage(List<ICard> cards) {
		super();
		main = new Table();
		main.setFillParent(true);
		
		top = new Table();
		bottom = new Table();

		for (int i = 0; i < maxNbrOfCards; i++) {
			views.add(new CardView(Resource.getInstance().cardHolder, Resource
					.getInstance().cardHolder));
		}

		for (Actor a : views) {
			addActor(a);
		}

		top.add(views.get(0)).expand();
		top.add(views.get(1)).expand();
		top.add(views.get(2)).expand();
		main.add(top).expand().fill().row();
		bottom.add().expand();
		bottom.add(views.get(3)).expand();
		bottom.add().expand();
		bottom.add(views.get(4)).expand();
		bottom.add().expand();
		main.add(bottom).expand().fill();
		addActor(main);

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
