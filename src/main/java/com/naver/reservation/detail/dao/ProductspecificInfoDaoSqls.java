package com.naver.reservation.detail.dao;

public class ProductspecificInfoDaoSqls {
	public final static String SELECT = "SELECT a.product_id, b.reservation_name, a.score, a.comment, b.reservation_email, d.file_name, a.create_date\r\n"
			+ "FROM\r\n"
			+ "reservation_user_comment AS a\r\n"
			+ "LEFT JOIN\r\n"
			+ "reservation_info AS b\r\n"
			+ "ON \r\n"
			+ "a.reservation_info_id = b.id \r\n"
			+ "LEFT JOIN \r\n"
			+ "reservation_user_comment_image AS c \r\n"
			+ "ON\r\n"
			+ "a.id = c.reservation_user_comment_id \r\n"
			+ "LEFT JOIN file_info AS d \r\n"
			+ "ON c.file_id = d.id WHERE a.product_id = :id;";

}
