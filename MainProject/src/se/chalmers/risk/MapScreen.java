package se.chalmers.risk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MapScreen extends AScreen {
	OrthographicCamera camera;
	Texture bucketImage;
	Rectangle bucket;

	public MapScreen(GDXGame game) {
		super(game);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		game.batch = new SpriteBatch();
		bucket = new Rectangle();
		
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;
		
		bucketImage = new Texture(Gdx.files.internal("Gfx/Bucket.png"));
	}

	@Override
	public void show() {

		
		
	}

	@Override
	public void render(float render) {
		Gdx.gl.glClearColor(0f, 1f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		game.batch.draw(bucketImage, bucket.x, bucket.y);
		game.batch.end();
		
		if(Gdx.input.isTouched()) {
		    Vector3 touchPos = new Vector3();
		    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		    camera.unproject(touchPos);
		    bucket.x = touchPos.x - 64 / 2;
		    bucket.y= touchPos.y; 
		 }


	}
}
