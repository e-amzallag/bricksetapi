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
package org.dajlab.bricksetapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.ResourceBundle;

import org.dajlab.bricksetapi.v3.service.impl.BricksetServiceImpl;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.SetCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.UserNotes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SetCollectionManagementServiceTest {

	private static BricksetServiceImpl bricksetService;

	private static String userhash;

	@BeforeAll
	public static void before() {
		ResourceBundle rb = ResourceBundle.getBundle("parameters");
		String apikey = rb.getString("apikey");
		bricksetService = new BricksetServiceImpl(apikey);
		userhash = rb.getString("userhash");
	}

	@Test
	public void testSetCollection() {

		try {
			// Set 10271-1
			SetCollectionParameters params = new SetCollectionParameters();
			params.setOwn(true).setQuantityOwned(2).setNotes("X-Mas Gift");
			bricksetService.setCollection(29962, params, userhash);
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getUserNotes() {
		try {
			List<UserNotes> usernotes = bricksetService.getUserNotes(userhash);
			assertNotNull(usernotes, "User notes null");
			for (UserNotes userNote : usernotes) {
				System.out.println(userNote.getSetId() + " - " + userNote.getNotes());
			}
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

}
