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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Year {

	private String theme;
	private String year;
	private Integer setCount;

	/**
	 * @return the theme
	 */
	public final String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public final void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the year
	 */
	public final String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public final void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the setCount
	 */
	public final Integer getSetCount() {
		return setCount;
	}

	/**
	 * @param setCount the setCount to set
	 */
	public final void setSetCount(Integer setCount) {
		this.setCount = setCount;
	}

}
