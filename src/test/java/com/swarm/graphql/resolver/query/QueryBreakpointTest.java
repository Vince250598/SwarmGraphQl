package com.swarm.graphql.resolver.query;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.swarm.graphql.SwarmGraphQlApplication;
import com.swarm.graphql.model.Breakpoint;
import com.swarm.graphql.model.Developer;
import com.swarm.graphql.model.Method;
import com.swarm.graphql.model.Namespace;
import com.swarm.graphql.model.Product;
import com.swarm.graphql.model.Session;
import com.swarm.graphql.model.Task;
import com.swarm.graphql.model.Type;

import outils.JsonReader;

public class QueryBreakpointTest {

	
	private SwarmGraphQlApplication serveur;
	
	@Before
	public final void lancement() {
		new SwarmGraphQlApplication().main(new String[0]);
	}
	
	@Test
	public final void testAllBreakpoints() throws IOException, JSONException {
		
		
		
		String valOutCorect = "{\"allBreakpoints\":["
				+ "{\"charStart\":\"breakpoint1.start\","
				+ "\"charEnd\":\"breakpoint1.end\","
				+ "\"id\":\"1\","
				+ "\"type\":"
					+ "{\"fullPath\":\"type1.fullPath\","
					+ "\"session\":{"
						+ "\"task\":{\"product\":{"
							+ "\"name\":\"product1.name\","
							+ "\"id\":\"1\"},"
						+ "\"color\":\"task1.color\","
						+ "\"id\":\"1\","
						+ "\"title\":\"task1.title\","
						+ "\"url\":\"task1.url\"},"
					+ "\"purpose\":\"session1.purpose\","
					+ "\"description\":\"session1.description\","
					+ "\"project\":\"session1.project\","
					+ "\"developer\":{"
						+ "\"color\":\"developer1.color\","
						+ "\"name\":\"developer1.name\","
						+ "\"id\":\"1\"},"
					+ "\"started\":\"03-avr.-2019\","
					+ "\"finished\":\"03-avr.-2019\","
					+ "\"id\":\"1\","
					+ "\"label\":\"session1.label\"},"
				+ "\"namespace\":{"
					+ "\"fullPath\":\"namespace1.fullPath\","
					+ "\"name\":\"namespace1.name\","
					+ "\"id\":\"1\"},"
				+ "\"name\":\"type1.name\","
				+ "\"fullName\":\"type1.fullName\","
				+ "\"id\":\"1\","
				+ "\"source\":\"type1.source\"},"
				+ "\"lineNumber\":59},"
				+ ""
				+ "{\"charStart\":\"breakpoint2.start\","
				+ "\"charEnd\":\"breakpoint2.end\","
				+ "\"id\":\"2\","
				+ "\"type\":{"
					+ "\"fullPath\":\"type2.fullPath\","
					+ "\"session\":{"
						+ "\"task\":{"
							+ "\"product\":{"
								+ "\"name\":\"product2.name\","
								+ "\"id\":\"2\"},"
							+ "\"color\":\"task2.color\","
							+ "\"id\":\"2\","
							+ "\"title\":\"task2.title\","
							+ "\"url\":\"task2.url\"},"
						+ "\"purpose\":\"session2.purpose\","
						+ "\"description\":\"session2.description\","
						+ "\"project\":\"session2.project\","
						+ "\"developer\":{"
							+ "\"color\":\"developer2.color\","
							+ "\"name\":\"developer2.name\","
							+ "\"id\":\"2\"},"
						+ "\"started\":\"03-avr.-2019\","
						+ "\"finished\":\"03-avr.-2019\","
						+ "\"id\":\"2\","
						+ "\"label\":\"session2.label\"}"
					+ ",\"namespace\":{"
						+ "\"fullPath\":\"namespace2.fullPath\","
						+ "\"name\":\"namespace2.name\","
						+ "\"id\":\"2\"},"
					+ "\"name\":\"type2.name\","
					+ "\"fullName\":\"type2.fullName\","
					+ "\"id\":\"2\","
					+ "\"source\":\"type2.source\"}"
				+ ",\"lineNumber\":374}]}";
		
		
		JSONObject json = JsonReader.readJsonFromUrl("http://localhost:8080/graphql?query=%7B" + 
				"allBreakpoints%7B" + 
				"id," + 
				"type%7B" + 
				"id," + 
				"namespace%7B" + 
				"id," + 
				"name," + 
				"fullPath" + 
				"%7D" + 
				"session,%7B" + 
				"id," + 
				"developer%7B" + 
				"id," + 
				"name," + 
				"color," + 
				"%7D" + 
				"task%7B" + 
				"id," + 
				"product%7B" + 
				"id," + 
				"name" + 
				"%7D" + 
				"title," + 
				"url," + 
				"color" + 
				"%7D" + 
				"description," + 
				"label," + 
				"purpose," + 
				"project," + 
				"started," + 
				"finished" + 
				"%7D" + 
				"fullName," + 
				"fullPath," + 
				"name," + 
				"source" + 
				"%7D" + 
				"charStart," + 
				"charEnd," + 
				"lineNumber" + 
				"%7D" + 
				"%7D");
		
		//System.out.println(json.toString());
		JSONObject data = json.getJSONObject("data");
		//System.out.println(data.toString());
		//System.out.println(valOutCorect);
		assertTrue(valOutCorect.equals(data.toString()));
		
		
	}	
	
}
