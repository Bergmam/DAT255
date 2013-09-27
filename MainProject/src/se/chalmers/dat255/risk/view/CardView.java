package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.ICard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class CardView extends AbstractView {
	private ICard card;
	
	public CardView(Texture normal, Texture checked) {
		super(normal, checked);
		setPosition(100, 100);
		setSize(Gdx.graphics.getWidth()/5,4*(Gdx.graphics.getHeight()/9));
	}
	public void addCard(Texture normal, Texture checked, ICard card){
		this.card = card;
		super.setImages(normal, checked);
	}
	
	public ICard getCard(){
		return card;
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		batch.draw(isClicked ? imageDown : imageUp ,getX(),getY(),getWidth(),getHeight());
		
	}
}
