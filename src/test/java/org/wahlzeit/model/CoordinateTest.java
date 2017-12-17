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
	
	// ------------------------------------------------------------------------
	// ---------------------- CartesianCoordinate tests -----------------------
	// ------------------------------------------------------------------------
	@Test
	public void testCartesianIsEqual() {
		CartesianCoordinate a = CartesianCoordinate.createCartesianCoordinate(5.5, 7.9, 6.30157);
		CartesianCoordinate b = CartesianCoordinate.createCartesianCoordinate(5.5, 7.9, 6.30157);
		CartesianCoordinate c = CartesianCoordinate.createCartesianCoordinate(77., 99., 111.);
		
		CartesianCoordinate d = CartesianCoordinate.createCartesianCoordinate(0., 0.01, 0.);
		CartesianCoordinate e = CartesianCoordinate.createCartesianCoordinate(0., 0.1*0.1, 0.);
		
		assertTrue(d.isEqual(e));
		assertTrue(a.isEqual(b));
		assertFalse(a.isEqual(c));
	}
	
	@Test
	public void testCartesianEquals() {
		CartesianCoordinate a = CartesianCoordinate.createCartesianCoordinate(5.5, 7.9, 6.30157);
		CartesianCoordinate b = CartesianCoordinate.createCartesianCoordinate(5.5, 7.9, 6.30157);
		CartesianCoordinate c = CartesianCoordinate.createCartesianCoordinate(77., 99., 111.);
		
		CartesianCoordinate d = CartesianCoordinate.createCartesianCoordinate(0., 0.01, 0.);
		CartesianCoordinate e = CartesianCoordinate.createCartesianCoordinate(0., 0.1*0.1, 0.);
		
		assertTrue(d.equals(e));
		assertTrue(a.equals(b));
		assertFalse(a.equals(c));
	}
	
	@Test
	public void testCartesianGetDistance() {
		CartesianCoordinate a = CartesianCoordinate.createCartesianCoordinate(5., 7., 6.);
		CartesianCoordinate b = CartesianCoordinate.createCartesianCoordinate(5., 7., 6.);
		CartesianCoordinate c = CartesianCoordinate.createCartesianCoordinate(6., 7., 6.);
		CartesianCoordinate d = CartesianCoordinate.createCartesianCoordinate(4., 7., 6.);
		CartesianCoordinate e = CartesianCoordinate.createCartesianCoordinate(5., 8., 6.);
		CartesianCoordinate f = CartesianCoordinate.createCartesianCoordinate(5., 6., 6.);
		CartesianCoordinate g = CartesianCoordinate.createCartesianCoordinate(5., 7., 7.);
		CartesianCoordinate h = CartesianCoordinate.createCartesianCoordinate(5., 7., 5.);
		CartesianCoordinate j = CartesianCoordinate.createCartesianCoordinate(-20., -10., -3.);
		
		assertEquals(0.0, a.getDistance(b), Coordinate.EPSILON);
		assertEquals(1.0, a.getDistance(c), Coordinate.EPSILON);
		assertEquals(1.0, a.getDistance(d), Coordinate.EPSILON);
		assertEquals(1.0, a.getDistance(e), Coordinate.EPSILON);
		assertEquals(1.0, a.getDistance(f), Coordinate.EPSILON);
		assertEquals(1.0, a.getDistance(g), Coordinate.EPSILON);
		assertEquals(1.0, a.getDistance(h), Coordinate.EPSILON);
		assertEquals(31.54362059117501, a.getDistance(j), Coordinate.EPSILON);
	}
	
	@Test
	public void testCartesianCoordinateCreation() {
		int size = CartesianCoordinate.cartesianCoordinates.size();
		
		CartesianCoordinate.createCartesianCoordinate(-100, -100, -100);
		assertTrue(CartesianCoordinate.cartesianCoordinates.size() == size+1);
		
		CartesianCoordinate.createCartesianCoordinate(-100, -100, -100);
		assertTrue(CartesianCoordinate.cartesianCoordinates.size() == size+1);
		
		CartesianCoordinate.createCartesianCoordinate(-200, -200, -200);
		assertTrue(CartesianCoordinate.cartesianCoordinates.size() == size+2);
		
		CartesianCoordinate.createCartesianCoordinate(-200, -200, -200);
		assertTrue(CartesianCoordinate.cartesianCoordinates.size() == size+2);
	}
	
	// ------------------------------------------------------------------------
	// ---------------------- SphericCoordinate tests -----------------------
	// ------------------------------------------------------------------------
	@Test
	public void testSphericIsEqual() {
		SphericCoordinate a = SphericCoordinate.createSphericCoordinate(Math.PI, 4.9, 6.30157);
		SphericCoordinate b = SphericCoordinate.createSphericCoordinate(Math.PI, 4.9, 6.30157);
		SphericCoordinate c = SphericCoordinate.createSphericCoordinate(2., 5., 111.);
		
		SphericCoordinate d = SphericCoordinate.createSphericCoordinate(0., 0.01, 0.);
		SphericCoordinate e = SphericCoordinate.createSphericCoordinate(0., 0.1*0.1, 0.);
		
		assertTrue(d.isEqual(e));
		assertTrue(a.isEqual(b));
		assertFalse(a.isEqual(c));
	}
	
	@Test
	public void testSphericEquals() {
		SphericCoordinate a = SphericCoordinate.createSphericCoordinate(Math.PI, 4.9, 6.30157);
		SphericCoordinate b = SphericCoordinate.createSphericCoordinate(Math.PI, 4.9, 6.30157);
		SphericCoordinate c = SphericCoordinate.createSphericCoordinate(2., 5., 111.);
		
		SphericCoordinate d = SphericCoordinate.createSphericCoordinate(0., 0.01, 0.);
		SphericCoordinate e = SphericCoordinate.createSphericCoordinate(0., 0.1*0.1, 0.);
		
		assertTrue(d.equals(e));
		assertTrue(a.equals(b));
		assertFalse(a.equals(c));
	}
	
	@Test
	public void testSphericGetDistance() {
		SphericCoordinate n = SphericCoordinate.createSphericCoordinate(0., 0., 0.);
		SphericCoordinate a = SphericCoordinate.createSphericCoordinate(0., 0., 6.);
		SphericCoordinate b = SphericCoordinate.createSphericCoordinate(0., 0., 6.);
		SphericCoordinate c = SphericCoordinate.createSphericCoordinate(Math.PI, 0., 6.);
		SphericCoordinate d = SphericCoordinate.createSphericCoordinate(0., Math.PI/2., 6.);
		SphericCoordinate e = SphericCoordinate.createSphericCoordinate(Math.PI/2., Math.PI/2., 6.);
		
		assertEquals(0., a.getDistance(b), Coordinate.EPSILON);
		assertEquals(12., a.getDistance(c), Coordinate.EPSILON);
		assertEquals(6., n.getDistance(c), Coordinate.EPSILON);
		assertEquals(6., n.getDistance(d), Coordinate.EPSILON);
		assertEquals(6., n.getDistance(e), Coordinate.EPSILON);
	}
	

	@Test
	public void testSphericCoordinateCreation() {
		int size = SphericCoordinate.sphericCoordinates.size();
		
		SphericCoordinate.createSphericCoordinate(0, 0, 100);
		assertTrue(SphericCoordinate.sphericCoordinates.size() == size+1);
		
		SphericCoordinate.createSphericCoordinate(0, 0, 100);
		assertTrue(SphericCoordinate.sphericCoordinates.size() == size+1);
		
		SphericCoordinate.createSphericCoordinate(0, 0, 200);
		assertTrue(SphericCoordinate.sphericCoordinates.size() == size+2);
		
		SphericCoordinate.createSphericCoordinate(0, 0, 200);
		assertTrue(SphericCoordinate.sphericCoordinates.size() == size+2);
	}
				
	// ------------------------------------------------------------------------
	// ---------------------------- Mixed test --------------------------------
	// ------------------------------------------------------------------------	
	@Test
	public void testCartesianDistanceMixed() {
		CartesianCoordinate cc1 = CartesianCoordinate.createCartesianCoordinate(0.,0.,0.);
		CartesianCoordinate cc2 = CartesianCoordinate.createCartesianCoordinate(1.,0.,0.);
		CartesianCoordinate cc3 = CartesianCoordinate.createCartesianCoordinate(0.,1.,0.);
		
		SphericCoordinate sc1 = SphericCoordinate.createSphericCoordinate(0.,0.,0.);
		SphericCoordinate sc2 = SphericCoordinate.createSphericCoordinate(Math.PI/2., 0., 1.);
		SphericCoordinate sc3 = SphericCoordinate.createSphericCoordinate(Math.PI/2., Math.PI/2., 1.);
		
		assertTrue(cc1.getDistance(sc1) < Coordinate.EPSILON);
		assertTrue(cc2.getDistance(sc2) < Coordinate.EPSILON);
		assertTrue(cc3.getDistance(sc3) < Coordinate.EPSILON);

	}
	
	@Test
	public void testSphericDistanceMixed() {
		CartesianCoordinate cc1 = CartesianCoordinate.createCartesianCoordinate(0.,0.,0.);
		CartesianCoordinate cc2 = CartesianCoordinate.createCartesianCoordinate(1.,0.,0.);
		CartesianCoordinate cc3 = CartesianCoordinate.createCartesianCoordinate(0.,1.,0.);
		
		SphericCoordinate sc1 = SphericCoordinate.createSphericCoordinate(0.,0.,0.);
		SphericCoordinate sc2 = SphericCoordinate.createSphericCoordinate(Math.PI/2., 0., 1.);
		SphericCoordinate sc3 = SphericCoordinate.createSphericCoordinate(Math.PI/2., Math.PI/2., 1.);

		assertTrue(sc1.getDistance(cc1)+"", sc1.getDistance(cc1) < Coordinate.EPSILON);
		assertTrue(sc2.getDistance(cc2) < Coordinate.EPSILON);
		assertTrue(sc3.getDistance(cc3) < Coordinate.EPSILON);
	}
	
	@Test
	public void testAsSphericCoordinate() {
		CartesianCoordinate cc1 = CartesianCoordinate.createCartesianCoordinate(0.,0.,0.);
		CartesianCoordinate cc2 = CartesianCoordinate.createCartesianCoordinate(1.,0.,0.);
		CartesianCoordinate cc3 = CartesianCoordinate.createCartesianCoordinate(0.,1.,0.);
		
		SphericCoordinate sc1 = SphericCoordinate.createSphericCoordinate(0.,0.,0.);
		SphericCoordinate sc2 = SphericCoordinate.createSphericCoordinate(Math.PI/2., 0., 1.);
		SphericCoordinate sc3 = SphericCoordinate.createSphericCoordinate(Math.PI/2., Math.PI/2., 1.);
		
		assertTrue(cc1.asSpericCoordinate().isEqual(sc1));
		assertTrue(cc2.asSpericCoordinate().isEqual(sc2));
		assertTrue(cc3.asSpericCoordinate().isEqual(sc3));
	}
	
	@Test
	public void testAsCartesianCoordinate() {
		CartesianCoordinate cc1 = CartesianCoordinate.createCartesianCoordinate(0.,0.,0.);
		CartesianCoordinate cc2 = CartesianCoordinate.createCartesianCoordinate(1.,0.,0.);
		CartesianCoordinate cc3 = CartesianCoordinate.createCartesianCoordinate(0.,1.,0.);
		
		SphericCoordinate sc1 = SphericCoordinate.createSphericCoordinate(0.,0.,0.);
		SphericCoordinate sc2 = SphericCoordinate.createSphericCoordinate(Math.PI/2., 0., 1.);
		SphericCoordinate sc3 = SphericCoordinate.createSphericCoordinate(Math.PI/2., Math.PI/2., 1.);
		
		assertTrue(sc1.asCartesianCoordinate().isEqual(cc1));
		assertTrue(sc2.asCartesianCoordinate().isEqual(cc2));
		assertTrue(sc3.asCartesianCoordinate().isEqual(cc3));
	}
}
