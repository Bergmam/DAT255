package se.chalmers.dat255.risk.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ProvinceListener extends InputListener {
	
	@Override
	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor){
		Gdx.app.log("LOLOL","InputEvent");
	}

}
