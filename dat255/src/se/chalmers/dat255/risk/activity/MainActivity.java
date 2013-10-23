package se.chalmers.dat255.risk.activity;

import se.chalmers.dat255.risk.GDXGame;
import se.chalmers.dat255.risk.model.Card;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.google.cloud.backend.android.networkhandler.NetworkHandler;

public class MainActivity extends Activity{

	private OnTouchListener createListener;
	private OnTouchListener joinListener;
	
	@Override
	public void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button createGameButton = (Button) findViewById(R.id.createGameButton);
		Button joinGameButton = (Button) findViewById(R.id.joinGameButton);
		createListener = new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN:
//					Networkhandler nH = new Networkhandler();
//					nH.postGameToServer("Thisisatestfile", "thisisnotmyusername");
					
					Intent intent = new Intent(MainActivity.this, CreateGameActivity.class);
					startActivity(intent); 

					return true;
				case MotionEvent.ACTION_UP:
					return true;
				default:
					return false;
				}
			}
		};

		joinListener = new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN:
					
					Intent intent = new Intent(MainActivity.this, JoinGameActivity.class);
					startActivity(intent); 

					return true;
				case MotionEvent.ACTION_UP:
					return true;
				default:
					return false;
				}
			}
		};
		joinGameButton.setOnTouchListener(joinListener);
		createGameButton.setOnTouchListener(createListener);
//		initialize(new GDXGame(), true);

	}

}
