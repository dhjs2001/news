package com.naver.reservation.detail.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.detail.dto.ReservationInfo;
import static com.naver.reservation.detail.dao.ReservationInfoDaoSqls.*;

import java.util.Collections;
import java.util.List;
@Repository
public class ReservationInfoDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	
	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationInfo> getReview(int id){
		List<ReservationInfo> list = jdbc.query(SELECT, Collections.singletonMap("id", id), rowMapper);
		return list;
	}
}
