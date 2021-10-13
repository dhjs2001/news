package com.naver.reservation.confirmreservation.dao;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naver.reservation.confirmreservation.dto.ConfirmReservation;
import static com.naver.reservation.confirmreservation.dao.ConfirmReservationDaoSqls.*;

@Repository
public class ConfirmReservationDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ConfirmReservation> rowMapper = BeanPropertyRowMapper.newInstance(ConfirmReservation.class);
	
	public ConfirmReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ConfirmReservation> getConfirmReservations(String emailName){
		Map<String, String> params = new HashMap<>();
		params.put("email", emailName);
		List<ConfirmReservation> list = jdbc.query(SELECT, params,rowMapper);
		return list;
	}
	public List<ConfirmReservation> getConfirmReservations(){
		List<ConfirmReservation> list = jdbc.query(SELECTALL, Collections.emptyMap(),rowMapper);
		return list;
	}
	
	
	public int updateCancelFlag(Integer id, Date modifyDate) {
		Map<String, String> params = new HashMap<>();
		params.put("id", Integer.toString(id));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(modifyDate);
		params.put("date", date);
		int count = jdbc.update(UPDATE_CANCEL_FLAG, params);
		return count;
	}
	
	public int updateUsedFlag(Integer id, Date modifyDate) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(modifyDate);
		params.put("date", date);
		int count = jdbc.update(UPDATE_USED_FLAG, params);
		return count;
	}

}
