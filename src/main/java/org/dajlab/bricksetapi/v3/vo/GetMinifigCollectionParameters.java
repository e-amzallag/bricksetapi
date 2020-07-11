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

@JsonInclude(Include.NON_EMPTY)
public class GetMinifigCollectionParameters {

	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Boolean owned;

	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Boolean wanted;

	private String query;

	/**
	 * Retrieve minifigs owned
	 * 
	 * @return this
	 */
	public final GetMinifigCollectionParameters onlyOwned() {
		owned = true;
		return this;
	}

	/**
	 * Retrieve minifigs wanted
	 * 
	 * @return this
	 */
	public final GetMinifigCollectionParameters onlyWanted() {
		wanted = true;
		return this;
	}

	/**
	 * @return the owned
	 */
	protected final Boolean getOwned() {
		return owned;
	}

	/**
	 * Set to true to retrieve minifigs owned
	 * 
	 * @param owned the owned to set
	 */
	protected final void setOwned(Boolean owned) {
		this.owned = owned;
	}

	/**
	 * @return the wanted
	 */
	protected final Boolean getWanted() {
		return wanted;
	}

	/**
	 * Set to true to retrieve minifigs wanted
	 * 
	 * @param wanted the wanted to set
	 */
	protected final void setWanted(Boolean wanted) {
		this.wanted = wanted;
	}

	/**
	 * @return the query
	 */
	public final String getQuery() {
		return query;
	}

	/**
	 * This can be a minifig number or name. If omitted, all minifigs owned are
	 * returned.
	 * 
	 * @param query the query to set
	 * @return this
	 */
	public final GetMinifigCollectionParameters setQuery(String query) {
		this.query = query;
		return this;
	}

}
