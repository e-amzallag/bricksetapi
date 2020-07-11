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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.dajlab.bricksetapi.v3.service.impl.ListSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(Include.NON_EMPTY)
public class SetParameters {

	/**
	 * Internal SetID.
	 */
	@JsonProperty("setID")
	private Integer setId;

	/**
	 * Search term: searches set number, name, theme and subtheme.
	 */
	private String query;

	/**
	 * 
	 */
	@JsonSerialize(using = ListSerializer.class)
	private List<String> theme;

	/**
	 * 
	 */
	@JsonSerialize(using = ListSerializer.class)
	private List<String> subtheme;

	/**
	 * Full set number, in the format {number}-{variant}, e.g. 6876-1.
	 */
	@JsonSerialize(using = ListSerializer.class)
	private List<String> setNumber;

	/**
	 * 
	 */
	@JsonSerialize(using = ListSerializer.class)
	private List<String> year;

	/**
	 * Tag.
	 */
	private String tag;

	/**
	 * Set to true to retrieve a user's owned sets
	 */
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Boolean owned;

	/**
	 * Set to true to retrieve a user's wanted sets
	 */
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Boolean wanted;

	/**
	 * 
	 */
	private Calendar updatedSince;

	/**
	 * Specify sort order.
	 */
	private OrderByEnum orderBy;

	/**
	 * Specify how many records to retrieve (default: 20, max: 500)
	 */
	private Integer pageSize;

	/**
	 * Specify which page of records to retrieve, use in conjunction with pageSize
	 * (default: 1)
	 */
	private Integer pageNumber;

	/**
	 * Set to true to retrieve the full data set, including tags, description and
	 * notes.
	 */
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Boolean extendedData;

	public SetParameters() {
		theme = new ArrayList<>();
		subtheme = new ArrayList<>();
		setNumber = new ArrayList<>();
		year = new ArrayList<>();
	}

	/**
	 * Retrieve a user's owned sets
	 * 
	 * @return this
	 */
	public final SetParameters onlyOwned() {
		owned = true;
		return this;
	}

	/**
	 * Retrieve a user's wanted sets.
	 * 
	 * @return this
	 */
	public final SetParameters onlyWanted() {
		wanted = true;
		return this;
	}

	/**
	 * Internal SetID.
	 * 
	 * @param setId the setId to set
	 * @return this
	 */
	public final SetParameters setSetId(Integer setId) {
		this.setId = setId;
		return this;
	}

	/**
	 * Search term: searches set number, name, theme, subtheme, barcode
	 * 
	 * @param query the query to set
	 * @return this
	 */
	public final SetParameters setQuery(String query) {
		this.query = query;
		return this;
	}

	/**
	 * @param theme the theme to set
	 * @return this
	 */
	public final SetParameters addTheme(String theme) {
		this.theme.add(theme);
		return this;
	}

	/**
	 * @param subtheme the subtheme to set
	 * @return this
	 */
	public final SetParameters addSubtheme(String subtheme) {
		this.subtheme.add(subtheme);
		return this;
	}

	/**
	 * Full set number, in the format {number}-{variant}, e.g. 6876-1
	 * 
	 * @param setNumber the setNumber to set
	 * @return this
	 */
	public final SetParameters addSetNumber(String setNumber) {
		this.setNumber.add(setNumber);
		return this;
	}

	/**
	 * @param year the year to set
	 * @return this
	 */
	public final SetParameters addYear(String year) {
		this.year.add(year);
		return this;
	}

	/**
	 * Set to true to retrieve a user's owned sets
	 * 
	 * @param owned the owned to set
	 */
	protected final void setOwned(Boolean owned) {
		this.owned = owned;
	}

	/**
	 * Set to true to retrieve a user's wanted sets
	 * 
	 * @param wanted the wanted to set
	 */
	protected final void setWanted(Boolean wanted) {
		this.wanted = wanted;
	}

	/**
	 * @param updatedSince the updatedSince to set
	 * @return this
	 */
	public final SetParameters setUpdatedSince(Calendar updatedSince) {
		this.updatedSince = updatedSince;
		return this;
	}

	/**
	 * Sort order
	 * 
	 * @param orderBy the orderBy to set
	 * @return this
	 */
	public final SetParameters setOrderBy(OrderByEnum orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	/**
	 * Specify how many records to retrieve (default: 20, max: 500)
	 * 
	 * @param pageSize the pageSize to set
	 * @return this
	 */
	public final SetParameters setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	/**
	 * Specify which page of records to retrieve, use in conjunction with pageSize
	 * (default: 1)
	 * 
	 * @param pageNumber the pageNumber to set
	 * @return this
	 */
	public final SetParameters setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}

	/**
	 * Retrieve the full data set, including tags, description and notes.
	 * 
	 * @return this
	 */
	public SetParameters withExtendedData() {
		this.extendedData = true;
		return this;
	}

	/**
	 * @return the setId
	 */
	public final Integer getSetId() {
		return setId;
	}

	/**
	 * @return the query
	 */
	public final String getQuery() {
		return query;
	}

	/**
	 * @return the theme
	 */
	public final List<String> getTheme() {
		return theme;
	}

	/**
	 * @return the subtheme
	 */
	public final List<String> getSubtheme() {
		return subtheme;
	}

	/**
	 * @return the setNumber
	 */
	public final List<String> getSetNumber() {
		return setNumber;
	}

	/**
	 * @return the year
	 */
	public final List<String> getYear() {
		return year;
	}

	/**
	 * @return the owned
	 */
	protected final Boolean getOwned() {
		return owned;
	}

	/**
	 * @return the wanted
	 */
	protected final Boolean getWanted() {
		return wanted;
	}

	/**
	 * @return the updatedSince
	 */
	public final Calendar getUpdatedSince() {
		return updatedSince;
	}

	/**
	 * @return the orderBy
	 */
	public final OrderByEnum getOrderBy() {
		return orderBy;
	}

	/**
	 * @return the pageSize
	 */
	public final Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @return the pageNumber
	 */
	public final Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the extendedData
	 */
	public Boolean getExtendedData() {
		return extendedData;
	}

	/**
	 * Set to true to retrieve the full data set, including tags, description and
	 * notes.
	 * 
	 * @param extendedData the extendedData to set
	 */
	public void setExtendedData(Boolean extendedData) {
		this.extendedData = extendedData;
	}

}
