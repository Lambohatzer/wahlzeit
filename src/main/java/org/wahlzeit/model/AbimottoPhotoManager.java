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

import java.util.logging.Logger;

public class AbimottoPhotoManager extends PhotoManager {

	protected static final AbimottoPhotoManager instance = new AbimottoPhotoManager();
	
	private static final Logger log = Logger.getLogger(AbimottoPhotoManager.class.getName());
	
	public AbimottoPhotoManager() {
		photoTagCollector = AbimottoPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	/**
	 * @methodtype getter
	 */
	public static AbimottoPhotoManager getInstance() {
		return instance;
	}
	
	/**
	 * @methodtype getter
	 * Overriding getPhoto until a better solution is found
	 * also doGetPhotoFromId does nothing yet, hopefully the feedback
	 * will give me some hints on what to do exactly
	 */
	@Override
	public Photo getPhoto(PhotoId id) {
		return instance.getPhotoFromId(id);
	}
	
	/**
	 * @methodtype getter
	 */
	@Override
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}
		
		Photo result = doGetPhotoFromId(id);
		
		if(result == null) {
			result = AbimottoPhotoFactory.getInstance().loadPhoto(id);
			if(result != null) {
				doAddPhoto(result);
			}
		}
		
		return result;
	}
	
	/**
	 * @methodtype command
	 */
	protected void doAddAbimottoPhoto(AbimottoPhoto myAbimottoPhoto) {
		super.doAddPhoto(myAbimottoPhoto);
	}
	
	/**
	 * @methodtype command
	 */
	@Override
	protected void doAddPhoto(Photo myPhoto) {
		if(!(myPhoto instanceof AbimottoPhoto)) {
			throw new IllegalArgumentException("Expected AbimottoPhoto");
		}
		doAddAbimottoPhoto((AbimottoPhoto) myPhoto);
	}	
}
