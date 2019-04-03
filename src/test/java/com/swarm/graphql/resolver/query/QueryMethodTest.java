package com.swarm.graphql.resolver.query;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;

import outils.JsonReader;

public class QueryMethodTest {

	public final void lancement() {
		new SwarmGraphQlApplication();
		SwarmGraphQlApplication.main(new String[0]);
	}

	@Test
	public final void testMethodsByTypeId() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BmethodsByTypeId(typeId:1)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		JSONArray methodsByTypeId = data.getJSONArray("methodsByTypeId");
	    String id = methodsByTypeId.getJSONObject(0).getString("id");
	    
	    String expectedIdResult = "1";
	    
		assertTrue(expectedIdResult.equals(id));
	}
	
	@Test
	public final void testStartingMethodsBySessionId() throws IOException, JSONException {
		lancement();
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BstartingMethodsBySessionId(sessionId:1)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		JSONArray startingMethodsBySessionId = data.getJSONArray("startingMethodsBySessionId");
	    String id = startingMethodsBySessionId.getJSONObject(0).getString("id");
	    
	    String expectedIdResult = "1";
	    
		assertTrue(expectedIdResult.equals(id));
	}
	
	@Test
	public final void testEndingMethodsBySessionId() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BendingMethodsBySessionId(sessionId:2)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		JSONArray endingMethodsBySessionId = data.getJSONArray("endingMethodsBySessionId");
	    String id = endingMethodsBySessionId.getJSONObject(0).getString("id");
	    
	    String expectedIdResult = "2";
	    
		assertTrue(expectedIdResult.equals(id));
	}
	

	

}
