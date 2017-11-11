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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CoordinateTest {
	
	@Test
	public void testIsEqual() {
		Coordinate a = new Coordinate(5.5, 7.9, 6.30157);
		Coordinate b = new Coordinate(5.5, 7.9, 6.30157);
		Coordinate c = new Coordinate(77, 99, 111);
		
		Coordinate d = new Coordinate(0,0.01,0);
		Coordinate e = new Coordinate(0,0.1*0.1,0);
		
		assertTrue(d.isEqual(e));
		assertTrue(a.isEqual(b));
		assertFalse(a.isEqual(c));
	}
	
	@Test
	public void testEquals() {
		Coordinate a = new Coordinate(5.5, 7.9, 6.30157);
		Coordinate b = new Coordinate(5.5, 7.9, 6.30157);
		Coordinate c = new Coordinate(77, 99, 111);
		
		Coordinate d = new Coordinate(0,0.01,0);
		Coordinate e = new Coordinate(0,0.1*0.1,0);
		
		assertTrue(d.equals(e));
		assertTrue(a.equals(b));
		assertFalse(a.equals(c));
	}
	
	@Test
	public void testGetDistance() {
		Coordinate a = new Coordinate(5, 7, 6);
		Coordinate b = new Coordinate(5, 7, 6);
		Coordinate c = new Coordinate(6, 7, 6);
		Coordinate d = new Coordinate(4, 7, 6);
		Coordinate e = new Coordinate(5, 8, 6);
		Coordinate f = new Coordinate(5, 6, 6);
		Coordinate g = new Coordinate(5, 7, 7);
		Coordinate h = new Coordinate(5, 7, 5);
		Coordinate j = new Coordinate(-20, -10, -3);
		
		assertEquals(0.0, a.getDistance(b), 0.0);
		assertEquals(1.0, a.getDistance(c), 0.0);
		assertEquals(1.0, a.getDistance(d), 0.0);
		assertEquals(1.0, a.getDistance(e), 0.0);
		assertEquals(1.0, a.getDistance(f), 0.0);
		assertEquals(1.0, a.getDistance(g), 0.0);
		assertEquals(1.0, a.getDistance(h), 0.0);
		assertEquals(31.54362059117501, a.getDistance(j), 0.0);
	}
		
}
