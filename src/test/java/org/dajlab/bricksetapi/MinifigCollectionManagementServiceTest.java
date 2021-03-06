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
import org.dajlab.bricksetapi.v3.vo.GetMinifigCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.MinifigCollection;
import org.dajlab.bricksetapi.v3.vo.SetMinifigCollectionParameters;
import org.dajlab.bricksetapi.v3.vo.UserMinifigNotes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MinifigCollectionManagementServiceTest {

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
	public void testSetMinifigCollectionNote() {
		try {
			SetMinifigCollectionParameters params = new SetMinifigCollectionParameters();
			params.setNotes("Roger bis");
			bricksetService.setMinifigCollection("sw0756", params, userhash);

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetMinifigCollection() {
		try {
			GetMinifigCollectionParameters params = new GetMinifigCollectionParameters();
			params.setQuery("Captain");
			List<MinifigCollection> minifigs = bricksetService.getMinifigCollection(params, userhash);
			assertNotNull(minifigs, "Minifig collection null");
			for (MinifigCollection minifig : minifigs) {
				System.out.println(minifig.getMinifigNumber() + " - " + " - " + minifig.getName() + " - "
						+ minifig.getCategory() + " - " + minifig.getOwnedInSets());
			}
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSetMinifigCollection() {
		try {
			SetMinifigCollectionParameters params = new SetMinifigCollectionParameters();
			params.setOwn(true).setQuantityOwned(2);
			// params.setOwn(false);
			bricksetService.setMinifigCollection("st007", params, userhash);

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getUserMinifigNotes() {
		try {
			List<UserMinifigNotes> notes = bricksetService.getUserMinifigNotes(userhash);
			assertNotNull(notes, "User minifigure notes null");
			for (UserMinifigNotes note : notes) {
				System.out.println(note.getMinifigNumber() + " - " + note.getNotes());
			}
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}
}
