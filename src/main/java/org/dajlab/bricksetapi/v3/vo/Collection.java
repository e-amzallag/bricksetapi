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
public class Collection {

	private Boolean owned;
	private Boolean wanted;
	private Integer qtyOwned;
	private Integer rating;
	private String notes;

	/**
	 * @return the owned
	 */
	public Boolean getOwned() {
		return owned;
	}

	/**
	 * @param owned the owned to set
	 */
	public void setOwned(Boolean owned) {
		this.owned = owned;
	}

	/**
	 * @return the wanted
	 */
	public Boolean getWanted() {
		return wanted;
	}

	/**
	 * @param wanted the wanted to set
	 */
	public void setWanted(Boolean wanted) {
		this.wanted = wanted;
	}

	/**
	 * @return the qtyOwned
	 */
	public Integer getQtyOwned() {
		return qtyOwned;
	}

	/**
	 * @param qtyOwned the qtyOwned to set
	 */
	public void setQtyOwned(Integer qtyOwned) {
		this.qtyOwned = qtyOwned;
	}

	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
