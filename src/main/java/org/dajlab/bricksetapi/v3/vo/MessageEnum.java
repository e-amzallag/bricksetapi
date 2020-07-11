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
package org.dajlab.bricksetapi.v3.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageEnum {

	INVALID_API_KEY("Invalid API key"),

	INVALID_USERNAME_OR_PASSWORD("Invalid username or password"),

	INVALID_USER_HASH("Invalid user hash"),

	PARAMETER_ERROR("Parameter error"),

	NO_VALID_PARAMETERS("No valid parameters"),

	DAILY_API_LIMIT_EXCEEDED("API limit exceeded"),

	TECHNICAL_ERROR("Technical error");

	private String message;

	private MessageEnum(String message) {
		this.message = message;
	}

	@JsonValue
	public String getMessage() {
		return message;
	}
}
