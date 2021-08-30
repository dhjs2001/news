package com.naver.reservation.main.dao;


public class MainProductDaoSqls {
	public static final String SELECT_PROMOTION = "SELECT a.description, c.file_name FROM product as a INNER JOIN product_image as b on a.id = b.product_id INNER JOIN file_info as c on b.file_id = c.id WHERE b.type = :type and a.id IN (SELECT product_id FROM promotion)";
	public static final String SELECT_PRODUCT_BY_CATEGORY_ID = "SELECT a.id, a.description, a.content, c.file_name FROM product as a INNER JOIN product_image as b on a.id = b.product_id INNER JOIN file_info as c on b.file_id = c.id WHERE b.type ='th' and a.category_id = :id limit :start, :limit";
	public static final String SELECT_ALLPRODUCT_BY_CATEGORY_ID = "SELECT a.id, a.description, a.content, c.file_name FROM product as a INNER JOIN product_image as b on a.id = b.product_id INNER JOIN file_info as c on b.file_id = c.id WHERE b.type ='th' and a.category_id = :id limit :start";
	public static final String SELECT_PRODUCT = "SELECT a.id, a.description, a.content, c.file_name FROM product as a INNER JOIN product_image as b on a.id = b.product_id INNER JOIN file_info as c on b.file_id = c.id WHERE b.type ='th' limit :start, :limit";
	public static final String COUNT_PRODUCT = "SELECT count(*) from product";
	public static final String COUNT_PRODUCT_BY_CATEGORY_ID = "SELECT count(*) FROM product WHERE category_id = :id";
	public static final int LIMIT = 4;

}
