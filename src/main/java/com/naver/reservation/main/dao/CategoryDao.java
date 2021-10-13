package com.naver.reservation.main.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.main.dto.Category;
import static com.naver.reservation.main.dao.CategoryDaoSqls.*;
@Repository
public class CategoryDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> getCategory() {
		List<Category> list = jdbc.query(SELECT, rowMapper);
		return list;
	}
}
