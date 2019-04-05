package com.swarm.graphql.query;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;

import outils.JsonReader;

public class QueryTypeTest {

	@Before
	public final void lancement() {
		new SwarmGraphQlApplication();
		SwarmGraphQlApplication.main(new String[0]);
	}
	
	
	@Test
	public final void typesBySessionIdtest() throws IOException, JSONException {
		
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BtypesBySessionId(sessionId:1)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		
		String valOptenuCorect =  "{\"typesBySessionId\":[{\"id\":\"1\"}]}";
		
		assertTrue(valOptenuCorect.equals(data.toString()));
		
	}

}
