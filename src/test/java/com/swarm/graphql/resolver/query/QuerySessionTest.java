package com.swarm.graphql.resolver.query;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;

import outils.JsonReader;

public class QuerySessionTest {
	
	public final void lancement() {
		new SwarmGraphQlApplication();
		SwarmGraphQlApplication.main(new String[0]);
	}

	@Test
	public final void testSessionsByTaskIdAndDeveloperId() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BsessionsByTaskIdAndDeveloperId(taskId:1,developerId:1)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
		JSONArray sessionsByTaskIdAndDeveloperId = data.getJSONArray("sessionsByTaskIdAndDeveloperId");
	    String id = sessionsByTaskIdAndDeveloperId.getJSONObject(0).getString("id");
	    
	    String expectedIdResult = "1";
	    
		assertTrue(expectedIdResult.equals(id));
	}
	
	@Test
	public final void testCountElements() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BcountElements(sessionId:1)%7D");
		JSONObject data = json.getJSONObject("data");
	    String count = data.getString("countElements");
	    
	    String expectedIdResult = "2";
	    
		assertTrue(expectedIdResult.equals(count));
	}
	
	@Test
	public final void testGetGraphData() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BgetGraphData(sessionId:1,addType:true)%7D");
		JSONObject data = json.getJSONObject("data");
	    String result = data.getString("getGraphData");
	    
	    String expectedIdResult = "[{ \"group\": \"nodes\", \"data\": "
	    		+ "{ \"id\": \"T1\", \"label\": \"type1.fullName\", \"shape\": \"roundrectangle\", \"color\": \"#888\"}},"
	    		+ "{ \"group\": \"nodes\", \"data\": "
	    		+ "{ \"id\": \"M1\", \"label\": \"type1.name. method1.name\", \"color\": \"#0e1991\",\"parent\": \"T1\"}},"
	    		+ "{ \"group\": \"edges\", \"data\":"
	    		+ "{ \"id\": \"I1\", \"source\": \"M1\", \"target\": \"M2\", \"line-color\": \"light-gray\", \"target-arrow-color\": \"light-gray\", \"label\": \"[1]\" }}]";
	    
		assertTrue(expectedIdResult.equals(result));
	}
	
	@Test
	public final void testGetStackData() throws IOException, JSONException {
		lancement();
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BgetStackData(sessionId:1)%7D");
		JSONObject data = json.getJSONObject("data");
	    String result = data.getString("getStackData");
	    
	    String expectedIdResult = "[{ \"group\": \"nodes\", \"data\": "
	    		+ "{ \"id\": \"P1-M1\", \"label\": \"type1.name method1.name()\", \"opacity\": \"1.0\", \"color\": \"#0e1991\"}},"
	    		+ "{ \"group\": \"nodes\", \"data\": "
	    		+ "{ \"id\": \"P1-M2\", \"label\": \"type2.name method2.name()\", \"opacity\": \"1.0\", \"color\": \"#578ab0\"}},"
	    		+ "{ \"group\": \"edges\", \"data\": "
	    		+ "{ \"id\": \"P1-I1\", \"source\": \"P1-M1\", \"target\": \"P1-M2\" , \"label\" : 1, \"linecolor\": \"black\", \"style\": \"solid\"}}]";
	    
		assertTrue(expectedIdResult.equals(result));
	}
	
	@Test
	public final void testGetInterPathEdges() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BgetInterPathEdges(sessionId:1)%7D");
		JSONObject data = json.getJSONObject("data");
	    String result = data.getString("getInterPathEdges");
	    
	    String expectedIdResult = "[]";
	    
		assertTrue(expectedIdResult.equals(result));
	}

}
