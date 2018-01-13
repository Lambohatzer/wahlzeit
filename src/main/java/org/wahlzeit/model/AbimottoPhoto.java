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

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class AbimottoPhoto extends Photo {

	private AbimottoTheme theme;
	
	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto(PhotoId id, AbimottoTheme theme) {
		super(id);
		this.theme = theme;
	}
	
	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto(PhotoId id) {
		this(id, AbimottoTheme.DEFAULT_THEME);
	}
	
	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto(AbimottoTheme theme) {
		super();
		this.theme = theme;
	}

	/**
	 * @methodtype constructor
	 */
	public AbimottoPhoto() {
		this(AbimottoTheme.DEFAULT_THEME);
	}
	
	/**
	 * @methodtype setter
	 */
	public void setAbimottoTheme(AbimottoTheme theme) {
		this.theme = theme;
	}
	
	/**
	 * @methodtype getter
	 */
	public AbimottoTheme getAbimottoTheme() {
		return theme;
	}
	
}
