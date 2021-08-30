package com.naver.reservation.detail.dto;

public class ProductPrice {
	private int productId;
	private String priceTypeName;
	private int price;
	private int discountRate;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	@Override
	public String toString() {
		return "ProductPrice [productId=" + productId + ", priceTypeName=" + priceTypeName + ", price=" + price
				+ ", discountRate=" + discountRate + "]";
	}
}
