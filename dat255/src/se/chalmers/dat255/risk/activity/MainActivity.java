package se.chalmers.dat255.risk.activity;

import se.chalmers.dat255.risk.GDXGame;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class MainActivity extends AndroidApplication {

	@Override
	public void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize(new GDXGame(), true);
	}

}
