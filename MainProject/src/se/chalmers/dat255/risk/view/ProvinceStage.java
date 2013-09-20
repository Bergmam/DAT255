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
	private List<Actor> actor;

	public ProvinceStage(int provinces) {
		actor = new ArrayList<Actor>();
		
		for (int i = 0 ; i<provinces ; i++){
			ProvinceView provinceView = new ProvinceView(new Texture(Gdx.files.internal("Gfx/bucket.png")));
			provinceView.addListener(new ProvinceListener());
			actor.add(provinceView);
		}
		
		actor.get(0).setPosition(0, 0);
		actor.get(1).setPosition(getWidth()-64, getHeight()-64);
		actor.get(2).setPosition(getWidth()-64, 0);
		actor.get(3).setPosition(0, getHeight()-64);
		
		table = new Table();
		this.addActor(table);
		
		for (int i = 0 ; i<provinces ; i++){
			addActor(actor.get(i));
		}
		Gdx.input.setInputProcessor(this);
	}
}
