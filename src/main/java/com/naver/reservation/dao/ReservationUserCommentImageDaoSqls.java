package com.naver.reservation.dao;

public class ReservationUserCommentImageDaoSqls {
	public static final String SELECT = "SELECT id, reservation_info_id, reservation_user_comment_id, file_id from reservation_user_comment_image ORDER BY id DESC limit :start, :limit";
	public static final String DELETE_BY_ID = "DELETE from reservation_user_comment_image where id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) from reservation_user_comment_image";

}
