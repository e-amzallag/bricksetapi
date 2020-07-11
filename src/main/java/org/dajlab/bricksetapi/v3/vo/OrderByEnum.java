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

public enum OrderByEnum {

	Number, NumberDESC, YearFrom, YearFromDESC, Pieces, PiecesDESC, Minifigs, MinifigsDESC, Rating, RatingDESC,
	UKRetailPrice, UKRetailPriceDESC, UKPricePerPiece, UKPricePerPieceDESC, USRetailPrice, USRetailPriceDESC,
	USPricePerPiece, USPricePerPieceDESC, CARetailPrice, CARetailPriceDESC, CAPricePerPiece, CAPricePerPieceDESC,
	DERetailPrice, DERetailPriceDESC, DEPricePerPiece, DEPricePerPieceDESC, FRRetailPrice, FRetailPriceDESC,
	FRPricePerPiece, FRPricePerPieceDESC, Theme, ThemeDESC, Subtheme, SubthemeDESC, Name, NameDESC, Random, RandomDESC,
	QtyOwned, QtyOwnedDESC, OwnCount, OwnCountDESC, WantCount, WantCountDESC, UserRating, UserRatingDESC, CollectionID,
	CollectionIDDESC;
}
