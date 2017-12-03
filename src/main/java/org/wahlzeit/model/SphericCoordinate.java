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
 * A SphericCoordinate is a set of three double Values (latitude, longitude, radius), 
 * that describe a point in a 3D Spheric coordinate system.
 */
public class SphericCoordinate extends AbstractCoordinate {

	private double latitude, longitude, radius;
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {	
		assertValidLatitude(latitude);
		assertValidLongitude(longitude);
		assertValidRadius(radius);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype cloning
	 */
	public SphericCoordinate(SphericCoordinate toClone) {
		assertArgumentIsNotNull(toClone);
		
		assertValidLatitude(toClone.latitude);
		assertValidLongitude(toClone.longitude);
		assertValidRadius(toClone.radius);
		
		this.latitude = toClone.latitude;
		this.longitude = toClone.longitude;	
		this.radius = toClone.radius;
		
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
	 * @methodtype setter
	 */
	public void setLatitude(double latitude) {
		assertClassInvariants();

		assertValidLatitude(latitude);
		
		this.latitude = latitude;
	}

	/**
	 * @methodtype setter
	 */
	public void setLongitude(double longitude) {
		assertClassInvariants();
		
		assertValidLongitude(longitude);
		
		this.longitude = longitude;
	}

	/**
	 * @methodtype setter
	 */
	public void setRadius(double radius) {
		assertClassInvariants();
		
		assertValidRadius(radius);
		
		this.radius = radius;
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
		return new CartesianCoordinate(x,y,z);
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
		return new SphericCoordinate(this);
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
		assertValidLongitude(this.longitude);
		assertValidLatitude(this.latitude);
		assertValidRadius(this.radius);
	}

	/**
	 * @methodtype assertion
	 */
	private void assertValidLongitude(double longitude) {
		assert (longitude >= 0.0) && (longitude <= 2.0 * Math.PI) : "longitude must be in range [0, 2*PI]!";		
	}

	/**
	 * @methodtype assertion
	 */
	private void assertValidLatitude(double latitude) {
		assert (latitude >= 0.0) && (latitude <= Math.PI) : "latitude must be in range [0, PI]!";		
	}

	/**
	 * @methodtype assertion
	 */
	private void assertValidRadius(double radius) {
		assert radius >= 0.0 : "radius must be greater than 0!";
	}
	
}
