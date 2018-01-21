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
import org.wahlzeit.services.OfyService;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.tools.cloudstorage.GcsFilename;

@PatternInstance(
		patternName = "Abstract Factory",
		participants = {
				"AbstractFactory",
				"ConcreteFactory"
		}
)
public class AbimottoPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
	
	@PatternInstance(
			patternName = "Singleton",
			participants = {"Singleton instance"}
	)
	private static AbimottoPhotoFactory instance;
	
	/**
	 * @methodtype initialization
	 */
	public static void initialize() {
		getInstance();	// drops result due to getInstance() side-effects
	}
	
	/**
	 * @methodtype getter
	 */
	public static AbimottoPhotoFactory getInstance() {
		if(instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting AbimottoPhotoFactory").toString());
			setInstance(new AbimottoPhotoFactory());
		}
		return instance;
	}
	
	/**
	 * @methodtype setter
	 */
	protected static synchronized void setInstance(AbimottoPhotoFactory abimottoPhotoFactory) {
		if(instance != null) {
			throw new IllegalStateException("attempt to initialize AbimottoPhotoFactory twice.");
		}
		instance = abimottoPhotoFactory;
	}
	
	/**
	 * @methodtype setter
	 * this method is just here temporarily to hide PhotoFactory's setInstance until
	 * I have found a better solution
	 */
	protected static synchronized void setInstance(PhotoFactory abimottoPhotoFactory) {
		if(!(abimottoPhotoFactory instanceof AbimottoPhotoFactory)) {
			throw new IllegalArgumentException("Expected AbimottoPhotoFactory as input.");
		}
		setInstance((AbimottoPhotoFactory) abimottoPhotoFactory);
	}
	
	protected AbimottoPhotoFactory() {
		super();
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return createAbimottoPhoto();
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
		return createAbimottoPhoto(id);
	}
	
	/**
	 * @methodtype factory
	 * @return a new AbimottoPhoto.
	 */
	public AbimottoPhoto createAbimottoPhoto() {
		return new AbimottoPhoto();
	}
	
	/**
	 * @methodtype factory
	 * @return a new AbimottoPhoto.
	 */
	public AbimottoPhoto createAbimottoPhoto(Abimotto abimotto) {
		return new AbimottoPhoto(abimotto);
	}
	
	/**
	 * @methodtype factory
	 * @return a new AbimottoPhoto @param id as its id.
	 */
	public AbimottoPhoto createAbimottoPhoto(PhotoId id) {
		return new AbimottoPhoto(id);
	}
	
	/**
	 * @methodtype factory
	 * @return a new AbimottoPhoto.
	 */
	public AbimottoPhoto createAbimottoPhoto(PhotoId id, Abimotto abimotto) {
		return new AbimottoPhoto(id, abimotto);
	}
		

}
