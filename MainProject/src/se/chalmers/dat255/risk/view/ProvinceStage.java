package se.chalmers.dat255.risk.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ProvinceStage extends Stage {
	Table table;
	Button button;
	Button button2;

	public ProvinceStage() {
		table = new Table();

		TextButtonStyle buttonStyle = new TextButtonStyle();
		buttonStyle.font = new BitmapFont();
		buttonStyle.fontColor = Color.WHITE;
		buttonStyle.pressedOffsetY = 1f;
		buttonStyle.downFontColor = new Color(0.8f, 0.8f, 0.8f, 1f);
		button = new TextButton("Hello", buttonStyle);
		button2 = new TextButton("Hello222222",buttonStyle);
		button2.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float float1, float float2) {
				Gdx.app.log("lololo", "2222 clicked");
			};

		});
		button.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float float1, float float2) {
				Gdx.app.log("lololo", "in clicked");
			};

		});
		table.row();
		table.add(button);
		table.add(button2);
		table.setFillParent(true);
		this.addActor(table);

	}
}
