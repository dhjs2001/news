package com.naver.reservation.reservation.dao;

public class ReservationPageInfoDaoSqls {
	public static final String SELECT = "SELECT a.id, a.description, b.price_type_name, b.price, b.discount_rate, c.opening_hours, c.place_street, e.file_name, b.id as product_price_id, c.id as display_info_id\r\n"
			+ "FROM product as a\r\n"
			+ "JOIN\r\n"
			+ "product_price as b\r\n"
			+ "ON\r\n"
			+ "a.id = b.product_id\r\n"
			+ "JOIN display_info as c\r\n"
			+ "ON a.id = c.product_id\r\n"
			+ "JOIN product_image as d\r\n"
			+ "ON a.id = d.product_id\r\n"
			+ "JOIN file_info as e\r\n"
			+ "ON d.file_id = e.id WHERE a.id = :id AND d.type = 'ma'";

}
