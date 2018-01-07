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

import java.util.ArrayList;

/**
 * A CartesianCoordinate is a set of three double Values (x, y, z), 
 * that describe a point in a 3D Cartesian coordinate system.
 */
@PatternInstance(
		patternName = "Value Object",
		participants = {
				"Abstract Superclass",
				"Value Object"
		}
)
public class CartesianCoordinate extends AbstractCoordinate {
		
	private double x, y, z;

	protected static ArrayList<Coordinate> cartesianCoordinates = new ArrayList<>();
	
	public static CartesianCoordinate createCartesianCoordinate(double x, double y, double z) {
		CartesianCoordinate coordinate = new CartesianCoordinate(x,y,z);
		
		if(cartesianCoordinates.contains(coordinate)) {
			return (CartesianCoordinate) cartesianCoordinates.get(cartesianCoordinates.indexOf(coordinate));
		} else {
			cartesianCoordinates.add(coordinate);
			return coordinate;
		}
	}
	
	/**
	 * @methodtype constructor
	 */
	private CartesianCoordinate(double x, double y, double z) {
		assertIsValidDouble(x);
		assertIsValidDouble(y);
		assertIsValidDouble(z);
		this.x = x;
		this.y = y;
		this.z = z;
		
		assertClassInvariants();
	}
			
	/**
	 * @methodtype getter
	 */
	public double getX() {
		assertClassInvariants();
		
		return x;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getY() {
		assertClassInvariants();
		
		return y;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getZ() {
		assertClassInvariants();
		
		return z;
	}

	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		
		return this;
	}

	/**
	 * @methodtype getter
	 */
	public double getCartesianDistance(Coordinate c) {
		assertClassInvariants();
		
		assertArgumentIsNotNull(c);
		
		double deltaX = this.x - c.asCartesianCoordinate().x;
		double deltaY = this.y - c.asCartesianCoordinate().y;
		double deltaZ = this.z - c.asCartesianCoordinate().z;
		
		assertClassInvariants();
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
	}
	
	/**
	 * @methodtype conversion
	 */
	public SphericCoordinate asSpericCoordinate() {
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		return SphericCoordinate.createSphericCoordinate(latitude, longitude, radius);
	}
	
	/**
	 * @methodtype getter
	 */
	public double getSphericDistance(Coordinate c) {
		assertClassInvariants();
		
		assertArgumentIsNotNull(c);
		
		return this.asSpericCoordinate().getSphericDistance(c);
	}
		
	@Override
	public String toString() {
		return "[x="+x+", y="+y+", z="+z+"]";
	}
	
	@Override
	protected void assertClassInvariants() {
		try {
			assertIsValidDouble(x);
			assertIsValidDouble(y);
			assertIsValidDouble(z);
		} catch(IllegalArgumentException e) {
			throw new IllegalStateException("Illegal State in CartesianCoordinate: " + e.getMessage());
		}
	}	
}
