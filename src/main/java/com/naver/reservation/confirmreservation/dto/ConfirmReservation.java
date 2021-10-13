package com.naver.reservation.confirmreservation.dto;

public class ConfirmReservation {
	int id;
	int productId;
	int cancelFlag;
	int usedFlag;
	String description;
	String openingHours;
	String placeName;
	int totalPrice;
	String history;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public int getUsedFlag() {
		return usedFlag;
	}
	public void setUsedFlag(int usedFlag) {
		this.usedFlag = usedFlag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "ConfirmReservation [id=" + id + ", productId=" + productId + ", cancelFlag=" + cancelFlag
				+ ", usedFlag=" + usedFlag + ", description=" + description + ", openingHours=" + openingHours
				+ ", placeName=" + placeName + ", totalPrice=" + totalPrice + ", history=" + history + "]";
	}
	
	


}
