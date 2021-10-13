package com.naver.reservation.writereview.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.naver.reservation.writereview.dto.ReservationUserComment;

@Repository
public class ReservationUserCommentDao {
	
	SimpleJdbcInsert insertAction;
	
	public ReservationUserCommentDao(DataSource dataSource) {
		this.insertAction = new SimpleJdbcInsert(dataSource).usingGeneratedKeyColumns("id").withTableName("reservation_user_comment");
	}
	
	
	public int insertAction(ReservationUserComment object) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(object);
		int key = insertAction.executeAndReturnKey(param).intValue();
		return key;
	}

}

