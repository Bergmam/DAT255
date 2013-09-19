package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.controller.ProvinceListener;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class ProvinceStage extends Stage {

	public ProvinceStage(){
		addListener(new ProvinceListener());
		
		
	}
}
