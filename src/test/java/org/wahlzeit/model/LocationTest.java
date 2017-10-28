package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class LocationTest {

	@Test
	public void testGetCoordinate() {
		Coordinate c = new Coordinate(5,9,73);
		Location l = new Location(c);
		
		assertSame(c, l.coordinate);
	}
	
}
