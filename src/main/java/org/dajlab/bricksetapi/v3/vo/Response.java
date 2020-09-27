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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private StatusEnum status;

	private MessageEnum message;

	private Integer matches;

	private List<Set> sets;

	private String hash;

	private List<AdditionalImages> additionalImages;

	private List<Instruction> instructions;

	private List<Reviews> reviews;

	private List<Theme> themes;

	private List<Subtheme> subthemes;

	private List<Year> years;

	private List<UserNotes> userNotes;

	private List<UserMinifigNotes> userMinifigNotes;

	private List<MinifigCollection> minifigs;

	private List<ApiKeyUsage> apiKeyUsage;

	/**
	 * @return the status
	 */
	public final StatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public final void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * @return the matches
	 */
	public final Integer getMatches() {
		return matches;
	}

	/**
	 * @param matches
	 *            the matches to set
	 */
	public final void setMatches(Integer matches) {
		this.matches = matches;
	}

	/**
	 * @return the sets
	 */
	public final List<Set> getSets() {
		return sets;
	}

	/**
	 * @param sets
	 *            the sets to set
	 */
	public final void setSets(List<Set> sets) {
		this.sets = sets;
	}

	/**
	 * @return the hash
	 */
	public final String getHash() {
		return hash;
	}

	/**
	 * @param hash
	 *            the hash to set
	 */
	public final void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the message
	 */
	public final MessageEnum getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public final void setMessage(MessageEnum message) {
		this.message = message;
	}

	/**
	 * @return the additionalImages
	 */
	public final List<AdditionalImages> getAdditionalImages() {
		return additionalImages;
	}

	/**
	 * @param additionalImages
	 *            the additionalImages to set
	 */
	public final void setAdditionalImages(List<AdditionalImages> additionalImages) {
		this.additionalImages = additionalImages;
	}

	/**
	 * @return the instructions
	 */
	public final List<Instruction> getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions
	 *            the instructions to set
	 */
	public final void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	/**
	 * @return the reviews
	 */
	public final List<Reviews> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews
	 *            the reviews to set
	 */
	public final void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	/**
	 * @return the themes
	 */
	public final List<Theme> getThemes() {
		return themes;
	}

	/**
	 * @param themes
	 *            the themes to set
	 */
	public final void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	/**
	 * @return the subthemes
	 */
	public final List<Subtheme> getSubthemes() {
		return subthemes;
	}

	/**
	 * @param subthemes
	 *            the subthemes to set
	 */
	public final void setSubthemes(List<Subtheme> subthemes) {
		this.subthemes = subthemes;
	}

	/**
	 * @return the years
	 */
	public final List<Year> getYears() {
		return years;
	}

	/**
	 * @param years
	 *            the years to set
	 */
	public final void setYears(List<Year> years) {
		this.years = years;
	}

	/**
	 * @return the userNotes
	 */
	public final List<UserNotes> getUserNotes() {
		return userNotes;
	}

	/**
	 * @param userNotes
	 *            the userNotes to set
	 */
	public final void setUserNotes(List<UserNotes> userNotes) {
		this.userNotes = userNotes;
	}

	/**
	 * @return the userMinifigureNotes
	 */
	public List<UserMinifigNotes> getUserMinifigNotes() {
		return userMinifigNotes;
	}

	/**
	 * @param userMinifigureNotes
	 *            the userMinifigureNotes to set
	 */
	public void setUserMinifigNotes(List<UserMinifigNotes> userMinifigureNotes) {
		this.userMinifigNotes = userMinifigureNotes;
	}

	/**
	 * @return the minifigs
	 */
	public final List<MinifigCollection> getMinifigs() {
		return minifigs;
	}

	/**
	 * @param minifigs
	 *            the minifigs to set
	 */
	public final void setMinifigs(List<MinifigCollection> minifigs) {
		this.minifigs = minifigs;
	}

	/**
	 * @return the apiKeyUsage
	 */
	public List<ApiKeyUsage> getApiKeyUsage() {
		return apiKeyUsage;
	}

	/**
	 * @param apiKeyUsage
	 *            the apiKeyUsage to set
	 */
	public void setApiKeyUsage(List<ApiKeyUsage> apiKeyUsage) {
		this.apiKeyUsage = apiKeyUsage;
	}

}
