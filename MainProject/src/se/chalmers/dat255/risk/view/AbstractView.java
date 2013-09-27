package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class AbstractView extends Actor implements
		PropertyChangeListener {

	protected boolean isClicked;
	protected BitmapFont font;
	protected Texture imageUp;
	protected Texture imageDown;
	protected float width;
	protected float height;

	// pretty much only for cardview
	public AbstractView(){
		font = new BitmapFont();
	}
	
	public AbstractView(Texture iU, Texture iD) {
		imageUp = iU;
		imageDown = iD;
		width = iU.getWidth();
		height = iU.getHeight();
		font = new BitmapFont();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}
	
	/*
	 * IsCicked makes the button look like it have been clicked or not.
	 */
	public void check(){
		isClicked =  !isClicked;
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		batch.draw(isClicked ? imageDown : imageUp ,getX(),getY());
	}

	public void setImages(Texture iU, Texture iD){
		imageUp = iU;
		imageDown = iD;
	}

	public void dispose() {
		font.dispose();
		imageUp.dispose();
		imageDown.dispose();
	}
}
