package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.ProvinceView;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ProvinceListener extends ClickListener {

	private IGame theGame;

	public ProvinceListener(IGame theGame) {
		this.theGame = theGame;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		if (event.getTarget() instanceof ProvinceView) {

			ProvinceView newClick = ((ProvinceView) event.getTarget());
			IProvince newClickedProvince = newClick.getProvince();

			theGame.handleProvinceEvent(newClickedProvince);
		}
	}
}
