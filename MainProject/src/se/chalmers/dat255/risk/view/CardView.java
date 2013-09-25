package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.ICard;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class CardView extends AbstractView {
	private ICard card;
	
	public CardView(Texture texture, ICard card) {
		super(texture, null);
		this.card = card;
		setSize(imageUp.getWidth(), imageUp.getHeight());
		setPosition(100, 100);
	}
	
	public ICard getCard(){
		return card;
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha) {		
		
		 batch.setColor(Color.RED); batch.draw(isClicked ? imageDown : imageUp, getX(),
		 getY(), getWidth(), getHeight());

	}

}
