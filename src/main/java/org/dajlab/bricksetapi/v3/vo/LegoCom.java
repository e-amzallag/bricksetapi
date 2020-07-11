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
public class LegoCom {

	@JsonProperty("US")
	private LegoComDetails us;
	@JsonProperty("UK")
	private LegoComDetails uk;
	@JsonProperty("CA")
	private LegoComDetails ca;
	@JsonProperty("DE")
	private LegoComDetails de;

	/**
	 * @return the us
	 */
	public LegoComDetails getUs() {
		return us;
	}

	/**
	 * @param us the us to set
	 */
	public void setUs(LegoComDetails us) {
		this.us = us;
	}

	/**
	 * @return the uk
	 */
	public LegoComDetails getUk() {
		return uk;
	}

	/**
	 * @param uk the uk to set
	 */
	public void setUk(LegoComDetails uk) {
		this.uk = uk;
	}

	/**
	 * @return the ca
	 */
	public LegoComDetails getCa() {
		return ca;
	}

	/**
	 * @param ca the ca to set
	 */
	public void setCa(LegoComDetails ca) {
		this.ca = ca;
	}

	/**
	 * @return the de
	 */
	public LegoComDetails getDe() {
		return de;
	}

	/**
	 * @param de the de to set
	 */
	public void setDe(LegoComDetails de) {
		this.de = de;
	}

}
