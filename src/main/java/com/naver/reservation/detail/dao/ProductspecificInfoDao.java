package com.naver.reservation.detail.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.detail.dto.ProductSpecificInfo;
import static com.naver.reservation.detail.dao.ProductspecificInfoDaoSqls.*;

import java.util.Collections;
import java.util.List;
@Repository
public class ProductspecificInfoDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ProductSpecificInfo> rowMapper = BeanPropertyRowMapper.newInstance(ProductSpecificInfo.class);
	
	public ProductspecificInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductSpecificInfo> getReview(int id){
		List<ProductSpecificInfo> list = jdbc.query(SELECT, Collections.singletonMap("id", id), rowMapper);
		return list;
	}
}
