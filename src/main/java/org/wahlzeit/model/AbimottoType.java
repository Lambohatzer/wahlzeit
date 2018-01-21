package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AbimottoType {

	private AbimottoType superType = null;
	private Set<AbimottoType> subTypes = new HashSet<>();
	
	private int year;
	private String topic;
	private boolean isParody;
	private String catchphrase;

	public AbimottoType() {
		year = 2015;
		topic = "Prime Time";
		isParody = true;
		catchphrase = "Abi Primetime 20:15";
	}

	public Abimotto createInstance() {
		return new Abimotto(this);
	}

	public AbimottoType getSuperType() {
		return superType;
	}

	public void addSubType(AbimottoType subType) {
		if (subType == null)
			throw new IllegalArgumentException("tried to set null as SubType!");
		subType.superType = this;
		subTypes.add(subType);
	}

	public boolean hasInstance(Abimotto abimotto) {
		if (abimotto == null)
			throw new IllegalArgumentException("asked for null!");
		if (abimotto.getType() == this)
			return true;
		for (AbimottoType type : subTypes) {
			if (type.hasInstance(abimotto))
				return true;
		}
		return false;
	}

	public boolean isSubtype() {
		return superType != null;
	}
	
	public boolean isSubtypeOf(AbimottoType other) {
		if(this.superType == null) return false;
		if(this.superType.isEqual(other)) return true;
		return this.superType.isSubtypeOf(other);
	}
	
	public boolean isSupertype() {
		return subTypes.size() != 0;
	}
	
	public boolean isSupertypeOf(AbimottoType other) {
		return other.isSubtypeOf(this);
	}
	
	public boolean hasSubtype(AbimottoType other) {
		for(AbimottoType at: subTypes) {
			if(other.isEqual(at)) return true;
			if(at.hasSubtype(other)) return true;
		}
		return false;
	}

	public boolean isEqual(AbimottoType other) {
		if (other == null)
			return false;
		return this.year == other.year && this.topic.equals(other.topic) && this.isParody == other.isParody
				&& this.catchphrase.equals(other.catchphrase);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public boolean isParody() {
		return isParody;
	}

	public void setParody(boolean isParody) {
		this.isParody = isParody;
	}

	public String getCatchphrase() {
		return catchphrase;
	}

	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof AbimottoType))
			return false;
		return isEqual((AbimottoType) o);
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + year;
		result = 31 * result + topic.hashCode();
		result = 31 * result + catchphrase.hashCode();
		result = 31 * result + (isParody ? 17 : 0);
		return result;
	}

}
