package com.naver.reservation.detail.dao;

public class ProductspecificInfoDaoSqls {
	public final static String SELECT = "SELECT a.id as reservation_user_comment_id, a.product_id, b.reservation_name, a.score, a.comment, b.reservation_email, a.create_date\r\n"
			+ "FROM\r\n"
			+ "reservation_user_comment AS a\r\n"
			+ "LEFT JOIN\r\n"
			+ "reservation_info AS b\r\n"
			+ "ON \r\n"
			+ "a.reservation_info_id = b.id \r\n"
			+ "WHERE a.product_id = :id \r\n"
			+ "ORDER BY a.id DESC;";
	
	public final static String SELECT_BY_RESERVATION_COMMENT_ID = "SELECT a.id as reservation_user_comment_id, a.product_id, b.reservation_name, a.score, a.comment, b.reservation_email, a.create_date\r\n"
			+ "FROM\r\n"
			+ "reservation_user_comment AS a\r\n"
			+ "LEFT JOIN\r\n"
			+ "reservation_info AS b\r\n"
			+ "ON \r\n"
			+ "a.reservation_info_id = b.id \r\n"
			+ "WHERE a.id = :id \r\n"
			+ "ORDER BY a.id DESC;";

}
