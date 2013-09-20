package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.controller.ProvinceListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ProvinceStage extends Stage {
	Table table;
	Actor a;

	public ProvinceStage() {
		a = new ProvinceView(this);

		a.addListener(new ProvinceListener());
		a.setBounds(800 / 2 - 64 / 2, 20, 100, 100);
		table = new Table();
		table.row();
		table.add(a);
		table.setFillParent(true);
		this.addActor(table);

	}
}
