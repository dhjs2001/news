package com.naver.reservation.confirmreservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.confirmreservation.dto.ReservationPrice;
import static com.naver.reservation.confirmreservation.dao.ReservationPriceDaoSqls.*;

@Repository
public class ReservationPriceDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ReservationPrice> rowMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);
	
	public ReservationPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public List<ReservationPrice> getReservationPrice(int id){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		List<ReservationPrice> list = jdbc.query(SELECT, params, rowMapper);
		return list;
	}
}
