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
public class MinifigCollection {

	private String minifigNumber;
	private String name;
	private String category;
	private Integer ownedInSets;
	private Integer ownedLoose;
	private Integer ownedTotal;
	private Boolean wanted;

	/**
	 * @return the minifigNumber
	 */
	public final String getMinifigNumber() {
		return minifigNumber;
	}

	/**
	 * @param minifigNumber the minifigNumber to set
	 */
	public final void setMinifigNumber(String minifigNumber) {
		this.minifigNumber = minifigNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the ownedInSets
	 */
	public final Integer getOwnedInSets() {
		return ownedInSets;
	}

	/**
	 * @param ownedInSets the ownedInSets to set
	 */
	public final void setOwnedInSets(Integer ownedInSets) {
		this.ownedInSets = ownedInSets;
	}

	/**
	 * @return the ownedLoose
	 */
	public final Integer getOwnedLoose() {
		return ownedLoose;
	}

	/**
	 * @param ownedLoose the ownedLoose to set
	 */
	public final void setOwnedLoose(Integer ownedLoose) {
		this.ownedLoose = ownedLoose;
	}

	/**
	 * @return the ownedTotal
	 */
	public final Integer getOwnedTotal() {
		return ownedTotal;
	}

	/**
	 * @param ownedTotal the ownedTotal to set
	 */
	public final void setOwnedTotal(Integer ownedTotal) {
		this.ownedTotal = ownedTotal;
	}

	/**
	 * @return the wanted
	 */
	public final Boolean getWanted() {
		return wanted;
	}

	/**
	 * @param wanted the wanted to set
	 */
	public final void setWanted(Boolean wanted) {
		this.wanted = wanted;
	}

}
