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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.dajlab.bricksetapi.v3.service.impl.BricksetServiceImpl;
import org.dajlab.bricksetapi.v3.service.impl.GeneralServiceImpl;
import org.dajlab.bricksetapi.v3.vo.ApiKeyUsage;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.MessageEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GeneralServiceTest {

	private static BricksetServiceImpl bricksetService;

	private static String login;

	private static String pwd;

	private static String userhash;

	private static SimpleDateFormat YYYY_MM_DD_DASH = new SimpleDateFormat("yyyy-MM-dd");

	@BeforeAll
	public static void before() {
		ResourceBundle rb = ResourceBundle.getBundle("parameters");
		String apikey = rb.getString("apikey");
		bricksetService = new BricksetServiceImpl(apikey);
		login = rb.getString("login");
		pwd = rb.getString("password");
		userhash = rb.getString("userhash");
	}

	@Test
	public void testCheckKey() {

		try {
			boolean response = bricksetService.checkKey();
			assertTrue(response, "Check key failed");
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testCheckKeyFail() {

		GeneralServiceImpl generalService = new GeneralServiceImpl("aaaa");
		try {
			generalService.checkKey();
			fail("Expected exception not throwned");
		} catch (BricksetException e) {
			assertEquals(MessageEnum.INVALID_API_KEY, e.getCodeMessage(), "Correct exception");
		}

	}

	@Test
	public void testLogin() {

		try {
			String response = bricksetService.login(login, pwd);
			System.out.println("User hash = " + response);
			assertEquals(userhash, response);
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testLoginFail() {

		try {
			bricksetService.login(login, "azerty");
			fail("Expected exception not throwned");
		} catch (BricksetException e) {
			assertEquals(MessageEnum.INVALID_USERNAME_OR_PASSWORD, e.getCodeMessage(), "Correct exception");
		}
	}

	@Test
	public void testCheckUserHash() {
		try {
			boolean response = bricksetService.checkUserHash(userhash);
			assertTrue(response, "Check user hash failed");
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testCheckUserHashFail() {
		try {
			bricksetService.checkUserHash("aaaa");
			fail("Expected exception not throwned");
		} catch (BricksetException e) {
			assertEquals(MessageEnum.INVALID_USER_HASH, e.getCodeMessage(), "Correct exception");
		}
	}

	@Test
	public void testGetKeyUsageStats() {
		try {
			List<ApiKeyUsage> usages = bricksetService.getKeyUsageStats();
			for (ApiKeyUsage usage : usages) {
				System.out.println(usage.getCount() + " for " + YYYY_MM_DD_DASH.format(usage.getDateStamp().getTime()));
			}
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

}
