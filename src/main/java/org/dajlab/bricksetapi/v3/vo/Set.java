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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Set.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Set {

	@JsonProperty("setID")
	private int setId;
	private String number;
	private int numberVariant;
	private String name;
	private Integer year;
	private String theme;
	private String themeGroup;
	private String subtheme;
	private String category;
	private Boolean released;
	private Integer pieces;
	private Integer minifigs;
	private Image image;
	private String bricksetURL;
	private Collection collection;
	private Collections collections;
	@JsonProperty("LEGOCom")
	private LegoCom legoCom;
	private BigDecimal rating;
	private Integer reviewCount;
	private String packagingType;
	private String availability;
	private Integer instructionsCount;
	private Integer additionalImageCount;
	private AgeRange ageRange;
	private Dimensions dimensions;
	private Barcodes barcode;
	private ExtendedData extendedData;
	private Calendar lastUpdated;

	/**
	 * @return the setId
	 */
	public int getSetId() {
		return setId;
	}

	/**
	 * @param setId the setId to set
	 */
	public void setSetId(int setId) {
		this.setId = setId;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the numberVariant
	 */
	public int getNumberVariant() {
		return numberVariant;
	}

	/**
	 * @param numberVariant the numberVariant to set
	 */
	public void setNumberVariant(int numberVariant) {
		this.numberVariant = numberVariant;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the themeGroup
	 */
	public String getThemeGroup() {
		return themeGroup;
	}

	/**
	 * @param themeGroup the themeGroup to set
	 */
	public void setThemeGroup(String themeGroup) {
		this.themeGroup = themeGroup;
	}

	/**
	 * @return the subtheme
	 */
	public String getSubtheme() {
		return subtheme;
	}

	/**
	 * @param subtheme the subtheme to set
	 */
	public void setSubtheme(String subtheme) {
		this.subtheme = subtheme;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the released
	 */
	public Boolean getReleased() {
		return released;
	}

	/**
	 * @param released the released to set
	 */
	public void setReleased(Boolean released) {
		this.released = released;
	}

	/**
	 * @return the pieces
	 */
	public Integer getPieces() {
		return pieces;
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}

	/**
	 * @return the minifigs
	 */
	public Integer getMinifigs() {
		return minifigs;
	}

	/**
	 * @param minifigs the minifigs to set
	 */
	public void setMinifigs(Integer minifigs) {
		this.minifigs = minifigs;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return the bricksetURL
	 */
	public String getBricksetURL() {
		return bricksetURL;
	}

	/**
	 * @param bricksetURL the bricksetURL to set
	 */
	public void setBricksetURL(String bricksetURL) {
		this.bricksetURL = bricksetURL;
	}

	/**
	 * @return the collection
	 */
	public Collection getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	/**
	 * @return the collections
	 */
	public Collections getCollections() {
		return collections;
	}

	/**
	 * @param collections the collections to set
	 */
	public void setCollections(Collections collections) {
		this.collections = collections;
	}

	/**
	 * @return the legoCom
	 */
	public LegoCom getLegoCom() {
		return legoCom;
	}

	/**
	 * @param legoCom the legoCom to set
	 */
	public void setLegoCom(LegoCom legoCom) {
		this.legoCom = legoCom;
	}

	/**
	 * @return the rating
	 */
	public BigDecimal getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	/**
	 * @return the reviewCount
	 */
	public Integer getReviewCount() {
		return reviewCount;
	}

	/**
	 * @param reviewCount the reviewCount to set
	 */
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	/**
	 * @return the packagingType
	 */
	public String getPackagingType() {
		return packagingType;
	}

	/**
	 * @param packagingType the packagingType to set
	 */
	public void setPackagingType(String packagingType) {
		this.packagingType = packagingType;
	}

	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * @return the instructionsCount
	 */
	public Integer getInstructionsCount() {
		return instructionsCount;
	}

	/**
	 * @param instructionsCount the instructionsCount to set
	 */
	public void setInstructionsCount(Integer instructionsCount) {
		this.instructionsCount = instructionsCount;
	}

	/**
	 * @return the additionalImageCount
	 */
	public Integer getAdditionalImageCount() {
		return additionalImageCount;
	}

	/**
	 * @param additionalImageCount the additionalImageCount to set
	 */
	public void setAdditionalImageCount(Integer additionalImageCount) {
		this.additionalImageCount = additionalImageCount;
	}

	/**
	 * @return the ageRange
	 */
	public AgeRange getAgeRange() {
		return ageRange;
	}

	/**
	 * @param ageRange the ageRange to set
	 */
	public void setAgeRange(AgeRange ageRange) {
		this.ageRange = ageRange;
	}

	/**
	 * @return the dimensions
	 */
	public Dimensions getDimensions() {
		return dimensions;
	}

	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	/**
	 * @return the barcodes
	 */
	public Barcodes getBarcode() {
		return barcode;
	}

	/**
	 * @param barcodes the barcodes to set
	 */
	public void setBarcode(Barcodes barcodes) {
		this.barcode = barcodes;
	}

	/**
	 * @return the extendedData
	 */
	public ExtendedData getExtendedData() {
		return extendedData;
	}

	/**
	 * @param extendedData the extendedData to set
	 */
	public void setExtendedData(ExtendedData extendedData) {
		this.extendedData = extendedData;
	}

	/**
	 * @return the lastUpdated
	 */
	public Calendar getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Calendar lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
