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

import org.wahlzeit.services.LogBuilder;

public class AbimottoPhotoManager extends PhotoManager {

	protected static AbimottoPhotoManager instance;
	
	private static final Logger log = Logger.getLogger(AbimottoPhotoManager.class.getName());
	
	public AbimottoPhotoManager() {
		photoTagCollector = AbimottoPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	/**
	 * @methodtype getter
	 */
	public static AbimottoPhotoManager getInstance() {
		if(instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting AbimottoPhotoManager").toString());
			setInstance(new AbimottoPhotoManager());
		}
		return instance;
	}
	
	/**
	 * @methodtype setter
	 */
	protected static synchronized void setInstance(AbimottoPhotoManager apm) {
		if(instance != null) {
			throw new IllegalStateException("attempt to initialize AbimottoPhotoManager twice.");
		}
		instance = apm;
	}
			
	/**
	 * @methodtype command
	 * @methodproperty primitive
	 */
	protected void doAddAbimottoPhoto(AbimottoPhoto myAbimottoPhoto) {
		super.doAddPhoto(myAbimottoPhoto);
	}
	
	/**
	 * @methodtype command
	 * @methodproperty primitive
	 */
	@Override
	protected void doAddPhoto(Photo myPhoto) {
		if(!(myPhoto instanceof AbimottoPhoto)) {
			throw new IllegalArgumentException("Expected AbimottoPhoto");
		}
		doAddAbimottoPhoto((AbimottoPhoto) myPhoto);
	}	
	
	/**
	 * @methodtype getter
	 */
	public AbimottoPhoto getAbimottoPhoto(PhotoId id) {
		return (AbimottoPhoto) super.getPhoto(id);
	}
}
