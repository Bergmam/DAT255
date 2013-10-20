package com.google.cloud.backend.android.networkhandler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

public class LobbyActivity extends CloudBackendActivity{

	// UI components
	private TextView tvPosts;


	// a list of posts on the UI
	List<CloudEntity> posts = new LinkedList<CloudEntity>();

	// initialize UI
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lobby_layout);
		Log.d("net", "Init Lobby");
		tvPosts = (TextView) findViewById(R.id.tvPosts);

	}

	@Override
	protected void onPostCreate() {
		super.onPostCreate();
		listAllPosts();
	}

	// execute query "SELECT * FROM Guestbook ORDER BY _createdAt DESC LIMIT 50"
	// this query will be re-executed when matching entity is updated
	private void listAllPosts() {

		// create a response handler that will receive the query result or an error
		CloudCallbackHandler<List<CloudEntity>> handler = new CloudCallbackHandler<List<CloudEntity>>() {
			@Override
			public void onComplete(List<CloudEntity> results) {
				posts = results;
				updateGuestbookUI();
			}

			@Override
			public void onError(IOException exception) {
				handleEndpointException(exception);
			}
		};

		// execute the query with the handler, 6 is the maximum amount of players allowed in a lobby
		getCloudBackend().listByKind("User", CloudEntity.PROP_CREATED_AT, Order.DESC, 6,
				Scope.FUTURE_AND_PAST, handler);
	}

	private void handleEndpointException(IOException e) {
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}

	// convert posts into string and update UI
	private void updateGuestbookUI() {
		final StringBuilder sb = new StringBuilder();
		for (CloudEntity post : posts) {
			sb.append(post.getOwner() + ": " + post.get("message") + "\n");
		}
		tvPosts.setText(sb.toString());
	}
}
