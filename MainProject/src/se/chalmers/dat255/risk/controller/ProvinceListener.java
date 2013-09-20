package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.view.ProvinceView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ProvinceListener extends ClickListener {

	@Override
	public void clicked(InputEvent event, float x, float y){
		if(event.getTarget() instanceof ProvinceView){
			((ProvinceView)event.getTarget()).check();
			((ProvinceView)event.getTarget()).addUnits();
		}
		Gdx.app.log("trololol", "province clicked");
	}

}
