package com.naver.reservation.main.dto;

public class MainProduct {
	private long id;
	private String description;
	private String content;
	private String fileName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "MainProduct [id=" + id + ", description=" + description + ", content=" + content + ", fileName="
				+ fileName + "]";
	}

}
