package com.naver.reservation.detail.dto;

public class DetailInfo {
	private String description;
	private String content;
	private String event;
	private String saveFileName;
	private int count;
	

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


	public String getSaveFileName() {
		return saveFileName;
	}


	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "DetailInfo [description=" + description + ", content=" + content + ", event=" + event
				+ ", saveFileName=" + saveFileName + ", count=" + count + "]";
	}

}
