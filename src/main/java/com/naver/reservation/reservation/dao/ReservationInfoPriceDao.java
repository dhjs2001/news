package com.naver.reservation.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.reservation.dto.ReservationInfoPrice;
import static com.naver.reservation.reservation.dao.ReservationInfoPriceDaoSqls.*;


@Repository
public class ReservationInfoPriceDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ReservationInfoPrice> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoPrice.class);
	
	public ReservationInfoPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationInfoPrice> getReservationInfoPrices(int reservationInfoId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", reservationInfoId);
		List<ReservationInfoPrice> list = jdbc.query(SELECT, param, rowMapper);
		return list;
	}

}
