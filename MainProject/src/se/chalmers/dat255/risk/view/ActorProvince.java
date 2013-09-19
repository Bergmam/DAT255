package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.controller.ProvinceListener;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorProvince extends Actor {

	public ActorProvince(){
		addListener(new ProvinceListener());
		
		
	}
}
