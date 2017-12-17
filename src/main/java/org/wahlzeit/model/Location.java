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
 *
 */
public class Location {
	
	public Coordinate coordinate;	
	
	/**
	 * @methodtype constructor
	 */
	public Location(Coordinate coordinate) {
		if(coordinate == null) {
			this.coordinate = Coordinate.DEFAULT_COORDINATE;
		} else {
			this.coordinate = coordinate;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		} else if(o == this) {
			return true;
		} else if(o instanceof Location) {
			return isEqual((Location) o);
		} else {
			return false;
		}
	}
	
	public boolean isEqual(Location other) {
		if(other == null) {
			return false;
		} else if(other == this) {
			return true;
		} else {
			return this.coordinate.isEqual(other.coordinate);
		}
	}
		
}
