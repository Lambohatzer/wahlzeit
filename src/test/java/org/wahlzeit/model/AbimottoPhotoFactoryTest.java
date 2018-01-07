/*
 * Copyright (c) 2017 by Philipp Guertler, https://github.com/Lambohatzer/wahlzeit
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;

@PatternInstance(
		patternName = "Test",
		participants = {
				"Testing Class",
				"Component to be Tested"
		}
)
public class AbimottoPhotoFactoryTest {
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());	
	
	@Test
	public void testInitialize() {		
		AbimottoPhotoFactory.initialize();
		
		assertFalse(AbimottoPhotoFactory.getInstance() == null);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testSetInstanceTwice() {
		AbimottoPhotoFactory apf = new AbimottoPhotoFactory();
		
		AbimottoPhotoFactory.setInstance(apf);
		assertTrue(AbimottoPhotoFactory.getInstance() == apf);

		AbimottoPhotoFactory.setInstance(apf);
		assertTrue(false);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInstanceWithWrongInput() {
		PhotoFactory pf = new PhotoFactory();
		AbimottoPhotoFactory.setInstance(pf);
		assertTrue(false);
	}
	
	@Test
	public void testCreatePhoto() {
		AbimottoPhotoFactory.initialize();
		Photo photo = AbimottoPhotoFactory.getInstance().createPhoto();
		
		assertTrue(photo instanceof AbimottoPhoto);
	}
	
	@Test
	public void testCreatePhotoId() {
		AbimottoPhotoFactory.initialize();
		PhotoId id = new PhotoId(42);
		Photo photo = AbimottoPhotoFactory.getInstance().createPhoto(id);
		
		assertTrue(photo.getId().isEqual(id));
	}
	
	@Test
	public void testCreateAbimottoPhoto() {
		AbimottoPhotoFactory.initialize();
		Photo photo = AbimottoPhotoFactory.getInstance().createAbimottoPhoto();
		
		assertTrue(photo instanceof AbimottoPhoto);
	}
	
	@Test
	public void testCreateAbimottoPhotoId() {
		AbimottoPhotoFactory.initialize();
		PhotoId id = new PhotoId(42);
		Photo photo = AbimottoPhotoFactory.getInstance().createAbimottoPhoto(id);
		
		assertTrue(photo.getId().isEqual(id));
	}
	
	
	
}
