package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.model.ICard;
import se.chalmers.dat255.risk.model.ICard.CardType;
import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.Player;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Stage for showing a players cards
 */
public class CardStage extends AbstractStage {

	private final int maxNbrOfCards = 5;
	private Table main, top, bottom;
	private List<List<AbstractView>> all;
	private Player current;

	public CardStage(IGame model) {
		super(model);
		model.addListener(this);

		all = new ArrayList<List<AbstractView>>();

		current = model.getActivePlayer();

		main = new Table();
		main.setFillParent(true);

		top = new Table();
		bottom = new Table();

		CardView view;
		List<AbstractView> list;
		for (Player p : model.getPlayers()) {
			p.addListener(this);

			list = new ArrayList<AbstractView>();

			for (int i = 0; i < maxNbrOfCards; i++) {
				view = new CardView(Resource.getInstance().cardHolder,
						Resource.getInstance().cardHolder);
				views.add(view);
				list.add(view);
			}
			all.add(list);
		}
		placeViews();

		addActor(main);

	}

	private void placeViews() {

		top.defaults().expand();
		top.add(getCurrentList().get(0));
		top.add(getCurrentList().get(1));
		top.add(getCurrentList().get(2));
		main.add(top).expand().fill().row();
		bottom.defaults().expand();
		bottom.add();
		bottom.add(getCurrentList().get(3));
		bottom.add();
		bottom.add(getCurrentList().get(4));
		bottom.add();
		main.add(bottom).expand().fill();
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
		if (event.getPropertyName().equalsIgnoreCase(Player.CARD_ADDED)) {
			addCard((ICard) event.getOldValue());
		} else if (event.getPropertyName()
				.equalsIgnoreCase(Player.CARD_REMOVED)) {
			removeCard((ICard) event.getNewValue());
		} else if (event.getPropertyName().equalsIgnoreCase(IGame.CHANGE_TURN)) {
			current = model.getActivePlayer();
			main.clear();
			top.clear();
			bottom.clear();
			placeViews();
		}

	}

	private List<AbstractView> getCurrentList() {
		return all.get(current.getId());
	}

	private void removeCard(ICard card) {
		for (AbstractView v : getCurrentList()) {
			if (((CardView) v).getCard() == card) {
				((CardView) v).removeCard();
				return;
			}
		}

	}

	private void addCard(ICard newCard) {
		for (AbstractView c : getCurrentList()) {
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
