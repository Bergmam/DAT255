package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.controller.ProvinceListener;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class WorldStage extends Stage implements GestureListener {
	private List<AbstractView> actor;
	private Image background;
	private Group provinceGroup;
	private OrthographicCamera camera;
	private GestureDetector gesture;

	public WorldStage(List<IProvince> provinces) {

		background = new Image(Resource.getInstance().backGround);
		camera = new OrthographicCamera();
		provinceGroup = new Group();
		gesture = new GestureDetector(this);
		
		/*
		 * setCamera(camera); camera.position.set(background.getWidth() / 2,
		 * background.getHeight() / 2, 0); //
		 * Texture.setEnforcePotImages(false); Solves power of two?
		 */
		actor = new ArrayList<AbstractView>();

		for (int i = 0; i < provinces.size(); i++) {
			Gdx.app.log("ProvinceView", "create ProvinceView");
			ProvinceView provinceView = new ProvinceView(null, null,
					provinces.get(i));
			provinceView.addListener(new ProvinceListener());
			actor.add(provinceView);

		}

		addActor(background);

		/*
		 * actor.get(0).setPosition(0, 0); actor.get(1).setPosition(getWidth() /
		 * 2, getHeight() / 2); actor.get(2).setPosition(0, getHeight() / 2);
		 * actor.get(3).setPosition(getWidth() / 2, 0);
		 * 
		 * setPositionFromCetre(actor.get(0),-x,-y);
		 * setPositionFromCetre(actor.get(2),0,0);
		 * setPositionFromCetre(actor.get(3),x,-y);
		 * setPositionFromCetre(actor.get(1),-x,y);
		 */

		for (int i = 0; i < provinces.size(); i++) {
			provinceGroup.addActor(actor.get(i));
		}
		addActor(provinceGroup);

		Gdx.input.setInputProcessor(gesture);
	}

	private void setPositionFromCetre(Actor actor, float f1, float f2) {
		actor.setPosition(Gdx.graphics.getWidth() / 2 + f1,
				Gdx.graphics.getHeight() / 2 + f1);
	}

	@Override
	public void dispose() {
		super.dispose();
		// TODO is this enough or do we need to dispose all of them?
		actor.get(0).dispose();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		Gdx.app.log("movment", "X: "+x +" Y: "+y);
		if(x>=0&&x+Gdx.graphics.getWidth()<=background.getImageWidth()){
		getCamera().position.x -= deltaX;
		getCamera().position.y += deltaY;
		}
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		
		 float ratio = initialDistance / distance;
		 Gdx.app.log("movment","zoom: " + ratio);
		 //camera.zoom += ratio;
	        
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}
}
