package se.chalmers.dat255.risk.activity;

import se.chalmers.dat255.risk.net.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateGameActivity extends Activity {

	private String[] spinnerItems;
	private OnTouchListener startListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.startgame_layout);
		
		spinnerItems=new String[5];
        spinnerItems[0]="1";
        spinnerItems[1]="2";
        spinnerItems[2]="3";
        spinnerItems[3]="4";
        spinnerItems[4]="5";
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this,
        android.R.layout.simple_spinner_item, spinnerItems);
        s.setAdapter(adapter);
        
        final EditText nameField = (EditText) findViewById(R.id.nameField);
        Button startButton = (Button) findViewById(R.id.startbutton);
        
        startListener = new OnTouchListener() {
			
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
	        	  }

	        	  return true;
	          case MotionEvent.ACTION_UP:
	            return true;
	          default:
	            return false;
	          }
	        }
	      };
        
	      startButton.setOnTouchListener(startListener);
	}
	private boolean checkUsername(String name){
		return true;
	}
}
