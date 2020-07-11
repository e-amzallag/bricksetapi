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

public class ApiKeyUsage {

	private Calendar dateStamp;

	private Integer count;

	/**
	 * @return the dateStamp
	 */
	public Calendar getDateStamp() {
		return dateStamp;
	}

	/**
	 * @param dateStamp the dateStamp to set
	 */
	public void setDateStamp(Calendar dateStamp) {
		this.dateStamp = dateStamp;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

}
