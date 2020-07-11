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
package org.dajlab.bricksetapi.v3.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.MessageEnum;
import org.dajlab.bricksetapi.v3.vo.Method;

/**
 * Abstract service.
 * 
 *
 */
public abstract class AbstractBricksetService {

	/**
	 * Consumer key.
	 */
	private String apiKey;

	/**
	 * API Base URL.
	 * 
	 * @see <a href="https://brickset.com/api/v3.asmx">Documentation V3</a>
	 */
	private static final String API_BASE_URL = "https://brickset.com/api/v3.asmx";

	/**
	 * Constructor.
	 * 
	 * @param apiKey your Rebrickable private key.
	 */
	protected AbstractBricksetService(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Call the service and return the response.
	 * 
	 * @param method http methode
	 * @param uri    uri
	 * @return the string representation of the JSON response
	 * @throws BricksetException if status is not success
	 */
	protected String returnJsonResponse(Method method, String uri) throws BricksetException {

		return returnJsonResponse(method, uri, null, null);
	}

	/**
	 * Call the service and return the response.
	 * 
	 * @param method     http methode
	 * @param uri        uri
	 * @param parameters request parameters
	 * @param userHash   user hash
	 * @return the string representation of the JSON response
	 * @throws BricksetException if status is not success
	 */
	protected String returnJsonResponse(Method method, String uri, Map<String, String> parameters, String userHash)
			throws BricksetException {

		String baseUrl = API_BASE_URL + uri + "?apiKey=" + apiKey;
		baseUrl += "&userHash=";
		if (userHash != null) {
			try {
				String encodedUserhash = URLEncoder.encode(userHash, StandardCharsets.UTF_8.toString());
				baseUrl += encodedUserhash;
			} catch (UnsupportedEncodingException e) {
				throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
			}
		}

		if (parameters != null) {
			StringBuilder params = new StringBuilder();
			for (Entry<String, String> param : parameters.entrySet()) {
				try {
					String encodedParam = URLEncoder.encode(param.getValue(), StandardCharsets.UTF_8.toString());
					params.append("&" + param.getKey() + "=" + encodedParam);
				} catch (UnsupportedEncodingException e) {
					throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
				}
			}
			baseUrl = baseUrl + params;
		}
		return callRestService(method, baseUrl);
	}

	/**
	 * Call the REST service with the full url.
	 * 
	 * @param method http method
	 * @param url    the url, complete with paramaters and key.
	 * @return the string representation of the JSON response
	 * @throws BricksetException if status is not success
	 */
	private String callRestService(Method method, String url) throws BricksetException {
		try {

			URL fullurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) fullurl.openConnection();
			conn.setRequestMethod(method.name());
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new BricksetException(MessageEnum.TECHNICAL_ERROR,
						"Failed : HTTP error code : " + conn.getResponseCode());
			}

			return new BufferedReader(new InputStreamReader(conn.getInputStream())).lines()
					.collect(Collectors.joining("\n"));

		} catch (Exception e) {
			throw new BricksetException(MessageEnum.TECHNICAL_ERROR, e.getMessage());
		}
	}

}
