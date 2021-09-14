package com.naver.reservation.login.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import static com.naver.reservation.login.dao.ReservationCountDaoSqls.*;

import com.naver.reservation.login.dto.ReservationCount;

@Repository
public class ReservationCountDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationCount> rowMapper = BeanPropertyRowMapper.newInstance(ReservationCount.class);
	
	public ReservationCountDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationCount> getReservationCount(String reservationEmail) {
		Map<String, String> params = new HashMap<>();
		params.put("email",reservationEmail);
		List<ReservationCount> list = jdbc.query(SELECT_COUNT, params, rowMapper );
		return list;
	}

}
