package se.chalmers.dat255.risk.view;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.dat255.risk.controller.ProvinceListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ProvinceStage extends Stage {
	private Table table;
	private List<ProvinceView> actor;

	public ProvinceStage(int provinces) {
		actor = new ArrayList<ProvinceView>();
		
		for (int i = 0 ; i<provinces ; i++){
			ProvinceView provinceView = new ProvinceView(new Texture(Gdx.files.internal("Gfx/province.png")));
			provinceView.addListener(new ProvinceListener());
			actor.add(provinceView);
		}
		
		float y = actor.get(0).getHeight();
		float x = actor.get(0).getWidth();
		
		//actor.get(0).setPosition(getWidth()/2-(float)0.01, getHeight()/2-(float)0.01);
		actor.get(1).setPosition(getWidth()/2-actor.get(0).getCenterX(), getHeight()/2-actor.get(0).getCenterY());
		actor.get(2).setPosition(getWidth()/2+actor.get(0).getCenterX(), getHeight()/2-actor.get(0).getCenterY());
		actor.get(3).setPosition(getWidth()/2-actor.get(0).getCenterX(), getHeight()/2+actor.get(0).getCenterY());
		
		table = new Table();
		this.addActor(table);
		
		for (int i = 0 ; i<provinces ; i++){
			addActor(actor.get(i));
		}
		Gdx.input.setInputProcessor(this);
	}
}
