package com.naver.reservation.dao;

public class ReservationUserCommentDaoSqls {
	public static final String SELECT = "SELECT id, product_id, reservation_info_id, score, comment, create_date, modify_date from reservation_user_comment ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from reservation_user_comment where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from reservation_user_comment";
	public static final String UPDATE = "UPDATE reservation_user_comment set :column = :value where id = :id";
	

}
