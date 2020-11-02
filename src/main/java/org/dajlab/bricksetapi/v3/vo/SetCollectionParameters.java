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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_EMPTY)
public class SetCollectionParameters {

	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Boolean own;
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Boolean want;
	@JsonProperty("qtyOwned")
	private Integer quantityOwned;
	/**
	 * User notes, max 1000 characters.
	 */
	private String notes;
	/**
	 * User rating 1-5.
	 */
	private Integer rating;

	/**
	 * @return the own
	 */
	public final Boolean getOwn() {
		return own;
	}

	/**
	 * If false then {@link #quantityOwned} is automatically set to 0
	 * 
	 * @param own the own to set
	 * @return this
	 */
	public final SetCollectionParameters setOwn(Boolean own) {
		this.own = own;
		return this;
	}

	/**
	 * @return the want
	 */
	public final Boolean getWant() {
		return want;
	}

	/**
	 * @param want the want to set
	 * @return this
	 */
	public final SetCollectionParameters setWant(Boolean want) {
		this.want = want;
		return this;
	}

	/**
	 * @return the quantityOwned
	 */
	public final Integer getQuantityOwned() {
		return quantityOwned;
	}

	/**
	 * 0-999. If greater than 0 then {@link #own} is automatically set to true
	 * 
	 * @param quantityOwned the quantityOwned to set
	 * @return this
	 */
	public final SetCollectionParameters setQuantityOwned(Integer quantityOwned) {
		this.quantityOwned = quantityOwned;
		return this;
	}

	/**
	 * @return the notes
	 */
	public final String getNotes() {
		return notes;
	}

	/**
	 * User notes, max 1000 characters
	 * 
	 * @param notes the notes to set
	 * @return this
	 */
	public final SetCollectionParameters setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	/**
	 * @return the rating
	 */
	public final Integer getRating() {
		return rating;
	}

	/**
	 * User rating 1-5
	 * 
	 * @param rating the rating to set
	 * @return this
	 */
	public final SetCollectionParameters setRating(Integer rating) {
		this.rating = rating;
		return this;
	}

}
