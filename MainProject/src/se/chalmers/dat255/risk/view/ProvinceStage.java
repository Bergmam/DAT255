package se.chalmers.dat255.risk.view;

import se.chalmers.dat255.risk.controller.ProvinceListener;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ProvinceStage extends Stage {
	Table table;
	Actor a,b,c,d;

	public ProvinceStage() {
		
		a = new ProvinceView();
		b = new ProvinceView();
		c = new ProvinceView();
		d = new ProvinceView();
		
		a.setPosition(0, 0);
		b.setPosition(getWidth()-64, getHeight()-64);
		c.setPosition(getWidth()-64, 0);
		d.setPosition(0, getHeight()-64);
		
		a.addListener(new ProvinceListener());
		b.addListener(new ProvinceListener());
		c.addListener(new ProvinceListener());
		d.addListener(new ProvinceListener());
		table = new Table();

		this.addActor(table);
		addActor(a);
		addActor(b);
		addActor(c);
		addActor(d);
	}
}
