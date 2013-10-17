package com.google.cloud.backend.android;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.google.cloud.backend.android.CloudQuery.Order;
import com.google.cloud.backend.android.CloudQuery.Scope;

import se.chalmers.dat255.risk.model.Game;
import android.util.Log;
import android.widget.Toast;


public class Networkhandler extends CloudBackendActivity {


	private static final String BROADCAST_PROP_DURATION = "duration";
	private static final String BROADCAST_PROP_MESSAGE = "message";
	
	private List<CloudEntity> gameVersions = new LinkedList<CloudEntity>();

	// Constructor
	public Networkhandler() {

	}

	@Override
	protected void onPostCreate() {
		super.onPostCreate();
		updateGame();
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
				Log.d("net", "onError CLOUDCALLBACKHANDLER!!!");
			}
		};

		// execute the query with the handler
		getCloudBackend().listByKind("Game", CloudEntity.PROP_CREATED_AT,
				Order.DESC, 1, Scope.FUTURE_AND_PAST, handler);
	}

	//Serialize game
	public void sendGame(Game game) {
		// PERSIST
		String filename = "game.txt";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(game);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		String serializedGame = null;
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (sc.hasNextLine()) {
			serializedGame = sc.nextLine();
			Log.d("net", serializedGame);
		}
		postGameToServer(serializedGame, game.getActivePlayer().getName());
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
			}

			@Override
			public void onError(final IOException exception) {
				Log.d("net", "onError SEND MESSAGE");
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
}
