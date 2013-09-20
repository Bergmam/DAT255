package se.chalmers.dat255.risk.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ProvinceView extends Actor {
	Texture image = new Texture(Gdx.files.internal("Gfx/bucket.png"));
	
	public ProvinceView(Stage st){
		setStage(st);
		setSize(50, 50);
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		batch.draw(image,800 / 2 - 64 / 2, 20);
	}

}
