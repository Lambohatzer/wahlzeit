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
	}

	public Abimotto createInstance() {
		return new Abimotto(this);
	}

	public AbimottoType getSuperType() {
		return superType;
	}

	public Iterator<AbimottoType> getSubTypesIterator() {
		return subTypes.iterator();
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
