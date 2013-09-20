package se.chalmers.dat255.risk.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ProvinceView extends Actor {
	Texture image;
	Color  c;
	BitmapFont font = new BitmapFont();
	int units = 0;
	
	public ProvinceView(Texture texture){
		super();
		image = texture;
		setSize(64, 64);
		c = Color.BLUE;
		
	}
	
	public float getCenterX(){
		return getX() + (getWidth()/2);
	}
	
	public float getCenterY(){
		return getY() +(getWidth()/2);
		
	}
	public void addUnits(){
		units++;
	}
	
	//temp be able to change to owner color
	public void changeColor(){
		c = c==Color.BLUE ? Color.RED: Color.BLUE;
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		batch.setColor(c);
		batch.draw(image, getX(), getY());
		font.draw(batch, ""+ units, getCenterX(), getCenterY());
		
	}

}
