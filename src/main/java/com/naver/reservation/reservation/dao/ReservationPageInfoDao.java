package com.naver.reservation.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.naver.reservation.reservation.dto.ReservationPageInfo;
import static com.naver.reservation.reservation.dao.ReservationPageInfoDaoSqls.*;

@Repository
public class ReservationPageInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationPageInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationPageInfo.class);
	
	@Autowired
	DataSource dataSource;
	
	public ReservationPageInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationPageInfo> getReservationPageInfo(int id){
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		List<ReservationPageInfo> list = jdbc.query(SELECT, params, rowMapper);
		return list;
	}
	
	public int insertAction(String tableName, Object object) {
		SimpleJdbcInsert insertAction = new SimpleJdbcInsert(dataSource).usingGeneratedKeyColumns("id").withTableName(tableName);
		SqlParameterSource params = new BeanPropertySqlParameterSource(object);
		int key = Integer.valueOf(insertAction.executeAndReturnKey(params).intValue()); 
		return key;
	}

}
