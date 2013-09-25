package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ChangePhase extends TextButton{
	static Drawable image = new TextureRegionDrawable(new TextureRegion(Resource.getInstance().bucket));
	
	private static int PHASE1 = 1;
	private static int PHASE2 = 2;
	private static int PHASE3 = 3;
	private static int ATTACK = 4;
	private static int NEXT = 5;	
	
	private int current;
	
	public ChangePhase() {
		super("", new TextButtonStyle(image,image,image, new BitmapFont() ));
		size(64,64);		
	}
	
	public void setStyle(){
		
	}
	
	public void setCurrent(int i){
		current = i;
	}
	
	private String getString(){
		
		return null;
		
	}

	@Override
	public void draw(SpriteBatch batch, float alpha){
		
	}
}
