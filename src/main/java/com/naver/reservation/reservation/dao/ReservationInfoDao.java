package com.naver.reservation.reservation.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.reservation.dto.ReservationInfo;
import static com.naver.reservation.reservation.dao.ReservationInfoDaoSqls.*;

@Repository
public class ReservationInfoDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	
	public ReservationInfoDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationInfo> getReservationInfos(int id) {
		Map<String,Integer> param = new HashMap<>();
		param.put("id", id);
		List<ReservationInfo> list = jdbc.query(SELECT, param, rowMapper);
		return list;
		
	}
	
	public int cancelReservation(int id){
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		int key = jdbc.update(CANCEL_UPDATE, param);
		return key;
	}
}
