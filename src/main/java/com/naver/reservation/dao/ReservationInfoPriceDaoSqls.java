package com.naver.reservation.dao;

public class ReservationInfoPriceDaoSqls {
	public static final String SELECT = "SELECT id, reservation_info_id, product_price_id, count from reservation_info_price ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from reservation_info_price where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from reservation_info_price";

}
