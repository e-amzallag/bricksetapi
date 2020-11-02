/*
 * Copyright 2020 Erik Amzallag
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dajlab.bricksetapi.v3.service.impl;

import java.util.List;

import org.dajlab.bricksetapi.v3.service.IBricksetService;
import org.dajlab.bricksetapi.v3.vo.AdditionalImages;
import org.dajlab.bricksetapi.v3.vo.ApiKeyUsage;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.GetMinifigCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.Instruction;
import org.dajlab.bricksetapi.v3.vo.MinifigCollection;
import org.dajlab.bricksetapi.v3.vo.Reviews;
import org.dajlab.bricksetapi.v3.vo.Set;
import org.dajlab.bricksetapi.v3.vo.SetCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.SetMinifigCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.SetParameters;
import org.dajlab.bricksetapi.v3.vo.Subtheme;
import org.dajlab.bricksetapi.v3.vo.Theme;
import org.dajlab.bricksetapi.v3.vo.UserMinifigNotes;
import org.dajlab.bricksetapi.v3.vo.UserNotes;
import org.dajlab.bricksetapi.v3.vo.Year;

/**
 * Implementation.
 * 
 *
 */
public class BricksetServiceImpl implements IBricksetService {

	/**
	 * General service.
	 */
	private GeneralServiceImpl generalService;
	/**
	 * Sets service.
	 */
	private SetsServiceImpl setsService;
	/**
	 * Set collection management service.
	 */
	private SetCollectionManagementServiceImpl setCollectionService;
	/**
	 * Minifig collection management service.
	 */
	private MinifigCollectionManagementServiceImpl minifigCollectionService;

	/**
	 * Constructor.
	 * 
	 * @param apiKey api key
	 */
	public BricksetServiceImpl(String apiKey) {
		generalService = new GeneralServiceImpl(apiKey);
		setsService = new SetsServiceImpl(apiKey);
		setCollectionService = new SetCollectionManagementServiceImpl(apiKey);
		minifigCollectionService = new MinifigCollectionManagementServiceImpl(apiKey);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkKey() throws BricksetException {

		return generalService.checkKey();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String login(String username, String password) throws BricksetException {

		return generalService.login(username, password);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkUserHash(String userHash) throws BricksetException {

		return generalService.checkUserHash(userHash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ApiKeyUsage> getKeyUsageStats() throws BricksetException {

		return generalService.getKeyUsageStats();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Set> getSets(SetParameters params) throws BricksetException {

		return setsService.getSets(params);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Set> getSets(SetParameters params, String userHash) throws BricksetException {

		return setsService.getSets(params, userHash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AdditionalImages> getAdditionalImages(int setId) throws BricksetException {

		return setsService.getAdditionalImages(setId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Instruction> getInstructions(int setId) throws BricksetException {

		return setsService.getInstructions(setId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Reviews> getReviews(int setId) throws BricksetException {

		return setsService.getReviews(setId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Theme> getThemes() throws BricksetException {

		return setsService.getThemes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Subtheme> getSubthemes(String theme) throws BricksetException {

		return setsService.getSubthemes(theme);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Year> getYears(String theme) throws BricksetException {

		return setsService.getYears(theme);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCollection(int setId, SetCollectionParameters params, String userHash) throws BricksetException {

		setCollectionService.setCollection(setId, params, userHash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserNotes> getUserNotes(String userHash) throws BricksetException {

		return setCollectionService.getUserNotes(userHash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserMinifigNotes> getUserMinifigNotes(String userHash) throws BricksetException {

		return minifigCollectionService.getUserMinifigNotes(userHash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MinifigCollection> getMinifigCollection(GetMinifigCollectionParameters params, String userHash)
			throws BricksetException {

		return minifigCollectionService.getMinifigCollection(params, userHash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMinifigCollection(String minifigNumber, SetMinifigCollectionParameters params, String userHash)
			throws BricksetException {

		minifigCollectionService.setMinifigCollection(minifigNumber, params, userHash);
	}

}
