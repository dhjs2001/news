package com.naver.reservation.detail.dto;

public class FileName {
	private String fileInfoId;
	private String saveFileName;
	public String getFileInfoId() {
		return fileInfoId;
	}
	public void setFileInfoId(String fileInfoId) {
		this.fileInfoId = fileInfoId;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "FileName [fileInfoId=" + fileInfoId + ", saveFileName=" + saveFileName + "]";
	}
	
}
