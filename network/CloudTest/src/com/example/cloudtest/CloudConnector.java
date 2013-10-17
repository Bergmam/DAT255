package com.example.cloudtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.cloud.backend.android.sample.guestbook.GuestbookActivity;

public class CloudConnector extends Activity {

	private Intent intent;
	private Button chatButton;
	private OnTouchListener chatListener;
	private EditText nameField;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cloud_connector);
		
		nameField = (EditText) findViewById(R.id.nameField);
		
		intent = new Intent("GuestbookActivity.intent.action.Launch");
		intent.putExtra("username", nameField.getText().toString());
		
		chatButton = (Button) findViewById(R.id.chatButton);
		
		chatListener = new OnTouchListener() {
			
	    	@Override
	        public boolean onTouch(View v, MotionEvent event) {
	          switch (event.getAction() & MotionEvent.ACTION_MASK) {
	          case MotionEvent.ACTION_DOWN:
	        	  Log.d("net", "Pressed");
	        	  	intent.putExtra("username", nameField.getText().toString());
	      			startActivity(intent);    	  

	        	  return true;
	          case MotionEvent.ACTION_UP:
	            return true;
	          default:
	            return false;
	          }
	        }
	      };
	      
	      chatButton.setOnTouchListener(chatListener);
	}
	

}
