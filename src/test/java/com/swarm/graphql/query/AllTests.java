package com.swarm.graphql.query;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.swarm.graphql.SwarmGraphQlApplication;

@RunWith(Suite.class)
@Suite.SuiteClasses({ QueryBreakpointTest.class,
	QueryInvocationTest.class,
	QueryMethodTest.class,
	QueryNamespaceTest.class,
	QuerySessionTest.class,
	QueryTaskTest.class,
	QueryTest.class,
	QueryTypeTest.class })
public class AllTests {
}
