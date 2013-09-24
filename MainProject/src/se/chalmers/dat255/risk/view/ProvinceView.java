package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.model.IProvince;

import com.badlogic.gdx.Gdx;
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
	private Texture image;
	private Texture image2;
	private boolean checked = false;
	private Color c;
	private BitmapFont font = new BitmapFont();
	private IProvince province;

	public ProvinceView(Texture texture, Texture texture2, IProvince province) {
		super(texture);
		image = texture;
		image2 = texture2;
		this.province = province;
		setSize(Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 2);
		c = Color.GREEN;
	}

	public float getCenterX() {
		return getX() + (getWidth() / 2);
	}

	public float getCenterY() {
		return getY() + (getWidth() / 2);

	}

	public void addUnits() {
		province.addUnits(1);
	}

	// temp be able to change to owner color
	public void changeColor() {
		c = c == Color.GREEN ? Color.RED : Color.GREEN;
	}

	public void check() {
		checked = !checked;
	}

	@Override
	public void draw(SpriteBatch batch, float alpha) {
		// needs better solution than static call
		// scale to 1/4 of screen size
		// Isn't this better?
		batch.draw(checked ? image2 : image, getX(), getY(), getWidth(),
				getHeight());
		font.drawMultiLine(batch, "Country: " + province.getId() + "\nUnits: "
				+ province.getUnits(), getCenterX() - (getWidth() / 3),
				getCenterY());
	}
	
	public IProvince getProvince(){
		return province;
	}
}
