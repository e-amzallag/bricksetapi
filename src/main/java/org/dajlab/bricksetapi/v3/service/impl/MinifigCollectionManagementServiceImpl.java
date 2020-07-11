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
import org.dajlab.bricksetapi.v3.vo.GetMinifigCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.MessageEnum;
import org.dajlab.bricksetapi.v3.vo.Method;
import org.dajlab.bricksetapi.v3.vo.MinifigCollection;
import org.dajlab.bricksetapi.v3.vo.Response;
import org.dajlab.bricksetapi.v3.vo.SetMinifigCollectionParameters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of the minifig collection management methods.
 * 
 * @author Erik
 *
 */
public class MinifigCollectionManagementServiceImpl extends AbstractBricksetService {

	/**
	 * Get minfigi collection uri method.
	 */
	private static final String GET_MINIFIG_COLLECTION = "/getMinifigCollection";

	/**
	 * Set minifig collection uri method.
	 */
	private static final String SET_MINIFIG_COLLECTION = "/setMinifigCollection";

	/**
	 * Constructor.
	 * 
	 * @param apiKey api key
	 */
	public MinifigCollectionManagementServiceImpl(String apiKey) {
		super(apiKey);
	}

	/**
	 * Get a list of minifigs owned/wanted by a user.
	 * 
	 * @param params   parameters
	 * @param userHash userhash
	 * @return list of minifigs
	 * @throws BricksetException if status is not success
	 */
	public List<MinifigCollection> getMinifigCollection(GetMinifigCollectionParameters params, String userHash)
			throws BricksetException {

		if (params != null) {
			String uri = GET_MINIFIG_COLLECTION;
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> parameters = new HashMap<>();
			try {
				String parametersStr = mapper.writeValueAsString(params);
				parameters.put("params", parametersStr);
				String output = returnJsonResponse(Method.GET, uri, parameters, userHash);

				if (output != null) {
					Response response = mapper.readValue(output, Response.class);
					switch (response.getStatus()) {
					case SUCCESS:
						return response.getMinifigs();
					case ERROR:
					default:
						throw new BricksetException(response.getMessage());
					}
				}
			} catch (JsonProcessingException e) {
				throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
			}
		}
		return new ArrayList<>(0);
	}

	/**
	 * Add/change a user's 'loose' minifig collection.
	 * 
	 * @param minifigNumber minifig number
	 * @param params        parameters
	 * @param userHash      userhash
	 * @throws BricksetException if status is not success
	 */
	public void setMinifigCollection(String minifigNumber, SetMinifigCollectionParameters params, String userHash)
			throws BricksetException {

		if (params != null) {
			String uri = SET_MINIFIG_COLLECTION;
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> parameters = new HashMap<>();
			try {
				String parametersStr = mapper.writeValueAsString(params);
				parameters.put("params", parametersStr);
				parameters.put("minifigNumber", minifigNumber);
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
}
