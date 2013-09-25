package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Card;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class CardView extends AbstractView {
	Image image;
	private Card card;
	
	public CardView(Texture texture, Card card) {
		image = new Image(texture);
		this.card = card;
		image.setScale(1000);
		System.out.println(image.getHeight());
	}
	
	public Card getCard(){
		return card;
	}

}
