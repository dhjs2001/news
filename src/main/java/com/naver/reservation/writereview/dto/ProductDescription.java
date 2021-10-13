package com.naver.reservation.writereview.dto;

public class ProductDescription {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductDescription [description=" + description + "]";
	}

}
