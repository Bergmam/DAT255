package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PopUp extends Window {
	private Slider slider;

	public PopUp(String title) {
		super(title, new WindowStyle(new BitmapFont(), Color.RED,
				new TextureRegionDrawable(new TextureRegion(
						Resource.getInstance().cardHolder))));
		setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		setSize(100, 100);
		setModal(true);
		
		//slider = new Slider(0 , );
	}
	
	

}
