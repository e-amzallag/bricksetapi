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
package org.dajlab.bricksetapi.v3.service;

import java.util.List;

import org.dajlab.bricksetapi.v3.vo.AdditionalImages;
import org.dajlab.bricksetapi.v3.vo.ApiKeyUsage;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.GetMinifigCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.Instruction;
import org.dajlab.bricksetapi.v3.vo.MinifigCollection;
import org.dajlab.bricksetapi.v3.vo.Reviews;
import org.dajlab.bricksetapi.v3.vo.Set;
import org.dajlab.bricksetapi.v3.vo.SetCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.SetMinifigCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.SetParameters;
import org.dajlab.bricksetapi.v3.vo.Subtheme;
import org.dajlab.bricksetapi.v3.vo.Theme;
import org.dajlab.bricksetapi.v3.vo.UserMinifigNotes;
import org.dajlab.bricksetapi.v3.vo.UserNotes;
import org.dajlab.bricksetapi.v3.vo.Year;

/**
 * Brickset web services.<br>
 * 
 * @see <a href="https://brickset.com/tools/webservices/v3">
 *      https://brickset.com/tools/webservices/v3</a>
 *
 */
public interface IBricksetService {

	// ************************************
	// General methods
	// ************************************

	/**
	 * Check if an API key is valid.
	 * 
	 * @return true if key is valid
	 * @throws BricksetException if status is not success
	 */
	boolean checkKey() throws BricksetException;

	/**
	 * Log in as a user and retrieve a token that can be used in subsequent API
	 * calls.
	 * 
	 * @param username A Brickset username
	 * @param password A Brickset password
	 * @return the user hash
	 * @throws BricksetException if status is not success
	 */
	String login(String username, String password) throws BricksetException;

	/**
	 * Check if a userHash key is valid.
	 * 
	 * @param userHash User hash retrieved by the login method
	 * @return true if userHash is valid
	 * @throws BricksetException if status is not success
	 */
	boolean checkUserHash(String userHash) throws BricksetException;

	/**
	 * Get key usage stats for the last 30 days. Note that only calls to the getSets
	 * method count against key usage.
	 * 
	 * @return key usage stats
	 * @throws BricksetException if status is not success
	 */
	List<ApiKeyUsage> getKeyUsageStats() throws BricksetException;

	// ************************************
	// Sets methods
	// ************************************

	/**
	 * Retrieve a list of sets, or more information about a particular one.
	 * 
	 * @param params parameters
	 * @return a list of sets
	 * @throws BricksetException if status is not success
	 */
	List<Set> getSets(SetParameters params) throws BricksetException;

	/**
	 * Retrieve a list of sets, or more information about a particular one.
	 * 
	 * @param params   parameters
	 * @param userHash userHash, only if user data needed
	 * @return a list of sets
	 * @throws BricksetException if status is not success
	 */
	List<Set> getSets(SetParameters params, String userHash) throws BricksetException;

	/**
	 * Get a list of URLs of additional set images for the specified set.
	 * 
	 * @param setId Set ID
	 * @return a list of additional images
	 * @throws BricksetException if status is not success
	 */
	List<AdditionalImages> getAdditionalImages(int setId) throws BricksetException;

	/**
	 * Get a list of instructions for the specified set.
	 * 
	 * @param setId Set ID
	 * @return a list of instructions
	 * @throws BricksetException if status is not success
	 */
	List<Instruction> getInstructions(int setId) throws BricksetException;

	/**
	 * Get a list of instructions for the specified set without the need to look up
	 * the set ID first.
	 * 
	 * @param setNumber Set number
	 * @return a list of instructions
	 * @throws BricksetException if status is not success
	 */
	List<Instruction> getInstructions2(String setNumber) throws BricksetException;

	/**
	 * Get user reviews for the specified set.
	 * 
	 * @param setId a set id.
	 * @return a list of reviews
	 * @throws BricksetException if status is not success
	 */
	List<Reviews> getReviews(int setId) throws BricksetException;

	/**
	 * Get a list of themes, with the total number of sets in each.
	 * 
	 * @return the list of themes
	 * @throws BricksetException if status is not success
	 */
	List<Theme> getThemes() throws BricksetException;

	/**
	 * Get a list of subthemes for a given theme, with the total number of sets in
	 * each.
	 * 
	 * @param theme a theme
	 * @return a list of subthemes
	 * @throws BricksetException if status is not success
	 */
	List<Subtheme> getSubthemes(String theme) throws BricksetException;

	/**
	 * Get a list of years for a given theme, with the total number of sets in each.
	 * 
	 * @param theme theme
	 * @return a list of years
	 * @throws BricksetException if status is not success
	 */
	List<Year> getYears(String theme) throws BricksetException;

	// ************************************
	// Set collection management
	// ************************************

	/**
	 * Set a user's collection details.
	 * 
	 * @param setId    Set ID.
	 * @param params   parameters
	 * @param userHash user hash
	 * @throws BricksetException if status is not success
	 */
	void setCollection(int setId, SetCollectionParameters params, String userHash) throws BricksetException;

	/**
	 * Get all of a user's set notes.
	 * 
	 * @param userHash user hash
	 * @return a list of user's notes
	 * @throws BricksetException if status is not success
	 */
	List<UserNotes> getUserNotes(String userHash) throws BricksetException;

	/**
	 * Get all of a user's minifigure notes.
	 * 
	 * @param userHash userhash
	 * @return a list of all user's notes
	 * @throws BricksetException if status is not success
	 */
	List<UserMinifigNotes> getUserMinifigNotes(String userHash) throws BricksetException;

	// ************************************
	// Minifig collection management
	// ************************************

	/**
	 * Get a list of minifigs owned/wanted by a user.
	 * 
	 * @param params   parameters
	 * @param userHash user hash
	 * @return a list of minifigs
	 * @throws BricksetException if status is not success
	 */
	List<MinifigCollection> getMinifigCollection(GetMinifigCollectionParameters params, String userHash)
			throws BricksetException;

	/**
	 * Add/change a user's 'loose' minifig collection.
	 * 
	 * @param minifigNumber minifig number
	 * @param params        parameters
	 * @param userHash      user hash
	 * @throws BricksetException if status is not success
	 */
	void setMinifigCollection(String minifigNumber, SetMinifigCollectionParameters params, String userHash)
			throws BricksetException;
}
