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
 * A SphericCoordinate is a set of three double Values (latitude, longitude, radius), 
 * that describe a point in a 3D Spheric coordinate system.
 */
public class SphericCoordinate extends AbstractCoordinate {

	private double latitude, longitude, radius;

	protected static ArrayList<Coordinate> sphericCoordinates = new ArrayList<>();
	
	public static SphericCoordinate createSphericCoordinate(double latitude, double longitude, double radius) {
		SphericCoordinate coordinate = new SphericCoordinate(latitude, longitude, radius);
		
		if(sphericCoordinates.contains(coordinate)) {
			return (SphericCoordinate) sphericCoordinates.get(sphericCoordinates.indexOf(coordinate));
		} else {
			sphericCoordinates.add(coordinate);
			return coordinate;
		}
	}
	
	/**
	 * @methodtype constructor
	 */
	private SphericCoordinate(double latitude, double longitude, double radius) {	
		assertValidLatitude(latitude);
		assertValidLongitude(longitude);
		assertValidRadius(radius);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
		assertClassInvariants();
	}
		
	/**
	 * @methodtype getter
	 */
	public double getLatitude() {
		assertClassInvariants();
		
		return latitude;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getLongitude() {
		assertClassInvariants();
		
		return longitude;
	}

	/**
	 * @methodtype getter
	 */
	public double getRadius() {
		assertClassInvariants();
		
		return radius;
	}
		
	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		
		double x = radius*Math.sin(latitude)*Math.cos(longitude);
		double y = radius*Math.sin(latitude)*Math.sin(longitude);
		double z = radius*Math.cos(latitude);

		assertClassInvariants();
		return CartesianCoordinate.createCartesianCoordinate(x,y,z);
	}

	/**
	 * @methodtype getter
	 */
	public double getCartesianDistance(Coordinate c) {
		assertClassInvariants();
		
		assertArgumentIsNotNull(c);
		
		return this.asCartesianCoordinate().getCartesianDistance(c);
	}
	
	/**
	 * @methodtype conversion, well, kind of
	 */
	public SphericCoordinate asSpericCoordinate() {
		assertClassInvariants();
		return this;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getSphericDistance(Coordinate c) {
		assertClassInvariants();
		
		assertArgumentIsNotNull(c);
		
		SphericCoordinate other = c.asSpericCoordinate();
		double ret = Math.sqrt(
				this.radius*this.radius + other.radius*other.radius -
				2.*this.radius*other.radius*(
						Math.sin(this.latitude)*Math.sin(other.latitude)*Math.cos(this.longitude-other.longitude) + 
						Math.cos(this.latitude)*Math.cos(other.latitude)
				)
		);

		assertClassInvariants();
		return ret; 
	}
		
	@Override
	public String toString() {
		return "[latitude="+latitude+", longitude="+longitude+", radius="+radius+"]";
	}

	/**
	 * @methodtype assertion
	 */
	@Override
	protected void assertClassInvariants() {
		try {
			assertValidLongitude(this.longitude);
			assertValidLatitude(this.latitude);
			assertValidRadius(this.radius);
		} catch(IllegalArgumentException e) {
			throw new IllegalStateException("Illegal State in SphericCoordinate: " + e.getMessage());
		}
	}

	/**
	 * @methodtype assertion
	 */
	private void assertValidLongitude(double longitude) {
		if((longitude < 0.0) || (longitude > 2.0 * Math.PI)) {
			throw new IllegalArgumentException("longitude must be in range [0, 2*PI]!");		
		}
	}

	/**
	 * @methodtype assertion
	 */
	private void assertValidLatitude(double latitude) {
		if((latitude < 0.0) || (latitude > Math.PI)) {
			throw new IllegalArgumentException("latitude must be in range [0, PI]!");		
		}
	}

	/**
	 * @methodtype assertion
	 */
	private void assertValidRadius(double radius) {
		if(radius < 0.0) {
			throw new IllegalArgumentException("radius must be greater than 0!");
		}
	}
	
}
