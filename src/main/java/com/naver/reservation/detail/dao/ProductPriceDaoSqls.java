package com.naver.reservation.detail.dao;

public class ProductPriceDaoSqls {
	public final static String SELECT = "SELECT product_id, price_type_name, price, discount_rate FROM product_price WHERE product_id =:id";

}
