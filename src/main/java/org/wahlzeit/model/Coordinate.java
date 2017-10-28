package org.wahlzeit.model;

/**
 * A Coordinate is a set of three double Values that describe a point in a
 * 3D Cartesian coordinate system.
 */
public class Coordinate {

	
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
		double deltaX = this.x - from.x;
		double deltaY = this.y - from.y;
		double deltaZ = this.z - from.z;
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Coordinate) {
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
		return (this.x == other.x) && (this.y == other.y) && (this.z == other.z);
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
