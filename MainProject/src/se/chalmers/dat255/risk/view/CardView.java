package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.ICard;

import com.badlogic.gdx.graphics.Texture;


public class CardView extends AbstractView {
	private ICard card;
	
	public CardView(Texture normal, Texture checked, ICard card) {
		super(normal, checked);
		this.card = card;
		setSize(imageUp.getWidth(), imageUp.getHeight());
		setPosition(100, 100);
	}
	
	public ICard getCard(){
		return card;
	}
}
