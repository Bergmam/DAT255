package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class AbstractView extends Actor implements
		PropertyChangeListener {

	protected boolean isClicked;
	protected static BitmapFont font;
	protected Texture imageUp;
	protected Texture imageDown;

	public AbstractView(Texture iU, Texture iD) {
		imageUp = iU;
		imageDown = iD;
		
		if (font == null) {
			font = new BitmapFont();
		}
	}

	public void dispose() {
		font.dispose();
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
}
