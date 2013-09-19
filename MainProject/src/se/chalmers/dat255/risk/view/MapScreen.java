package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.controller.ProvinceListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class MapScreen extends AScreen {
	Texture bucketImage;
	Rectangle bucket;
	Actor a;
	
	public MapScreen(GDXGame game) {
		super(game);
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		bucket = new Rectangle();
		
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;
		
		bucketImage = new Texture(Gdx.files.internal("Gfx/bucket.png"));
		a = new Actor();
		a.addListener(new ProvinceListener());
		a.setBounds( 800 / 2 - 64 / 2, 20, 100, 100);
		a.setSize(100, 100);
		a.setColor(Color.BLUE);
	
	
		
	}

	@Override
	public void show() {

		
		
	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0f, 1f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		a.draw(batch,11);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		batch.end();
		
		if(Gdx.input.isTouched()) {
		    Vector3 touchPos = new Vector3();
		    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		    boolean t = a.hit(touchPos.x, touchPos.y, true) != null;
		    Gdx.app.log("Actor",""+t);
		  /*  camera.unproject(touchPos);
		    bucket.x = touchPos.x - 64 / 2;
		    bucket.y= touchPos.y; 
		 */}


	}
	
	@Override
	public void dispose(){
		super.dispose();
	}
}
