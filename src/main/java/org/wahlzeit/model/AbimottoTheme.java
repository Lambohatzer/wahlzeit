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

public class AbimottoTheme {

	private boolean isParody;
	private String topic;
	private int year;
	private String catchphrase;
	
	public static final AbimottoTheme DEFAULT_THEME = new AbimottoTheme(true, "Prosieben Blockbuster", 2015, "Abi Primetime 20:15");
	
	public AbimottoTheme(boolean isParody, String topic, int year, String catchphrase) {
		this.isParody = isParody;
		this.topic = topic;
		this.year = year;
		this.catchphrase = catchphrase;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setIsParody(boolean isParody) {
		this.isParody = isParody;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setCatchprase(String catchphrase) {
		this.catchphrase = catchphrase;
	}
	
	/**
	 * @methodtype getter
	 */
	public boolean isParody() {
		return isParody;
	}

	/**
	 * @methodtype getter
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @methodtype getter
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @methodtype getter
	 */
	public String getCatchphrase() {
		return catchphrase;
	}
	
}
