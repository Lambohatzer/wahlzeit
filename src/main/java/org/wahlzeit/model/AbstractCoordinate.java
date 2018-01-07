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


@PatternInstance(
		patternName = "Abstract Superclass",
		participants = {
				"AbstractClass",
				"ConcreteClass"
		}
)
public abstract class AbstractCoordinate implements Coordinate {

	
	@Override
	public boolean equals(Object o) {
		assertClassInvariants();
		
		if(o == null) {
			return false;
		} else if(o == this) {
			return true;
		} else if(o instanceof Coordinate) {
			return isEqual((Coordinate) o);
		} else {
			return false;
		}
	}
	
	/**
	 * @methodtype boolean-query
	 * Checks if all three Coordinate-Values of this and other are the same.
	 * Returns true if they are the same, false otherwise.
	 */
	public boolean isEqual(Coordinate c) {
		assertClassInvariants();
		
		if(c == null) {
			return false;
		} else if(c == this) {
			return true;
		} else {
			return 	this.asCartesianCoordinate().getCartesianDistance(c) < EPSILON;
		}
	}
	
	/**
	 * returns the Cartesian distance as default distance
	 */
	public double getDistance(Coordinate c) {
		assertClassInvariants();
		
		assertArgumentIsNotNull(c);
		
		return this.asCartesianCoordinate().getCartesianDistance(c);
	}
	
	/**
	 * @methodtype assertion
	 */
	protected abstract void assertClassInvariants();

	/**
	 * @methodtype assertion
	 */
	protected void assertArgumentIsNotNull(Object o) {
		if(o == null) {
			throw new IllegalArgumentException("Argument must not be null!");
		}
	}
	
	protected void assertIsValidDouble(double d) {
		if(Double.isInfinite(d)) {
			throw new IllegalArgumentException("Argument must not be infinite!");
		}
		if(Double.isNaN(d)) {
			throw new IllegalArgumentException("Argument must not be NaN!");
		}
	}
	
}
