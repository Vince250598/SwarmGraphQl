package com.swarm.graphql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;

import outils.JsonReader;

public class QueryBreakpointTest {

	
	private SwarmGraphQlApplication serveur;
/*
	@Before
	public final void lancement() {
		new SwarmGraphQlApplication().main(new String[0]);
	}
*/
	@Test
	public final void testAllBreakpoints() throws IOException, JSONException {
		
		System.out.println("testAllBreakpoints");
		
		String valOutCorect = "{\"allBreakpoints\":["
				+ "{\"id\":\"1\"},"
				+ "{\"id\":\"2\"}]}";
		
		
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7B" + 
				"allBreakpoints%7B" + 
				"id," +
				"%7D" + 
				"%7D");
		
		//System.out.println(json.toString());
		JSONObject data = json.getJSONObject("data");
		//System.out.println(data.toString());
		//System.out.println(valOutCorect);
		assertEquals(valOutCorect,data.toString());	
	}	
	
}
