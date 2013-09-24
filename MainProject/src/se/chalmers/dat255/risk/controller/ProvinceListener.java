package se.chalmers.dat255.risk.controller;

import se.chalmers.dat255.risk.model.IGame;
import se.chalmers.dat255.risk.model.IProvince;
import se.chalmers.dat255.risk.view.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ProvinceListener extends ClickListener {

	IProvince oldClickedProvince;
	IGame	theGame;
	@Override
	public void clicked(InputEvent event, float x, float y){
		if(event.getTarget() instanceof ProvinceView){
			ProvinceView newClick =  ((ProvinceView)event.getTarget());
			IProvince newClickedProvince = newClick.getProvince();
			newClick.check();

			// TROOP REINFORCMENT PHASE 1, ONLY THE PLACEMENT
			if(theGame.getCurrentPhase()==IGame.Phase.F1){
				//PUT A SINGEL UNIT ON THIS PROVINCE IF OWNED
			}
			// FIGHTING PHASE 2
			else if(theGame.getCurrentPhase()==IGame.Phase.F2){
				if(oldClickedProvince!=null){
					// FIGHT IF SECOND PROVINCE CLICKED AND OWNED BY DIFFERENT PLAYER 
					// AND ATTACKING PROVINCE OWNED BY MED
				}
			}
			//	MOVING TROOPS IN PHASE 3
			else if(theGame.getCurrentPhase()==IGame.Phase.F3){
				if(oldClickedProvince!=null){
						if(oldClickedProvince!=newClickedProvince){
							theGame.moveToProvince(1, oldClickedProvince, newClickedProvince);// MAY BE INVALID INPUT, THEN NOTHING WILL HAPPEN
						}
				}
				oldClickedProvince=newClickedProvince;
			}
		}
	//	Gdx.app.log("trololol", "province clicked");
		else if(event.getTarget() instanceof ChangePhase){
		}

		
	}

}
