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
import org.dajlab.bricksetapi.v3.vo.ApiKeyUsage;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.MessageEnum;
import org.dajlab.bricksetapi.v3.vo.Method;
import org.dajlab.bricksetapi.v3.vo.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of the general methods.
 *
 */
public class GeneralServiceImpl extends AbstractBricksetService {

	/**
	 * Checkey uri method.
	 */
	private static final String CHECK_KEY = "/checkKey";

	/**
	 * Login uri method.
	 */
	private static final String LOGIN = "/login";

	/**
	 * Check userhash uri method.
	 */
	private static final String CHECK_USER_HASH = "/checkUserHash";

	/**
	 * Get key usage stats uri method.
	 */
	private static final String GET_KEY_USAGE_STATS = "/getKeyUsageStats";

	/**
	 * Constructor.
	 * 
	 * @param apiKey api key
	 */
	public GeneralServiceImpl(String apiKey) {
		super(apiKey);
	}

	/**
	 * Check if an API key is valid.
	 * 
	 * @return true if so.
	 * @throws BricksetException if the key is incorrect
	 */
	public boolean checkKey() throws BricksetException {

		String uri = CHECK_KEY;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String output = returnJsonResponse(Method.GET, uri);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return true;
				case ERROR:
				default:
					throw new BricksetException(response.getMessage());
				}
			}
		} catch (JsonProcessingException e) {
			throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
		}
		return false;
	}

	/**
	 * Log in as a user and retrieve a token that can be used in subsequent API
	 * calls.
	 * 
	 * @param username Brickset username
	 * @param password password
	 * @return the userHash
	 * @throws BricksetException if log in failed
	 */
	public String login(String username, String password) throws BricksetException {

		String uri = LOGIN;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> parameters = new HashMap<>();
		try {
			parameters.put("username", username);
			parameters.put("password", password);

			String output = returnJsonResponse(Method.GET, uri, parameters, null);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getHash();
				case ERROR:
				default:
					throw new BricksetException(response.getMessage());
				}
			}
		} catch (JsonProcessingException e) {
			throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
		}
		return null;
	}

	/**
	 * Check if a userHash key is valid.
	 * 
	 * @param userHash a userHash
	 * @return true if valid
	 * @throws BricksetException if userhash is invalid
	 */
	public boolean checkUserHash(String userHash) throws BricksetException {

		String uri = CHECK_USER_HASH;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String output = returnJsonResponse(Method.GET, uri, null, userHash);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return true;
				case ERROR:
				default:
					throw new BricksetException(response.getMessage());
				}
			}
		} catch (JsonProcessingException e) {
			throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
		}
		return false;
	}

	/**
	 * Get key usage stats for the last 30 days. Note that only calls to the getSets
	 * method count against key usage.
	 * 
	 * @return key usage stats
	 * @throws BricksetException if status is not success
	 */
	public List<ApiKeyUsage> getKeyUsageStats() throws BricksetException {

		String uri = GET_KEY_USAGE_STATS;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String output = returnJsonResponse(Method.GET, uri);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getApiKeyUsage();
				case ERROR:
				default:
					throw new BricksetException(response.getMessage());
				}
			}
		} catch (JsonProcessingException e) {
			throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
		}
		return new ArrayList<>(0);
	}

}
