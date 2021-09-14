package com.naver.reservation.login.dao;

public class ReservationCountDaoSqls {
	public static final String SELECT_COUNT ="SELECT count(reservation_email) as count FROM reservation_info WHERE reservation_email = :email;";

}
