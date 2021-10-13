package com.naver.reservation.detail.dao;

public class DisplayInfoDaoSqls {
	public static final String SELECT = "SELECT a.description, b.place_street, b.place_lot, b.place_name, b.tel, d.save_file_name FROM product AS a \r\n"
			+ "JOIN \r\n"
			+ "display_info AS b \r\n"
			+ "ON a.id = b.product_id \r\n"
			+ "JOIN\r\n"
			+ "display_info_image as c\r\n"
			+ "ON b.id = c.display_info_id \r\n"
			+ "JOIN\r\n"
			+ "file_info as d \r\n"
			+ "ON c.file_id = d.id where a.id = :id;"; 

}
