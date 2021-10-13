package com.naver.reservation.confirmreservation.dao;

public class ConfirmReservationDaoSqls {
	public static final String SELECT = "SELECT a.id, a.product_id, a.cancel_flag, a.used_flag, b.description, c.opening_hours, c.place_name \r\n"
			+ "FROM\r\n"
			+ "reservation_info as a\r\n"
			+ "JOIN\r\n"
			+ "product as b\r\n"
			+ "ON\r\n"
			+ "a.product_id = b.id\r\n"
			+ "JOIN\r\n"
			+ "display_info as c\r\n"
			+ "ON\r\n"
			+ "b.id = c.product_id\r\n"
			+ "WHERE a.reservation_email = :email";

	public static final String SELECTALL = "SELECT a.id, a.product_id, a.cancel_flag, a.used_flag, b.description, c.opening_hours, c.place_name \r\n"
			+ "FROM\r\n"
			+ "reservation_info as a\r\n"
			+ "JOIN\r\n"
			+ "product as b\r\n"
			+ "ON\r\n"
			+ "a.product_id = b.id\r\n"
			+ "JOIN\r\n"
			+ "display_info as c\r\n"
			+ "ON\r\n"
			+ "b.id = c.product_id\r\n";

	public static final String UPDATE_USED_FLAG = "UPDATE reservation_info SET used_flag = 1, modify_date = :date WHERE id = :id";
	public static final String UPDATE_CANCEL_FLAG = "UPDATE reservation_info SET cancel_flag = 1, modify_date = :date WHERE id = :id";
}
