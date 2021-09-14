package com.naver.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.reservation.reservation.dao.ReservationPageInfoDao;
import com.naver.reservation.reservation.dto.ReservationPageInfo;
import com.naver.reservation.service.ReservationPageService;

@Service
public class ReservationPageServiceImpl implements ReservationPageService {
	@Autowired
	ReservationPageInfoDao reservationPageInfoDao;

	@Override
	@Transactional
	public List<ReservationPageInfo> getReservationPageInfo(int id) {
		List<ReservationPageInfo> list = reservationPageInfoDao.getReservationPageInfo(id);
		return list;
	}
	@Override
	@Transactional
	public Integer insertAction(String tableName, Object object) {
		return reservationPageInfoDao.insertAction(tableName, object);
	}

}
