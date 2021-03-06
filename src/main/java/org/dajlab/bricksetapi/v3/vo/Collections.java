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
public class Collections {

	private Integer ownedBy;

	private Integer wantedBy;

	/**
	 * @return the ownedBy
	 */
	public Integer getOwnedBy() {
		return ownedBy;
	}

	/**
	 * @param ownedBy the ownedBy to set
	 */
	public void setOwnedBy(Integer ownedBy) {
		this.ownedBy = ownedBy;
	}

	/**
	 * @return the wantedBy
	 */
	public Integer getWantedBy() {
		return wantedBy;
	}

	/**
	 * @param wantedBy the wantedBy to set
	 */
	public void setWantedBy(Integer wantedBy) {
		this.wantedBy = wantedBy;
	}

}
