package org.wahlzeit.handlers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.PatternInstance;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TellFriendTest.class
})
@PatternInstance(
		patternName = "TestSuite",
		participants = {
				"TestSuite Class",
				"TestClasses to be started",
				"TestSuites to be started"
		}
)
public class HandlersTestSuite {}