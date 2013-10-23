package se.chalmers.dat255.risk.activity;

import se.chalmers.dat255.risk.net.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class JoinGameActivity extends Activity{

	private OnTouchListener joinListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.joingame_layout);

		final EditText nameField = (EditText) findViewById(R.id.nameField2);
		Button joinButton = (Button) findViewById(R.id.joinGame);

		joinListener = new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN:
					//TODO
					String username = nameField.getText().toString();
					User user;

					if(checkUsername(username)){
						//Create lobby activity
						//Set max players to spinner value (intent)
						user = new User(username);

						Intent intent = new Intent("NetworkHandler.intent.action.Launch");
						intent.putExtra("user", username);
						intent.putExtra("game", "ThisisagameFYI");
						startActivity(intent);
						
						finish();
					}

					return true;
				case MotionEvent.ACTION_UP:
					return true;
				default:
					return false;
				}
			}
		};

		joinButton.setOnTouchListener(joinListener);
	}
	
	private boolean checkUsername(String name){
		if(name.length()>1 && name.length()<15)
			return true;
		return false;
	}
}
