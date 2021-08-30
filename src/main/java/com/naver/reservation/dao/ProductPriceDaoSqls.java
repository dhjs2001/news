package com.naver.reservation.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT = "SELCT id, product_id, price_type_name, price, discount_rate, create_date, modify_date from product_price ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from product_price where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from product_price";
	public static final String UPDATE = "UPDATE product_price set :column = :value where id = :id";
			

}
