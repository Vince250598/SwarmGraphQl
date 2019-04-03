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

public class QueryNamespaceTest {

	@Before
	public final void lancement() {
		new SwarmGraphQlApplication();
		SwarmGraphQlApplication.main(new String[0]);
	}

	@Test
	public final void testNamespaceByFullPath() throws IOException, JSONException {
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7BnamespaceByFullPath(fullPath:%22namespace1.fullPath%22)%7Bid%7D%7D");
		JSONObject data = json.getJSONObject("data");
	    JSONObject namespaceByFullPath = data.getJSONObject("namespaceByFullPath");
	    String id = namespaceByFullPath.getString("id");
	    
	    String expectedIdResult = "1";
	    
		assertTrue(expectedIdResult.equals(id));
	}

}
