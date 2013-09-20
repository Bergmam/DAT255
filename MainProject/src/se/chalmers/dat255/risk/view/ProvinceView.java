package se.chalmers.dat255.risk.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/*	Hej svejs!
 * 	
 *  Det känns väldigt fel att ha en int units i provinceView.
 *  Jag föreslår att klassen implementerar Observer, eller
 *  motsvarande, och att klassen observerar Players unit variabel.
 *  Då kan man enkelt i en update metod uppdatera det GUI-värdet.
 *  På så vis slipper man ha samma variabel på två ställen.
 *  
 *  Hade vart awesome att koppla ihop det inför kvällens inlämning
 *  att truppantalet uppdateras i province-objektet när man klickar
 *  på den, men det kanske är för tidskrävande?
 *  
 * Med vänlig hälsning
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
