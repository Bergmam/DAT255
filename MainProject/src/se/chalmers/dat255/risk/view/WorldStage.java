package se.chalmers.dat255.risk.view;

import java.beans.PropertyChangeEvent;
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
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class WorldStage extends AbstractStage implements GestureListener {
	private Image background;
	private Group provinceGroup;
	private OrthographicCamera camera;
	private GestureDetector gesture;
	private float initialZoom;

	public WorldStage(List<IProvince> provinces) {

		background = new Image(Resource.getInstance().backGround);
		camera = new OrthographicCamera();
		provinceGroup = new Group();
		gesture = new GestureDetector(this);
		camera.setToOrtho(false);
		setCamera(camera);

		camera.position.set(background.getWidth() / 2,
				background.getHeight() / 2, 0); //
		// Texture.setEnforcePotImages(false); Solves power of two?

		actor = new ArrayList<AbstractView>();

		for (int i = 0; i < provinces.size(); i++) {
			Gdx.app.log("ProvinceView", "create ProvinceView");
			ProvinceView provinceView = new ProvinceView(null, null,
					provinces.get(i));
			actor.add(provinceView);

		}

		addActor(background);

		for (int i = 0; i < provinces.size(); i++) {
			provinceGroup.addActor(actor.get(i));
		}
		addActor(provinceGroup);
		//addActor(new ChangePhase());
		enterStage();
	}

	private void setPositionFromCetre(Actor actor, float f1, float f2) {
		actor.setPosition(Gdx.graphics.getWidth() / 2 + f1,
				Gdx.graphics.getHeight() / 2 + f1);
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		initialZoom = camera.zoom;
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
		Gdx.app.log("movment", "X: " + x + " Y: " + y);
		getCamera().position.x -= deltaX;
		getCamera().position.y += deltaY;

		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {

		float ratio = initialDistance / distance;

		camera.zoom = initialZoom * ratio;

		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterStage() {
		Gdx.input.setInputProcessor(gesture);
		
	}
}
