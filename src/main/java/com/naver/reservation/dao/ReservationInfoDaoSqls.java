package com.naver.reservation.dao;

public class ReservationInfoDaoSqls {
	public static final String SELECT = "SELECT id, product_id, display_info_id, reservation_name, reservation_tel, reservation_email, reservation_date, cancel_flag, create_date, modify_date from reservation_info ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from reservation_info where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from reservation_info";
	public static final String UPDATE = "UPDATE reservation_info set :column = :value where id = :id";
	

}
