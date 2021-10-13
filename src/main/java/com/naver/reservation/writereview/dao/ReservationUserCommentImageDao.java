package com.naver.reservation.writereview.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.naver.reservation.writereview.dto.ReservationUserCommentImage;

@Repository
public class ReservationUserCommentImageDao {
	SimpleJdbcInsert insertAction;
	
	public ReservationUserCommentImageDao(DataSource dataSource) {
		this.insertAction = new SimpleJdbcInsert(dataSource).usingGeneratedKeyColumns("id").withTableName("reservation_user_comment_image");
	}
	
	public int insertAction(ReservationUserCommentImage object) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(object);
		int key = insertAction.executeAndReturnKey(params).intValue();
		return key;
	}

}
