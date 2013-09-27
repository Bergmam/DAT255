package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.ICard;

import com.badlogic.gdx.graphics.Texture;


public class CardView extends AbstractView {
	private ICard card;
	
	public CardView(Texture normal, Texture checked) {
		super(normal, checked);
		setPosition(100, 100);
		setSize(imageUp.getWidth(), imageUp.getHeight());
	}
	public void addCard(Texture normal, Texture checked, ICard card){
		this.card = card;
		super.setImages(normal, checked);
	}
	
	public ICard getCard(){
		return card;
	}
}
