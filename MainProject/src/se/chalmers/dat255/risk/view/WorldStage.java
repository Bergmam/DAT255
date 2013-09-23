package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.controller.ProvinceListener;
import se.chalmers.dat255.risk.model.IProvince;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class WorldStage extends Stage {
	private List<ProvinceView> actor;
	Image a = new Image( new Texture(Gdx.files.internal("Gfx/RiskMap.png")));

	public WorldStage(List<IProvince> provinces) {
		actor = new ArrayList<ProvinceView>();
		
		for (int i = 0; i < provinces.size(); i++) {
			ProvinceView provinceView = new ProvinceView(new Texture(
					Gdx.files.internal("Gfx/province.png")), new Texture(
					Gdx.files.internal("Gfx/provinceChosen.png")),
					provinces.get(i));
			provinceView.addListener(new ProvinceListener());
			actor.add(provinceView);
		}
		addActor(a);
		float y = actor.get(0).getHeight();
		float x = actor.get(0).getWidth();

		// correct placements
		// also we dont need table. it just line things up.
		actor.get(0).setPosition(0, 0);
		actor.get(1).setPosition(getWidth() / 2, getHeight() / 2);
		actor.get(2).setPosition(0, getHeight() / 2);
		actor.get(3).setPosition(getWidth() / 2, 0);
		/*
		 * setPositionFromCetre(actor.get(0),-x,-y);
		 * setPositionFromCetre(actor.get(2),0,0);
		 * setPositionFromCetre(actor.get(3),x,-y);
		 * setPositionFromCetre(actor.get(1),-x,y);
		 */

		System.out.println("" + Gdx.graphics.getWidth() + "=gdx anddddd " + x);
		for (int i = 0; i < provinces.size(); i++) {
			//addActor(actor.get(i));
		}
		Gdx.input.setInputProcessor(this);
	}

	private void setPositionFromCetre(Actor actor, float f1, float f2) {
		actor.setPosition(Gdx.graphics.getWidth() / 2 + f1,
				Gdx.graphics.getHeight() / 2 + f1);
	}
}
