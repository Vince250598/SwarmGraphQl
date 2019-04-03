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
		
		
		Developer developer1 = new Developer("developer1.name", "developer1.color");
		Developer developer2 = new Developer("developer2.name", "developer2.color");
		
		Product product1 = new Product("product1.name");
		Product product2 = new Product("product2.name");
		
		Task task1 = new Task(product1, "task1.title","task1.url","task1.color");
		Task task2 = new Task(product2, "task2.title","task2.url","task2.color");
		
		Date date = new Date();
		
		Session session1 = new Session(developer1, task1, "session1.description", "session1.label","session1.purpose","session1.project",date,date);
		Session session2 = new Session(developer2, task2, "session2.description", "session2.label","session2.purpose","session2.project",date,date);
		
		Namespace namespace1 = new Namespace("namespace1.name","namespace1.fullPath");
		Namespace namespace2 = new Namespace("namespace2.name","namespace2.fullPath");
		
		Type type1 = new Type(namespace1, session1, "type1.fullName","type1.fullPath", "type1.name","type1.source");
		Type type2 = new Type(namespace2, session2, "type2.fullName","type2.fullPath", "type2.name","type2.source");
		
		Breakpoint breakpoint1 = new Breakpoint(type1,"breakpoint1.start","breakpoint1.end",59);
		Breakpoint breakpoint2 = new Breakpoint(type2,"breakpoint2.start","breakpoint2.end",374);
		
		
		
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
		System.out.println(data.toString());
		
		
	}	
	
}
