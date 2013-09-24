package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.controller.ProvinceListener;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.resource.Resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class WorldStage extends Stage {
	private List<AbstractView> actor;
	private Image background;
	private Group provinceGroup;

	public WorldStage(List<IProvince> provinces) {

		background = new Image(Resource.getInstance().backGround);

		provinceGroup = new Group();

		// Texture.setEnforcePotImages(false); Solves power of two?

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
		Gdx.input.setInputProcessor(this);
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
}
