package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.ServicesMailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ServicesMailingTestSuite.class,
	EmailAddressTest.class,
	LogBuilderTest.class
})
public class ServicesTestSuite {}