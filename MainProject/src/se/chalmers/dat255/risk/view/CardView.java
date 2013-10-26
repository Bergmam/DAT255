package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.ICard;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class CardView extends AbstractView {
	private ICard card;
	private boolean hasCard;
	private Label label;

	public CardView(Texture normal, Texture checked) {
		super(normal, checked);
		setSize(Gdx.graphics.getWidth() / 5, 4 * (Gdx.graphics.getHeight() / 9));
		label = new Label("", Resource.getInstance().skin);
		label.setColor(Color.RED);

	}

	public void addCard(Texture normal, Texture checked, ICard card) {
		this.card = card;
		hasCard = true;
		super.setImages(normal, checked);
		label.setText(card.getName());
		
	}

	public void removeCard() {
		hasCard = false;
		label.setText("");
		setImages(Resource.getInstance().cardHolder,
				Resource.getInstance().cardHolder);
	}

	public boolean hasCard() {
		return hasCard; 
	}

	public ICard getCard() {
		return card;
	}

	private boolean isChecked() {
		return hasCard() ? card.isActive() : false;
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		batch.draw(isChecked() ? imageDown : imageUp, getX(), getY(),
				getWidth(), getHeight());
		label.setPosition(getX() +width/2 - ((label.getTextBounds().width /3)),
				getY() + height/3);
		label.draw(batch, alpha);

	}
}
