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
public class Rating {

	private Integer overall;

	private Integer parts;

	private Integer buildingExperience;

	private Integer playability;

	private Integer valueForMoney;

	/**
	 * @return the overall
	 */
	public final Integer getOverall() {
		return overall;
	}

	/**
	 * @param overall
	 *            the overall to set
	 */
	public final void setOverall(Integer overall) {
		this.overall = overall;
	}

	/**
	 * @return the parts
	 */
	public final Integer getParts() {
		return parts;
	}

	/**
	 * @param parts
	 *            the parts to set
	 */
	public final void setParts(Integer parts) {
		this.parts = parts;
	}

	/**
	 * @return the buildingExperience
	 */
	public final Integer getBuildingExperience() {
		return buildingExperience;
	}

	/**
	 * @param buildingExperience
	 *            the buildingExperience to set
	 */
	public final void setBuildingExperience(Integer buildingExperience) {
		this.buildingExperience = buildingExperience;
	}

	/**
	 * @return the playability
	 */
	public final Integer getPlayability() {
		return playability;
	}

	/**
	 * @param playability
	 *            the playability to set
	 */
	public final void setPlayability(Integer playability) {
		this.playability = playability;
	}

	/**
	 * @return the valueForMoney
	 */
	public final Integer getValueForMoney() {
		return valueForMoney;
	}

	/**
	 * @param valueForMoney
	 *            the valueForMoney to set
	 */
	public final void setValueForMoney(Integer valueForMoney) {
		this.valueForMoney = valueForMoney;
	}

}
