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

import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class AbimottoPhoto extends Photo {

	@Serialize
	private Abimotto abimotto;
	
	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto(PhotoId id, Abimotto abimotto) {
		super(id);
		this.abimotto = abimotto;
	}
	
	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto(PhotoId id) {
		this(id, null);
	}
	
	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto(Abimotto abimotto) {
		super();
		this.abimotto = abimotto;
	}

	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto() {
		super();
		abimotto = null;
	}
	
	/**
	 * @methodtype setter
	 */
	public void setAbimottoTheme(Abimotto abimotto) {
		this.abimotto = abimotto;
	}
	
	/**
	 * @methodtype getter
	 */
	public Abimotto getAbimottoTheme() {
		return abimotto;
	}
	
}
