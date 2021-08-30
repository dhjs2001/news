package com.naver.reservation.dao;

public class DisplayInfoImageDaoSqls {
	public static final String SELECT = "SELECT id, display_info_id, file_id from display_info_image ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from display_info_image where id = :id"; 
	public static final String SELECT_COUNT = "select count(*) from display_info_image";
	

}
