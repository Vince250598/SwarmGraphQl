package com.swarm.graphql.query;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;

import outils.JsonReader;

public class QueryTaskTest {

	public final void lancement() {
		new SwarmGraphQlApplication();
		SwarmGraphQlApplication.main(new String[0]);
	}
	
	
	@Test
	public final void allTaskTest() throws IOException, JSONException {
		
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BallTasks%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		
		String valObtenuCorect = "{\"allTasks\":[{\"id\":\"1\"},{\"id\":\"2\"}]}";
		
		
		//System.out.println(valObtenuCorect);
		//System.out.println(data.toString());
		assertTrue(valObtenuCorect.equals(data.toString()));
	}
	
	
	@Test
	public final void getBreakpointGraphDataTest() throws IOException, JSONException {
		lancement();
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BgetBreakpointGraphData(taskId:1)%7D");
		JSONObject data = json.getJSONObject("data");
		
		String corect = "{\"getBreakpointGraphData\":\"[{ \\\"data\\\": { \\\"id\\\": \\\"Ttype1.fullName\\\", \\\"label\\\": \\\"type1.fullName\\\", \\\"shape\\\": \\\"roundrectangle\\\", \\\"color\\\": \\\"#888\\\"}},{ \\\"data\\\": { \\\"id\\\": \\\"B1\\\", \\\"shape\\\": \\\"circle\\\", \\\"label\\\": \\\"60 developer1.name\\\", \\\"dev\\\": 1,\\\"color\\\": \\\"developer1.color\\\",\\\"parent\\\": \\\"Ttype1.fullName\\\"},\\\"position\\\": { \\\"x\\\": 150, \\\"y\\\": 40} }]\"}";
		
		//System.out.println(corect);
		//System.out.println(data.toString());
		assertTrue(corect.equals(data.toString()));
	}

}
