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

public class NullCoordinate implements Coordinate {

	/**
	 * @methodtype constructor
	 */
	public NullCoordinate() {}
		
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate(Double.NaN, Double.NaN, Double.NaN);
	}

	/**
	 * @methodtype getter
	 */
	public double getCartesianDistance(Coordinate c) {
		return Double.NaN;
	}
	
	/**
	 * @methodtype conversion
	 */
	public SphericCoordinate asSpericCoordinate() {
		return new SphericCoordinate(Double.NaN, Double.NaN, Double.NaN);
	}
	
	/**
	 * @methodtype getter
	 */
	public double getSphericDistance(Coordinate c) {
		return Double.NaN;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getDistance(Coordinate c) {
		return Double.NaN;
	}

	/**
	 * @methodtype boolean-query
	 */
	public boolean isEqual(Coordinate c) {
		return false;
	}
}
