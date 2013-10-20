package com.google.cloud.backend.android.networkhandler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
		Log.d("net", "Init");
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

		// execute the query with the handler
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
			sb.append(post.getOwner() + "\n");
		}
		tvPosts.setText(sb.toString());
	}

	// removing the domain name part from email address
	private String getCreatorName(CloudEntity b) {
		//TODO
		if (b.getOwner() != null) {
			return b.getOwner();
		} else {
			return "<anonymous>";
		}
	}

	// handles broadcast message and show a toast
	@Override
	public void onBroadcastMessageReceived(List<CloudEntity> l) {
		for (CloudEntity e : l) {
			String message = (String) e.get("_owner");
			int duration = Integer.parseInt((String) e.get("duration"));
			Toast.makeText(this, message, duration).show();
		}
	}
}
