package com.naver.reservation.reservation.dao;

public class ReservationInfoDaoSqls {
	public final static String SELECT = "SELECT id, product_id, display_info_id, reservation_name, reservation_tel, reservation_email, reservation_date, cancel_flag, create_date, modify_date FROM reservation_info WHERE id = :id";
	public final static String CANCEL_UPDATE = "UPDATE reservation_info SET cancel_flag = 1 WHERE id = :id";

}
