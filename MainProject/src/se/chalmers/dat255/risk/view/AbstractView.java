package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class AbstractView extends Image implements PropertyChangeListener{
	
	protected static ShapeRenderer shape = new ShapeRenderer();
	protected static BitmapFont font = new BitmapFont();
	
	public AbstractView(Texture t){
		super(t);
	}
	
	public void dispose(){
		shape.dispose();
		font.dispose();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt){
	}
}
