package com.dat255.risk.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;

public class SendObject {


	public static void sendMessage(){

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		JSONObject obj=new JSONObject();
		JSONArray registrationsIDList = new JSONArray();

		Query newsQuery = new Query();
		List<Entity> results =  datastore.prepare(newsQuery).asList(
				FetchOptions.Builder.withDefaults());

		if(results!=null){
			for(int j=0;j<results.size();j++){
				Entity entity=results.get(j);
				if(entity!=null){
					String ID=(String) entity.getProperty("Registration ID");
					if(ID!=null){
						registrationsIDList.put(ID);
					}
				}
			}
		}

		try {
			obj.put("Test", "Message");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		//Sending message to GCM for devices


		try {
			URL url = new URL("https://android.googleapis.com/gcm/send");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json ; charset=utf-8");
			connection.setRequestProperty("Authorization", "key=AIzaSyCcewuoEyAfP1_FabkbqvM_JCE9DKyaVik");

			OutputStream writer = connection.getOutputStream();
			Entity tmp=new Entity("JSON");
			tmp.setProperty("Message", obj.toString());
			datastore.put(tmp);
			writer.write(obj.toString().getBytes());
			writer.close();

			Entity device=new Entity("Messages Results");
			device.setProperty("Response Code", connection.getResponseCode());
			device.setProperty("Response Message", connection.getResponseMessage());
			datastore.put(device);

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

			} else {
				// Server returned HTTP error code.
			}
		} catch (MalformedURLException ex) {
			// ...
		} catch (IOException ex1) {
			// ...
		}
	}
}
