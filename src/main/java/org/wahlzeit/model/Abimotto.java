package org.wahlzeit.model;

public class Abimotto {

	private AbimottoType type;
	private Integer id;
	private String backgroundColor;
	
	private static int globalId = 0;
	
	public Abimotto(AbimottoType type) {
		this.type = type;
		this.id = new Integer(globalId++);		
	}
	
	public AbimottoType getType() {
		return type;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public boolean isEqual(Abimotto other) {
		if(other == null) return false;
		return this.type.isEqual(other.type) && this.id == other.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(!(o instanceof Abimotto)) return false;
		return isEqual((Abimotto) o);
	}
	
	@Override
	public int hashCode() {
		int result = 0;
		result += 31 * result + id;
		result += 31 * result + type.hashCode();
		return result;
	}
	
}
