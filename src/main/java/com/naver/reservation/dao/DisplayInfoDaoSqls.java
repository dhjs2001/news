package com.naver.reservation.dao;

public class DisplayInfoDaoSqls {
	public static final String SELECT = "SELECT id, product_id, opening_hours, place_name place_lot, place_street, tel, homepage, email, create_date, modify_date from display_info ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from display_info where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from display_info";
	public static final String UPDATE = "UPDATE display_info set :columns = :value where id = :id";

}
