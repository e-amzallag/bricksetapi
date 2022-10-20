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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import org.dajlab.bricksetapi.v3.service.impl.BricksetServiceImpl;
import org.dajlab.bricksetapi.v3.vo.AdditionalImages;
import org.dajlab.bricksetapi.v3.vo.AgeRange;
import org.dajlab.bricksetapi.v3.vo.Barcodes;
import org.dajlab.bricksetapi.v3.vo.BricksetException;
import org.dajlab.bricksetapi.v3.vo.Collections;
import org.dajlab.bricksetapi.v3.vo.Dimensions;
import org.dajlab.bricksetapi.v3.vo.ExtendedData;
import org.dajlab.bricksetapi.v3.vo.Image;
import org.dajlab.bricksetapi.v3.vo.Instruction;
import org.dajlab.bricksetapi.v3.vo.LegoCom;
import org.dajlab.bricksetapi.v3.vo.LegoComDetails;
import org.dajlab.bricksetapi.v3.vo.OrderByEnum;
import org.dajlab.bricksetapi.v3.vo.Rating;
import org.dajlab.bricksetapi.v3.vo.Reviews;
import org.dajlab.bricksetapi.v3.vo.Set;
import org.dajlab.bricksetapi.v3.vo.SetParameters;
import org.dajlab.bricksetapi.v3.vo.Subtheme;
import org.dajlab.bricksetapi.v3.vo.Theme;
import org.dajlab.bricksetapi.v3.vo.Year;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SetsServiceTest {

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
	public void testGetSetsNoExist() {

		try {
			SetParameters params = new SetParameters();
			params.addSetNumber("3009-1");
			List<Set> sets = bricksetService.getSets(params, userhash);
			assertNotNull(sets, "List null");
			assertEquals(0, sets.size(), "A result was found");
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSetQuerySetNumber() {

		try {
			SetParameters params = new SetParameters();
			params.addSetNumber("60132-1").withExtendedData();
			List<Set> sets = bricksetService.getSets(params, userhash);
			assertTrue(!sets.isEmpty(), "No matches");
			for (Set set : sets) {
				System.out.println(set.getNumber() + "-" + set.getNumberVariant() + " - " + set.getYear());
				assertEquals("Service Station", set.getName());
				assertEquals("Retail", set.getAvailability());
				assertEquals("https://brickset.com/sets/60132-1", set.getBricksetURL());
				assertEquals("Normal", set.getCategory());
				assertEquals("60132", set.getNumber());
				assertEquals(1, set.getNumberVariant());
				assertEquals("Box", set.getPackagingType());
				assertEquals(25931, set.getSetId());
				assertEquals("Traffic", set.getSubtheme());
				assertEquals("City", set.getTheme());
				assertEquals("Modern day", set.getThemeGroup());
				assertEquals(13, set.getAdditionalImageCount().intValue());
				assertEquals(4, set.getInstructionsCount().intValue());
				assertNotNull(set.getLastUpdated());
				assertEquals(4, set.getMinifigs().intValue());
				assertEquals(515, set.getPieces().intValue());
				assertNotNull(set.getRating());
				assertTrue(set.getReleased());
				assertNotNull(set.getReviewCount());
				assertEquals(2016, set.getYear().intValue());

				AgeRange ageRange = set.getAgeRange();
				assertEquals(7, ageRange.getMin().intValue());
				assertEquals(12, ageRange.getMax().intValue());

				Barcodes barcodes = set.getBarcode();
				assertEquals("5702015594936", barcodes.getEan());
				assertEquals("673419250030", barcodes.getUpc());

				Collections collections = set.getCollections();
				assertTrue(collections.getOwnedBy() > 0);
				assertTrue(collections.getWantedBy() > 0);

				Dimensions dimensions = set.getDimensions();
				assertEquals(7.8486, dimensions.getDepth().doubleValue());
				assertEquals(28.194, dimensions.getHeight().doubleValue());
				assertEquals(54.0004, dimensions.getWidth().doubleValue());
				assertEquals(1.36531186, dimensions.getWeight().doubleValue());

				ExtendedData ext = set.getExtendedData();
				assertNotNull(ext.getDescription());
				assertTrue(!ext.getTags().isEmpty());
				assertTrue(ext.getTags().contains("Truck"));

				Image images = set.getImage();
				assertEquals("https://images.brickset.com/sets/images/60132-1.jpg", images.getImageURL());
				assertEquals("https://images.brickset.com/sets/small/60132-1.jpg", images.getThumbnailURL());

				LegoCom lego = set.getLegoCom();
				LegoComDetails detailDE = lego.getDe();
				assertEquals(69.99, detailDE.getRetailPrice().doubleValue());
				assertEquals(2016, detailDE.getDateFirstAvailable().get(Calendar.YEAR));
				assertEquals(5, detailDE.getDateFirstAvailable().get(Calendar.MONTH));
				assertEquals(3, detailDE.getDateFirstAvailable().get(Calendar.DAY_OF_MONTH));

				assertEquals(2017, detailDE.getDateLastAvailable().get(Calendar.YEAR));
				assertEquals(10, detailDE.getDateLastAvailable().get(Calendar.MONTH));
				assertEquals(14, detailDE.getDateLastAvailable().get(Calendar.DAY_OF_MONTH));
			}
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSetsByThemeAndYear() {

		try {
			SetParameters params = new SetParameters();
			params.addTheme("Architecture").addTheme("Classic").addYear("2020");
			List<Set> sets = bricksetService.getSets(params);
			assertNotNull(sets, "No matches");
			assertTrue(!sets.isEmpty(), "No matches");
			assertTrue(sets.stream().anyMatch(set -> {
				return "21054".equals(set.getNumber());
			}), "21054-1 not found");
			assertTrue(sets.stream().anyMatch(set -> {
				return "11007".equals(set.getNumber());
			}), "11007-1 not found");
			assertFalse(sets.stream().anyMatch(set -> {
				return "10271".equals(set.getNumber());
			}), "10271-1 found");
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSetsOrderBy() {

		try {
			SetParameters params = new SetParameters();
			params.setQuery("666").setOrderBy(OrderByEnum.PiecesDESC);
			List<Set> sets = bricksetService.getSets(params);
			assertNotNull(sets, "No matches");
			assertTrue(!sets.isEmpty(), "No matches");
			for (Set set : sets) {
				System.out.println(set.getNumber() + "-" + set.getNumberVariant() + " - " + set.getPieces());
			}
			Set set1 = sets.get(0);
			Set set2 = sets.get(1);
			assertTrue(set1.getPieces() > set2.getPieces());
		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSetsBySets() {

		try {
			SetParameters params = new SetParameters();
			params.addSetNumber("6080-1").addSetNumber("6081-1");
			List<Set> sets = bricksetService.getSets(params);
			assertNotNull(sets, "No matches");
			assertEquals(2, sets.size(), "No matches");
			Set s6080 = sets.get(0);
			assertEquals("6080", s6080.getNumber());
			Set s6081 = sets.get(1);
			assertEquals("6081", s6081.getNumber());

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSetsByTag() {

		try {
			SetParameters params = new SetParameters();
			params.setTag("Windmill");
			List<Set> sets = bricksetService.getSets(params);
			assertNotNull(sets, "No matches");
			assertTrue(sets.stream().anyMatch(set -> {
				return "4999".equals(set.getNumber());
			}), "4999-1 not found");

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetAdditionalImages() {

		try {
			// Set 10271-1
			List<AdditionalImages> images = bricksetService.getAdditionalImages(29962);
			assertNotNull(images, "No matches");
			assertTrue(!images.isEmpty(), "No matches");
			for (AdditionalImages image : images) {
				System.out.println(image.getImageURL());
				assertNotNull(image.getThumbnailURL(), "No thumbnail image");
				assertNotNull(image.getImageURL(), "No image");
			}

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetInstructions() {

		try {
			List<Instruction> instructions = bricksetService.getInstructions(29962);
			assertNotNull(instructions, "No matches");
			assertTrue(!instructions.isEmpty(), "No matches");
			for (Instruction instruction : instructions) {
				System.out.println(instruction.getDescription() + " - " + instruction.getUrl());
				assertNotNull(instruction.getDescription(), "No description");
				assertNotNull(instruction.getUrl(), "No url");
			}

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetInstructions2() {

		try {
			List<Instruction> instructions = bricksetService.getInstructions2("21301-1");
			assertNotNull(instructions, "No matches");
			assertTrue(!instructions.isEmpty(), "No matches");
			for (Instruction instruction : instructions) {
				System.out.println(instruction.getDescription() + " - " + instruction.getUrl());
				assertNotNull(instruction.getDescription(), "No description");
				assertNotNull(instruction.getUrl(), "No url");
			}

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetReviews() {

		try {
			SetParameters param = new SetParameters();
			param.addSetNumber("7239-1");
			List<Set> sets = bricksetService.getSets(param);
			Set set = sets.get(0);

			List<Reviews> reviews = bricksetService.getReviews(set.getSetId());
			assertNotNull(reviews, "No matches");
			assertTrue(!reviews.isEmpty(), "No matches");
			for (Reviews review : reviews) {
				System.out.println("Title = " + review.getTitle());
				System.out.println("Review = " + review.getReview());
				System.out.println("By " + review.getAuthor());
				System.out.println("Posted " + review.getDatePosted());
				System.out.println("Html " + review.getHtml());

				Rating rating = review.getRating();
				assertNotNull(review.getRating(), "No rating");
				System.out.println(rating.getBuildingExperience() + "-" + rating.getOverall() + "-" + rating.getParts()
						+ "-" + rating.getPlayability() + "-" + rating.getValueForMoney());

			}

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetThemes() {

		try {
			List<Theme> themes = bricksetService.getThemes();
			assertNotNull(themes, "No matches");
			assertTrue(!themes.isEmpty(), "No matches");
			for (Theme theme : themes) {
				System.out.println(theme.getTheme() + " - " + theme.getSetCount());
				assertNotNull(theme.getTheme(), "No theme");
				assertNotNull(theme.getSetCount(), "No set count");
			}

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSubthemes() {

		try {
			List<Subtheme> subthemes = bricksetService.getSubthemes("Mixels");
			assertNotNull(subthemes, "No matches");
			assertTrue(!subthemes.isEmpty(), "No matches");
			for (Subtheme subtheme : subthemes) {
				System.out.println(subtheme.getSubtheme() + " - " + subtheme.getSetCount());
				assertNotNull(subtheme.getTheme(), "No theme");
				assertNotNull(subtheme.getSubtheme(), "No subtheme");
				assertNotNull(subtheme.getSetCount(), "No set count");
				assertNotNull(subtheme.getYearFrom(), "No year from");
				assertNotNull(subtheme.getYearTo(), "No year to");
			}

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetYears() {

		try {
			List<Year> years = bricksetService.getYears("Mixels");
			assertNotNull(years, "No matches");
			assertTrue(!years.isEmpty(), "No matches");
			for (Year year : years) {
				System.out.println(year.getYear() + " - " + year.getSetCount());
				assertNotNull(year.getYear(), "No year");
				assertNotNull(year.getTheme(), "No theme");
				assertNotNull(year.getSetCount(), "No set count");
			}

		} catch (BricksetException e) {
			fail(e.getMessage());
		}
	}
}
