package com.naver.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT = "SELECT id, product_id from promotion ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from promotion where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from promotion";

}
