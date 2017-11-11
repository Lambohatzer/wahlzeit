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

public class NullCoordinate extends Coordinate {

	/**
	 * @methodtype convenience
	 */
	public NullCoordinate() {
		this(Double.NaN, Double.NaN, Double.NaN);
	}
	
	public NullCoordinate(double x, double y, double z) {
		super(Double.NaN, Double.NaN, Double.NaN);
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	@Override
	public boolean isEqual(Coordinate other) {
		return false;
	}
	
	@Override
	public double getDistance(Coordinate from) {
		return Double.NaN;
	}
	
	@Override
	public void setX(double x) {
		// do nothing, this.x is still Double.NaN
	}
	
	@Override
	public void setY(double y) {
		// do nothing, this.x is still Double.NaN
	}
	
	@Override
	public void setZ(double z) {
		// do nothing, this.x is still Double.NaN
	}

}
