package com.naver.reservation.reservation.dao;

public class ReservationInfoPriceDaoSqls {
	public final static String SELECT = "SELECT id, reservation_info_id, product_price_id, count FROM reservation_info_price where id = :id"; 

}
