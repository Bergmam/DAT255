package com.dat255.risk.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.google.cloud.backend.android.CloudEntity;
import com.google.cloud.backend.android.Consts;
import com.google.cloud.backend.android.mobilebackend.model.EntityDto;

public class DatastoreConnetion {

	public static void postData() {
		EntityDto cd = getMBSEndpoint().get(kindName, id).execute();
	    CloudEntity co = CloudEntity.createCloudEntityFromEntityDto(cd);
	    Log.i(Consts.TAG, "get: result: " + co);
}
