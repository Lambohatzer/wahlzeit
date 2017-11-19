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
public class CartesianCoordinate implements Coordinate{
		
	private double x, y, z;
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
				
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		} else if(o == this) {
			return true;
		} else if(o instanceof CartesianCoordinate) {
			return isEqual((CartesianCoordinate) o);
		} else {
			return false;
		}
	}
	
	/**
	 * @methodtype getter
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * @methodtype getter
	 */
	public double getCartesianDistance(Coordinate c) {
		return this.getDistance(c);
	}
	
	/**
	 * @methodtype conversion
	 */
	public SphericCoordinate asSpericCoordinate() {
		double radius = Math.sqrt(x*x+y*y+z*z);
		double latitude;
		if(radius > 0.) {
			latitude  = Math.acos(z/radius);
		} else {
			latitude = 0.;
		}
		double longitude;
		if(x > 0) {
			longitude = Math.atan(y/x);
		} else if(x == 0) {
			longitude = Math.signum(y)*(Math.PI/2.);
		} else if(y >= 0) {
			longitude = Math.atan(y/x)+Math.PI;
		} else {
			longitude = Math.atan(y/x)-Math.PI;
		}
		return new SphericCoordinate(latitude, longitude, radius);
	}
	
	/**
	 * @methodtype getter
	 */
	public double getSphericDistance(Coordinate c) {
		return this.asSpericCoordinate().getDistance(c);
	}
	
	/**
	 * @methodtype getter
	 * Computes distance between from and this.
	 */
	public double getDistance(Coordinate c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		double deltaX = this.x - c.asCartesianCoordinate().x;
		double deltaY = this.y - c.asCartesianCoordinate().y;
		double deltaZ = this.z - c.asCartesianCoordinate().z;
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
	}

	/**
	 * @methodtype boolean-query
	 * Checks if all three Coordinate-Values of this and other are the same.
	 * Returns true if they are the same, false otherwise.
	 */
	public boolean isEqual(Coordinate c) {
		if(c == null) {
			return false;
		} else if(c == this) {
			return true;
		} else {
			return 	this.getDistance(c) < EPSILON;
		}
	}
	
	@Override
	public String toString() {
		return "[x="+x+", y="+y+", z="+z+"]";
	}
	
}
