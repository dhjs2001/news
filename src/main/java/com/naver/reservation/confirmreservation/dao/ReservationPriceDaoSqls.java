package com.naver.reservation.confirmreservation.dao;

public class ReservationPriceDaoSqls {
	public static final String SELECT = "SELECT a.id, d.count, e.price_type_name, e.price, e.discount_rate\r\n"
			+ "FROM\r\n"
			+ "reservation_info as a\r\n"
			+ "JOIN\r\n"
			+ "reservation_info_price as d\r\n"
			+ "ON\r\n"
			+ "a.id = d.reservation_info_id\r\n"
			+ "JOIN\r\n"
			+ "product_price as e\r\n"
			+ "ON\r\n"
			+ "d.product_price_id = e.id\r\n"
			+ "WHERE a.id = :id;";

}
