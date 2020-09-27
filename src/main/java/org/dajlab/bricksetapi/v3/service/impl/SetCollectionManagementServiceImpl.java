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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dajlab.bricksetapi.v3.service.AbstractBricksetService;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.MessageEnum;
import org.dajlab.bricksetapi.v3.vo.Method;
import org.dajlab.bricksetapi.v3.vo.Response;
import org.dajlab.bricksetapi.v3.vo.SetCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.UserMinifigNotes;
import org.dajlab.bricksetapi.v3.vo.UserNotes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Implementation of the set collection management methods.
 *
 */
public class SetCollectionManagementServiceImpl extends AbstractBricksetService {

	/**
	 * Set collection uri method.
	 */
	private static final String SET_COLLECTION = "/setCollection";

	/**
	 * Get user notes uri method.
	 */
	private static final String GET_USER_NOTES = "/getUserNotes";

	/**
	 * Get minifigure user notes uri method.
	 */
	private static final String GET_USER_MINIFIG_NOTES = "/getUserMinifigNotes";

	/**
	 * Constructor.
	 * 
	 * @param apiKey
	 *            api key
	 */
	public SetCollectionManagementServiceImpl(String apiKey) {
		super(apiKey);
	}

	/**
	 * Set a user's collection details.
	 * 
	 * @param setId
	 *            Set ID
	 * @param params
	 *            parameters and options
	 * @param userHash
	 *            userhash
	 * @throws BricksetException
	 *             if status is not success
	 */
	public void setCollection(int setId, SetCollectionParameters params, String userHash) throws BricksetException {
		if (params != null) {
			String uri = SET_COLLECTION;
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> parameters = new HashMap<>();
			try {
				String parametersStr = mapper.writeValueAsString(params);
				parameters.put("params", parametersStr);
				parameters.put("SetID", setId + "");
				String output = returnJsonResponse(Method.GET, uri, parameters, userHash);

				if (output != null) {
					Response response = mapper.readValue(output, Response.class);
					switch (response.getStatus()) {
					case SUCCESS:
						break;
					case ERROR:
					default:
						throw new BricksetException(response.getMessage());
					}
				}
			} catch (JsonProcessingException e) {
				throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
			}
		}
	}

	/**
	 * Get all of a user's set notes.
	 * 
	 * @param userHash
	 *            userhash
	 * @return a list of all user's notes
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<UserNotes> getUserNotes(String userHash) throws BricksetException {
		String uri = GET_USER_NOTES;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String output = returnJsonResponse(Method.GET, uri, null, userHash);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getUserNotes();
				case ERROR:
				default:
					throw new BricksetException(response.getMessage());
				}
			}
		} catch (JsonProcessingException e) {
			throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
		}
		return new ArrayList<>();
	}

	/**
	 * Get all of a user's minifigure notes.
	 * 
	 * @param userHash
	 *            userhash
	 * @return a list of all user's notes
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<UserMinifigNotes> getUserMinifigNotes(String userHash) throws BricksetException {
		String uri = GET_USER_MINIFIG_NOTES;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String output = returnJsonResponse(Method.GET, uri, null, userHash);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getUserMinifigNotes();
				case ERROR:
				default:
					throw new BricksetException(response.getMessage());
				}
			}
		} catch (JsonProcessingException e) {
			throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
		}
		return new ArrayList<>();
	}
}
