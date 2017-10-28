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
		this.coordinate = coordinate;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Location) {
			return isEqual((Location) o);
		} else {
			return false;
		}
	}
	
	public boolean isEqual(Location other) {
		return this.coordinate.isEqual(other.coordinate);
	}
		
}
