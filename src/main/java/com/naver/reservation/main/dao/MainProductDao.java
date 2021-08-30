package com.naver.reservation.main.dao;

import static com.naver.reservation.main.dao.MainProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.main.dto.MainProduct;

@Repository
public class MainProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<MainProduct> rowMapper = BeanPropertyRowMapper
			.newInstance(MainProduct.class);

	public MainProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<MainProduct> getPromotionInfo(String type) {
		Map<String, String> params = new HashMap<>();
		params.put("type", type);
		List<MainProduct> list = jdbc.query(SELECT_PROMOTION,params, rowMapper);
		return list;
	}
	public List<MainProduct> getProductAll(int start){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", LIMIT);
		List<MainProduct> list = jdbc.query(SELECT_PRODUCT, params, rowMapper);
		return list;
	}

	public List<MainProduct> getAllProductByCategoryId(int id, int start){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		params.put("start", start);
		List<MainProduct> list = jdbc.query(SELECT_ALLPRODUCT_BY_CATEGORY_ID, params, rowMapper);
		return list;
	}
	
	public List<MainProduct> getProductByCategoryId(int id, int start){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		params.put("start", start);
		params.put("limit", LIMIT);
		List<MainProduct> list = jdbc.query(SELECT_PRODUCT_BY_CATEGORY_ID, params, rowMapper);
		return list;
	}
	
	public Integer selectCount() {
		Integer length = jdbc.queryForObject(COUNT_PRODUCT, Collections.emptyMap(), Integer.class );
		return length;
	}
	public Integer selectCountByCategoryId(int id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		Integer length = jdbc.queryForObject(COUNT_PRODUCT_BY_CATEGORY_ID,params, Integer.class);
		return length;
	}

}
