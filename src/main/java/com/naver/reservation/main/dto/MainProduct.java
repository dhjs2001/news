package com.naver.reservation.main.dto;

public class MainProduct {
	private int id;
	private String description;
	private String content;
	private String saveFileName;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "MainProduct [id=" + id + ", description=" + description + ", content=" + content + ", saveFileName="
				+ saveFileName + "]";
	}


}
