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
	
	@Test
	public final void typesBySessionIdtest() throws IOException, JSONException {
		
		System.out.println("typesBySessionIdtest");
		
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BtypesBySessionId(sessionId:1)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		
		String valOptenuCorect =  "{\"typesBySessionId\":[{\"id\":\"1\"}]}";
		
		assertEquals(valOptenuCorect,data.toString());
		
	}

}
