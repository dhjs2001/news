package com.naver.reservation.detail.dto;

public class DetailInfo {
	private String description;
	private String content;
	private String event;
	private String fileName;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "DetailInfo [description=" + description + ", content=" + content + ", event=" + event + ", fileName="
				+ fileName + ", count=" + count + "]";
	}

}
