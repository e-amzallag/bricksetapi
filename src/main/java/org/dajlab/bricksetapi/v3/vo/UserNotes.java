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
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserNotes {

	@JsonProperty("setID")
	private int setId;

	private String notes;

	/**
	 * @return the setId
	 */
	public final int getSetId() {
		return setId;
	}

	/**
	 * @param setId the setId to set
	 */
	public final void setSetId(int setId) {
		this.setId = setId;
	}

	/**
	 * @return the userNotes
	 */
	public final String getNotes() {
		return notes;
	}

	/**
	 * @param userNotes the userNotes to set
	 */
	public final void setNotes(String userNotes) {
		this.notes = userNotes;
	}

}
