package se.chalmers.dat255.risk.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/*	Hej svejs!
 * 	
 *  Det k�nns v�ldigt fel att ha en int units i provinceView.
 *  Jag f�resl�r att klassen implementerar Observer, eller
 *  motsvarande, och att klassen observerar Players unit variabel.
 *  D� kan man enkelt i en update metod uppdatera det GUI-v�rdet.
 *  P� s� vis slipper man ha samma variabel p� tv� st�llen.
 *  
 *  Hade vart awesome att koppla ihop det inf�r kv�llens inl�mning
 *  att truppantalet uppdateras i province-objektet n�r man klickar
 *  p� den, men det kanske �r f�r tidskr�vande?
 *  
 * Med v�nlig h�lsning
 * Emil
 */

public class ProvinceView extends Image {
	Texture image;
	Color  c;
	BitmapFont font = new BitmapFont();
	int units = 0;
	
	public ProvinceView(Texture texture){
		super(texture);
		image = texture;
		setSize(200, 200);
		c = Color.BLACK;
		
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
	
	/*@Override
	public void draw(SpriteBatch batch, float alpha){
		batch.setColor(c);
		batch.draw(image, getX(), getY());
		font.draw(batch, ""+ units, getCenterX(), getCenterY());
	
	}*/

}
