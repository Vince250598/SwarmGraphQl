package com.swarm.graphql.query;

import static org.junit.Assert.*;

import java.io.IOException;

import org.aspectj.lang.annotation.After;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;

import outils.JsonReader;

public class QueryInvocationTest {
	
	@Before
	public final void lancement() {
		new SwarmGraphQlApplication();
		SwarmGraphQlApplication.main(new String[0]);
	}

	@Test
	public final void testInvocationsByMethods() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BinvocationsByMethods(sessionId:1,invokingId:1,invokedId:2)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		JSONArray invocationsByMethods = data.getJSONArray("invocationsByMethods");
	    String id = invocationsByMethods.getJSONObject(0).getString("id");
	    
	    String expectedIdResult = "1";
	    
		assertTrue(expectedIdResult.equals(id));
	}

}
