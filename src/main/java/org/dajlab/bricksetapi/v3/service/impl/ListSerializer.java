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
package org.dajlab.bricksetapi.v3.service.impl;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Serializer for list.
 *
 */
public class ListSerializer extends StdSerializer<List<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3082448948641452416L;

	public ListSerializer() {
		this(null);
	}

	protected ListSerializer(Class<List<String>> t) {
		super(t);
	}

	@Override
	public void serialize(List<String> value, JsonGenerator gen, SerializerProvider provider) throws IOException {

		String valueS = String.join(",", value);
		gen.writeObject(valueS);
	}

}
