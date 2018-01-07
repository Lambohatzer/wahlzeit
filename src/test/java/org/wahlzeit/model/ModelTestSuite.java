package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.ModelPersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ModelPersistenceTestSuite.class,
	AbimottoPhotoFactoryTest.class,
	AbimottoPhotoManagerTest.class,
	AbimottoPhotoTest.class,
	AccessRightsTest.class,
	CoordinateTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	LocationTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class
})
@PatternInstance(
		patternName = "TestSuite",
		participants = {
				"TestSuite Class",
				"TestClasses to be started",
				"TestSuites to be started"
		}
)
public class ModelTestSuite {}