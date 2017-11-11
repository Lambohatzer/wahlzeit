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

/**
 * A Coordinate is a set of three double Values that describe a point in a
 * 3D Cartesian coordinate system.
 */
public class Coordinate {
	
	public static final Coordinate NULL_COORDINATE = new NullCoordinate();
	private static final double EPSILON = 0.0000001;
	
	private double x, y, z;
	
	/**
	 * @methodtype constructor
	 */
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
			
	/**
	 * Computes distance between from and this.
	 */
	public double getDistance(Coordinate from) {
		if(from == null) {
			throw new IllegalArgumentException();
		}
		double deltaX = this.x - from.x;
		double deltaY = this.y - from.y;
		double deltaZ = this.z - from.z;
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
	}
	
	@Override
	public boolean equals(Object o) {
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
	 * Checks if all three Coordinate-Values of this and other are the same.
	 * Returns true if they are the same, false otherwise.
	 */
	public boolean isEqual(Coordinate other) {
		if(other == null) {
			return false;
		} else if(other == this) {
			return true;
		} else {
			return 	(Math.abs(this.x - other.x) < EPSILON) && 
					(Math.abs(this.y - other.y) < EPSILON) && 
					(Math.abs(this.z - other.z) < EPSILON);
		}
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * @methodtype set
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @methodtype set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @methodtype set
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
}
