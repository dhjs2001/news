package com.naver.reservation.dao;

public class ProductImageDaoSqls {
	public static final String SELECT = "SELECT id, product_id, type, file_id from product_image ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from product_image where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from product_image";
	public static final String SELECT_PROMOTION_IMAGE = "SELECT id, product_id, type, file_id FROM product_image WHERE type = 'ma' and product_id IN (SELECT product_id FROM promotion)";
}
