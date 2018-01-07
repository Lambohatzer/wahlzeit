package org.wahlzeit.services.mailing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.PatternInstance;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	EmailServiceTest.class
})
@PatternInstance(
		patternName = "TestSuite",
		participants = {
				"TestSuite Class",
				"TestClasses to be started",
				"TestSuites to be started"
		}
)
public class ServicesMailingTestSuite {}