package com.naver.reservation.detail.dao;

import static com.naver.reservation.detail.dao.DetailInfoDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.detail.dto.DetailInfo;
@Repository

public class DetailInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DetailInfo> rowMapper = BeanPropertyRowMapper.newInstance(DetailInfo.class);
	
	public DetailInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DetailInfo> getDetailInfo(int id){
		Map<String, Integer> params = Collections.singletonMap("id", id);
		List<DetailInfo> list = jdbc.query(SELECT,params,rowMapper);
		return list;
	}
	public int getDetailInfoCount(int id){
		Map<String, Integer> params = Collections.singletonMap("id", id);
		int count = jdbc.queryForObject(SELECT_COUNT, params, Integer.class);
		return count;
	}

}
