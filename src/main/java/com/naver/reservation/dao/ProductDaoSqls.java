package com.naver.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT = "SELECT id, category_id, description, content, event, create_date, modify_date from product ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from product where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from product";
	public static final String UPDATE = "UPDATE product set :column = :value where id = :id";
	public static final String SELECT_PROMOTION= "SELECT id, description FROM product WHERE id in (SELECT product_id FROM promotion)";
}
