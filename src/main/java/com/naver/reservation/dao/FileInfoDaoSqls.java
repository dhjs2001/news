package com.naver.reservation.dao;

public class FileInfoDaoSqls {
	public static final String SELECT = "SELECT id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date from file_info ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from file_info where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from file_info";
	

}
