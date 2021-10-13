package com.naver.reservation.detail.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.detail.dto.FileName;
import static com.naver.reservation.detail.dao.FileNameDaoSqls.*;

@Repository
public class FileNameDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<FileName> rowMapper = BeanPropertyRowMapper.newInstance(FileName.class);
	
	public FileNameDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	public List<FileName> getFileNames(int id){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		List<FileName> list = jdbc.query(SELECT, params, rowMapper);
		return list;
	}

}
