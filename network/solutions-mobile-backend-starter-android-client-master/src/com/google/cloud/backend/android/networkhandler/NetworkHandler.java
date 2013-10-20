package com.google.cloud.backend.android.networkhandler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.cloud.backend.android.CloudBackendActivity;
import com.google.cloud.backend.android.CloudCallbackHandler;
import com.google.cloud.backend.android.CloudEntity;
import com.google.cloud.backend.android.CloudQuery.Order;
import com.google.cloud.backend.android.CloudQuery.Scope;
import com.google.cloud.backend.android.R;


public class NetworkHandler extends CloudBackendActivity {

	public static boolean busy = false;
	private static final String TAG = "NetworkHandler";
	private static final String BROADCAST_PROP_DURATION = "duration";
	private static final String BROADCAST_PROP_MESSAGE = "message";
	private TextView statusText;
	private static final String registerUser = "Registering User";

	private List<CloudEntity> gameVersions = new LinkedList<CloudEntity>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		busy = true;
		setContentView(R.layout.networkhandler_layout);
		Log.d("Networkhandler", "Init");

		statusText = (TextView) findViewById(R.id.statusText);
		
		Intent intent = getIntent();
		String user = null;
		String game = null;
		try{
			user = new String(intent.getExtras().getString("user"));
			Log.d(TAG, "This is a user");
		}catch(NullPointerException e){
			Log.d(TAG, "This is not a User");
		}

		try{
			game = new String(intent.getExtras().getString("game"));
			Log.d(TAG, "This is a game");
		}catch(NullPointerException e){
			Log.d(TAG, "This is not a Game");
		}
		registerUser(user);
	}

	/**
	 * Back pressing not allowed!
	 */
	@Override
	public void onBackPressed(){
		
	}

	@Override
	protected void onPostCreate() {
		super.onPostCreate();
		updateGame();
	}

	private void registerUser(String username){
		statusText.setText(registerUser);
		CloudEntity newPost = new CloudEntity("User");

		newPost.put("_owner", "" + username);

		// create a response handler that will receive the result or an error
		CloudCallbackHandler<CloudEntity> handler = new CloudCallbackHandler<CloudEntity>() {
			@Override
			public void onComplete(final CloudEntity result) {
				Log.d(TAG, "User registered");
				
				
				busy = false;
				
				Intent intent = new Intent(NetworkHandler.this, LobbyActivity.class);
				startActivity(intent);
				
				finish();
			}

			@Override
			public void onError(final IOException exception) {
				showDialog("Can't connect to the server. Please check your connection");
				Log.d(TAG, "egisterUser onError");
			}
		};

		// execute the insertion with the handler
		getCloudBackend().insert(newPost, handler);

		
	}
	//Get update from server
	public void updateGame() {
		// create a response handler that will receive the query result or an
		// error
		CloudCallbackHandler<List<CloudEntity>> handler = new CloudCallbackHandler<List<CloudEntity>>() {
			@Override
			public void onComplete(List<CloudEntity> results) {
				gameVersions = results;
				Log.d("net", "" + gameVersions.get(0).get("message"));
			}

			@Override
			public void onError(IOException exception) {
				showDialog("Can't connect to the server. Please check your connection");
				Log.d("net", "onError CLOUDCALLBACKHANDLER!!!");
			}
		};

		// execute the query with the handler
		getCloudBackend().listByKind("Game", CloudEntity.PROP_CREATED_AT,
				Order.DESC, 1, Scope.FUTURE_AND_PAST, handler);
	}


	// post a new message to server
	public void postGameToServer(String serializedGame, String username) {

		// create a CloudEntity with the new post
		CloudEntity newPost = new CloudEntity("Game");
		newPost.put("message", serializedGame);

		newPost.put("_owner", "" + username);

		// create a response handler that will receive the result or an error
		CloudCallbackHandler<CloudEntity> handler = new CloudCallbackHandler<CloudEntity>() {
			@Override
			public void onComplete(final CloudEntity result) {
				gameVersions.add(0, result);
				finish();
			}

			@Override
			public void onError(final IOException exception) {
				Log.d("net", "onError SEND MESSAGE");
				showDialog("Can't connect to the server. Please check your connection.");
			}
		};

		// execute the insertion with the handler
		getCloudBackend().insert(newPost, handler);
	}

	// handles broadcast message and show a toast
	@Override
	public void onBroadcastMessageReceived(List<CloudEntity> l) {
		for (CloudEntity e : l) {
			String message = (String) e.get(BROADCAST_PROP_MESSAGE);
			int duration = Integer.parseInt((String) e.get(BROADCAST_PROP_DURATION));
			Toast.makeText(this, message, duration).show();
		}
	}

	private void showDialog(String message) {
	    new AlertDialog.Builder(this)
	        .setMessage(message)
	        .setPositiveButton(android.R.string.ok,
	            new DialogInterface.OnClickListener() {
	              public void onClick(DialogInterface dialog, int id) {
	                dialog.dismiss();
	                finish();
	              }
	            }).show();
	  }
	
}
