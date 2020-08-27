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
import org.dajlab.bricksetapi.v3.vo.AdditionalImages;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.Instruction;
import org.dajlab.bricksetapi.v3.vo.MessageEnum;
import org.dajlab.bricksetapi.v3.vo.Method;
import org.dajlab.bricksetapi.v3.vo.Response;
import org.dajlab.bricksetapi.v3.vo.Reviews;
import org.dajlab.bricksetapi.v3.vo.Set;
import org.dajlab.bricksetapi.v3.vo.SetParameters;
import org.dajlab.bricksetapi.v3.vo.Subtheme;
import org.dajlab.bricksetapi.v3.vo.Theme;
import org.dajlab.bricksetapi.v3.vo.Year;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of the sets methods.
 * 
 *
 */
public class SetsServiceImpl extends AbstractBricksetService {

	/**
	 * Get sets uri method.
	 */
	private static final String GET_SETS = "/getSets";

	/**
	 * Get additional images uri method.
	 */
	private static final String GET_ADDITIONAL_IMAGES = "/getAdditionalImages";

	/**
	 * Get instructions uri method.
	 */
	private static final String GET_INSTRUCTIONS = "/getInstructions";

	/**
	 * Get user reviews for the specified set.
	 */
	private static final String GET_REVIEWS = "/getReviews";

	/**
	 * Get themes uri method.
	 */
	private static final String GET_THEMES = "/getThemes";

	/**
	 * Get subthemes uri method.
	 */
	private static final String GET_SUBTHEMES = "/getSubthemes";

	/**
	 * Get years uri method.
	 */
	private static final String GET_YEARS = "/getYears";

	/**
	 * Constructor.
	 * 
	 * @param apiKey
	 *            api key
	 */
	public SetsServiceImpl(String apiKey) {
		super(apiKey);
	}

	/**
	 * Retrieve a list of sets, or more information about a particular one.
	 * 
	 * @param params
	 *            query paratemers
	 * @return a list of sets
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<Set> getSets(SetParameters params) throws BricksetException {
		return getSets(params, null);
	}

	/**
	 * Retrieve a list of sets, or more information about a particular one.
	 * 
	 * @param params
	 *            query paratemers
	 * @param userHash
	 *            userhash
	 * @return a list of sets
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<Set> getSets(SetParameters params, String userHash) throws BricksetException {

		if (params != null) {
			String uri = GET_SETS;
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
						return response.getSets();
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
	 * Get a list of URLs of additional set images for the specified set.
	 * 
	 * @param setId
	 *            the set id.
	 * @return a list of additional images
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<AdditionalImages> getAdditionalImages(int setId) throws BricksetException {

		String uri = GET_ADDITIONAL_IMAGES;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> parameters = new HashMap<>();
		try {
			parameters.put("setID", setId + "");
			String output = returnJsonResponse(Method.GET, uri, parameters, null);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getAdditionalImages();
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

	/**
	 * Get a list of instructions for the specified set.
	 * 
	 * @param setId
	 *            a set id.
	 * @return a list of instructions
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<Instruction> getInstructions(int setId) throws BricksetException {

		String uri = GET_INSTRUCTIONS;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> parameters = new HashMap<>();
		try {
			parameters.put("setID", setId + "");
			String output = returnJsonResponse(Method.GET, uri, parameters, null);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getInstructions();
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

	/**
	 * Get user reviews for the specified set.
	 * 
	 * @param setId
	 *            a set id.
	 * @return a list of reviews
	 * @throws BricksetException
	 *             if status is not success
	 * @return a list of reviews
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<Reviews> getReviews(int setId) throws BricksetException {

		String uri = GET_REVIEWS;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> parameters = new HashMap<>();
		try {
			parameters.put("setID", setId + "");
			String output = returnJsonResponse(Method.GET, uri, parameters, null);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getReviews();
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

	/**
	 * Get a list of themes, with the total number of sets in each.
	 * 
	 * @return the list of the themes
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<Theme> getThemes() throws BricksetException {

		String uri = GET_THEMES;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String output = returnJsonResponse(Method.GET, uri);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getThemes();
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

	/**
	 * Get a list of subthemes for a given theme, with the total number of sets in
	 * each.
	 * 
	 * @param theme
	 *            a theme
	 * @return a list of subthemes
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<Subtheme> getSubthemes(String theme) throws BricksetException {

		String uri = GET_SUBTHEMES;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> parameters = new HashMap<>();
		try {
			parameters.put("theme", theme);
			String output = returnJsonResponse(Method.GET, uri, parameters, null);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getSubthemes();
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

	/**
	 * Get a list of years for a given theme, with the total number of sets in each.
	 * 
	 * @param theme
	 *            Theme. An empty string get totals for all sets.
	 * @return a list of years
	 * @throws BricksetException
	 *             if status is not success
	 */
	public List<Year> getYears(String theme) throws BricksetException {

		String uri = GET_YEARS;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> parameters = new HashMap<>();
		try {
			parameters.put("theme", theme);
			String output = returnJsonResponse(Method.GET, uri, parameters, null);

			if (output != null) {
				Response response = mapper.readValue(output, Response.class);
				switch (response.getStatus()) {
				case SUCCESS:
					return response.getYears();
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
