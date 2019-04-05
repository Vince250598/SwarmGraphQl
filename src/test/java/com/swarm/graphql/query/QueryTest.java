package com.swarm.graphql.query;

import static org.junit.Assert.assertTrue;

import org.aspectj.lang.annotation.After;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;

import outils.JsonReader;

public class QueryTest {
	
	@Before
	public final void lancement() {
		new SwarmGraphQlApplication();
		SwarmGraphQlApplication.main(new String[0]);
	}
	
	@Test
	public final void testHello() throws Exception {

		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7Bhello%7D");
		JSONObject data = json.getJSONObject("data");
		
		JSONObject resultVoulut = new JSONObject("{\"hello\":\"hello\"}");
		System.out.println(resultVoulut);
		System.out.println(data);
		assertTrue(resultVoulut.toString().equals(data.toString()));

	}
	

}
