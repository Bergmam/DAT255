package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.Card;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class CardView extends AbstractView {
	private Card card;
	
	public CardView(Texture texture, Card card) {
		super(texture, null);
		this.card = card;
		setSize(imageUp.getWidth(), imageUp.getHeight());
		setPosition(100, 100);
	}
	
	public Card getCard(){
		return card;
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha) {		
		
		 batch.setColor(Color.RED); batch.draw(isClicked ? imageDown : imageUp, getX(),
		 getY(), getWidth(), getHeight());

	}

}
