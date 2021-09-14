package com.naver.reservation.detail.dto;

public class ProductSpecificInfo {
	private int productId;
	private String reservationName;
	private double score;
	private String comment;
	private String reservationEmail;
	private String fileName;
	private String createDate;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "ReservationInfo [productId=" + productId + ", reservationName=" + reservationName + ", score=" + score
				+ ", comment=" + comment + ", reservationEmail=" + reservationEmail + ", fileName=" + fileName
				+ ", createDate=" + createDate + "]";
	}
	
	
}
