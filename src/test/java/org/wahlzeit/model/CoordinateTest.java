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
		
		assertTrue(a.isEqual(b));
		assertFalse(a.isEqual(c));
	}
	
	@Test
	public void testEquals() {
		Coordinate a = new Coordinate(5.5, 7.9, 6.30157);
		Coordinate b = new Coordinate(5.5, 7.9, 6.30157);
		Coordinate c = new Coordinate(77, 99, 111);
		
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
