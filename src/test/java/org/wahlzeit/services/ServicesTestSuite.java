package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.PatternInstance;
import org.wahlzeit.services.mailing.ServicesMailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ServicesMailingTestSuite.class,
	EmailAddressTest.class,
	LogBuilderTest.class
})
@PatternInstance(
		patternName = "TestSuite",
		participants = {
				"TestSuite Class",
				"TestClasses to be started",
				"TestSuites to be started"
		}
)
public class ServicesTestSuite {}