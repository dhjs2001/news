package com.naver.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import static com.naver.reservation.dao.DisplayInfoDaoSqls.*;
import com.naver.reservation.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);

	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("display_info")
				.usingGeneratedKeyColumns("id");
	}

	public List<DisplayInfo> selectAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		return jdbc.query(SELECT, params, rowMapper);
	}

	public long insert(DisplayInfo displayinfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(displayinfo);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public int deleteById(long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	public int update(DisplayInfo displayInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(displayInfo);
		return jdbc.update(UPDATE, params);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}

}
