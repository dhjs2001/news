package com.naver.reservation.writereview.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.naver.reservation.writereview.dto.FileInfo;
import static com.naver.reservation.writereview.dao.FileInfoDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FileInfoDao {
	private SimpleJdbcInsert insertAction;
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<FileInfo> rowMapper =  BeanPropertyRowMapper.newInstance(FileInfo.class);
	
	public FileInfoDao(DataSource dataSource) {
		this.insertAction = new SimpleJdbcInsert(dataSource).usingGeneratedKeyColumns("id").withTableName("file_info");
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int insertAction(FileInfo object) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(object);
		int key = insertAction.executeAndReturnKey(params).intValue();
		return key;
	}
	
	public List<FileInfo> getFileInfo(int id) {
		Map<String, Integer> params = new HashMap<>();
		List<FileInfo> list = jdbc.query(SELECT, params, rowMapper);
		return list;
	}

}
