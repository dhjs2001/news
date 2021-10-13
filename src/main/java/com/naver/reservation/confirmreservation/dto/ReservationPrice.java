package com.naver.reservation.confirmreservation.dto;

public class ReservationPrice {
	int id;
	int count;
	int price;
	String priceTypeName;
	int discountRate;
	

	public String getPriceTypeName() {
		return priceTypeName;
	}
	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
		return "ReservationPrice [id=" + id + ", count=" + count + ", price=" + price + ", priceTypeName="
				+ priceTypeName + ", discountRate=" + discountRate + "]";
	}
	

}
