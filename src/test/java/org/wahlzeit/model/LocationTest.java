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

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@PatternInstance(
		patternName = "Test",
		participants = {
				"Testing Class",
				"Component to be Tested"
		}
)
public class LocationTest {

	@Test
	public void testGetCoordinate() {
		CartesianCoordinate c = CartesianCoordinate.createCartesianCoordinate(5, 9, 73);
		Location l = new Location(c);
		
		assertSame(c, l.coordinate);
	}
	
	@Test
	public void testEquals() {
		CartesianCoordinate c1 = CartesianCoordinate.createCartesianCoordinate(5, 9, 73);
		CartesianCoordinate c2 = CartesianCoordinate.createCartesianCoordinate(5, 9, 73);
		
		Location l1 = new Location(c1);
		Location l2 = new Location(c2);
		
		assertTrue(l1.equals(l2));
		assertFalse(l1.equals(null));
	}
	
	@Test
	public void testIsEqual() {
		CartesianCoordinate c1 = CartesianCoordinate.createCartesianCoordinate(5, 9, 73);
		CartesianCoordinate c2 = CartesianCoordinate.createCartesianCoordinate(5, 9, 73);
		
		Location l1 = new Location(c1);
		Location l2 = new Location(c2);
		
		assertTrue(l1.isEqual(l2));
		assertFalse(l1.isEqual(null));
	}
		
}
