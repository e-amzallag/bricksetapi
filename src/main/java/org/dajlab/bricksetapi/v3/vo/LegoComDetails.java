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

import java.math.BigDecimal;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LegoComDetails {

	private BigDecimal retailPrice;

	private Calendar dateFirstAvailable;
	private Calendar dateLastAvailable;

	/**
	 * @return the retailPrice
	 */
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	/**
	 * @param retailPrice the retailPrice to set
	 */
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * @return the dateFirstAvailable
	 */
	public Calendar getDateFirstAvailable() {
		return dateFirstAvailable;
	}

	/**
	 * @param dateFirstAvailable the dateFirstAvailable to set
	 */
	public void setDateFirstAvailable(Calendar dateFirstAvailable) {
		this.dateFirstAvailable = dateFirstAvailable;
	}

	/**
	 * @return the dateLastAvailable
	 */
	public Calendar getDateLastAvailable() {
		return dateLastAvailable;
	}

	/**
	 * @param dateLastAvailable the dateLastAvailable to set
	 */
	public void setDateLastAvailable(Calendar dateLastAvailable) {
		this.dateLastAvailable = dateLastAvailable;
	}

}
