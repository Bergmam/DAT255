package se.chalmers.dat255.risk.controller;

import java.awt.Color;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ProvinceListener extends ClickListener {

	IGame	theGame;
	
	/**
	 *	If we want to highlight the province that logic can/should
	 *	be in this method.
	 *  
	 */
	@Override
	public void clicked(InputEvent event, float x, float y){
		if(event.getTarget() instanceof ProvinceView){
			ProvinceView newClick =  ((ProvinceView)event.getTarget());
			IProvince newClickedProvince = newClick.getProvince();
			newClick.check();
			theGame.handleProvinceClick(newClickedProvince);
		}
	//	Gdx.app.log("trololol", "province clicked");
	}
}
