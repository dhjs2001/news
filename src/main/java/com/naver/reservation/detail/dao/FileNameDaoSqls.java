package com.naver.reservation.detail.dao;

public class FileNameDaoSqls {
	public final static String SELECT = "SELECT a.id as file_info_id, a.save_file_name \r\n"
			+ "FROM file_info as a \r\n"
			+ "LEFT JOIN reservation_user_comment_image as b\r\n"
			+ "ON a.id = b.file_id \r\n"
			+ "WHERE b.reservation_user_comment_id = :id;";

}
