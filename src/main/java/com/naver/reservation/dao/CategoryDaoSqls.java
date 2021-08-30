package com.naver.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT = "SELECT id, name from Category ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from Category where id= :id";
	public static final String SELECT_COUNT = "SELECT count(*) from Category";

}
