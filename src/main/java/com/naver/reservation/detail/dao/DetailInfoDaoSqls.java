package com.naver.reservation.detail.dao;


public class DetailInfoDaoSqls {
	public final static String SELECT ="SELECT a.description, a.content, a.event, c.file_name FROM product AS a INNER JOIN product_image AS b ON a.id = b.product_id INNER JOIN file_info AS c ON b.file_id = c.id WHERE a.id = :id AND b.type IN ('ma', 'et')";
	public final static String SELECT_COUNT = "SELECT count(*) FROM product AS a INNER JOIN product_image AS b ON a.id = b.product_id INNER JOIN file_info AS c ON b.file_id = c.id WHERE a.id = :id AND b.type IN ('ma', 'et')";

}
