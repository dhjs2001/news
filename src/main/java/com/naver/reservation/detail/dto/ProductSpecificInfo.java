package com.naver.reservation.detail.dto;

import java.util.List;

public class ProductSpecificInfo {
	private int reservationUserCommentId;
	private int productId;
	private String reservationName;
	private double score;
	private String comment;
	private String reservationEmail;
	private List<String> saveFileName;
	private String createDate;
	
	
	
	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}



	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}



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



	public List<String> getSaveFileName() {
		return saveFileName;
	}



	public void setSaveFileName(List<String> saveFileName) {
		this.saveFileName = saveFileName;
	}



	public String getCreateDate() {
		return createDate;
	}



	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	@Override
	public String toString() {
		return "ProductSpecificInfo [reservationUserCommentId=" + reservationUserCommentId + ", productId=" + productId
				+ ", reservationName=" + reservationName + ", score=" + score + ", comment=" + comment
				+ ", reservationEmail=" + reservationEmail + ", saveFileName=" + saveFileName + ", createDate="
				+ createDate + "]";
	}
	
	
	
}
