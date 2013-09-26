package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.ICard;

import com.badlogic.gdx.graphics.Texture;


public class CardView extends AbstractView {
	private ICard card;
	
	public CardView() {
		setPosition(100, 100);
	}
	public void addCard(Texture normal, Texture checked, ICard card){
		this.card = card;
		imageUp = normal;
		imageDown = checked;
		setSize(imageUp.getWidth(), imageUp.getHeight());
	}
	public ICard getCard(){
		return card;
	}
}
