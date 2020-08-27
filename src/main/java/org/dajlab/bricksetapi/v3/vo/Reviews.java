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

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reviews {

	private String author;

	private Calendar datePosted;

	private Rating rating;

	private String title;

	private String review;

	@JsonProperty("HTML")
	private Boolean html;

	/**
	 * @return the author
	 */
	public final String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public final void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the datePosted
	 */
	public final Calendar getDatePosted() {
		return datePosted;
	}

	/**
	 * @param datePosted
	 *            the datePosted to set
	 */
	public final void setDatePosted(Calendar datePosted) {
		this.datePosted = datePosted;
	}

	/**
	 * @return the rating
	 */
	public final Rating getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public final void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the review
	 */
	public final String getReview() {
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public final void setReview(String review) {
		this.review = review;
	}

	/**
	 * @return the html
	 */
	public final Boolean getHtml() {
		return html;
	}

	/**
	 * @param html
	 *            the html to set
	 */
	public final void setHtml(Boolean html) {
		this.html = html;
	}

}
