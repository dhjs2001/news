package com.naver.reservation.reservation.dto;

public class ReservationPageInfo {
	private int id;
	private String description;
	private String priceTypeName;
	private int price;

	private int discountRate;
	private String openingHours;
	private String placeStreet;
	private String fileName;
	private String productPriceId;
	private String displayInfoId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(String productPriceId) {
		this.productPriceId = productPriceId;
	}

	public String getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(String displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	@Override
	public String toString() {
		return "ReservationPageInfo [id=" + id + ", description=" + description + ", priceTypeName=" + priceTypeName
				+ ", price=" + price + ", discountRate=" + discountRate + ", openingHours=" + openingHours
				+ ", placeStreet=" + placeStreet + ", fileName=" + fileName + ", productPriceId=" + productPriceId
				+ ", displayInfoId=" + displayInfoId + "]";
	}

}