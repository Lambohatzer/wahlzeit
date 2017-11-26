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
		assertLatitudeAndLongitude(latitude, longitude);
		this.latitude = latitude;			//0 <= latitude <= PI
		this.longitude = longitude;			//0 <= longitude <= 2PI
		this.radius = radius;
	}
	
	/**
	 * @methodtype cloning
	 */
	public SphericCoordinate(SphericCoordinate toClone) {
		this.latitude = toClone.latitude;
		this.longitude = toClone.longitude;	
		this.radius = toClone.radius;
	}
	
	/**
	 * @methodtype assert
	 */
	private void assertLatitudeAndLongitude(double latitude, double longitude) {
		if(latitude > Math.PI || latitude < 0) {
			throw new IllegalArgumentException();
		}
		if(longitude > Math.PI*2. || longitude < 0) {
			throw new IllegalArgumentException();
		}
		return;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * @methodtype getter
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype getter
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @methodtype setter
	 */
	public void setLantitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @methodtype setter
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @methodtype setter
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
		
	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius*Math.sin(latitude)*Math.cos(longitude);
		double y = radius*Math.sin(latitude)*Math.sin(longitude);
		double z = radius*Math.cos(latitude);
		return new CartesianCoordinate(x,y,z);
	}

	/**
	 * @methodtype getter
	 */
	public double getCartesianDistance(Coordinate c) {
		return this.asCartesianCoordinate().getCartesianDistance(c);
	}
	
	/**
	 * @methodtype conversion, well, kind of
	 */
	public SphericCoordinate asSpericCoordinate() {
		return new SphericCoordinate(this);
	}
	
	/**
	 * @methodtype getter
	 */
	public double getSphericDistance(Coordinate c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
		SphericCoordinate other = c.asSpericCoordinate();
		double ret = Math.sqrt(
				this.radius*this.radius + other.radius*other.radius -
				2.*this.radius*other.radius*(
						Math.sin(this.latitude)*Math.sin(other.latitude)*Math.cos(this.longitude-other.longitude) + 
						Math.cos(this.latitude)*Math.cos(other.latitude)
				)
		);
		return ret; 
	}
		
	@Override
	public String toString() {
		return "[latitude="+latitude+", longitude="+longitude+", radius="+radius+"]";
	}

}
