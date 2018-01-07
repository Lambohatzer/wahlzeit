package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.PatternInstance;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlersTestSuite.class,
	ModelTestSuite.class,
	ServicesTestSuite.class,
	UtilsTestSuite.class
})
@PatternInstance(
		patternName = "TestSuite",
		participants = {
				"TestSuite Class",
				"TestClasses to be started",
				"TestSuites to be started"
		}
)
public class OverallWahlzeitTestSuite {}