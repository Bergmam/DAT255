package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ProvinceListener extends ClickListener {

	//IProvince oldClickedProvince;
	IGame	theGame;
	@Override
	public void clicked(InputEvent event, float x, float y){
		if(event.getTarget() instanceof ProvinceView){
			ProvinceView newClick =  ((ProvinceView)event.getTarget());
			IProvince newClickedProvince = newClick.getProvince();
			newClick.check();
			theGame.handleProvinceClick(newClickedProvince);
		}
	//	Gdx.app.log("trololol", "province clicked");
		else if(event.getTarget() instanceof ChangePhase){
		}

		
	}

}
