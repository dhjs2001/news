package com.naver.reservation.detail.dto;

public class DisplayInfo {
	private String description;
	private String placeStreet;
	private String placeLot;
	private String placeName;
	private String tel;
	private String fileName;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	public String getPlaceLot() {
		return placeLot;
	}
	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "DisplayInfo [description=" + description + ", placeStreet=" + placeStreet + ", placeLot=" + placeLot
				+ ", placeName=" + placeName + ", tel=" + tel + ", fileName=" + fileName + "]";
	}

}
