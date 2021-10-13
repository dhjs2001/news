package com.naver.reservation.writereview.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.writereview.dto.ProductDescription;
import static com.naver.reservation.writereview.dao.ProductDescriptionDaoSqls.*;

@Repository
public class ProductDescriptionDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductDescription> rowMapper = BeanPropertyRowMapper.newInstance(ProductDescription.class);
	public ProductDescriptionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductDescription> getProductDescription(int id){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		List<ProductDescription> list = jdbc.query(SELECT, params, rowMapper);
		return list;
	}

}
